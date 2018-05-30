package com.revature.main;
import java.util.ArrayList;

public class Client {
	
	
	private String name;
	private String userName;
	private String password;
	ArrayList<Account> accounts = new ArrayList<Account>();
	
	public Client(String userName, String password, String name) {
		this.setName(name);
		this.setUserName(userName);
		this.setPassword(password);
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
