package com.app.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.app.dto.LoginRequestDto;
import com.app.dto.UserDto;
import com.app.pojos.Course;
import com.app.pojos.Subject;
import com.app.pojos.User;


public interface UserService {

	List<User> getAllUsers();

	User authenticateAdmin(LoginRequestDto dto);
	User authenticateCustomer(LoginRequestDto dto);

	List<Course> getAllCategories();

	List<Subject> getAllProducts(Long catId);

   //Subject addSubject(Long categoryId, Subject addSubject);

	User saveUserDetails(User user);

	String deleteCustomer(Long custId);
	
}
