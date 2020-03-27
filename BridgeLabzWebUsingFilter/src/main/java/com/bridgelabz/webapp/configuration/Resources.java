package com.bridgelabz.webapp.configuration;

public class Resources {
	private String url = "jdbc:mysql://localhost:3306/bridgelabzdatabase";
	private String username = "root";
	private String password = "root";
	private String driverName="com.mysql.jdbc.Driver";
    public String getDriverName() {
	 return driverName;
 }
 public void setDriverName(String driverName) {
	 this.driverName=driverName;
 }
public String getUrl() {
	return url;
}
public void setUrl(String url) {
	this.url=url;
}
public String getUserName() {
	return username;
}
public void setUsername(String username) {
	this.username=username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password=password;
}
}
