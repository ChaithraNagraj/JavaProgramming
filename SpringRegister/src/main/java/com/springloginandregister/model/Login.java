package com.springloginandregister.model;

public class Login {
private String username;
private String paswd;
public String getuname() {
	return username;
}
public void setuname(String uname) {
	this.username=uname;
	System.out.println(username);
}
public String getpswd() {
	return paswd;
}
public void setpswd(String pswd) {
	this.paswd=pswd;
	System.out.println(paswd);
}
}
