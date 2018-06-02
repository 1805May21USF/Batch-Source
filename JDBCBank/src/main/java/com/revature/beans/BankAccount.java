package com.revature.beans;

public class BankAccount {
	private int bank_account_ID;
	private float balance;
	private int user_ID;
	
	public BankAccount() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BankAccount(int bank_account_ID, float balance, int user_ID) {
		super();
		this.bank_account_ID = bank_account_ID;
		this.balance = balance;
		this.user_ID = user_ID;
	}
	
	public int getBank_account_ID() {
		return bank_account_ID;
	}
	public void setBank_account_ID(int bank_account_ID) {
		this.bank_account_ID = bank_account_ID;
	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	public int getUser_ID() {
		return user_ID;
	}
	public void setUser_ID(int user_ID) {
		this.user_ID = user_ID;
	}
	
	@Override
	public String toString() {
		return "BankAccount [bank_account_ID=" + bank_account_ID + ", balance=" + balance + ", user_ID=" + user_ID
				+ "]";
	}
}
