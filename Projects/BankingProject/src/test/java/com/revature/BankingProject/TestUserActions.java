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
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.revature.Utility.UtilityActions;

class TestUserActions {
	private static UserActions u = new UserActions();
	private static RegistrationActions r = new RegistrationActions();
	private static UUID id, id2;
	private static File bankfilename = new File("BankAccounts.txt");
	private static File regfilename = new File("UserAccounts.txt");
	private static File cusfilename = new File("CustomerAccounts.txt");
	
	//Executes once before all 
	@BeforeEach
	void setup() {	
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
		CustomerAccount cus = CustomerActions.createCustomerAccount("user", "asdf", "asdf", "asdf");
		UserActions.approveAccount(id, cus);
		
		r.register("user2", "pass", 0);
		id2 = UserActions.createBankAccount();
		CustomerAccount cus2 = CustomerActions.createCustomerAccount("user2", "asdf", "asdf", "asdf");
		UserActions.approveAccount(id2, cus2);
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
		assertNotNull(UserActions.getBankAccounts());
		
		//Gets null if no accounts exist
		clearAccounts();
		assertNull(UserActions.getBankAccounts());
	}
	
	@Test
	void testGetBankAccountById() {
		//Get account success
		assertNotNull(UserActions.getBankAccountById(id));
		
		//Get account failure
		assertNull(UserActions.getBankAccountById(UUID.randomUUID()));
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
		assertNotNull(UserActions.getBalance(id));
	}
	
	@Test 
	void testDeposit() {
		double balance = UserActions.getBalance(id);
		UserActions.deposit(UserActions.getBankAccountById(id), 25.03);
		double balance2 = UserActions.getBalance(id);
		double difference = balance2 - balance;
		
		//Deposit funds and balance changes
		assertEquals(difference, 25.03, 0.01);
	}
	
	@Test
	void testWithdraw() {
		UserActions.deposit(UserActions.getBankAccountById(id), 4.0);
		double balance = UserActions.getBalance(id);
		
		UserActions.withdraw(UserActions.getBankAccountById(id), 2.0);
		double balance2 = UserActions.getBalance(id);
		
		//different balances in account
		assertNotEquals(balance, balance2, 0.01);
	}
	
	@Test
	void testTransfer() {
		double balance = UserActions.getBalance(id);
		double balance2 = UserActions.getBalance(id2);

		UserActions.transfer(id, id2, 50);
		//Transfer funds changes balances
		assertEquals(UserActions.getBalance(id), balance - 50, 0.01);
		assertEquals(UserActions.getBalance(id2), balance2 + 50, 0.01);
	}
	
	@Test
	void testApplyForJoint() {
		//customer applies for joint ownership of user2's account
		CustomerAccount curAccount = CustomerActions.getCustomerAccountByUsername("user");	
		CustomerAccount otherAccount = CustomerActions.getCustomerAccountByUsername("user2");
		
		u.apply(curAccount, otherAccount.getBankAccountIDs().get(0));
		curAccount = CustomerActions.getCustomerAccountByUsername("user");
		assertNotNull(curAccount.getApplies().get(0));
	}
}
