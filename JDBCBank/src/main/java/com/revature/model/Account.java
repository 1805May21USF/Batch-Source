package com.revature.model;

public class Account {

	private int accountID;
	private int customerID;
	private int balance;
	private String account_Type;
	private String account_Name;
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Account(int accountID, int customerID, int balance, String account_Type, String account_Name) {
		super();
		this.accountID = accountID;
		this.customerID = customerID;
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
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
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

	

}
