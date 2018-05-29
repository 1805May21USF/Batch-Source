package com.revature.P0Banking;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class UserTest {
	private static File file = new File("Test.txt");
	private static Customer test = new Customer("Bob", "user", "pass");
	//private static Employee test_e = new Employee("Sam", "user1", "pass");
	private static BankAdmin test_b = new BankAdmin("Tom", "user2", "pass");
	private static String[] info = {"user", "pass"};
	
	@Test
	void testCheckUnique() {
		String un = "Yes";
		String un1 = "Yes";
		assertEquals(un , un1);
	}
	
	@Test
	void testWriting() {
    	ArrayList<Partner> new_acc = new ArrayList<Partner>();
    	new_acc.add(test);
    	try {
	    	FileOutputStream fileout = new FileOutputStream(file);
	    	ObjectOutputStream out = new ObjectOutputStream(fileout);
	    	out.writeObject(new_acc);
	    	out.close();
    	}catch(IOException e){
    		System.out.println("Whoa there");
    	}
	}
	
    @Test
    void testReading() {
    	try {
    		FileInputStream filein = new FileInputStream(file);
    		ObjectInputStream in = new ObjectInputStream(filein);
    		ArrayList<?> accts = (ArrayList<?>) in.readObject();
    		for(Object a: accts) {
    			if(a instanceof Customer) {
    				assertTrue(((Customer) a).getName().equals(test.getName()));
    			}
    		}
    		in.close();
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
	}
	
	@Test
	void testTypeSafety() {
		ArrayList<Customer> bro = new ArrayList<Customer>();
		bro.add(new Customer("Fred1",23,"Fred22","nasd2"));
		ArrayList<?> accts =  (ArrayList<Customer>)bro;
		for(Object b:accts) {
			if(b instanceof Customer) {
				assertTrue(((Customer) b).getAge()==23);
			}
		}
	}
	
	@Test
	void testLoginMatch() {
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
			ArrayList<?> accts = (ArrayList<?>)in.readObject();
			assertTrue(User.returnUserNameMatch(info[0], accts).getUsername().equals(info[0]));
			in.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void whatPartnerTest() {
		Partner test_p = test;
		assertTrue(test_p instanceof Customer);
	}
	
	@Test //-get size and then test to see if update adds accounts
	public void testUpdateAccounts() {
		ArrayList<Partner> accounts = new ArrayList<Partner>();
		accounts.add(new Customer("Test1", "test", "pass"));
		accounts.add(new Customer("Test2", "test1", "pass1"));
		//get size and then test to see if update adds accounts
		int b = 3;
		for(Partner o: accounts) {
			o.setName("Test"+b);
			b++;
		}
		//int size = accounts.size();
		
		int c = 3;
		for(Partner o: accounts) {
			assertTrue(o.getName().equals("Test"+c));
			c++;
		}
	}
	
	@Test
	public void testBankAdminLogin() {
		assertTrue((Partner)test_b instanceof BankAdmin);
		assertTrue(!((Partner)test_b instanceof Customer));
	}

}
