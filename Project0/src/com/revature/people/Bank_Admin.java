package com.revature.people;

public class Bank_Admin extends Person{

	protected Bank_Admin(String first_name, String last_name, String address, int phone, String username, String password, int SSN) {
		super(first_name, last_name, address, phone, username, password, SSN);
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
