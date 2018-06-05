/**
 * This class represents a customer of a bank.
 * A customer can login or register for an account. 
 * Complete: Yes
 */
package com.revature.bankingapplication;

import java.sql.SQLException;

import com.revature.bankingapplication.ConnFactory;

/**
 * @author Nicholas Smith
 *
 */
public class Customer
{	
	
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
	
	//method that will register a customer into the database
	public void register(String username, String password, String firstName, String lastName) throws SQLException 
	{
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		
		CustomerTools customerTools = new CustomerTools();
		customerTools.insertCustomer(username, password, firstName, lastName);
	}
	
	//method that will allow the customer to login into the system
	public void login() 
	{
		
	}
	
}
