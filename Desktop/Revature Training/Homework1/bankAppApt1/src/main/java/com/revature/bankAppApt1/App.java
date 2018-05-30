package com.revature.bankAppApt1;

/**
 * Hello world!
 *
 */
import java.util.Scanner;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import java.io.*;

public class App extends Options{
	
	final static Logger logger = Logger.getLogger(App.class);
	
	private static void runMe(String parameter){
		
		if(logger.isDebugEnabled()){
			logger.debug("This is debug : " + parameter);
		}
		
		if(logger.isInfoEnabled()){
			logger.info("This is info : " + parameter);
		}
		
		logger.warn("This is warn : " + parameter);
		logger.error("This is error : " + parameter);
		logger.fatal("This is fatal : " + parameter);
		
	}

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		Customer c = new Customer();
		c.setFName("Rafael");
		//c.setFName(input.nextLine());
		c.setLName("Mariano");
		//c.setLName(input.nextLine());
		c.setUserName("fee");
		//c.setUserName(input.nextLine());
		c.setPassword("0");
		//c.setPassword(input.nextLine());
		c.setCheckings(100.00);
		//c.setCheckings(input.nextDouble());
		c.setSavings(200.00);
		//c.setSavings(input.nextDouble());
		
		
		Boolean again = true;
		String userWant ="";
		
		LoginCustomer lc = new LoginCustomer(); //this is to compare the original username and password 
		Options op = new Options(); //class for the menu
		
		do 
		{
			//asking user to login or sign up for a new account
			//System.out.print("Login or Sign Up?: ");
			runMe("Login or Sign Up?: ");
			userWant = input.nextLine();
			
			
			
			
			if(userWant.equals("Login")) 
			{
				//System.out.print("Enter username: ");
				runMe("Enter username: ");
				lc.setLoginUserName(input.nextLine());
				//System.out.print("Enter password: ");
				runMe("Enter password: ");
				lc.setLoginPassword(input.nextLine());
				
				
				//to which account do you want to logiin to?

				
				// if user types in the username and password and matches the factory username and password then it'll log them in and will give them the options
				if(lc.getLoginUserName().equals(c.getUserName()) && lc.getLoginPassword().equals(c.getPassword())) 
				{
					//System.out.println("\n\t\tWelcome! "+c.getFName());
					//System.out.println("\n\t\tWelcome "+c.getFName()+"!\n");
					runMe("\n\t\tWelcome "+c.getFName()+"!\n");
					
					//Calling Options class to display the menu options
					op.whatYouWant(c.getFName(), c.getLName(), c.getCheckings(), c.getSavings());
					c.setCheckings(op.getCh());
					again = false;
				}
				else 
				{
					//System.out.println("Incorrect username and password.");
					runMe("Incorrect username and password.");
					//System.out.println("Enter username: ");
					runMe("Enter username: ");
					lc.setLoginUserName(input.nextLine());
					//System.out.println("Enter password: ");
					runMe("Enter password: ");
					lc.setLoginPassword(input.nextLine());
					
					if(lc.getLoginUserName().equals(c.getUserName()) && lc.getLoginPassword().equals(c.getPassword())) 
					{
						//System.out.println("\n\t\tWelcome! "+c.getFName());
						//System.out.println("\n\t\tWelcome, "+c.getFName()+"!\n");
						runMe("\n\t\tWelcome, "+c.getFName()+"!\n");
						
						//Calling Options class to display the menu options
						op.whatYouWant(c.getFName(), c.getLName(), c.getCheckings(), c.getSavings());
						c.setCheckings(op.getCh());
						again = false;
					}
					
				}	
			}
			else if(userWant.equals("Sign up"))
			{
				//System.out.print("Enter your First Name: ");
				runMe("Enter your First Name: ");
				String ser = input.nextLine();
				//System.out.print("Enter your Last Name: ");
				runMe("Enter your Last Name: ");
				String last1 = input.nextLine();
				//System.out.print("Create a username: ");
				runMe("Create a username: ");
				String user1 = input.nextLine();
				//System.out.println("Create a password: ");
				runMe("Create a password: ");
				String pass1 = input.nextLine();
				double ck = 50.00;
				double svngs = 50.00;
				
				
				SignUp su = new SignUp();
				su.createSignUp(ser, ser, last1, user1, pass1);
				
				op.whatYouWant(ser, last1, ck, svngs);
			}
		
			
		}while(again);
		

		
		//set boolean for admin
		//set true if youre an admin
		
		
		//--------------------------------------- below is used for the original Login ----------------------------------
		
		// Serializing an Object
		try 
		{
			FileOutputStream fileOut = new FileOutputStream("Customer.ser"); //this will create a Customer.ser file
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(c);
			out.close();
			fileOut.close();
			//System.out.printf("Serialized data is saved in custoomer.ser");
			runMe("Serialized data is saved in custoomer.ser");
		}
		catch(IOException ioe) 
		{
			ioe.printStackTrace();
		}
		
		
		// Deserializing an Object
		c = null;
		try 
		{
			FileInputStream fileIn = new FileInputStream("Customer.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			c = (Customer) in.readObject();
			in.close();
			fileIn.close();
		}
		catch(IOException ioe) 
		{
			ioe.printStackTrace();
		}
		catch(ClassNotFoundException cnf) 
		{
			//System.out.println("Customer class not found");
			runMe("Customer class not found");
			cnf.printStackTrace();
			return;
		}
		
/*	      System.out.println("\nDeserialized Customer...");
	      System.out.println("Name: " + c.getFName()+" "+c.getLName());
	      System.out.println("Username: " + c.getUserName());
	      System.out.println("Password: " + c.getPassword());
	      System.out.println("Checkings: " + c.getCheckings());
	      System.out.println("Savings: " + c.getSavings());*/
	      
	      runMe("\nDeserialized Customer...");
	      runMe("Name: " + c.getFName()+" "+c.getLName());
	      runMe("Username: " + c.getUserName());
	      runMe("Password: " + c.getPassword());
	      runMe("Checkings: " + c.getCheckings());
	      runMe("Savings: " + c.getSavings());


	}

}

