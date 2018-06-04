package com.revature.beans;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.daoImpl.AccountDAOImpl;


public class User {

	private int userID;
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private static AccountDAOImpl acd = new AccountDAOImpl();
	
	public User() {
		super();
	}
	
	public User(int userID, String firstName, String lastName, String username, String password) {
		super();
		this.userID = userID;
		this.firstName = firstName;
		this.lastName = lastName;
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

	@Override
	public String toString() {
		return "User [userID=" + userID + ", firstName=" + firstName + ", lastName=" + lastName + ", username="
				+ username + ", password=" + password + "]";
	}
	
	/*admin can view all user accounts using this method
	 * 
	 */
	public void viewUserAccount() throws SQLException{
		System.out.println("===========================================");
		System.out.println("               ***Accounts***              ");
		List<Account> accounts = acd.getUserAccount(this.getUserID()); //gets the user account based on the userid
		int i = 1;
		for(Account ac: accounts ) {
			System.out.println(i+") Account ID: "+ ac.getAccountID() + " " +"Balance : $"+String.format("%.2f", ac.getBalance()));
			i++;
		}
		System.out.println("===========================================");
	}
	
	/*
	 * a registerd user can create a new bank account using this method
	 */
	public void createBankAccount() throws SQLException {
		acd.createAccount(this.userID);
		System.out.println("===========================================");
		System.out.println("You have successfully created a new account");
		System.out.println("===========================================");
	}
	
}
