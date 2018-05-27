package com.revature.P0Banking;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AccountTests {

	@Test
	public void createAccount() {
		Account one = new Account("fififi32", "bibibi22");
		assertNotNull(one);
	}
}
