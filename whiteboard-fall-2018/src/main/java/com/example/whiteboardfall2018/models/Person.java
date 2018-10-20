package com.example.whiteboardfall2018.models;

import java.util.Date;

public class Person {
	
	private int id;
	private String userName;
	private String password;
	private String firstName;
	private String lastName;
	private double phoneNo;
	private String email;

	//Default COnstructor
	public Person() {}
	
	//Parameterized constructor
	public Person(int id, String userName, String password, String firstName, String lastName) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	
	@Override
	public String toString() {
		return "Person [id=" + id + ", userName=" + userName + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", phoneNo=" + phoneNo + ", email=" + email + ", role=" + role + ", dob="
				+ dob + "]";
	}

	public Person(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	//Setters and Getters
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}

	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	private String role;
	private Date dob;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public double getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(double phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}


}
