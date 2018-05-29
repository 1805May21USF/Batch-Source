package com.revature.BankingProject;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.UUID;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.revature.Utility.UtilityActions;

class TestAdminActions {
	private static UserActions u = new UserActions();
	private static RegistrationActions r = new RegistrationActions();
	private static UUID id, id2;
	private static CustomerAccount cus, cus2;
	private static BankAccount bk, bk2;
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
		cus = CustomerActions.createCustomerAccount("user", "asdf", "asdf", "asdf");
		//cus.addBankAccountID(id);
		//CustomerActions.saveCustomerAccount(cus);	
		
		r.register("user2", "pass", 0);
		id2 = UserActions.createBankAccount();
		cus2 = CustomerActions.createCustomerAccount("user2", "asdf", "asdf", "asdf");
		//cus2.addBankAccountID(id2);
		//CustomerActions.saveCustomerAccount(cus2);
	}
	
	private static void clearAccounts() {
		UtilityActions.clearAccounts(bankfilename);
		UtilityActions.clearAccounts(regfilename);
		UtilityActions.clearAccounts(cusfilename);
	}
	
	@Test
	void testApproveAccount() {
		UserActions.approveAccount(id, cus);
		//check bank is open
		bk = UserActions.getBankAccountById(id);
		assertTrue(bk.isOpen());
		
		//check cus has account 
		cus = CustomerActions.getCustomerAccountByUsername("user");
		assertEquals(cus.getBankAccountIDs().get(0), id);
	}
	
	@Test 
	void testDenyAccount() {
		UserActions.denyAccount(id, cus);
		//check bank is closed
		assertNull(UserActions.getBankAccountById(id));
		
		//check is deleted
		assertNull(CustomerActions.getCustomerAccountByUsername("user"));
	}
	
	//cancel account
	//approve request for account
	//deny request for account
	//edit personal info of account
}
