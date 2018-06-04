package com.revature.beans;

public class B_User {
	private int userID;
	private String username;
	private String firstName;
	private String lastName;
	private String password;
	private boolean loggedIn;
	private boolean admin;
	private String priv;
	
	public B_User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public B_User(int userID, String username, String firstName, String lastName, String password, boolean admin,
			boolean loggedIn, String priv) {
		super();
		this.userID = userID;
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.loggedIn = loggedIn;
		this.admin = admin;
		this.priv = priv;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isLoggedIn() {
		return loggedIn;
	}
	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}
	public boolean isAdmin() {
		return admin;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	public String getPriv() {
		return priv;
	}
	public void setPriv(String priv) {
		this.priv = priv;
	}
	
	@Override
	public String toString() {
		return "[userID=" + userID + ", username=" + username + ", firstName=" + firstName + ", lastName="
				+ lastName + ", password=" + password + ", loggedIn=" + loggedIn + ", admin=" + admin + ", priv=" + priv
				+ "]";
	}
	
	
	
	
}
