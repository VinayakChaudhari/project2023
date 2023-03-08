package com.app.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dto.SubjectDtoToUpdate;
import com.app.pojos.Course;
import com.app.pojos.Subject;
import com.app.repository.SubjectRepository;

@Service
@Transactional
public class SubjectServiceImpl implements SubjectService {

	@Autowired
	private CourseService courseService;

	@Autowired
	private SubjectRepository subjectRepo;

	@Override
	public List<Subject> getAllSubject(Long catId) {
		// TODO Auto-generated method stub

		// return subjectRepo.findById(catId);
		List<Subject> allProducts = new ArrayList<>();
		allProducts = subjectRepo.findAll();
		List<Subject> reqProducts = new ArrayList<>();
		System.out.println(allProducts);
		System.out.println(reqProducts);
		for (Subject p : allProducts) {
			System.out.println(p.getSubjectCourse());
			if (p.getSubjectCourse().getId() == catId) {
				reqProducts.add(p);
			}
		}
		System.out.println(reqProducts);
		return reqProducts;
	}

	@Override
	public Subject addHospital(Long categoryId, Subject addSubject) {
		Course cou = courseService.findCategory(categoryId);
//		Category cat11=new Category();
//		cat11.addProduct(addHospital);
		Subject newSubject = addSubject;
		newSubject.setSubjectCourse(cou);;
		return subjectRepo.save(newSubject);

	}

	@Override
	public String deleteHospital(Long productId) {
		// TODO Auto-generated method stub
		String msg = "Deletion of product details failed Invalid Id!!!!!!!!!!!";
		if (subjectRepo.existsById(productId)) {
			subjectRepo.deleteById(productId);
			msg = "product deleted successfully !!";
		}
		return msg;
	}

	@Override
	public Subject updateProduct(SubjectDtoToUpdate detachedProduct) {
		
		Subject persistentSubject = subjectRepo.findById(detachedProduct.getId())
				.orElseThrow(() -> new ResourceNotFoundException("invalid subject id !!!!!"));
		persistentSubject.setProductName(detachedProduct.getSubjectName());
		persistentSubject.setDescription(detachedProduct.getDescription());
		persistentSubject.setLatitude(detachedProduct.getLatitude());
		persistentSubject.setLongitude(detachedProduct.getLongitude());
		persistentSubject.setInStock(detachedProduct.getInStock());
		return persistentSubject;
	}

}
