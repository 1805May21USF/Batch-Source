/**
 * This class represents an application for a bank account.
 * If approved, customer can create an account.
 */
package com.revature.bankingapp;

/**
 * @author Nicholas Smith
 *
 */
public class Application
{
	//instance variables
	//customer information
	//boolean approved
	
	private String customerName;
	private int customerAge;
	private int customerSs;
	private boolean approved;
	
	public String getCustomerName()
	{
		return customerName;
	}
	public void setCustomerName(String customerName)
	{
		this.customerName = customerName;
	}
	public int getCustomerAge()
	{
		return customerAge;
	}
	public void setCustomerAge(int customerAge)
	{
		this.customerAge = customerAge;
	}
	public int getCustomerSs()
	{
		return customerSs;
	}
	public void setCustomerSs(int customerSs)
	{
		this.customerSs = customerSs;
	}
	public boolean isApproved()
	{
		return approved;
	}
	public void setApproved(boolean approved)
	{
		this.approved = approved;
	}
	
	//create a constructor for Application 
	public Application(String customerName, int customerAge, int customerSs)
	{
		this.customerName = customerName;
		this.customerAge = customerAge;
		this.customerSs = customerSs;
	}
	
	//create a method to print the Application to the console
	public void printApplication() 
	{
		System.out.println("Customer name: " + customerName);
		System.out.println("Customer age: " + customerAge);
		System.out.println("Customer social security: " + customerSs);
	}
	
}
