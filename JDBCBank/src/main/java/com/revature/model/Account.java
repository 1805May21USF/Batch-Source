package com.revature.model;

public class Account {
	private String userName;
	private int accountID;
	private double balance;
	private String account_Type;
	private String account_Name;
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Account(int accountID, String userName, double balance, String account_Type, String account_Name) {
		super();
		this.accountID = accountID;
		this.userName = userName;
		this.balance = balance;
		this.account_Type = account_Type;
		this.account_Name = account_Name;
	}
	public int getAccountID() {
		return accountID;
	}
	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getAccount_Type() {
		return account_Type;
	}
	public void setAccount_Type(String account_Type) {
		this.account_Type = account_Type;
	}
	public String getAccount_Name() {
		return account_Name;
	}
	public void setAccount_Name(String account_Name) {
		this.account_Name = account_Name;
	}

	public String display()
	{
		String output = "Account " + this.accountID  + " Balance " + this.balance;
		return output;
	}
	public void deposit(double x) {
		this.balance=this.balance+x;
		
	}
	public void withdraw(double x) {
		this.balance=this.balance-x;
		
	}
	

}
