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
	private int ss;
	private int age;
	
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public int getSs()
	{
		return ss;
	}
	public void setSs(int ss)
	{
		this.ss = ss;
	}
	public int getAge()
	{
		return age;
	}
	public void setAge(int age)
	{
		this.age = age;
	}

	//create a constructor for Customer that takes 3 arguments
	public Customer(String name, int ss, int age)
	{
		this.name = name;
		this.ss = ss;
		this.age = age;
	}
	
	//create a constructor for Customer that takes no arguments
	public Customer() 
	{
		//
	}
	
	//getters and setters
	
	

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
	//returns Account
	public Account register (String username, String password) 
	{
		//creates a new Account Object
		Account a1 = new Account(username, password);
		
		return a1;
	}
	
	//create method that prints customer information
	public void printCustomer() 
	{
		//print to the console
		System.out.println("Customer name: " + name);
		System.out.println("Customer Social Security: " + ss);
		System.out.println("Customer age: " + age);
	}
	
	//create a method so that a customer can apply for an account
	public void apply() 
	{
		//a customer must at least 18 to open a bank account
	}

}
