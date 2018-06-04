package com.revature.model;

import java.io.Serializable;
import java.util.Random;


public class Customer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String userName;
	private String lastName;
	private String password;
	public int accountNumber;
	private int balance;
	
	public Customer(String userName, String password, int accountNumber, int balance) {
		this.name = name;
		this.userName = userName;
		this.lastName = lastName;
		this.password = password;
		this.accountNumber = accountNumber;
		this.balance = balance;
	}
	
	public Customer() {
		
	Random rand = new Random();
		accountNumber =  (int) Math.random();
		int n = rand.nextInt(100)+1;
		
	}
	
	public double getAccountNumber() {
		return accountNumber;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = (int) balance;
	
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
public Customer(String userName, String password, long accountNumber) {
	
	this.userName = userName;
	this.password = password;
	this.accountNumber = accountNumber;
}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
	

