package com.app.dto;

import java.util.Objects;




/*
 * Product Entity : id, name,price,desc,inStock +
private Category productCategory;

 */

public class CourseDtoToUpdate {
	
	@Override
	public String toString() {
		return "CourseDto [courseName=" + courseName + ", description=" + description + "]";
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public CourseDtoToUpdate() {
		super();
	}
	
	public CourseDtoToUpdate(Long id, String courseName, String description) {
		super();
		this.id = id;
		this.courseName = courseName;
		this.description = description;
	}

	private Long id;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	private String courseName;
	private String description;
	
}
