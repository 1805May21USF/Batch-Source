package com.revature.P0Banking;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class AccountTests {
	private static Account test = new Account("test");
	private static Account test1 = new Account("test1");
	
	@Test
	public void createUniqueId() {
		
		ArrayList<Account> test = new ArrayList<Account>();
		
		for(int i = 0; i < 5; i++)
		{
			test.add(new Account("test"+i));
		}
		assertTrue(test.get(0).getId() != test.get(4).getId());
	}
	
	@Test
	public void testAddToBalance() {
		test.setBalance(test.getBalance()+500.00);
		assertTrue(test.getBalance()==500.00);
	}
	
	@Test
	public void testsubtractFromBalance() {
		test.setBalance(test.getBalance()-450.00);
		System.out.println(test.getBalance());
		assertTrue(test.getBalance()==50.00);
	}
	
	@Test
	public void testTransfer() throws BadInputException{
		test.withdraw(50);
		test1.deposit(50);
		assertTrue(test1.getBalance()==50);
		
	}

}
