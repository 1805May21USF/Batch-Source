/**
 * This class represents a bank account.
 * 
 * Complete: No
 */
package com.revature.bankingapplication;
/**
 * @author Nicholas Smith
 *
 */
public class Account
{
	private double balance;
	private int accountNumber;
	
	//account is also associated with a user name and password
	private String username;
	private String password;
	
	//create a constructor for Account
	public Account(String u, String p) 
	{
		username = u;
		password = p;
	}
	
	//create a constructor for Account using 0 parameters
	public Account() 
	{
		//
	}
	
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
	public String getUsername()
	{
		return username;
	}
	public void setUsername(String username)
	{
		this.username = username;
	}
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
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
 
	//create a method to view Account information
	public void printAccount() 
	{
		System.out.println("Balance: " + balance);
		System.out.println("Account number: " + accountNumber);
		System.out.println("Username: " + username);
		System.out.println("Password: " + password);
	}
	
	//create a method to view balance
	public void printBalance() 
	{
		System.out.println("Balance is: " + balance);
	}
	
}
