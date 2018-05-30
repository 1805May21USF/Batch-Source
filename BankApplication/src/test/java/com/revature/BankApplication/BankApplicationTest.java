package com.revature.BankApplication;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class BankApplicationTest extends TestCase {

	private BankApp ba;
	private String a = "Accounts.txt";
	private String c = "Customer.txt";
	
	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
		ba = new BankApp();
		ba.deleteAllCustAcc();
		ba.checkAndCreate();
		
	}
	
	/**
	 * Checks if files can be created.
	 */
	public void testCheckandCreate() {
		File acc =new File(a);
		File cust = new File(c);
		acc.delete();
		cust.delete();
		ba.checkAndCreate();
		boolean exist = acc.exists() && cust.exists();
		assertEquals(true, exist);
		
	}
	
	public void testSignup() {
		//BankApp ba = new BankApp();
		ba.signup("Sunny","P","sunny,password");
		ArrayList<Customer> cl = null;
		try {
			ObjectInputStream ois;
			ois = new ObjectInputStream(new FileInputStream(c));
			cl = (ArrayList<Customer>) ois.readObject();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean sunnyExist = false;
		for(Customer customer : cl) {
			if(customer.getFname().equals("Sunny")) {
				sunnyExist = true;
			}
		}
		assertEquals(true,sunnyExist);
	}
	
	public void testpwCheck() {
		ba.signup("John", "Smith", "smithj,bestpassword");
		
		assertEquals(true,ba.pwCheck("smithj", "bestpassword"));
		assertEquals(false,ba.pwCheck("smithj", "Nogood"));
	}
	
	public void testUserExist() {
		ba.signup("Eri", "Sasaki", "eris,flower");
		assertEquals(true,ba.userExist("eris"));
		assertEquals(false,ba.userExist("eri"));
	}
}
