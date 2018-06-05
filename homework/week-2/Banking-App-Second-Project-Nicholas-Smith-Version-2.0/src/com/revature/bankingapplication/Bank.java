/**
 * This class is a representation of a banking application. 
 */
package com.revature.bankingapplication;

import java.sql.SQLException;
import java.util.Scanner;

import com.revature.bankingapplication.ConnFactory;

/**
 * @author Nicholas Smith
 *
 */
public class Bank
{
	
	public static void main(String[] args) throws SQLException
	{
		//create an instance of ConnFactory 
		Scanner input = new Scanner(System.in);
		int numSelect = -1;
		Customer customer = new Customer();
		
		System.out.println("Welcome to Green Bank.");
		System.out.println("Please press 1 to login.");
		System.out.println("Please press 2 register.");
		System.out.println("Press 0 exit.");
			
		//assign numSelection to what the user enters next
		numSelect = input.nextInt();
		
		
		if(numSelect == 0) 
		{
			System.out.println("Exit");
		}
		else if (numSelect == 1)
		{
			System.out.println("login");
			//TODO: Call the login() method
		}
		else if (numSelect == 2) 
		{
			System.out.println("Please enter a username:");
			String username = input.next();
			
			//skip the newline
			input.nextLine();
			
			System.out.println("Please enter a password:");
			String password = input.next();
			
			//skip the newline
			input.nextLine();
			
			System.out.println("Please enter your first name:");
			String firstName = input.next();
			
			//skip the newline
			input.nextLine();
			
			System.out.println("Please enter your last name:");
			String lastName = input.next();
			
			//skip the newline
			input.nextLine();
			
			System.out.println("username: " + username);
			System.out.println("password: " + password);
			System.out.println("firstname: " + firstName);
			System.out.println("lastname: " + lastName);
			
			//Call the register() method
			customer.register(username, password, firstName, lastName);
			
			//
			System.out.println("You are now registered.");
			System.out.println("You may view your balance.");
		}
		
		String cString = customer.toString();
		System.out.println(cString);
	}
}
