package com.revature.main;

public class Account {
	
	private int accountID;
	private String username;
	private double balance;
	
	public Account(String username, int id, double balance) {
		// TODO Auto-generated constructor stub
		this.setUsername(username);
		this.setAccountID(id);
		this.setBalance(balance);
	}

	public String toString() {
		
		return "Account#  " + accountID + "  ,  Balance:  " + balance + "  " ;
	}
	
	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public int getAccountID() {
		return accountID;
	}

	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}

	
}
