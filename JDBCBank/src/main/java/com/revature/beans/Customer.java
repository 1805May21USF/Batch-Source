package com.revature.beans;

public class Customer {
	private String firstname;
	private String lastname;
	private String username;
	private String password;
	private int accountnumber;
	private int accountId;
	private Account account;
	private int status;

	public Customer() {
		// TODO Auto-generated constructor stub
	}
	
	public Customer(String firstname, String lastname, String username, String password, Account account, int status) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
		this.account = account;
		this.status = status;
	}
	
	public Customer(String firstname, String lastname, String username, String password, int accountnumber,
			int status) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
		this.accountnumber = accountnumber;
		this.status = status;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getAccountnumber() {
		return accountnumber;
	}

	public void setAccountnumber(int accountnumber) {
		this.accountnumber = accountnumber;
	}

	@Override
	public String toString() {
		return "Customer: " + "\nFirstName: " + firstname +
		"\nLastName: " + lastname +
		"\nUsername: " + username +
		"\nPassword: " + password +
		"\nAccount Number: " + accountnumber +
		"\nStatus: " + status ;
	}
}
