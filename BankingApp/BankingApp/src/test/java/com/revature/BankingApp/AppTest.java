package com.revature.BankingApp;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Vector;

import org.junit.jupiter.api.*;

import com.revature.storage.Account;
import com.revature.storage.Customer;
import com.revature.storage.Employee;

/**
 * Unit test for simple BankingApp.
 */
public class AppTest {
	
	// Tests that Customer objects can be serialized, deserialized, and deleted
	@Test
	@DisplayName("Customer serialization test")
	public void customerSerializationTest() {
		// Creates an Account to link to the Customer
		Vector<Account> accounts = new Vector<>();
		Account a = new Account("checking", "Personal Checking", 200.00, "none");
		accounts.add(a);
		
		// Creates a new Customer object
		Customer c = new Customer("Well", "this", "was", 'a', "triumph", 13, "cake", accounts);
		
		// Prints the Customer object and the asserts the Customer can be serialized
		System.out.println(c.toString());
		assertTrue(App.serialize(c));
		
		// Clears the Customer object
		c = null;
		
		// Asserts that a Customer will be returned and prints the returned Customer
		assertNotNull(c = App.deserializeCustomer("Well"));
		System.out.println(c.toString());
		
		// Asserts that the Customer file can be deleted
		assertTrue(App.deleteCustomer(c));
	}
	
	// Tests that Customer objects can be serialized, deserialized, and deleted
	@Test
	@DisplayName("Employee serialization test")
	public void employeeSerializationTest() {
		Employee e = new Employee("Well", "this", "was", 'a', "triumph", 13, "cake", "huge success", 23);
			
		System.out.println(e.toString());
		assertTrue(App.serialize(e));
			
		e = null;
			
		assertNotNull(e = App.deserializeEmployee("Well"));
		System.out.println(e.toString());
			
		assertTrue(App.deleteEmployee(e));
	}
}
