package com.project.Vertex.entity;

import java.util.Arrays;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class Property {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	private String propertyType;
	private String propertyAddress;
	private String propertyDetails;
	private double propertyPrice;
	@Lob
	private byte[] image1;
	@Lob
	private byte[] image2;

	public Property() {
		
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getPropertyType() {
		return propertyType;
	}

	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}

	public String getPropertyAddress() {
		return propertyAddress;
	}

	public void setPropertyAddress(String propertyAddress) {
		this.propertyAddress = propertyAddress;
	}

	public String getPropertyDetails() {
		return propertyDetails;
	}

	public void setPropertyDetails(String propertyDetails) {
		this.propertyDetails = propertyDetails;
	}

	public double getPropertyPrice() {
		return propertyPrice;
	}

	public void setPropertyPrice(double propertyPrice) {
		this.propertyPrice = propertyPrice;
	}

	public byte[] getImage1() {
		return image1;
	}

	public void setImage1(byte[] image1) {
		this.image1 = image1;
	}

	public byte[] getImage2() {
		return image2;
	}

	public void setImage2(byte[] image2) {
		this.image2 = image2;
	}

	public Property(Long id, String propertyType, String propertyAddress, String propertyDetails, double propertyPrice,
			byte[] image1, byte[] image2) {
		super();
		Id = id;
		this.propertyType = propertyType;
		this.propertyAddress = propertyAddress;
		this.propertyDetails = propertyDetails;
		this.propertyPrice = propertyPrice;
		this.image1 = image1;
		this.image2 = image2;
	}

	@Override
	public String toString() {
		return "Property [Id=" + Id + ", propertyType=" + propertyType + ", propertyAddress=" + propertyAddress
				+ ", propertyDetails=" + propertyDetails + ", propertyPrice=" + propertyPrice + ", image1=" + image1
				+ ", image2=" + image2 + "]";
	}
	
	
}
