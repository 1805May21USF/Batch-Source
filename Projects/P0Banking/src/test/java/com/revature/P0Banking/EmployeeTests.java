package com.revature.P0Banking;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EmployeeTests {
	private static Customer c = new Customer("test", "user", "pass");
	@Test
	void testViewInfo() {
		assertTrue(c.getName().equals("test"));
	}

}
