package com.revature.main;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Vector;

import org.junit.jupiter.api.*;

import com.revature.beans.Account;
import com.revature.beans.Customer;
import com.revature.main.Main;

/**
 * Unit test for simple BankingApp.
 */
public class SignUpTest {
	
	@Test
	@DisplayName("Customer serialization test")
	public void customerSerializationTest() {
		Vector<Account> accounts = new Vector<>();
		Account a = new Account("checking", "Personal Checking", 200.00, "none");
		accounts.add(a);
		
		Customer c = new Customer("Well", "this", "was", 'a', "triumph", 13, "cake", accounts);
		
		System.out.println(c.toString());
		assertTrue(Main.serialize(c));
		
		c = null;
		
		assertNotNull(c = Main.deserializeCustomer("Well"));
		System.out.println(c.toString());
		
		Main.deleteCustomer(c);
	}
	
}
