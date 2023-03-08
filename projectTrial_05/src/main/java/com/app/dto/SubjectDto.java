package com.app.dto;

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
private Category productCategory;

 */

public class SubjectDto {
	
	private String subjectName;
	
	private String latitude;
	
	private String longitude;
	private String description;
	
	private int inStock;

	
	//Product 1----->1 CartItem

	

	public SubjectDto(String subjectName, String latitude, String longitude, String description, int inStock) {
		super();
		this.subjectName = subjectName;
		this.latitude = latitude;
		this.longitude = longitude;
		this.description = description;
		this.inStock = inStock;
		
	}

	public SubjectDto() {
		super();
	}

	public String getProductName() {
		return subjectName;
	}

	public void setProductName(String subjectName) {
		this.subjectName = subjectName;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getInStock() {
		return inStock;
	}

	public void setInStock(int inStock) {
		this.inStock = inStock;
	}

	

	

	
	
}
