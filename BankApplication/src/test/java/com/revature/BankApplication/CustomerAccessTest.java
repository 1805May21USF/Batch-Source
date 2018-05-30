package com.revature.BankApplication;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


public class CustomerAccessTest extends TestCase {

	private String a = "Accounts.txt";
	private String c = "Customer.txt";
	private BankApp ba = new BankApp();
	private CustomerAccess ca;
	
	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
		ca = new CustomerAccess(new Customer("Sunny","Prasavath","sunny","password"));
	}
	
	public void testUpdateCustomer() {
		ArrayList<Customer> cl = null; 
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(c));
			cl = (ArrayList<Customer>) ois.readObject();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(Customer c : cl) {
			System.out.println(c.getFname() + " " + c.getLname() + "\n" +
					c.getUser() + " " + c.getPass() +"\n" + "Accounts: "  );
			for(int i :c.getAccNum()) {
				System.out.print(i + " ");
			}
			
		}
		
		ArrayList<Integer> inn = new ArrayList<Integer>();
		ca.getC().getAccNum().add(0);
		for(int i = 0; i < cl.size(); i++) {
			if(cl.get(i).getUser().equals(ca.getC().getUser())) {
				cl.set(i, ca.getC());
			}
		}
		
		for(Customer c : cl) {
			System.out.println(c.getFname() + " " + c.getLname() + "\n" +
					c.getUser() + " " + c.getPass() +"\n" + "Accounts: "  );
			for(int i :c.getAccNum()) {
				System.out.print(i + " ");
			}
		}
		
	
	}
}
