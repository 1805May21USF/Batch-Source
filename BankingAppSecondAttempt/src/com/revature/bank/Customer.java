package com.revature.bank;

import java.io.Serializable;

public class Customer implements Serializable {
	
	private String firstName;
	private String lastName;
	private String accounts;
	private String password;
	
	public Customer(String firstName, String lastName, String accounts, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.accounts = accounts;
		this.password = password;
	}

	public String getAccounts() {
		return accounts;
	}

	public void setAccounts(String accounts) {
		this.accounts = accounts;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	/*public void printCustomer() {
		System.out.println("Customer ID: " + userName);
		System.out.println("Accounts: ");
		for(String i : accounts) {
			System.out.println("\t" + i);
		}
	}*/

}
