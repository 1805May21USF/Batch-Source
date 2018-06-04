package com.sunny.JDBCBank;

import com.sunny.beans.Account;

import junit.framework.TestCase;

public class AccountTest extends TestCase {

	/**
	 * Test the create account 
	 */
	public void createAccTest() {
		Account a = new Account(0,1,0); //Savings account with balance of 0
		Account b = new Account(0,2,0); //Checkings account with a balance of 0
		
		
		
	}
}
