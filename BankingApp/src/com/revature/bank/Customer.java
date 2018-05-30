package com.revature.bank;

import java.io.Serializable;

public class Customer implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String firstName;
	private String lastName;
	private String account;
	private String savings;
	private String password;
	
	public Customer(String firstName, String lastName, String account, String savings, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.account = account;
		this.savings = savings;
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getSavings() {
		return savings;
	}

	public void setSavings(String savings) {
		this.savings = savings;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void printCustomer() {
		
		System.out.println("First Name: " + firstName);
		System.out.println("Last Name: " + lastName);
		System.out.println("Checking #: " + account);
		System.out.println("Savings #: " + savings);
		
	}
	
	/*public void printCustomer() {
		System.out.println("Customer ID: " + userName);
		System.out.println("Accounts: ");
		for(String i : accounts) {
			System.out.println("\t" + i);
		}
	}*/

}
