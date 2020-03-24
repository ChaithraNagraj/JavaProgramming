package com.bridgelabz.loginreg.model;
//Creating Model class of customer and creating getters and setters for that
public class Customer {
	private String firstName;
	private String lastName;
	private String userId;
	private String password;
    private String emailId;
    private int phoneNumber;
   	public Customer(String firstName2, String lastName2, String userID2, String password2, String emailId2,
			int phoneNumber2) {}

	public Customer() {
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setlastName(String lastName) {
		this.lastName=lastName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getUserId() {
		return userId;
	}
	
		public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmiald() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId=emailId;
	}
	public int getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber=phoneNumber;
	}
	
}

