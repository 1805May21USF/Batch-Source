package com.revature.BankingProject;

import java.io.Serializable;
import java.util.UUID;

public class BankAccount implements Serializable {
	private static final long serialVersionUID = 1L;
	private double balance;
	private UUID accountID;
	private boolean open;
	
	public BankAccount() {
		super();
		this.balance = 0;
		this.accountID = UUID.randomUUID();
		this.setOpen(false);
	}
	
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public UUID getAccountID() {
		return accountID;
	}
	public void setAccountID(UUID accountID) {
		this.accountID = accountID;
	}
	public boolean isOpen() {
		return open;
	}
	public void setOpen(boolean open) {
		this.open = open;
	}
}
