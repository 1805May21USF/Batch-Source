package com.revature.beans;

public class Admin extends User {
	
	private int adminID;

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Admin(int userID, String firstName, String lastName, String email, String username, String password) {
		super(userID, firstName, lastName, email, username, password);
		// TODO Auto-generated constructor stub
	}

	public Admin(int adminID) {
		super();
		this.adminID = adminID;
	}

	public int getAdminID() {
		return adminID;
	}

	public void setAdminID(int adminID) {
		this.adminID = adminID;
	}
	
	

}
