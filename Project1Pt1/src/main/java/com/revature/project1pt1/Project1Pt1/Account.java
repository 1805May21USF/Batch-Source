package com.revature.project1pt1.Project1Pt1;
import java.io.Serializable;


public class Account implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4L;
	//private String accountType;
	private double balance;
	private int acctNum;

	public Account()
	{
		
	}
	
	public Account( double balance, int acctNum) {
		super();
		
		this.balance = balance;
		this.acctNum = acctNum;

	}
	
	/*public Account(String accountType, double balance, int acctNum) {
		super();
		
		this.accountType = accountType;
		this.balance = balance;
		this.acctNum = acctNum;

	}*/

	/*public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}*/
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public int getAcctNum() {
		return acctNum;
	}
	public void setAcctNum(int acctNum) {
		this.acctNum = acctNum;
	}
	
	


}
