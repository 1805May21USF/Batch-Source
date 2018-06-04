package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.beans.Customer;

public interface CustomerDAO {
	// Declares the abstract methods that need to be implemented by a class
	public abstract void createCustomer(String username, String password, String firstName, String lastName, char middleInitial, 
			   							int age, String address, String city, int zip, String state) throws SQLException;
	public abstract List<Customer> getCustomerList(String arg) throws SQLException;
	public abstract void deleteCustomer(int id) throws SQLException;
	public abstract void updateCustomer(Customer c) throws SQLException;
}
