package com.revature.BankingProject;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.ArrayList;
import java.util.UUID;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.revature.Utility.UtilityActions;

class TestUserActions {
	private static UserActions u = new UserActions();
	private static CustomerActions c = new CustomerActions();
	private static RegistrationActions r = new RegistrationActions();
	private static UUID id;
	private static File bankfilename = new File("BankAccounts.txt");
	private static File regfilename = new File("UserAccounts.txt");
	private static File cusfilename = new File("CustomerAccounts.txt");
	
	//Executes once before all 
	@BeforeAll
	static void setup() {	
		clearAccounts();
			
		makeDummyUsers();
	}
	
	@AfterAll
	static void tearDown() {
		clearAccounts();
	}
	
	private static void makeDummyUsers() {
		r.register("user", "pass", 0);
		id = UserActions.createBankAccount();	
		c.attachBankAccountToCustomer(id, "user");	
	}
	
	private static void clearAccounts() {
		UtilityActions.clearAccounts(bankfilename);
		UtilityActions.clearAccounts(regfilename);
		UtilityActions.clearAccounts(cusfilename);
	}
	
	@Test
	void testCreateAccount() {
		//Get id on success
		assertNotNull(id);
	}
	
	@Test
	void testGetAllBankAccounts() {
		//Gets all bank accounts
		assertNotNull(u.getBankAccounts());
		
		//Gets null if no accounts exist
		clearAccounts();
		assertNull(u.getBankAccounts());
		makeDummyUsers();
	}
	
	@Test
	void testGetBankAccountById() {
		//Get account success
		assertNotNull(u.getBankAccountById(id));
		
		//Get account failure
		assertNull(u.getBankAccountById(UUID.randomUUID()));
	}
	
	@Test
	void testBankAccountExists() {
		//Account exists
		assertTrue(u.bankAccountExists(id));
		
		//Account does not exist
		assertFalse(u.bankAccountExists(UUID.randomUUID()));
	}
	
	@Test
	void testGetBalance() {
		//Get balance of a account real account
		assertNotNull(u.getBalance(id));
	}
	
	@Test 
	void testDeposit() {
		double balance = u.getBalance(id);
		u.deposit(u.getBankAccountById(id), 25.03);
		double balance2 = u.getBalance(id);
		double difference = balance2 - balance;
		
		//Deposit funds and balance changes
		assertEquals(difference, 25.03, 0.01);
	}
	
	@Test
	void testWithdraw() {
		u.deposit(u.getBankAccountById(id), 4.0);
		double balance = u.getBalance(id);
		
		u.withdraw(u.getBankAccountById(id), 2.0);
		double balance2 = u.getBalance(id);
		
		//different balances in account
		assertNotEquals(balance, balance2, 0.01);
	}
	
	@Test
	void testTransfer() {
		//make another user
		r.register("user2", "pass", 0);
		UUID id2 = UserActions.createBankAccount();	
		c.attachBankAccountToCustomer(id2, "user2");
		
		double balance = u.getBalance(id);
		double balance2 = u.getBalance(id2);
		ArrayList<BankAccount> accs = u.getBankAccounts();
		
		u.transfer(id, id2, 50);
		//Transfer funds changes balances
		assertEquals(u.getBalance(id), balance - 50, 0.01);
		assertEquals(u.getBalance(id2), balance + 50, 0.01);
	}
}
