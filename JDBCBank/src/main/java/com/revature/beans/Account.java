package com.revature.beans;

public class Account {
	
	private int accountNumber;
	private double amount;
	private String accountStatus;
	private int userId;
	
	public Account() {
		super();
	}

	public Account(int accountNumber, double amount, String accountStatus, int userId) {
		super();
		this.accountNumber = accountNumber;
		this.amount = amount;
		this.accountStatus = accountStatus;
		this.userId = userId;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
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
		return "Account [accountNumber=" + accountNumber + ", amount=" + amount + ", accountStatus=" + accountStatus
				+ ", userId=" + userId + "]";
	}

}
