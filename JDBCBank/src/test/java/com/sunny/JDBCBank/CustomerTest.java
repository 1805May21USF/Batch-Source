package com.sunny.JDBCBank;

import java.sql.SQLException;
import java.util.ArrayList;

import com.sunny.beans.Customer;
import com.sunny.daoimpl.CustomerDAOImpl;

import junit.framework.TestCase;

public class CustomerTest extends TestCase {
	Customer c1, c2;
	CustomerDAOImpl c;
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		c1 = new Customer("Bob", "Test", "bobtest", "password");
		c2 = new Customer("Mary", "Test", "marytest", "wordpass");
		c = new CustomerDAOImpl();
	}
	

	public void test() throws SQLException{
		createCustAndExistTest();
		getCustomerListTest();
		getCustomerIdTest();
		getPasswordTest();
		removeCustomerTest();
	}
	
	/**
	 * Checks if createCustomer and customerExists works properly
	 * @throws SQLException
	 */
	public void createCustAndExistTest() throws SQLException {
		c.createCustomer(c1.getFname(),c1.getLname(),c1.getUser(),c1.getPass());
		boolean exists = c.customerExists(c1.getUser());
		assertEquals(true,exists);
		c.createCustomer(c2.getFname(),c2.getLname(),c2.getUser(),c2.getPass());
		exists = c.customerExists(c2.getUser());
		assertEquals(true,exists);
		exists = c.customerExists("bobthebuilder");
		assertEquals(false,exists);
		
	}

	
	public void getCustomerListTest() throws SQLException {
		ArrayList<Customer> testlist = c.getCustomerList();
		boolean check = false;
		for(Customer cust : testlist) {
			if(c1.getUser().equals(cust.getUser())) {
				check = true;
			}
		}
		assertEquals(true,check);
		check = false;
		for(Customer cust : testlist) {
			if(c2.getUser().equals(cust.getUser())) {
				check = true;
			}
		}
		assertEquals(true,check);
	}
	
	public void getCustomerIdTest() throws SQLException{
		int user1 = c.getCustomerID(c1.getUser());
		c1.setCustomerID(user1);
		int user2 = c.getCustomerID(c2.getUser());
		c2.setCustomerID(user2);
		assertEquals(false,user1==user2);
	}
	
	public void getPasswordTest() throws SQLException{
		assertEquals(c1.getPass(),c.getPassword(c1.getUser()));
		assertEquals(c2.getPass(),c.getPassword(c2.getUser()));
	}
	
	public void removeCustomerTest() throws SQLException {
		c.removeCustomer(c1.getCustomerID());
		c.removeCustomer(c2.getCustomerID());
		assertEquals(false,c.customerExists(c1.getUser()));
		assertEquals(false,c.customerExists(c2.getUser()));
	}
	
	
}
