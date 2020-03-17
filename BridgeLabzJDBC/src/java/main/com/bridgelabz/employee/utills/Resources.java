package com.bridgelabz.employee.utills;

public class Resources {
	private String url = "jdbc:mysql://localhost:3306/bridgelabzdatabase";
	private String username = "root";
	private String password = "Harshi@1";
	private String driverName="com.mysql.cj.jdbc.Driver";
	
	public String getDriverName() {
		return driverName;
	}
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
