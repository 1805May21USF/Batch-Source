package com.revature.main;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Vector;

import org.junit.jupiter.api.*;

import com.revature.beans.Account;
import com.revature.beans.Customer;
import com.revature.beans.Employee;
import com.revature.main.Main;

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
		assertTrue(Main.serialize(c));
		
		// Clears the Customer object
		c = null;
		
		// Asserts that a Customer will be returned and prints the returned Customer
		assertNotNull(c = Main.deserializeCustomer("Well"));
		System.out.println(c.toString());
		
		// Asserts that the Customer file can be deleted
		assertTrue(Main.deleteCustomer(c));
	}
	
	// Tests that Customer objects can be serialized, deserialized, and deleted
	@Test
	@DisplayName("Employee serialization test")
	public void employeeSerializationTest() {
		Employee e = new Employee("Well", "this", "was", 'a', "triumph", 13, "cake", "huge success", 23);
			
		System.out.println(e.toString());
		assertTrue(Main.serialize(e));
			
		e = null;
			
		assertNotNull(e = Main.deserializeEmployee("Well"));
		System.out.println(e.toString());
			
		assertTrue(Main.deleteEmployee(e));
	}
}
