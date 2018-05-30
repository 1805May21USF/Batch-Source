package com.revature.bank;

import java.util.ArrayList;

public class Customer implements java.io.Serializable {
	private String userName;
	private String password;
	private ArrayList<account> accounts;
	private boolean isEmployee;
	public Customer(String userName, String password, ArrayList<account> accounts) {
		super();
		this.userName = userName;
		this.password = password;
		this.accounts = accounts;
		this.isEmployee = false;
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
	public ArrayList<account> getAccounts() {
		return accounts;
	}
	public void setAccounts(ArrayList<account> accounts) {
		this.accounts = accounts;
	}
	public void addAccount(account x) {
		this.accounts.add(x);
	}
	public boolean isEmp() {
		return isEmployee;
	}
	public void setEmployee() {
		isEmployee = true;
	}
}
