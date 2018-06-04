package com.revature.accounts;

public class Account {
	
	private int balance;
	private String banking_account_id;
	private int previous_transaction;

	public Account(String banking_account_id, int balance, int previous_transaction) {
		this.balance = balance;
		this.banking_account_id = banking_account_id;
		this.previous_transaction = previous_transaction;
	}
	
	protected int getBalance() {
		return balance;
	}

	protected String getBanking_account_id() {
		return banking_account_id;
	}

	protected int getPrevious_transaction() {
		return previous_transaction;
	}

}
