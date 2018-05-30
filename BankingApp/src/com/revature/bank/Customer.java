package com.revature.bank;

public class Customer {

	private String userName;
	private String[] accountNumbers;
	private String firstName;
	private String lastName;
	private String password;
	
	public Customer(String userName, String[] accountNumbers, String firstName, String lastName, String password) {
		this.userName = userName;
		this.accountNumbers = accountNumbers;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
	}
	
}
