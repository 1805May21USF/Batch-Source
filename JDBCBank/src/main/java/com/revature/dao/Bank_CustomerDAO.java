package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.model.Bank_Customer;

public interface Bank_CustomerDAO {

	//CRUD OPERATION
		// CREATE, UPDATE , DELETE
		
		public abstract void createCustomer(String customerID) throws SQLException;
		public abstract void insertCustomer(String customerID) throws SQLException;
		public abstract List<Bank_Customer> getCustomerList() throws SQLException;
		public abstract void updateCustomer(int customerID) throws SQLException;
		public abstract void deleteCustomer(int customerID) throws SQLException;
		
		
		
		
}
