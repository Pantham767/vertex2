package com.project.Vertex.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Register {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	private String email;
	private String mobileNumber;
	private String preferredLocation;
	private String password;
	private String confirmPassword;
	private String role = "user";

	
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}



	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}



	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}



	public String getPreferredLocation() {
		return preferredLocation;
	}
	public void setPreferredLocation(String preferredLocation) {
		this.preferredLocation = preferredLocation;
	}



	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}



	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	
	public Register(Long id, String email, String mobileNumber, String preferredLocation, String password,
			String confirmPassword, String role) {
		super();
		Id = id;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.preferredLocation = preferredLocation;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.role = role;
	}
	
	
	@Override
	public String toString() {
		return "Register [Id=" + Id + ", email=" + email + ", mobileNumber=" + mobileNumber + ", preferredLocation="
				+ preferredLocation + ", password=" + password + ", confirmPassword=" + confirmPassword + ", role="
				+ role + "]";
	}
	public Register() {
		
	}
}
