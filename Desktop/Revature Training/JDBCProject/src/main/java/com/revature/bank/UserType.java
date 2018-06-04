package com.revature.bank;

import java.sql.*;
import java.util.Scanner;

public class UserType {
	
	//Connection myConn = null;
	public static String url = "jdbc:oracle:thin:@may21-1805raf.clfhd4artcrz.us-east-2.rds.amazonaws.com:1521:ORCL";
	public static String user = "rafaeltx";
	public static String password = "Zoombies30";
	
	//if registered user
	public static String registeredUserPassword(String username) throws SQLException
	{
		Connection myConn = DriverManager.getConnection(url, user, password);
		String[] primaryKey = new String[1];
		primaryKey[0] = "username";
		String sql = "select password from bank_customers where username = ?";
		
		PreparedStatement ps = myConn.prepareStatement(sql, primaryKey);
		
		ps.setString(1, username);
		
		ResultSet rs = ps.executeQuery();
		
		
		if(rs.next() == true) 
		{
			return rs.getString("password");
		}
		else 
		{
			System.out.println("Didnt work.");
			return null;
		}	
		
	}
	
	
	public void userOptions() throws SQLException
	{
		Connection myConn = DriverManager.getConnection(url, user, password);
		ResultSet rs = null;
		String[] primaryKey = new String[1];
		primaryKey[0] = "username";
		String sql1 = "select firstname from bank_customers";
		
		//for option one
		PreparedStatement ps = null;
	
		Scanner input = new Scanner(System.in);
		Boolean keepGoing = true;
		int options;
		while(keepGoing) 
		{
			
			System.out.println("Enter 1: Create an Account");
			System.out.println("Enter 2: View Account");
			System.out.println("Enter 3: Delete Account");
			System.out.println("Enter 4: Deposit to another account");
			System.out.println("Enter 5: Withdrawl from another account");
			System.out.println("Enter 0: Logout");
			System.out.print("\nHere are your options: ");
			options = input.nextInt();
			
			if(options == 1) 
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
			}
			else if(options == 2) 
			{
				ps = myConn.prepareStatement("select * from bank_customers where username = ?");
				System.out.print("Enter username: ");
				String op2 = input.next();
				ps.setString(1, op2);
				
				rs = ps.executeQuery();
				
				display(rs);
			}
			else if(options == 3) 
			{
				ps = myConn.prepareStatement("delete from bank_customers where ? is null");	
				System.out.print("Enter username: ");
				String opt3 = input.next();
				
				ps.setString(1, opt3);
				
				rs = ps.executeQuery();
				
				System.out.println("\nIf Account was empty, it has been deleted.\n");
			}
			else if(options == 4) 
			{
				//callable statment
				System.out.println("Deposit to another account");
				
			}
			else if(options == 5) 
			{
				//callable statment
				System.out.println("Withdraw from another account");
			}
		}
	}
	
	//for superusers
	public void superuser() throws SQLException
	{
		Connection myConn = DriverManager.getConnection(url, user, password);
		ResultSet rs = null;
		String[] primaryKey = new String[1];
		primaryKey[0] = "username";
		String sql1 = "select firstname from bank_customers";
		
		//for option one
		PreparedStatement ps = null;
		
		//gotta change the options suitable for superuser
		
		
		Scanner input = new Scanner(System.in);
		Boolean keepGoing = true;
		int options;
		while(keepGoing) 
		{
			
			System.out.println("Enter 1: Create an Account");
			System.out.println("Enter 2: View All Account");
			System.out.println("Enter 3: Delete Account");
			System.out.println("Enter 4: Deposit to another account");
			System.out.println("Enter 5: Withdrawl from another account");
			System.out.println("Enter 0: Logout");
			System.out.print("\nHere are your options: ");
			options = input.nextInt();
			
			if(options == 1) 
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
			}
			else if(options == 2) 
			{
				ps = myConn.prepareStatement("select * from bank_customers");
/*				System.out.print("Enter username: ");
				String op2 = input.next();
				ps.setString(1, op2);*/
				
				rs = ps.executeQuery();
				
				display(rs);
			}
			else if(options == 3) 
			{
				ps = myConn.prepareStatement("delete from bank_customers where ? is null");	
				System.out.print("Enter username: ");
				String opt3 = input.next();
				
				ps.setString(1, opt3);
				
				rs = ps.executeQuery();
				
				System.out.println("\nIf Account was empty, it has been deleted.\n");
			}
			else if(options == 4) 
			{
				//callable statment
				System.out.println("Deposit to another account");
				
			}
			else if(options == 5) 
			{
				//callable statment
				System.out.println("Withdraw from another account");
			}
		}
	}
	
	
	
	
	private static void display(ResultSet myRs) throws SQLException 
	{
		while (myRs.next()) 
		{
			String lastName = myRs.getString("lastname");
			String firstName = myRs.getString("firstname");
			double checkings = myRs.getDouble("checkings");
			double savings = myRs.getDouble("savings");
			
			System.out.println("\nLast Name: "+lastName+"\n"+"First Name: "+firstName+"\n"+"Checkings: "+
					checkings+"\n"+"Savings: "+savings+"\n");
			
			//System.out.printf("\n%s, %s, %.2f, %s\n", lastName, firstName, checkings, savings);
		}
	}
	
	

}
