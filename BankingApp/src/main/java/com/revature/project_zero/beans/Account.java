package com.revature.project_zero.beans;

import java.io.Serializable;

public class Account implements Serializable{

	private double balance;
	
	public Account() {
		balance = 0.0;
	}
	
	public void deposit(double amount) {
		balance = balance + amount;
	}
	
	public void withdraw(double amount) {
		if(amount <= balance) {
			balance = balance - amount;
		}else {
			System.out.println("Insufficient funds");
		}
		
	}
	
	public double getBalance() {
		return balance;
	}
}
