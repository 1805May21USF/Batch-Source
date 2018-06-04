package com.revature.beans;

import java.util.List;

public class User {
	
	//variables
	private int userId;
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	
	private Usertype userType;
	private List<Account> account;
	
	//no var constructor
	public User() {
		super();
		
	}
	
	//var constructor for returns
	public User(int userId, String firstName, String lastName, String username, String password, Usertype userType,
			List<Account> account) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.userType = userType;
		this.account = account;
	}
	
	public User(int userId, String firstName, String lastName, String username, String password,
			List<Account> account) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.userType = userType;
		this.account = account;
	}

	//var constructor for creation
	public User(String firstName, String lastName, String username, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;

	}


	//setters and getters
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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

	public Usertype getUserType() {
		return userType;
	}

	public void setUserType(Usertype userType) {
		this.userType = userType;
	}

	public List<Account> getAccount() {
		return account;
	}

	public void setAccount(List<Account> account) {
		this.account = account;
	}

	
	//toString method
	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", username="
				+ username + ", password=" + password + ", userType=" + userType + ", account=" + account + "]";
	}
	
	
	
	

	
	


	
	
}
