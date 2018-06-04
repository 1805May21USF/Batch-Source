package com.revature.bank;

import java.util.Scanner;
import java.sql.*;

public class Driver {
	

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		// creating the stuff for the database
		String url = "jdbc:oracle:thin:@may21-1805raf.clfhd4artcrz.us-east-2.rds.amazonaws.com:1521:ORCL";
		String user = "rafaeltx";
		String password = "Zoombies30";
			
	
		Connection myConn = null;
		ResultSet rs = null;
		PreparedStatement ps,ps2 = null;
		
		
		Boolean again = true; //create a boolean for the do/while loop
		String userWant =""; //this is to assign what the user wants to do either login or sign up
		
		String takeUsername = "";
		String takePassword ="";
		
		try 
		{
			//1. get a connection to a database
			myConn = DriverManager.getConnection(url, user, password);			
			
/*			//Creating a table for customers information
			ps = myConn.prepareStatement("create table bank_customers(firstname varchar(13), lastname varchar(13), "
					+ "checkings number, savings number, username varchar(13), password varchar(13))");
			ps.executeUpdate();
			System.out.println("Table Created.");
			
			//add to the table
			ps2 = myConn.prepareStatement("insert into bank_customers(firstname, lastname, checkings, savings, username, password)"
					+ " values(?,?,?,?,?,?)");
			
			ps2.setString(1, "Rafael");
			ps2.setString(2, "Mariano");
			ps2.setDouble(3, 200.00);
			ps2.setDouble(4, 300.00);
			ps2.setString(5, "fee");
			ps2.setString(6, "zero");
			rs = ps2.executeQuery(); //this goes after the values have been entered. 
			
			System.out.println("Data inserted.");*/
			
			UserType ut = new UserType();
			
			do 
			{
				System.out.print("Returning User/ Unregistered User/ Superuser ");
				userWant = input.nextLine();
				
				
				if(userWant.equals("Returning User")) 
				{
					System.out.print("Enter username: ");
					takeUsername = input.nextLine();
					
					System.out.print("Enter password: ");
					takePassword = input.nextLine();
					
					if(takePassword.equals(UserType.registeredUserPassword(takeUsername)))
					{
						ut.userOptions();
					}
				}
				else if(userWant.equals("Unregistered User")) 
				{
					ps = myConn.prepareStatement("insert into bank_customers(firstname, lastname, checkings, savings, username, password)"
							+ " values(?,?,?,?,?,?)");
					
					System.out.print("Enter First Name: ");
					String newfirstname = input.next();
					
					System.out.print("Enter Last Name: ");
					String newlastname = input.next();
					
					System.out.print("Enter Checkings Amount: ");
					double newcheckings = input.nextDouble();				
					
					System.out.print("Enter Savings Amount: ");
					double newsavings = input.nextDouble();			
					
					System.out.print("Enter new username: ");
					String newusername = input.next();
					
					System.out.print("Enter new password: ");
					String newpassword = input.next();
					
					ps.setString(1, newfirstname);
					ps.setString(2, newlastname);
					ps.setDouble(3, newcheckings);
					ps.setDouble(4, newsavings);
					ps.setString(5, newusername);
					ps.setString(6, newpassword);
					
					rs = ps.executeQuery();
					System.out.println("\nYou've created a new account!\n");
					
					ut.userOptions();
				}
				else if(userWant.equals("Superuser")) 
				{
					//call superuser object
				}
				else 
				{
					System.out.println("Exiting ... ");
				}
				
			}
			while(again);

		
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	
	
	
	

}
