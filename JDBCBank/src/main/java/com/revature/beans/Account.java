package com.revature.beans;

public class Account {
	
	private int accountNumber;
	private double balance;
	private String accountStatus;
	private int userId;
	
	public Account() {
		super();
	}

	public Account(int accountNumber, double balance, String accountStatus, int userId) {
		super();
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.accountStatus = accountStatus;
		this.userId = userId;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", amount=" + balance + ", accountStatus=" + accountStatus
				+ ", userId=" + userId + "]";
	}

}
