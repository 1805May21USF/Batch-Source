package com.revature.beans;

public class Account {
	
	private int accountID;
	private int clientID;
	private double balance;
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Account(int accountID, int clientID, double balance) {
		super();
		this.accountID = accountID;
		this.clientID = clientID;
		this.balance = balance;
	}
	
	public Account(int clientID, double balance) {
		this.clientID = clientID;
		this.balance = balance;
	}
	
	public int getAccountID() {
		return accountID;
	}
	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}
	public int getClientID() {
		return clientID;
	}
	public void setClientID(int clientID) {
		this.clientID = clientID;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "Account [accountID=" + accountID + ", clientID=" + clientID + ", balance=" + balance + "]";
	}
	
	public void deposit(double amount) {
		this.balance = balance + amount;
	}
	
	public void withdraw(double amount) {
		this.balance = balance - amount;
	}
	
	

}
