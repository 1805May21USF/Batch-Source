package com.revature.accounts;

public class Checking extends Account{

	private String name = "Checking";
	
	protected String getName() {
		return name;
	}

	protected Checking(String banking_account_id, int balance, int previous_transaction) {
		super(banking_account_id,  balance,  previous_transaction);
	}
	
	protected void withdraw() {
		
	}
	
	protected void deposit() {
		
	}
	
	protected void transfer_funds() {
		
	}
	
}
