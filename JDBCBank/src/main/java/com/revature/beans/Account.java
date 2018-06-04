package com.revature.beans;

import java.text.DecimalFormat;

/**
 * Class for creating bank account objects.
 * @author Nathaniel Simpson
 *
 */
public class Account {
	
	private int accountNumber;
	private double balance;
	private String accountStatus;
	private int userId;
	
	DecimalFormat df = new DecimalFormat("$#0.00");
	
	// Default constructor
	public Account() {
		super();
	}

	// Constructor
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
	
	/*
	 * Returns the account number and balance as a formatted String
	 */
	public String toCustomerString() {
		return "Acct#: " + accountNumber + "---------- " + df.format(balance);
	}
	
	/*
	 * Returns the balance as a formatted String
	 */
	public String toBalanceString() {
		return df.format(balance);
	}

}
