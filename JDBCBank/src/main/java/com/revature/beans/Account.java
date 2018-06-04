package com.revature.beans;

public class Account {
	private int accountnumber;
	private double accountbalance;
	private int account_id;
	
	public Account() {
		// TODO Auto-generated constructor stub
	}

	public Account(int accountnumber, double accountbalance, int account_id) {
		super();
		this.accountnumber = accountnumber;
		this.accountbalance = accountbalance;
		this.account_id = account_id;
	}

	public int getAccountnumber() {
		return accountnumber;
	}

	public void setAccountnumber(int accountnumber) {
		this.accountnumber = accountnumber;
	}

	public double getAccountbalance() {
		return accountbalance;
	}

	public void setAccountbalance(double accountbalance) {
		this.accountbalance = accountbalance;
	}

	public int getAccount_id() {
		return account_id;
	}

	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}

	@Override
	public String toString() {
		return "Account Number: " + accountnumber +
				"\nAccount Balance: " + accountbalance +
				"\nAccount ID: " + account_id;
		//return "Account [accountnumber=" + accountnumber + ", accountbalance=" + accountbalance + ", account_id="
				//+ account_id + "]";
	}
}
