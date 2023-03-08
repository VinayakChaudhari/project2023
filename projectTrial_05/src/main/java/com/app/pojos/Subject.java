package com.app.pojos;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

/*
 * Product Entity : id, name,price,desc,inStock +
private Category subjectCategory;

 */
@Entity
@Table(name = "subject")
public class Subject extends BaseEntity {
	@Column(name = "subject_name", length = 30, unique = true)
	private String subjectName;
	@Column(length = 20)
	private String latitude;
	@Column(length = 20)
	private String longitude;
	private String description;
	@Column(name = "in_stock")
	private int inStock;
//	// many to one Product *-----> 1Category
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "course_id")
	private Course subjectCourse;
	// Product 1----->1 CartItem

	public Subject() {
		// TODO Auto-generated constructor stub
	}

	public Subject(String subjectName, String description, int inStock, String latitude, String longitude) {
		super();
		this.subjectName = subjectName;

		this.description = description;
		this.inStock = inStock;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public String getProductName() {
		return subjectName;
	}

	public void setProductName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int isInStock() {
		return inStock;
	}

	public void setInStock(int inStock) {
		this.inStock = inStock;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public int getInStock() {
		return inStock;
	}

	public Course getSubjectCourse() {
		return subjectCourse;
	}

	public void setSubjectCourse(Course subjectCourse) {
		this.subjectCourse = subjectCourse;
	}

	@Override
	public String toString() {
		return "Product ID " + getId() + " [subjectName=" + subjectName + ", description=" + description + ", inStock="
				+ inStock + "latitude=" + latitude + "longitude=" + longitude + "]";
	}

}
