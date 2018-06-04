/**
 * This class represents a customer of a bank.
 * 
 * Complete: No
 */
package com.revature.bankingapp2;

import com.revature.bankingapp2.ConnFactory;

/**
 * @author Nicholas Smith
 *
 */
public class Customer
{	
	public Customer(int userId, String firstName, String lastName,
			String username, String password)
	{
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
	}


	//instance variables
	private int userId;
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	public int getUserId()
	
	//getters and setters
	{
		return userId;
	}
	public void setUserId(int userId)
	{
		this.userId = userId;
	}
	public String getFirstName()
	{
		return firstName;
	}
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}
	public String getLastName()
	{
		return lastName;
	}
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
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
	
	
	@Override
	public String toString()
	{
		return "Customer [userId=" + userId + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", username=" + username
				+ ", password=" + password + "]";
	}
	

}
