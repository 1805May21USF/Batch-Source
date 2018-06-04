package com.revature.test;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.revature.beans.CustomerAccount;
import com.revature.daoimpl.CustomerAccountDAOImpl;

class TestCustomerAccount {
	private CustomerAccountDAOImpl ca = new CustomerAccountDAOImpl();

	@Test
	void testGetCustomerAccounts() {
		try {
			assertNotNull(ca.getCustomerAccounts());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	void testInsertCustomerAccount() {
		try {
			List<CustomerAccount> customerAccounts = ca.getCustomerAccounts();
			int size1 = customerAccounts.size();
			CustomerAccount cus = new CustomerAccount(0, "dude1", "pass", "John", "Smith");
			
			ca.createCustomerAccount(cus);
			
			customerAccounts = ca.getCustomerAccounts();
			int size2 = customerAccounts.size();
			
			assertNotEquals(size1, size2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	void testDeleteCustomerAccount() {
		try {
			List<CustomerAccount> customerAccounts = ca.getCustomerAccounts();
			int size1 = customerAccounts.size();
			ca.deleteCustomerAccount(customerAccounts.get(0));
			
			customerAccounts = ca.getCustomerAccounts();
			int size2 = customerAccounts.size();
			
			assertNotEquals(size1, size2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	void testUpdateCustomerAccount() {
		try {
			CustomerAccount cus = new CustomerAccount(0, "dude1", "pass", "John", "Smith");	
			ca.createCustomerAccount(cus);
			
			List<CustomerAccount> customerAccounts = ca.getCustomerAccounts();
			cus = customerAccounts.get(0);
			String beforeName = cus.getFirstname();
			
			cus.setFirstname("billy");
			ca.updateCustomerAccount(cus);
			
			customerAccounts = ca.getCustomerAccounts();
			cus = customerAccounts.get(0);
			String afterName = cus.getFirstname();
			
			assertNotEquals(beforeName, afterName);
			
			ca.deleteCustomerAccount(customerAccounts.get(0));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
