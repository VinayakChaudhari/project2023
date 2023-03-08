package com.app.service;

import java.util.List;

import com.app.dto.CourseDtoToUpdate;
import com.app.pojos.Course;


public interface CourseService {

	
	List<Course> getAllCategories();
	Course findCategory(Long catId);
	String deleteCategory(Long catId);
	Course addCategory(Course newCategory);
	Course updateCategory(CourseDtoToUpdate detachedCategory);
	
}
