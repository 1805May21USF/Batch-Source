/**
 * This class represents a customer of a bank.
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
	private String username;
	private String password;
	private int id;
	
	//create a constructor for Customer that takes 4 arguments
	public Customer(String n, String u, String p, int i) 
	{
		name = n;
		username = u;
		password = p;
		id = i;
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
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
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
	
}
