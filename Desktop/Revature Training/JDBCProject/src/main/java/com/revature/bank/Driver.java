package com.revature.bank;

import java.util.Scanner;
import java.sql.*;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;


public class Driver {
	
	public static Logger logger = Logger.getLogger(Driver.class);
	
	
	public static void main(String[] args) throws SQLException{
		
		BasicConfigurator.configure();
		
		Scanner input = new Scanner(System.in);
		
		// creating the stuff for the database
		String url = "jdbc:oracle:thin:@may21-1805raf.clfhd4artcrz.us-east-2.rds.amazonaws.com:1521:ORCL";
		String user = "rafaeltx";
		String password = "Zoombies30";
			
	
		Connection myConn = null;
		ResultSet rs = null;
		PreparedStatement ps,ps2 = null;
		
		
		Boolean again = true; //create a boolean for the do/while loop
		int userWant; //this is to assign what the user wants to do either login or sign up
		
		String takeUsername = "";
		String takePassword ="";
		
		try 
		{
			//1. get a connection to a database
			myConn = DriverManager.getConnection(url, user, password);	
			
			//----------------------------- Comment out after table has been created -----------------------------
/*			
			//Creating a table for customers information
			ps = myConn.prepareStatement("create table if not exists bank_customers(firstname varchar(13), lastname varchar(13), "
					+ "checkings number, savings number, username varchar(13), password varchar(13))");
			ps.executeUpdate();
			System.out.println("Table Created.");*/
			
			//-----------------------------------------------------------------------------------------------------
			
			
/*			//add to the table
			ps2 = myConn.prepareStatement("insert into bank_customers(firstname, lastname, checkings, savings, username, password)"
					+ " values(?,?,?,?,?,?)");
			
			ps2.setString(1, "Rafael");
			ps2.setString(2, "Mariano");
			ps2.setDouble(3, 200.00);
			ps2.setDouble(4, 300.00);
			ps2.setString(5, "fee");
			ps2.setString(6, "zero");
			rs = ps2.executeQuery(); //this goes after the values have been entered. 
*/			
			System.out.println("Data inserted.");
			
			UserType ut = new UserType();
			
			do 
			{
				System.out.println("[1] Returning User");
				System.out.println("[2] Unregistered User");
				System.out.println("[3] Superuser");
				System.out.println("[< 4] To Exit");

				System.out.print("\nLoggin as: ");
				userWant = input.nextInt();
				
				
				if(userWant == 1) 
				{
					System.out.print("Enter username: ");
					takeUsername = input.next();
					
					System.out.print("Enter password: ");
					takePassword = input.next();
					
					if(takePassword.equals(UserType.registeredUserPassword(takeUsername)))
					{
						ut.userOptions(takeUsername);
					}

				}
				else if(userWant == 2) 
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
					
					System.out.println("\n"+newfirstname+", "+"You are now a registered user!");
					
					rs = ps.executeQuery();
					
					ut.userOptions(newusername);
				}
				else if(userWant == 3) 
				{
					//call superuser object
					
					Superuser su = new Superuser();
					su.superuse();
				}
				else 
				{
					System.out.println("Exiting ... ");
					break;
				}
				
			}
			while(again);

		
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		
		myConn.close();
	}
	
	
	
	
	

}
