package com.revature.BankingApp;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Vector;

import org.junit.jupiter.api.*;

import com.revature.storage.Account;
import com.revature.storage.Customer;

/**
 * Unit test for simple BankingApp.
 */
public class BankingTest {
	
	@Test
	@DisplayName("Customer serialization test")
	public void customerSerializationTest() {
		Vector<Account> accounts = new Vector<>();
		Account a = new Account("checking", "Personal Checking", 200.00, "none");
		accounts.add(a);
		
		Customer c = new Customer("Well", "this", "was", 'a', "triumph", 13, "cake", accounts);
		
		System.out.println(c.toString());
		assertTrue(App.serialize(c));
		
		c = null;
		
		assertNotNull(c = App.deserializeCustomer("Well"));
		System.out.println(c.toString());
		
		App.deleteCustomer(c);
	}
	
}
