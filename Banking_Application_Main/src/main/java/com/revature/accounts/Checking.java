package com.revature.accounts;

public class Checking extends Account{

	private String name = "Checking";
	
	protected String getName() {
		return name;
	}

	protected Checking(int balance, int account_number) {
		super(balance, account_number);
	}
	
	protected void withdraw() {
		
	}
	
	protected void deposit() {
		
	}
	
	protected void transfer_funds() {
		
	}
	
}
