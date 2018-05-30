package com.revature.accounts;

public abstract class Account {
	
	private int balance;
	private int account_number;
	
	protected Account(int balance, int account_number) {
		this.balance = balance;
		this.account_number = account_number;
	}

	abstract void withdraw();
	
	abstract void deposit();
	
	abstract void transfer_funds();
}
