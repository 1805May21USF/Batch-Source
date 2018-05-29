package com.revature.BankingProject;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.revature.Utility.UtilityActions;

class TestRegistrationActions {	
	private static RegistrationActions r = new RegistrationActions();
	private static File filename = new File("UserAccounts.txt");
	
	//Executes once before all 
	@BeforeAll
	static void setup() {
		UtilityActions.clearAccounts(filename);
		r.register("user", "pass", 0);
	}
	
	//Executes once after all
	@AfterAll
	static void tearDown() {
		UtilityActions.clearAccounts(filename);
	}

	@Test
	void testRegister() {	
		//Register Success
		assertTrue(r.register("testUser", "pass", 1));	
		
		//Register Failure
		assertFalse(r.register("testUser", "word", 2));
	}
	
	@Test
	void testGetAccounts() {
		//Gets accounts from file	
		assertNotNull(RegistrationActions.getAccounts());
		
		//Gets null since accounts is empty
		UtilityActions.clearAccounts(filename);
		assertNull(RegistrationActions.getAccounts());
		r.register("user", "pass", 0);
	}
	
	@Test
	void testUserNameExists() {
		//Username exists
		assertTrue(RegistrationActions.usernameExists("user"));

		//Username not used yet
		assertFalse(RegistrationActions.usernameExists("hasdfdfdkf"));
	}
	
	@Test
	void testGetAccountByUsername() {
		//Get Account success
		assertNotNull(r.getUserAccountByUsername("user"));
		
		//Get Account failure, doesn't exist
		assertNull(r.getUserAccountByUsername("hasdklfj"));
	}
	
	@Test
	void testLogin() {
		//Login success
		assertTrue(r.login("user", "pass"));
		
		//Login failure, invalid login
		assertFalse(r.login("testUser", "jfjdka"));
	}
}
