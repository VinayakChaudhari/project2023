package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dto.CourseDtoToUpdate;
import com.app.pojos.Course;
import com.app.pojos.Subject;
import com.app.repository.CourseRepository;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseRepository catRepo;
	
	@Override
	public List<Course> getAllCategories() {
		// TODO Auto-generated method stub
		return catRepo.findAll();
	}

	@Override
	public Course findCategory(Long catId) {
		// TODO Auto-generated method stub
		return catRepo.findById(catId)
				.orElseThrow(()-> new ResourceNotFoundException("invalid catId"));
	}

	@Override
	public String deleteCategory(Long catId) {
		// TODO Auto-generated method stub
		String msg="unable to delete category !!";
		if(catRepo.existsById(catId))
		{
			msg="category deleted successfully !!";
			catRepo.deleteById(catId);
		}
		return msg;
	}

	@Override
	public Course addCategory(Course newCategory) {
		// TODO Auto-generated method stub
		return catRepo.save(newCategory);
	}

	@Override
	public Course updateCategory(CourseDtoToUpdate detachedCategory) {
		// TODO Auto-generated method stub
		
		Course persistentCourse=catRepo.findById(detachedCategory.getId())
				.orElseThrow(() -> new ResourceNotFoundException("invalid category id !!!!!"));

		persistentCourse.setCourseName(detachedCategory.getCourseName());
		persistentCourse.setDescription(detachedCategory.getDescription());
			
			return persistentCourse;
	
		
		
	}

}
