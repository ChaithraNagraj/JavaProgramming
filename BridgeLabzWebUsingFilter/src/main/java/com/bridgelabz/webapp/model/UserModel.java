package com.bridgelabz.webapp.model;

public class UserModel {
private int id;
private String username;
private String password;
private String name;
private String email;
private String state;
private String city;
private int age;
public UserModel() {
	
}
public UserModel(String username,String password,String name,String email,String state,String city,int age) {
	super();
	this.username=username;
	this.password=password;
	this.name=name;
	this.email=email;
	this.state=state;
	this.city=city;
	this.age=age;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id=id;
}
public String getUsername() {
	return username;
}
public void setUserName(String username) {
	this.username=username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password=password;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name=name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email=email;
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state=state;
}
public String getCity() {
	return city;
}

public void setCity(String city) {
	this.city = city;
}

public int getAge() {
	return age;
}

public void setAge(int age) {
	this.age = age;
}

public UserModel(int id, String username, String password, String name, String email, String state, String city,
		int age) {
	super();
	this.id = id;
	this.username = username;
	this.password = password;
	this.name = name;
	this.email = email;
	this.state = state;
	this.city = city;
	this.age = age;
}
}
