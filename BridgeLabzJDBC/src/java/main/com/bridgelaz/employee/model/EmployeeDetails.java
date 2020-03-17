package com.bridgelaz.employee.model;

public class EmployeeDetails {
	private String EmpName;
	private int EmpId;
	private String EmpDept;
	private double EmpSalary;
	

	public EmployeeDetails() {
		
	}
	public EmployeeDetails(String empName, int empId, String empDept, double empSalary) {
		super();
		EmpName = empName;
		EmpId = empId;
		EmpDept = empDept;
		EmpSalary = empSalary;
	}
	@Override
	public String toString() {
		return "EmployeeDetails [EmpName=" + EmpName + ", EmpId=" + EmpId + ", EmpDept=" + EmpDept + ", EmpSalary="
				+ EmpSalary + "]";
	}
	public String getEmpName() {
		return EmpName;
	}
	public void setEmpName(String empName) {
		EmpName = empName;
	}
	public int getEmpId() {
		return EmpId;
	}
	public void setEmpId(int empId) {
		EmpId = empId;
	}
	public String getEmpDept() {
		return EmpDept;
	}
	public void setEmpDept(String empDept) {
		EmpDept = empDept;
	}
	public double getEmpSalary() {
		return EmpSalary;
	}
	public void setEmpSalary(double empSalary) {
		EmpSalary = empSalary;
	}
	
	
}
