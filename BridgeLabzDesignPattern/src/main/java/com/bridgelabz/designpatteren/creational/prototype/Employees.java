package com.bridgelabz.designpatteren.creational.prototype;

import java.util.ArrayList;
import java.util.List;

public class Employees implements Cloneable {
private List<String>empList;
public Employees() {
	empList=new ArrayList<String>();
}
public Employees(List<String> list) {
	this.empList=list;
}
public void loadData() {
	//\read all employees from database and put into  the list
	empList.add("pankaj");
	empList.add("vikram");
	empList.add("chaithra");
	empList.add("david");
	
}
public List<String>getEmpList(){
	return empList;
}//@override
public Object clone() throws CloneNotSupportedException{
	List<String>temp=new ArrayList<String>();
	for(String s: this.getEmpList()) {
		temp.add(s);
	}
	return new Employees(temp);
}
}
