package com.revature.bankAppApt1;


public class Customer extends LoginCustomer implements java.io.Serializable{
	
	
	
	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	private double checkings;
	private double savings;
	
	public Customer() 
	{
		
	}
	
	public void setFName(String fName) 
	{
		firstName = fName;
	}
	
	public String getFName() 
	{
		return firstName;
	}
	
	public void setLName(String lName) 
	{
		lastName = lName;
	}
	
	public String getLName() 
	{
		return lastName;
	}
	
	public void setUserName(String user) 
	{
		userName = user;
	}
	
	public String getUserName() 
	{
		return userName;
	}
	
	public void setPassword(String pass) 
	{
		password = pass;
	}
	
	public String getPassword() 
	{
		return password;
	}
	
	public void setCheckings(double ch) 
	{
		checkings = ch;
	}
	
	public double getCheckings() 
	{
		return checkings;
	}
	
	public void setSavings(double sav) 
	{
		savings = sav;
	}
	
	public double getSavings() 
	{
		return savings;
	}

	
	

}
