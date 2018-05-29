package com.revature.BankingApp;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.*;

/**
 * Unit test for simple BankingApp.
 */
public class AppTest {
	
	@Test
	@DisplayName("Admin should always exist in every class")
	public void adminShouldExist() {
		assertTrue(SignUp.exists("admin"));
		assertTrue(SignIn.exists("admin", "rolltide"));
	}
	
	@Test
	@DisplayName("Admin should never possess an account")
	public void adminAccountShouldNotExist(){
		assertFalse(Banking.userExists("admin"));
	}
}
