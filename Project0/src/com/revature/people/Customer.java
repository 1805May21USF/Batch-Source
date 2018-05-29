package com.revature.people;

import com.revature.accounts.Account;
import com.revature.accounts.Checking;
import com.revature.accounts.Joint;
import com.revature.accounts.Savings;

public class Customer extends Person {

	private String claim_number;
	private Savings savings_account;
	private Checking checking_account;
	private Joint joint_account;
	
	protected Customer(String first_name, String last_name, String address, int phone, String username, String password,int SSN) {
		super(first_name, last_name, address, phone, username, password, SSN);
	}
	
	protected int apply_for_application() {
		return 0;
	}
	
	protected void view_personal_info() {
		
	}
	
	protected void check_application(String claim_number) {
		
	}
	
	protected void check_banking_account(Account account) {
		
	}
}
