package com.app.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.catalina.filters.ExpiresFilter.XServletOutputStream;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dto.LoginRequestDto;
import com.app.dto.UserDto;
import com.app.pojos.AadharCard;
import com.app.pojos.Course;
import com.app.pojos.Subject;
import com.app.pojos.Role;
import com.app.pojos.User;
import com.app.repository.CourseRepository;
import com.app.repository.SubjectRepository;
import com.app.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private CourseRepository catRepo;

	@Autowired
	private SubjectRepository productRepo;

	@Autowired(required = false)
	private ModelMapper mapper;

	@Override
	public List<User> getAllUsers() {

		return userRepo.findAll();
	}

	@Override
	public User authenticateAdmin(LoginRequestDto dto) {
		// TODO Auto-generated method stub
		User user = userRepo.findByEmailAndPassword(dto.getEmail(), dto.getPassword())
				.orElseThrow(() -> new ResourceNotFoundException("Bad Credentials !!!!!"));
		if (user.getUserRole() == Role.ADMIN) {
			return user;
		} else {
			// return null;
			throw new ResourceNotFoundException("not a admin");
		}
	}

	@Override
	public User authenticateCustomer(LoginRequestDto dto) {
		// TODO Auto-generated method stub
		User user = userRepo.findByEmailAndPassword(dto.getEmail(), dto.getPassword())
				.orElseThrow(() -> new ResourceNotFoundException("Bad Credentials !!!!!"));
		if (user.getUserRole() == Role.STUDENT) {
			return user;
		} else {
			// return null;
			throw new ResourceNotFoundException("not a customer");
		}
	}

	@Override
	public List<Course> getAllCategories() {
		// TODO Auto-generated method stub
		return catRepo.findAll();
	}

	@Override
	public List<Subject> getAllProducts(Long catId) {
		// TODO Auto-generated method stub

		// return productRepo.findById(catId);
		List<Subject> allProducts = productRepo.findAll();
		List<Subject> reqProducts = new ArrayList<>();
		for (Subject p : allProducts) {
			if (p.getSubjectCourse().getId() == catId) {
				reqProducts.add(p);
			}
		}
		System.out.println(reqProducts);
		return reqProducts;
	}

//	@Override
//	public Subject addSubject(Long courseId, Subject addHospital) {
//		Optional<Course> cat = catRepo.findById(courseId);
//		return null;
//	}

	@Override
	public User saveUserDetails(User user) {
		
		System.out.println("value of cart is while registering"+user.getCart());
		return userRepo.save(user);
	}

	@Override
	public String deleteCustomer(Long custId) {
		// TODO Auto-generated method stub
		String msg = "unable to delete customer !!";
		if (userRepo.existsById(custId)) {
			userRepo.deleteById(custId);
			msg = "customer deleted successfully !!";
		}
		return msg;
	}

}
