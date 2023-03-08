package com.app.dto;

import java.util.Objects;




/*
 * Product Entity : id, name,price,desc,inStock +
private Category productCategory;

 */

public class CourseDto {
	
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
	public CourseDto() {
		super();
	}
	public CourseDto(String courseName, String description) {
		super();
		this.courseName = courseName;
		this.description = description;
	}
	private String courseName;
	private String description;
	
}
