package com.revature.beans;

public class B_Account {
	private int accountID;
	private float accountBalance;
	private String lastTransaction;
	
	public B_Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	public B_Account(int accountID, float accountBalance, String lastTransaction) {
		super();
		this.accountID = accountID;
		this.accountBalance = accountBalance;
		this.lastTransaction = lastTransaction;
	}
	public int getAccountID() {
		return accountID;
	}
	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}
	public float getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(float accountBalance) {
		this.accountBalance = accountBalance;
	}
	public String getLastTransaction() {
		return lastTransaction;
	}
	public void setLastTransaction(String lastTransaction) {
		this.lastTransaction = lastTransaction;
	}
	
	@Override
	public String toString() {
		return "B_Account [accountID=" + accountID + ", accountBalance=" + accountBalance + ", lastTransaction="
				+ lastTransaction + "]";
	}
}
