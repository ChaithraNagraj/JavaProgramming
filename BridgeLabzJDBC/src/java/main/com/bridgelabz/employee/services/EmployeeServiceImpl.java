package com.bridgelabz.employee.services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.bridgelabz.employee.repository.EmployeeRepoSqlQueries;
import com.bridgelabz.employee.repository.EmployeeService;
import com.bridgelabz.employee.utills.ConnectionConfig;
import com.bridgelabz.employee.utills.InputUtility;
import com.bridgelaz.employee.model.EmployeeDetails;

public class EmployeeServiceImpl implements EmployeeService{
	EmployeeRepoSqlQueries repo=new EmployeeRepoSqlQueries();
	//EmployeeDetails emp;
	ConnectionConfig config=ConnectionConfig.getInstance();
	@Override
	public void InsertEmployeeDetails() {
		 
		String sql=repo.InsertQuery();
		PreparedStatement statement;
		try {
			statement = config.getDbConnection().prepareStatement(sql);
			System.out.println("Enter the employee id: ");
			int id = InputUtility.intVal();
			System.out.println("Enter the employee name: ");
			InputUtility.inputstring();
			String name = InputUtility.inputstring();
			System.out.println("Enter the employee department: ");
			String dept = InputUtility.stringVal();
			System.out.println("Enter the employee salary: ");
			double salary = InputUtility.doubleVal();
			
			statement.setInt(1, id);
			statement.setString(2, name);
			statement.setString(3, dept);
			statement.setDouble(4, salary);
			
			EmployeeDetails emp=new EmployeeDetails(name, id, dept, salary);
			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("Name: "+emp.getEmpName()+"Id: "+emp.getEmpId()+"Dept: "+emp.getEmpDept()+"Salary: "+emp.getEmpSalary());
			    System.out.println("employee was inserted successfully!");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void SelectEmployeeDetails() {
		String sql=repo.SelectQuery();
		Statement statement;
		try {
			statement = config.getDbConnection().createStatement();
			ResultSet result = statement.executeQuery(sql);
			 
			int count = 0;
			 System.out.println("Employee details are:");
			while (result.next()){
			    String EId = result.getString(2);
			    String EName = result.getString(1);
			    String EDept = result.getString("empDept");
			    String ESalary = result.getString("empSalary");
			 
			    String output = "Employee %d: %s - %s - %s - %s";
			    System.out.println(String.format(output, ++count, EId, EName, EDept, ESalary));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void UpdateEmployeeDetails() {
		 String sql=repo.UpdateQuery();
		PreparedStatement statement;
		try {
			statement = config.getDbConnection().prepareStatement(sql);
			statement.setString(1, "43");
			statement.setString(2, "rajesh");
			statement.setString(3, "Finance");
			statement.setString(4, "25000");
			 
			int rowsUpdated = statement.executeUpdate();
			if (rowsUpdated > 0) {
			    System.out.println("An existing employee was updated successfully!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteEmployee() {
		 String sql=repo.DeleteQuery();
		PreparedStatement statement;
		try {
			statement = config.getDbConnection().prepareStatement(sql);
			statement.setString(2, "Rajesh");
			 
			int rowsDeleted = statement.executeUpdate();
			if (rowsDeleted > 0) {
			    System.out.println("A employee was deleted successfully!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

