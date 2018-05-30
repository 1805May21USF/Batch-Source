package com.revature.project1pt1.Project1Pt1;
import java.io.*;



public class Customer implements Serializable 
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private Account account;

	public Customer()
	{
		this.account = new Account();
	}
	//we never use this:(in the current version of this program)
/*	public Customer(String firstName, String lastName, String username, String password, int accNum, double initAccBalance ) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.account = new Account(initAccBalance, accNum );
	}
*/	
	
	public void setAccount(double d, int i) {
		// TODO Auto-generated method stub
		this.account.setAcctNum(i);
		this.account.setBalance(d);
	}
	
	public void setAccount(double d) {
		// TODO Auto-generated method stub
		this.account.setBalance(d);
	}
	
	public void setAccount(int i) {
		// TODO Auto-generated method stub
		this.account.setAcctNum(i);
	}


	public int getAccountnum() {
		return this.account.getAcctNum();
	}
	public double getAccountbal() {
		return this.account.getBalance();
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

	
	
}
