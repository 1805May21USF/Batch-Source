package com.revature.DAO;

import java.util.ArrayList;

import com.revature.beans.Customer;

public interface CustomerDAO {
	
	   public ArrayList<Customer> getAllCustomer();
	   public Customer getCustomer(int ID);
	   public void updateCustomer(Customer customer);
	   public void deleteCustomer(Customer customer);

}
