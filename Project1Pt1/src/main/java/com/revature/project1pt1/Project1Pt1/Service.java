package com.revature.project1pt1.Project1Pt1;

import java.io.File;

public class Service 
{
	Serializer serial = new Serializer();
	EmployeeSerializer eSerial = new EmployeeSerializer();
	
	private boolean fnameIsGood = false;
	private boolean lnameIsGood = false;
	private boolean userIsGood = false;
	private boolean passIsGood = false;


	public boolean isFnameIsGood() {
		return fnameIsGood;
	}

	public void setFnameIsGood(boolean fnameIsGood) {
		this.fnameIsGood = fnameIsGood;
	}

	public boolean isLnameIsGood() {
		return lnameIsGood;
	}

	public void setLnameIsGood(boolean lnameIsGood) {
		this.lnameIsGood = lnameIsGood;
	}

	public boolean isUserIsGood() {
		return userIsGood;
	}

	public void setUserIsGood(boolean userIsGood) {
		this.userIsGood = userIsGood;
	}

	public boolean isPassIsGood() {
		return passIsGood;
	}

	public void setPassIsGood(boolean passIsGood) {
		this.passIsGood = passIsGood;
	}
	
	public void withdraw(double wAmount, Customer c)
	{
		double balance = c.getAccountbal();
		if(wAmount > 0.0)
		{
			if(wAmount > balance)
			{
				System.out.println("Withdrawal amount exceeded account balance");
			}
			else 
			{
				c.setAccount(balance - wAmount);
				//acc.setBalance(acc.getBalance() - wAmount);
			}
		}
	}
	
	public void deposit(double dAmount, Customer c)
	{	
		
		double balance = c.getAccountbal();
		if (dAmount > 0.0) //if the deposit amount is a valid one
		{
			c.setAccount(balance + dAmount);
		}
	}
	
	
	//Transfer from current account to another account
	public void transfer(double tAmount, Customer c, Customer c2)
	{
		double balance = c.getAccountbal();
		if(tAmount > 0.0)
		{
			if(tAmount > balance)
			{
				System.out.println("Transfer amount exceeded account balance");
			}
			else
			{
				c.setAccount(balance - tAmount);
				c2.setAccount(balance + tAmount);
			}
		}

	}
	
	//validate first name
	public void validFirstName(String name) 
	{
		if (validateFirstName(name) == true )
		{
			setFnameIsGood(true);
		}
		else
		{
			System.out.println("Not a valid input. ");
		}
	}
	
	public static boolean validateFirstName(String firstName)
	{
			
		return firstName.matches("[A-Z][a-zA-Z]*");
			
	}
	
	
	//validate last name
	public void validLastName(String name) 
	{
		if (validateLastName(name) == true )
		{
			setLnameIsGood(true);
		}
		else
		{
			System.out.println("Not a valid input. ");
		}
	}
	
	public static boolean validateLastName(String lastName)
	{
		return lastName.matches( "[a-zA-z]+([ '-][a-zA-Z]+)*" );
			
	}
		
	//validate username
	public boolean validUsername(String name) 
	{
		if (validateUsername(name) == true )
		{
			return true;
		}

		System.out.println("Not a valid input. ");
		return false;
	}
	
	public static boolean validateUsername(String username)
	{
		return username.matches( "^[a-z0-9_-]{6,14}$" );
			
	}
		
	//validate password
	public void validPassword(String name) 
	{
		if (validatePassword(name) == true )
		{
			setPassIsGood(true);
		}
		else
		{
			System.out.println("Not a valid input. ");
		}
	}
	
	/*Passwords will contain at least 1 upper case letter
	Passwords will contain at least 1 lower case letter
	Passwords will contain at least 1 number or special character
	Passwords will contain at least 8 characters in length
	Password maximum length should not be arbitrarily limited*/
	public static boolean validatePassword(String password)
	{
		return password.matches( "(?=^.{8,}$)((?=.*\\d)|(?=.*\\W+))(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$" );
				
	}
	
	
	//Check if username already exists
	public boolean usernameExists(String u)
	{
		File file = new File("data/customers/" + u + ".text" );
		
		if( file.exists())
		{
			return true;
		}

		return false;
		
	}
	
	//Check if username already exists
	public boolean eUsernameExists(String u)
	{
			File file = new File("data/employees/" + u + ".text" );
			
			if( file.exists())
			{
				return true;
			}

			return false;
			
	}
	
	
	//customer serialize calls
	public void customerSerialize(Customer c)
	{
		serial.serializing(c);
	}
	
	public Customer customerDeserialize(String username)
	{
		return serial.deserializing(username);
	}
	
	
	//employee serialize calls
	public void employeeSerialize(Employee e)
	{
		eSerial.eSerializing(e);
	}
	
	public Employee employeeDeserialize(String username)
	{
		return eSerial.eDeserializing(username);
	}


}
