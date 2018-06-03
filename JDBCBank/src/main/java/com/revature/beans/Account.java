package com.revature.beans;

public class Account {

	private int accountID;
	private String firstName;
	private String lastName;
	private float balance;
	
	public Account() {
		super();
		balance = 0.0f;
	}

	public Account(int accountID, String firstName, String lastName, float balance) {
		super();
		this.accountID = accountID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.balance = balance;
	}

	public int getAccountID() {
		return accountID;
	}

	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Account [accountID=" + accountID + ", firstName=" + firstName + ", lastName=" + lastName + ", balance="
				+ balance + "]";
	}

	public void deposit(float amount) {
		balance = balance + amount;
	}
	
	public void withdraw(float amount) {
		if(amount <= balance) {
			balance = balance - amount;
			System.out.println("You have successfully withdrawn $" + amount);
		}else {
			System.out.println("Insufficient funds");
		}
	}
}
