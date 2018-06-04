package com.revature.console;
import com.revature.beans.User;
import com.revature.service.*;
import java.util.Scanner;

public class Display {
	
	String newLine = System.getProperty("line.separator");//This will retrieve line separator dependent on OS.
	Scanner input = new Scanner(System.in);
	Verify verify = new Verify();
	UserView uView = new UserView();
	Service service = new Service();
	
	public void userWelcome()
	{
		int choice;
		System.out.println("										Welcome to Wakanda National Bank");
        System.out.println("                 							     _______________________________________" + newLine);

          	 System.out.println("What would you like to do? Enter in the number of your selection.");
		     System.out.println("1. Apply for a new account" + newLine + "2. Login " + newLine + "3. Exit bank");
		     
		     while(!input.hasNextInt())
		     {
		    	 String input2 = input.next();
		    	 System.out.printf("\"%s\" is not a valid selection.\n" + newLine + "Enter 1, 2, or 3 to apply, login or exit respectively.", input2);
		     }
		     
		     choice = input.nextInt();
		     
		     switch(choice)
		     {
		     	case 1:
		     		//continue to register
		     		register();
		     		break;
		     	case 2:
		     		//continue to login
		     		login();
		     		break;
		     	case 3:
		     		//exit bank
		     		System.out.println("Thank you for using Wakanda National Bank! Goodbye.");
        			System.exit(0);
        			break;
		     	default:
		     		//error message
        			System.out.println("Type 1, 2, or 3 respectively continue or quit" + newLine);
        			break;
		     }
	}
	
	public void register()
	{
		String firstName;
		String lastName;
		String username;
		String password;
		boolean isValid = true;
		
		System.out.println("Welcome to the registration process for Wakanda National Bank!");
		
		//firstName
		do
		{
			System.out.println("Please enter your first name: ");
			System.out.println("First name must have a capital first letter.");
			firstName = input.next();
			if (verify.validFirstName(firstName) == false)
			{
				isValid = false;
				System.out.println("Invalid format for first name.");
			}
			else
			{
				isValid = true;
			}
			
		}while(isValid == false);
		
		//lastName
		do
		{
			System.out.println("Please enter your last name: ");
			lastName = input.next();
			
			if (verify.validLastName(lastName) == false)
			{
				isValid = false;
				System.out.println("Invalid format for last name.");
			}
			else
			{
				isValid = true;
			}
			
		}while(isValid == false);
		
		//userName
		do
		{
			System.out.println("Please create a username: ");
			System.out.println("Username cannot have capital letters and must include numbers.");
			username = input.next();		
			if (verify.validUsername(username) == false)
			{
				isValid = false;
				System.out.println("Invalid format for username.");
			}
			else
			{
				isValid = true;
			}
			System.out.println("Checking availability...");
			if(verify.usernameExists(username) == true)
			{	
				isValid = false;
				System.out.println("Username already exists.");
			}
			else
			{
				isValid = true;
			}
			
		}while(isValid == false);
		
		//password
		do
		{
			System.out.println("Please create a password: ");
			System.out.println("Pass must have at least 1 captial letter, a number and 1 special character.");
			password = input.next();
			
			if (verify.validPassword(password) == false)
			{
				isValid = false;
				System.out.println("Invalid format for password.");
			}
			else
			{
				isValid = true;
			}
			
		}while(isValid == false);
		
		System.out.println("You are now a registered user of Wakanda National Bank!");
		
		service.createUser(firstName, lastName, username, password);

		login();
		
	}
	
	public void login()
	{
		
		String username;
		String password;
		boolean isValid = true;
		
		System.out.println("Please login to your account.");
		
		//userName
		do
		{
			System.out.println("Please enter your username: ");
			username = input.next();
					
			if (verify.validUsername(username) == false)
			{
				isValid = false;
				System.out.println("Invalid format for username.");
			}
			else
			{
				isValid = true;
			}

		}while(isValid == false);
		
		//password
		do
		{
			System.out.println("Please enter your password: ");
			password = input.next();
			
			if (verify.validPassword(password) == false)
			{
				isValid = false;
				System.out.println("Invalid format for password.");				
			}
			else
			{
				isValid = true;
			}
			
			
		}while(isValid == false);
		
		System.out.println("Verifying...");
		if(verify.usernameExists(username) == false )
		{	
			System.out.println("Username does not exist." + newLine + "Taking you back to home... ");
			userWelcome();
		}
		else
		{
			System.out.println("Login successful.");
			if (service.isUser(username) == true)
			{
				uView.customerView(username);
				userWelcome();
			}
			else
			{
				uView.adminView(username);
				userWelcome();
			}
		}
		
					
	}
	
	
	

}
