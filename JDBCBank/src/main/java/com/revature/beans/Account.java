package com.revature.beans;

import java.sql.SQLException;

import com.revature.daoImpl.AccountDAOImpl;

public class Account {

	private int accountID;
	private float balance;
	private int userID;
	private static AccountDAOImpl acd = new AccountDAOImpl();
	
	public Account() {
		super();
		balance = 0.0f;
	}

	
	public Account(int accountID, float balance, int userID) {
		super();
		this.accountID = accountID;
		this.balance = balance;
		this.userID = userID;
	}


	public int getAccountID() {
		return accountID;
	}


	public void setAccountID(int accountID) {
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


	@Override
	public String toString() {
		return "Account [accountID=" + accountID + ", balance=" + balance + ", userID=" + userID + "]";
	}


	public void deposit(float amount) {
		//deposit method
		
		this.setBalance(this.getBalance() + amount);
		try {
			acd.updateAccount(this, this.getBalance()); //updates the balance of the user
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("===========================================");
		System.out.println("You have successfully deposited $" + balance);
		System.out.println("===========================================");
	}
	
	public void withdraw(float amount){
		//withdraw method
		
		if(amount <= this.getBalance()) {
			this.setBalance(this.getBalance() - amount);
			try {
				acd.updateAccount(this, this.getBalance()); //updates the user balance
			} catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.println("===========================================");
			System.out.println("You have successfully withdrawn $" + amount);
			System.out.println("===========================================");
		}else if(amount < 0.00) {
			System.out.println("===========================================");
			System.out.println("Amount must be bigger than 0");
			System.out.println("===========================================");
		}
		else {
			System.out.println("===========================================");
			System.out.println("Insufficient funds");
			System.out.println("===========================================");
		}
	}
}
