package com.revature.beans;

public class Account {
	private float balance;
	private int userID;
	private int accountID;
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Account(float balance, int userID, int accountID) {
		super();
		this.balance = balance;
		this.userID = userID;
		this.accountID = accountID;
	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public int getAccountID() {
		return accountID;
	}
	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}
	@Override
	public String toString() {
		return "Account [balance=" + balance + ", userID=" + userID + ", accountID=" + accountID + "]\n";
	}
	
	
}
