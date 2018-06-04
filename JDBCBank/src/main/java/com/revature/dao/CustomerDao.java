package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.beans.Account;
import com.revature.beans.Customer;

public interface CustomerDao {
	public abstract void createCustomer(String Firstname, String Lastname, String Username, String Password, int status, int accountNumber, int accountId) throws SQLException;
	public abstract Customer readCustomer(String Username, String Password) throws SQLException;
	public abstract void updateCustomer(String Username, String Password) throws SQLException;	
	public abstract void deleteCustomer(String Username, String Password) throws SQLException;
	public abstract List<Customer> getCustomer() throws SQLException;
}
