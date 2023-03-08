package com.app.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.app.dto.LoginRequestDto;
import com.app.dto.SubjectDtoToUpdate;
import com.app.pojos.Course;
import com.app.pojos.Subject;
import com.app.pojos.User;


public interface SubjectService {
	
	List<Subject> getAllSubject(Long catId);

	Subject addHospital(Long courseId, Subject addSubject);

	String deleteHospital(Long productId);

	 Subject updateProduct(SubjectDtoToUpdate detachedsubject);
	
}
