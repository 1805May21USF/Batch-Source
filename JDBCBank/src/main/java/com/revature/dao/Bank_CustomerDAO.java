package com.revature.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.Bank_Customer;

public interface Bank_CustomerDAO {

	//CRUD OPERATION
		// CREATE, UPDATE , DELETE
		
		public abstract void createCustomer(Bank_Customer bankCustomer) throws SQLException;
		public abstract void updateCustomer(Bank_Customer bankCustomer) throws SQLException;
		public abstract ArrayList<Bank_Customer> getCustomerList() throws SQLException;
		//public abstract void updateCustomer(int customerID) throws SQLException;
		public abstract void deleteCustomer(Bank_Customer bankCustomer) throws SQLException;
		
		
		
		
}
