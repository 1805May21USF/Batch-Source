/**
 * This class represents a customer of a bank.
 * A customer can have multiple Accounts. 
 * 
 * Complete: No
 */
package com.revature.bankingapp;

/**
 * @author Nicholas Smith
 *
 */
public class Customer
{
	//instance variables
	private String name;
	private int socialSecurity;
	
	//create a constructor for Customer that takes 4 arguments
	public Customer(String n, int i) 
	{
		name = n;
		setSocialSecurity(i);
	}
	
	//create a constructor for Customer that takes no arguments
	public Customer() 
	{
		//
	}
	
	//getters and setters
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	

	//create a method to transfer funds between accounts
	//takes Account object1, Account object 2, double amount
	//returns nothing
	public void transfer(Account a1, Account a2, double amount) 
	{
		//withdraws Amount from account 1
		//deposits Amount into account 2
		
		//set the account balance of a1 to a1's balance - amount
		a1.setBalance(a1.getBalance() - amount);
		
		//set the account balance of a2 to a2's balance + amount
		a2.setBalance(a2.getBalance() + amount);

	}
	
	//create a method that allows customers to register for an account
	//takes a user name and password
	//returns nothing
	public void register (String username, String password) 
	{
		
	}

	public int getSocialSecurity()
	{
		return socialSecurity;
	}

	public void setSocialSecurity(int socialSecurity)
	{
		this.socialSecurity = socialSecurity;
	}
	
}
