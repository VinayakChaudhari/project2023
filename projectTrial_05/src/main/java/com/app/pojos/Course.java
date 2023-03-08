package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

/*.initializeBean(AbstractAutowireCapableBeanFactory.java:1804) ~[spring-beans-5.3.25.jar:5.3.25]
 * 2. course : id,  courseName ,description +
private List<subject> subjects=new ArrayList<>();//as per Gavin King's suggestion : DO NOT keep collection based null
 */
@Entity
@Table(name="course")
public class Course extends BaseEntity {
	@Column(name="course_name",length = 30,unique = true)
	private String courseName;
	@Column(length = 300)
	private String description;
	// one to many : bi dir course 1--->* subject
	//course -- one , parent , inverse(since no FK mapping)
	@JsonBackReference
	@OneToMany(mappedBy = "subjectCourse",
			cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Subject> subjects = new ArrayList<>(); // init to empty list

	public Course(){
		// TODO Auto-generated constructor stub
	}

	public Course(String courseName, String description) {
		super();
		this.courseName = courseName;
		this.description = description;
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

	public List<Subject> getsubjects() {
		return subjects;
	}

	public void setsubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}
	
	// Founder's suggestion : NEVER add asso properties toString --o.w may cause
	// recursion!

	@Override
	public String toString() {
		return "course ID " + getId() + " [courseName=" + courseName + ", description=" + description + "]";
	}
	//add a method(convenience/helper) to establish a bi dir asso. between entities
	public void addsubject(Subject p)
	{
		//parent --> child
		subjects.add(p);
		//child --> parent
		p.setSubjectCourse(this);
	}
	//add a method(convenience/helper) to remove a bi dir asso. between entities
		public void removesubject(Subject p)
		{
			//parent ----X---> child
			subjects.remove(p);
			//child ----X----> parent
			p.setSubjectCourse(null);			
		}

}
