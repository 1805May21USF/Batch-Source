package com.revature.DAO;

import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.beans.Customer;

public interface CustomerDAO {

	public abstract Customer findCustomer(int ID) throws SQLException;
	public abstract Customer findCustomerByUsername(String username) throws SQLException;
	
	public abstract ArrayList<Customer> findAllCustomers() throws SQLException;
	public abstract void createCustomer(Customer customer) throws SQLException;
	public abstract void updateCustomer(Customer customer) throws SQLException;
	public abstract void deleteCustomer(Customer customer) throws SQLException;

}
