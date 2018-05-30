/**
 * This class represents an employee.
 * An employee can view customer information
 * and approve/deny open applications for accounts.
 */
package com.revature.bankingapp;

/**
 * @author Nicholas Smith
 *
 */
public class Employee
{
	//instance variables
	private String name;
	private int empID;

	
	//getters and setters
	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getEmpID()
	{
		return empID;
	}

	public void setEmpID(int empID)
	{
		this.empID = empID;
	}


	//create a constructor for Employee
	public Employee(String name, int empID) 
	{
		this.name = name;
		this.empID = empID;
	}
	
	//create a method to view customer information
	//takes in a customer object
	//prints to the console
	public void viewCustomer(Customer c1) 
	{
		c1.printCustomer();
	}
}
