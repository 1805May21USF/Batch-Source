package com.revature.BankingProject;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class TestApp {	
	private static BankActions b;
	
	//Executes once before all 
	@BeforeAll
	static void setup() {
		b = new BankActions();
	}

	@Test
	void testRegister() {		
		b.Register("user", "pass", 0);
		
		Account acc = b.getAccountByUsername("user");
		
		assertNotNull(acc);
		
		assertTrue(b.userNameExists("user"));
	}
	
	@Test
	void testGetAccounts() {
		b.Register("yourUser", "yourPass", 0);
		
		assertNotNull(b.getAccounts());
	}
	
	@Test
	void testUserNameExists() {
		b.Register("yourUser", "yourPass", 0);
		assertTrue(b.userNameExists("yourUser"));

		assertFalse(b.userNameExists("hasdfdfdkf"));
	}
}
