package com.bridgelabz.loginreg.model;
public class Customer {
	private String firstName;
	private String userId;
	private String password;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getUserId() {
		return userId;
	}

	public Customer() {
		super();
	}

	public Customer(String firstName, String userId, String password) {
		super();
		this.firstName = firstName;
		this.userId = userId;
		this.password = password;
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

}
