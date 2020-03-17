package com.bridgelabz.employee.repository;

public class EmployeeRepoSqlQueries {
	public String InsertQuery() {
		String sql = "INSERT INTO bridgelabzemployee (empId, empName, empDept, empSalary) VALUES (?, ?, ?, ?)";
		return sql;
	}
	public String SelectQuery() {
		String sql = "SELECT * FROM bridgelabzemployee";
		return sql;
	}
	public String UpdateQuery() {
		String sql = "UPDATE bridgelabzemployee SET empId=?, empDept=?, empSalary=? WHERE empName=?";
		return sql;
	}
	public String DeleteQuery() {
		String sql = "DELETE FROM bridgelabzemployee WHERE empName=?";
		return sql;
	}}
