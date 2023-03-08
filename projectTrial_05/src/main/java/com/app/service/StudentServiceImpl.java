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
public class StudentServiceImpl implements StudentService {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private CourseRepository catRepo;

	@Autowired
	private SubjectRepository productRepo;

	@Autowired(required = false)
	private ModelMapper mapper;

	

	

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
	public User saveUserDetails(User user) {
		
		System.out.println("value of cart is while registering"+user.getCart());
		return userRepo.save(user);
	}
	
	 @Override
	    public User forgetPassword(LoginRequestDto dto) {
	        // TODO Auto-generated method stub
	    	//return userRepo.findByMobileNo(user.getMobileNo());
	    	
	    	return userRepo.findByEmail(dto.getEmail());
	    }

	

}
