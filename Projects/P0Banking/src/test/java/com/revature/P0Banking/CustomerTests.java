package com.revature.P0Banking;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

class CustomerTests {

	@BeforeEach
	public void beforeEach(TestInfo info) {
		System.out.println("Initialize Test Data for "+info.getDisplayName());
	}
	
	@Test
	public void createCustomerTest() {
		Customer one = new Customer("Jimmy", 23, "Jim123","apple");
		assertNotNull(one);
	}
	
	@Test
	public void testUnPwCreation() {
		fail("Not yet implemented");
	}

}
