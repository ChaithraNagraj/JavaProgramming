package com.bridgelabz.loginreg.repository;

import com.bridgelabz.loginreg.model.Customer;
//creting interface
public interface CustomerDao {

	public int insertCustomer(Customer c);

	public Customer getCustomer(String userID, String pass);

}
