/**
 * This class represents a bank account.
 * 
 * Complete: No
 */
package com.revature.bankingapp;

/**
 * @author Nicholas Smith
 *
 */
public class Account
{
	private double balance;
	private int accountNumber;
	
	//getters and setters
	public double getBalance()
	{
		return balance;
	}
	public void setBalance(double balance)
	{
		this.balance = balance;
	}
	public int getAccountNumber()
	{
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber)
	{
		this.accountNumber = accountNumber;
	}
	
	//create a method to withdraw funds
	//takes double 
	//returns nothing
	public void withdraw(double amount) 
	{
		//subtract amount from balance
		balance = balance - amount;
	}
	
	//create a method to deposit funds
	//takes double
	//returns nothing
	public void deposit(double amount) 
	{
		//add amount to balance
		balance = balance + amount;
	}
	
}
