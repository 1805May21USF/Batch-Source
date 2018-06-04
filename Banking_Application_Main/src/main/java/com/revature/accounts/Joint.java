package com.revature.accounts;

import com.revature.people.Customer;

public class Joint extends Account{

	private Customer joint_partner;
	
	protected Joint(String banking_account_id, int balance, int previous_transaction) {
		super(banking_account_id, balance, previous_transaction);
	}
	
	protected void withdraw() {
		
	}
	
	protected void deposit() {
		
	}
	
	protected void transfer_funds() {
		
	}
}
