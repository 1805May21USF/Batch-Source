/**
 * This class is a representation of a banking application. 
 */
package com.revature.bankingapp;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Nicholas Smith
 *
 */
public class Bank
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		//create a Scanner object to take user input
		Scanner input = new Scanner(System.in);
		
		//create a Customer object
		
		
		//welcome the user
		System.out.println("Welcome to Green Bank.");
		
		//prompt the user to enter user name
		System.out.println("Please enter user name:");
		
		//prompt the user to enter password
		System.out.println("Please enter password:");
		
		//greet the customer
		System.out.println("Hello customer");
		
		//line break
		System.out.println("");
		
		
		
		//------- Account TESTING BEGIN  ---------
		
		//create a new Account object
		Account a1 = new Account();
		a1.setAccountNumber(1212);
		a1.setBalance(500.25);
		
		double a1AN = a1.getAccountNumber();
		double a1B = a1.getBalance();
		
		System.out.println("A1 account number: " + a1AN);
		System.out.println("A1 balance: " + a1B);
		
		a1.deposit(40);
		System.out.println("A1 balance: " + a1.getBalance());
		
		a1.withdraw(100.25);
		System.out.println("A1 balance: " + a1.getBalance());
		
		
		//line break
		System.out.println("");
		
		//create a second Account object
		Account a2 = new Account();
		
		//add a deposit to account 2
		a2.deposit(300.50);
		
		//withdraw from account 2
		a2.withdraw(100.50);
		
		System.out.println("A2 balance " + a2.getBalance());
		
		
		//-----------Account TESTING END  -----------
		
		
		
		//---------- Customer TESTING BEGIN ----------
		
		//line break
		System.out.println("");
		
		//Create a new Customer object
		Customer c1 = new Customer("Nicholas Smith", 789881212);
		Customer c2 = new Customer("Bob Dole", 412562);
		Customer c3 = new Customer("Marry Joe", 7899754);
		
		
		
		System.out.println("c1 name: " + c1.getName());
		System.out.println("c1 social security: " + c1.getSocialSecurity());
		
		//line break
		System.out.println("");
		
		//view the balances of a1 and a2
		System.out.println("a1 balance: " + a1.getBalance());
		System.out.println("a2 balance: " + a2.getBalance());
		
		//test the transfer method
		//transfer 45.85 dollars from a1 to a2
		
		c1.transfer(a1, a2, 35.25);
		
		//line break
		System.out.println("");
		
		//print the new balances of a1 and a2
		System.out.println("a1 balance: " + a1.getBalance());
		System.out.println("a2 balance: " + a2.getBalance());
		
		
		//-----------Customer TESTING END ------------
		
		
		
		//-------------General TESTING BEGIN -----------
		
		
		//test the register method
		Account a3 = c1.register("boo", "8989");
		
		System.out.println("user: " + a3.getUsername());
		System.out.println("pass: " + a3.getPassword());
		
		//-------------General TESTING END --------------
		
		
		//------------Employee TESTING BEGIN-------------------
		
		//line break
		System.out.println("");
		
		//create a new employee object
		Employee e1 = new Employee("Bob", 7989);
		
		System.out.println("e1 name: " + e1.getName());
		System.out.println("e1 id: " + e1.getEmpID());
		
		//line break
		System.out.println("");
		e1.viewCustomer(c1);
		e1.viewCustomer(c2);
		e1.viewCustomer(c3);
		
		
		//------------Employee TESTING ENDS--------------------
		
	
	}

}
