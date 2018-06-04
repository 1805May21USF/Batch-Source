package com.revature.people;

import com.revature.accounts.Account;

public class Bank_Admin extends Person{

	private String account_level;
	
	protected Bank_Admin(String first_name, String last_name, String address, String city, String state, String zipcode, String phone, String username, String password, String ssn, String status) {
		super(first_name, last_name, address, city, zipcode, state, phone, username, password, ssn);
		this.account_level = account_level;
	}
	
	 public String getAccount_level() {
		return account_level;
	}

	protected void approve_and_deny_accounts() {
		
	}
	
	protected void manage_funds(Customer account) {
		
	}
	
	protected <T> void search_for_account(T account) {
		
	}
	
	protected void view_account(Customer account) {
		
	}
	
	protected void cancel_account(Customer account) {
		
	}
}
