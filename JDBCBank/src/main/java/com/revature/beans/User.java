package com.revature.beans;

import java.util.ArrayList;
import java.util.List;

public class User {

	private int userID;
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private int accountID;
	
	public User() {
		super();
	}
	
	public User(int userID, String firstName, String lastName, String username, String password, int accountID) {
		super();
		this.userID = userID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.accountID = accountID;
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

	public int getAccountID() {
		return accountID;
	}

	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}

	@Override
	public String toString() {
		return "User [userID=" + userID + ", firstName=" + firstName + ", lastName=" + lastName + ", username="
				+ username + ", password=" + password + ", accountID=" + accountID + "]";
	}

	public boolean usernameExists(String username) {
		List<User> users = new ArrayList<User>();
		
			if(users != null) {
				for(User user: users)
					if(user.getUsername().equals(username))
						return true;
			}
			return false;
	}
}
