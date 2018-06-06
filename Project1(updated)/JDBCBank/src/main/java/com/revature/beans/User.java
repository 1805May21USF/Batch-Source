package com.revature.beans;

public class User {
	private String username;
	private String password;
	private int userID;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String username, String password, int userID) {
		super();
		this.username = username;
		this.password = password;
		this.userID = userID;
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
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", userID=" + userID + "]\n";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}
	
	public boolean isequal(String obj) {
		if (this.username == obj)
			return true;
		return false;
	}
	
	
	
}
