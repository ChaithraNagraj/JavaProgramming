package com.bridgelabz.loginreg.serviceprovider;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bridgelabz.loginreg.model.Customer;
import com.bridgelabz.loginreg.repository.CustomerDao;
import com.bridgelabz.loginreg.config.ConnectionConfig;

public class CustomerDaoImpl implements CustomerDao {
static ConnectionConfig con; 
String insertQuery="insert into customer values(?,?,?)";
String getQuery="select * from customer where userID=? and password=?";
	public int insertCustomer(Customer customer) {
		int status=0;
		try {
			Connection connection=con.getDbConnection();
			PreparedStatement pStmt=connection.prepareStatement(insertQuery);
			pStmt.setString(1,customer.getFirstName());
			pStmt.setString(2, customer.getUserId());
			pStmt.setString(3, customer.getPassword());
			status=pStmt.executeUpdate();
		}catch(Exception e) {
		e.printStackTrace();
		}
		return status;
	}

	public Customer getCustomer(String userID, String password) {
		Customer customer=new Customer();
		try {
			Connection connection=con.getDbConnection();
			PreparedStatement ps=connection.prepareStatement(getQuery);
			ps.setString(1, userID);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				customer.setFirstName(rs.getString(1));
			customer.setUserId(rs.getString(2));
			customer.setPassword(rs.getString(3));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return customer;
	}

}
//Implementation of CustomersDAo and creating  Sql queries and methods
public class CustomerDaoImpl implements CustomerDao {
static ConnectionConfig con; 
String insertQuery="insert into customer values(?,?,?,?,?,?)";
String getQuery="select * from customer where userID=? and password=?";//selecting userId and password from customer table or class

	public int insertCustomer(Customer customer) {
		int status=0;
		try {
			Connection connection=con.getDbConnection();
			PreparedStatement pStmt=connection.prepareStatement(insertQuery);
			pStmt.setString(1,customer.getFirstName());
			pStmt.setString(2,customer.getLastName());
			pStmt.setString(3,customer.getUserId());
			pStmt.setString(4,customer.getPassword());
			pStmt.setString(5,customer.getEmiald());
			pStmt.setInt(6, customer.getPhoneNumber());
			status=pStmt.executeUpdate();
		}catch(Exception e) {
		e.printStackTrace();
		}
		return status;
	}
	public Customer getCustomer(String userID, String password) {
		Customer customer=new Customer();
		try {
			Connection connection=con.getDbConnection();
			PreparedStatement ps=connection.prepareStatement(getQuery);
			ps.setString(1, userID);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				customer.setFirstName(rs.getString(1));
			customer.setUserId(rs.getString(2));
			customer.setPassword(rs.getString(3));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return customer;
	}

}
