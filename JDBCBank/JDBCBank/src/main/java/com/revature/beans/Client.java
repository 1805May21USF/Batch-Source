package com.revature.beans;

public class Client extends User {
	
	private int clientID;

	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Client(int userID, String firstName, String lastName, String email, String username, String password) {
		super(userID, firstName, lastName, email, username, password);
		// TODO Auto-generated constructor stub
	}

	public Client(int clientID) {
		super();
		this.clientID = clientID;
	}

	public int getClientID() {
		return clientID;
	}

	public void setClientID(int clientID) {
		this.clientID = clientID;
	}
	
	
	
	

}
