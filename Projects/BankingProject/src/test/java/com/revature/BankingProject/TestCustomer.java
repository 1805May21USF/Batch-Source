package com.revature.BankingProject;

import static org.junit.Assert.*;

import org.junit.jupiter.api.*;

import com.revature.BankingProject.Customer;

class TestCustomer {
	private static Customer cus;
	
	//Executes once before all 
	@BeforeAll
	static void setup() {
		cus = new Customer("Jim", "123 Fake ln", "123-555-6462");
	}
	
	@Test
	void testCustomerCreation() {
		assertNotNull(cus);
	}
	
	@Test
	void testCustomerFields() {
		assertEquals("Jim", cus.getName());
		assertEquals("123 Fake ln", cus.getAddress());
		assertEquals("123-555-6462", cus.getPhone());
	}

	

}
