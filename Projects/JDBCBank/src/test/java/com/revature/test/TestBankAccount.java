package com.revature.test;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.revature.beans.BankAccount;
import com.revature.beans.CustomerAccount;
import com.revature.daoimpl.BankAccountDAOImpl;
import com.revature.daoimpl.CustomerAccountDAOImpl;

class TestBankAccount {
	private BankAccountDAOImpl ba = new BankAccountDAOImpl();
	private static CustomerAccountDAOImpl ca = new CustomerAccountDAOImpl();
	private static CustomerAccount cus;
	
	@BeforeEach
	void setup() {
		cus = new CustomerAccount(0, "bruce", "pass", "John", "Smith");
		try {
			ca.createCustomerAccount(cus);
			for (CustomerAccount c : ca.getCustomerAccounts())
				if (c.getUsername().equals(cus.getUsername()))
					cus = c;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@AfterEach
	void tearDown() {
		try {
			ca.deleteCustomerAccount(cus);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	void testGetBankAccounts() {
		try {
			assertNotNull(ba.getBankAccounts());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	void testInsertBankAccount() {
		try {
			List<BankAccount> bankAccounts = ba.getBankAccounts();
			int size1 = bankAccounts.size();
			List<CustomerAccount> customerAccounts = ca.getCustomerAccounts();
			BankAccount acc = new BankAccount(0, 0, customerAccounts.get(0).getUser_ID());
			
			ba.createBankAccount(acc);
			
			bankAccounts = ba.getBankAccounts();
			int size2 = bankAccounts.size();
			
			assertNotEquals(size1, size2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	void testDeleteBankAccount() {
		try {
			BankAccount acc = new BankAccount(0, 0, cus.getUser_ID());	
			ba.createBankAccount(acc);
			
			List<BankAccount> bankAccounts = ba.getBankAccounts();
			int size1 = bankAccounts.size();
			ba.deleteBankAccount(bankAccounts.get(0));
			
			bankAccounts = ba.getBankAccounts();
			int size2 = bankAccounts.size();
			
			assertNotEquals(size1, size2);			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	void testUpdateBankAccount() {
		try {
			BankAccount acc = new BankAccount(0, 0, cus.getUser_ID());	
			ba.createBankAccount(acc);
			
			List<BankAccount> bankAccounts = ba.getBankAccounts();
			acc = bankAccounts.get(0);
			double beforeBal = acc.getBalance();
			
			acc.setBalance(40);
			ba.updateBankAccount(acc);
			
			bankAccounts = ba.getBankAccounts();
			acc = bankAccounts.get(0);
			double afterBal = acc.getBalance();
			
			assertNotEquals(beforeBal, afterBal);
			
			ba.deleteBankAccount(bankAccounts.get(0));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
