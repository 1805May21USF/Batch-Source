/**
 * This class interacts with the user.
 */
package com.revature.bankingapplication;

//import the Scanner class
import java.util.Scanner;

/**
 * @author Nicholas Smith
 *
 */
public class Terminal
{
	//class variables
	Scanner input = new Scanner(System.in);
	int numSelection;
	String username;
	String password;
	
	//create a method that welcomes the user
	public void welcome() 
	{
		System.out.println("Welcome to Green Bank.");
		System.out.println("Please press 1 to login.");
		System.out.println("Please press 2 create an account.");
		
		//assign numSelection to what the user enters next
		numSelection = input.nextInt();
	}
	
	//create a method to login in a customer
	public void logIn() 
	{
		System.out.println("Please enter user name:");
		username = input.next();
		System.out.println("Please enter password:");
		password = input.next();
	}
	
	//create a method to register a customer
}
