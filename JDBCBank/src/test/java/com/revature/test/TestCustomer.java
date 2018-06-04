package com.revature.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.revature.beans.Customer;

public class TestCustomer {

	public TestCustomer() {
		// TODO Auto-generated constructor stub
	}
	
	@Test
	public void testGetFirstName() {
		Customer c = new Customer("Jay Jay","Okocha","JL56y","J5", 82, 5);
		String firstName = c.getFirstname();
		assertEquals("Jay Jay", firstName);
	}
	
	@Test
	public void testGetLastName() {
		Customer c = new Customer("Jay Jay","Okocha","JL56y","J5", 82, 5);
		String lastName = c.getLastname();
		assertEquals("Okocha", lastName);
	}
	
	@Test
	public void testGetUserName() {
		Customer c = new Customer("Jay Jay","Okocha","JL56y","J5",82,5);
		String userName = c.getUsername();
		assertEquals("JL56y", userName);
	}
	
	@Test
	public void testGetPassword() {
		Customer c = new Customer("Jay Jay","Okocha","JL56y","J5",82,5);
		String password = c.getPassword();
		assertEquals("J5", password);
	}
	
	@Test
	public void testToString() {
		Customer c = new Customer("Jay Jay","Okocha","JL56y","J5", 82, 5);
		String str = "Customer: " + "\nFirstName: " + c.getFirstname() +
					 "\nLastName: " + c.getLastname() +
					 "\nUsername: " + c.getUsername() +
					 "\nPassword: " + c.getPassword() +
					 "\nAccount Number: " + c.getAccountnumber() +
					 "\nStatus: " + c.getStatus();
		assertEquals(str, c.toString());
	}
	
	
}

