package com.revature.beans;

public class Employee {
	private String firstname;
	private String lastname;
	private String username;
	private String password;
	//private String accountid;
	private String accountnumber;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(String firstname, String lastname, String username, String password, String accountnumber) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
		this.accountnumber = accountnumber;
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

//	public String getAccountid() {
//		return accountid;
//	}
//
//	public void setAccountid(String accountid) {
//		this.accountid = accountid;
//	}

	public String getAccountnumber() {
		return accountnumber;
	}

	public void setAccountnumber(String accountnumber) {
		this.accountnumber = accountnumber;
	}
	
	@Override
	public String toString() {
		return "Employee [firstname=" + firstname + ", lastname=" + lastname + ", username=" + username + ", password="
				+ password + ", accountnumber=" + accountnumber + "]";
	}
}
