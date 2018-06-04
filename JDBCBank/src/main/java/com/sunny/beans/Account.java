package com.sunny.beans;

public class Account{
	
	private int accountId;
	private int accType;
	private float balance;
	
	public Account(int id, int type, float balance) {
		accountId = id;
		accType = type;
		this.balance = balance;
	}
	
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public int getAccType() {
		return accType;
	}
	public void setAccType(int accType) {
		this.accType = accType;
	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(float d) {
		this.balance = d;
	}

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", accType=" + accType + ", balance=" + balance + "]";
	}

	
	
	
}




