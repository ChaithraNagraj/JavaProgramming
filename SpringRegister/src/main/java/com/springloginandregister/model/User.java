package com.springloginandregister.model;
/***
Register model
**/
public class User {
	private String fstname;
	private String lstname;
	private String adrs;
	private String usrname;
	private String pswd;
	private String email;
	private int phoneno;

	public int getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(int phoneno) {
		this.phoneno = phoneno;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getFstname() {
		return fstname;
	}
	public void setFstname(String fstname) {
		this.fstname = fstname;
	}
	public String getLstname() {
		return lstname;
	}
	public void setLstname(String lstname) {
		this.lstname = lstname;
	}
	public String getAdrs() {
		return adrs;
	}
	public void setAdrs(String adrs) {
		this.adrs = adrs;
	}
	public String getUsrname() {
		return usrname;
	}
	public void setUsrname(String usrname) {
		this.usrname = usrname;
	}
	public String getPswd() {
		return pswd;
	}
	public void setPswd(String pswd) {
		this.pswd = pswd;
	}


}
