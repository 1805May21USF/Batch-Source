package com.revature.bank;

import java.io.Serializable;

public class Account implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private double balance;
	
	public Account(double balance) {
		this.balance = balance;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public void deposit(double d) {
		balance += d;
	}
	
	public void withdraw(double w) {
		balance -= w;
	}
	
	/*public void printAccount() {
		System.out.println("Account number: " + accountNumber);
		System.out.println("Balance: " + balance);
	}*/

}
