package com.revature.P0Banking;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.*;

class CustomerTests {

	private static ArrayList<Account> test_accts = new ArrayList<Account>();
	//private static Customer test = new Customer("Bob", 2, "user", "pass");
	
	@BeforeEach
	public void beforeEach(TestInfo info) {
		System.out.println("Initialize Test Data for "+info.getDisplayName());
	}
	
	@Test
	public void testCustomerTest() {
		Customer testMe = new Customer("Bob", 2, "user", "pass");
		assertNotNull(testMe);
	}
	
	
	@Test
	public void testPickAccount() {
		Account newacct = new Account("Joint");
		Account newacct1 = new Account("Joint");
		test_accts.add(newacct);
		test_accts.add(newacct1);
		for(int i=0; i<test_accts.size();i++) {
			System.out.println((i+1)+") "+test_accts.get(i).getName()+"-"+test_accts.get(i).getId());
		}
		assertNotSame(test_accts.get(0),test_accts.get(1));
	}

}
