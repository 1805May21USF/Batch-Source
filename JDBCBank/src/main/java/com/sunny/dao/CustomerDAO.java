package com.sunny.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.sunny.beans.Customer;

public interface CustomerDAO {
	public abstract void createCustomer(String fname,
			String lname, String user, String pass) throws SQLException;
	public abstract ArrayList<Customer> getCustomerList() throws SQLException;
	public abstract boolean customerExists(String user) throws SQLException;
	public abstract String getPassword(String user) throws SQLException;
	public abstract int getCustomerID(String user) throws SQLException;
	public abstract Customer getCustomer(int cid) throws SQLException;
	public abstract void removeCustomer(int cid) throws SQLException; 
	public abstract void editCustomerName(int cid, String fn, String ln) throws SQLException;
	public abstract void editCustomerUser(int cid, String user) throws SQLException;
	public abstract void editCustomerPass(int cid, String pass) throws SQLException;
}
