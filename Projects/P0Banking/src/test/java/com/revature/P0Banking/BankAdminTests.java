package com.revature.P0Banking;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class BankAdminTests {
	private static ArrayList<Partner> a = new ArrayList<Partner>();
	private static Customer test = new Customer("Bob", "user", "pass");
	private static Employee test_e = new Employee("Sam", "user1", "pass");
	private static BankAdmin test_b = new BankAdmin("Tom", "user2", "pass");
	
	@Test
	void testViewPartners() {
		a.add(test);
		a.add(test_e);
		a.add(test_b);
		assertTrue(a.get(0).getUsername().equals(test.getUsername()));
		assertTrue(a.get(1).getUsername().equals(test_e.getUsername()));
		assertTrue(a.get(2).getUsername().equals(test_b.getUsername()));

	}

}
