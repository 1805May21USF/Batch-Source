package com.revature.storage;

import java.util.Vector;

public class Customer extends Person implements java.io.Serializable{
	// The serialVersionUID for the Customer class
	private static final long serialVersionUID = 3L;
	
	// The fields stored in the Customer class
	private Vector<Account> accounts;
	
	// Constructor for the Customer class
	public Customer(String un, String pw, String fn, char mi, String ln, int age, String a, Vector<Account> acc) {
		super(un, pw, fn, mi, ln, age, a);
		accounts = acc;
	}
	
	// Getter and setter for the accounts Vector
	public Vector<Account> getAccounts(){
		return accounts;
	}
	
	// Overrides the toString method in Object
	@Override
	public String toString() {
		StringBuilder output = new StringBuilder("Username: " + getUsername() + "\nPassword: " + getPassword() + "\nFirst Name: " + 
												 getFirstName() + "\nMiddle Initial: " + getMiddleInitial() + "\nLast Name: " + 
												 getLastName() + "\nAge: " + getAge() + "\nAddress: " + getAddress() + "\n\n");
		
		for(Account a : accounts) {
			output.append(a.toString() + "\n");
		}
		return output.toString();
	}
}
