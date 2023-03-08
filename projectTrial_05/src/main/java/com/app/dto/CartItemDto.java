package com.app.dto;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;


public class CartItemDto {
	private String latitude;
	private String longitude;
	private Long courseId;
	private Long userId;

	
	
	
	public CartItemDto() {
		super();
	}
	public CartItemDto(String latitude, String longitude, Long courseId, Long userId) {
		super();
		this.latitude = latitude;
		this.longitude = longitude;
		this.courseId = courseId;
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "CartItemDto [latitude=" + latitude + ", longitude=" + longitude + ", courseId=" + courseId + ", userId="
				+ userId + "]";
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
	public Long getCourseId() {
		return courseId;
	}
	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	
	

	

	
	
}
