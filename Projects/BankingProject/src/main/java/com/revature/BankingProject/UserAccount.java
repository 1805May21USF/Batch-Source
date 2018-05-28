package com.revature.BankingProject;

import java.io.Serializable;

public class UserAccount implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String username;
	private String password;
	private int accountType;
	
	//0: customer, 1:employee, 2:admin
	public UserAccount(String username, String password, int accountType) {
		super();
		this.username = username;
		this.password = password;
		this.accountType = accountType;
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
	public int getAccountType() {
		return accountType;
	}
	public void setAccountType(int accountType) {
		this.accountType = accountType;
	}
    
}
