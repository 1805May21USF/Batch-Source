package com.revature.test;

public class Account {
	
	private String name;
	private double balance;
	
	public Account(String string, double d) {
		// TODO Auto-generated constructor stub
		this.setName(string);
		this.setBalance(d);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

}
