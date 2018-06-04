package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.beans.CustomerAccount;

/*
 * Interface for customer account actions to the database.
 */
public interface CustomerAccountDAO {
	/*
	 * Retrieves all of the customer accounts from the database.
	 */
	public abstract List<CustomerAccount> getCustomerAccounts() throws SQLException;
	
	/*
	 * Creates a new customer account and saves to the database.
	 */
	public abstract void createCustomerAccount(CustomerAccount cus) throws SQLException;
	
	/*
	 * Deletes an existing customer account with all associated bank accounts. 
	 */
	public abstract void deleteCustomerAccount(CustomerAccount cus) throws SQLException;
	
	/*
	 * Updates an existing customer account and saves to the databse.
	 */
	public abstract void updateCustomerAccount(CustomerAccount cus) throws SQLException;
}
