/**
 * This class is a representation of a banking application. 
 */
package com.revature.bankingapp;

import java.util.Scanner;

/**
 * @author Nicholas Smith
 *
 */
public class Driver
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
		Customer c1 = new Customer("Nicholas Smith", "smithboy", "123", 4141);
		
		System.out.println("c1 name: " + c1.getName());
		System.out.println("c1 username: " + c1.getUsername());
		System.out.println("c1 pass: " + c1.getPassword());
		System.out.println("c1 id: " + c1.getId());
		
		//line break
		System.out.println("");
		
		//view the balances of a1 and a2
		System.out.println("a1 balance: " + a1.getBalance());
		System.out.println("a2 balance: " + a2.getBalance());
		
		//test the transfer method
		//transfer 45.85 dollars from a1 to a2
		
		c1.transfer(a1, a2, 45.85);
		
		//print the new balances of a1 and a2
		System.out.println("a1 balance: " + a1.getBalance());
		System.out.println("a2 balance: " + a2.getBalance());
			
		//-----------Customer TESTING END ------------
		
		
	}

}
