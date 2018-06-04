package com.revature.beans;

import java.util.List;

public class Account {
	
	private int accountId;
	private double balance;
	private List<Transactions> transactions;
	
	public Account() {
		super();
	}

	public Account(int accountId, double balance, List<Transactions> transactions) {
		super();
		this.accountId = accountId;
		this.balance = balance;
		this.transactions = transactions;
	}
	
	public Account(int accountId, double balance) {
		super();
		this.accountId = accountId;
		this.balance = balance;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public List<Transactions> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transactions> transactions) {
		this.transactions = transactions;
	}

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", balance=" + balance
				+ ", transactions=" + transactions + "]";
	}

	
	
	
	
	
	
	

	
	
	
}