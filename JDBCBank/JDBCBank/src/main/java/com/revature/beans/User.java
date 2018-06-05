package com.revature.beans;

import java.util.List;

public class User {
	
	private int userID;
	private String firstName;
	private String lastName;
	private String email;
	private String username;
	private String password;
	private Account account;
	private List<Account> accounts;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int userID, String firstName, String lastName, String email, String username, String password) {
		super();
		this.userID = userID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.username = username;
		this.password = password;
	}
	
	public User(int userID, String firstName, String lastName, String email, String username, String password, Account account) {
		super();
		this.userID = userID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.username = username;
		this.password = password;
		this.account = account;
	}
	
	public User(String firstName, String lastName, String email, String username, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.username = username;
		this.password = password;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public void setAccount(Account account) {
		this.account = account;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	@Override
	public String toString() {
		return "User [userID=" + userID + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", username=" + username + ", password=" + password + "]";
	}
	
	

}
