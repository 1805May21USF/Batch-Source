package com.revature.test;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.revature.main.Account;
import com.revature.main.Bank;

class BankTest{
	
	private Scanner in;
	public static ArrayList<Account> dummyList = new ArrayList<Account>();
	

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void test() {
		
		Bank bank = new Bank();
	}
	
	@Test
	void testConstructorName() {
		Bank bank = new Bank();
		assertEquals("Bank", bank.getName());
	}
	
	@Test
	void initArrayList() {
		
	}
	
	
	
	
	@Test
	void importAccountsFromFile(){
		
		boolean fileOpen = false;
		// TODO Auto-generated method stub
		try {
		 in = new Scanner(new File("Accounts.txt"));
		fileOpen = true;
		}
		catch(Exception e) {
			System.out.println("Something went wrong homie! Your Files Not there.");
		}
		
		
		
		try {
		while(in.hasNext()) {
			dummyList.add(new Account(in.nextInt(),in.next(),in.next(),in.nextDouble()));
			
		}
		}
		catch(Exception NullPointerException) {
			System.out.println("Noting There" );
		}
		finally {
		//Assert.assertEquals(1, actual);
		Assert.assertEquals("Karen", dummyList.get(0).getAccountHolder1());
		Assert.assertEquals("Bob", dummyList.get(1).getAccountHolder1());
		Assert.assertEquals(2, dummyList.size());
		System.out.println(dummyList.size());
		}
		Assert.assertEquals(true , fileOpen);
		
	}
	
		@Test
		void retrieveAccount() {
			
			Scanner input = new Scanner(System.in);
			System.out.println("Enter your account number");
			int myInt = input.nextInt();
			Account acc = dummyList.get(0);
			//System.out.println(acc);
			int id = acc.getAccountID();
			
			assertEquals(2, id);
		}

	
	
	

}
