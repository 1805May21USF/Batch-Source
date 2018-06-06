/**
 * This class is a representation of a banking application. 
 */
package com.revature.bankingapplication;

import java.sql.SQLException;
import java.util.Scanner;

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
		CustomerTools customerTools = new CustomerTools();
		AccountTools accountTools = new AccountTools();
		
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
			//TODO: Call the login() method
			System.out.println("Please enter your username:");
			String username = input.next();
			
			//skip the newline
			input.nextLine();
			
			System.out.println("Please enter your password:");
			String password = input.next();
			
			//check if the customer exists in the database
			boolean exists = customerTools.checkCustomer(username, password);
			
			if(exists == true) 
			{
				System.out.println("You are logged in.");
				System.out.println("Press 1 to view balance.");
				System.out.println("Press 2 to deposit.");
				System.out.println("Press 3 to withdraw.");
				System.out.println("Press 4 to transfer.");
				
				//grabe the userid
				int userId = customerTools.getDatabaseUserId(username, password);
				
				//use the userid to access to bank account

				
				//create a new Account (maybe. let me use the class instance first)
				//initialize it to match the customer's information
				//use the customer's id, since they match both tables
				
			
				int logNumSelect = -1;
				
				//assign numSelection to what the user enters next
				logNumSelect = input.nextInt();
				
				if(logNumSelect == 1) 
				{
					double balance;
					
					//call the viewBalance() method
					balance = accountTools.getDatabaseBalance(userId);
					
					System.out.println("Current balance: " + balance);
				}
				else if(logNumSelect == 2) 
				{
					System.out.println("You pressed: " + logNumSelect);
					
					//call the deposit() method

				}
				else if(logNumSelect == 3) 
				{
					System.out.println("You pressed: " + logNumSelect);
					
					//call the withdraw() method

				}
				
				//TODO: NOTE: I will probably have to skip this one.
				else if(logNumSelect == 4) 
				{
					System.out.println("You pressed: " + logNumSelect);
					//call the transfer method
				}
				
			}
			else 
			{
				System.out.println("Incorrect username and password.");
			}
			
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
			
			//call the insertCustomer method
			customerTools.insertCustomer(username, password, firstName, lastName);
			
			//assign bankAccountUserId to the newly generated customerAccountId
			/*int bankAccountUserId = customer.getUserId();*/
			
			int bankAccountUserId = customerTools.getUserId();
			
			//call the insertAccount() method
			accountTools.insertAccount(bankAccountUserId);
			
			//Inform the newly registered customer
			System.out.println("You are now registered.");
			
			//String cString = customerTools.toString();
			//System.out.println(cString);
		}
		
		//END. Close the Scanner.
		input.close();
	}
	
}
