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
	private String account_level;
	private String user_id;
	private String bank_account_id;
	
	public Customer(String first_name, String last_name, String address, String city, String state, String zipcode, String username, String password, String ssn, String phone, String account_level) {
		super(first_name, last_name, address, city, zipcode, state, username, password,  phone, ssn);
		
	}
	
	public Customer(String user_id, String first_name, String last_name, String address, String city, String state,
			String zipcode, String username, String password, String ssn, String phone,  String account_level, String bank_account_id) {
		super(first_name, last_name, address, city, zipcode, state, username, password, phone, ssn);
		this.account_level = account_level;
		this.user_id = user_id;
		this.bank_account_id = bank_account_id;
	}

	public void logged_in() {
		System.out.println("Logged");
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
	
	public String getAccount_level() {
		return account_level;
	}

	public String getUser_id() {
		return user_id;
	}

	public String getBank_account_id() {
		return bank_account_id;
	}

	
	public String getClaim_number() {
		return claim_number;
	}

	public Savings getSavings_account() {
		return savings_account;
	}

	public Checking getChecking_account() {
		return checking_account;
	}

	public Joint getJoint_account() {
		return joint_account;
	}
}
