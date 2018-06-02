package com.revature.beans;

public class CustomerAccount {
	private int user_ID;
	private String username;
	private String password;
	private String firstname;
	private String lastname;
	
	public CustomerAccount() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CustomerAccount(String username, String password, String firstname, String lastname) {
		super();
		this.user_ID = 0;
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
	}
	public CustomerAccount(int user_id, String username, String password, String firstname, String lastname) {
		super();
		this.user_ID = user_id;
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
	}
	
	public int getUser_ID() {
		return user_ID;
	}
	public void setUser_ID(int user_ID) {
		this.user_ID = user_ID;
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
	
	@Override
	public String toString() {
		return "CustomerAccount [user_ID=" + user_ID + ", username=" + username + ", password=" + password
				+ ", firstname=" + firstname + ", lastname=" + lastname + "]";
	}
}
