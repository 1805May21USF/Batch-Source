package com.revature.bank;

import java.sql.*;
import java.util.Scanner;

public class UserType extends Driver{
	
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
	
	//this is the menu that the user will see
	public void userOptions(String opUsername) throws SQLException
	{
		Connection myConn = DriverManager.getConnection(url, user, password);
		ResultSet rs = null;
		String[] primaryKey = new String[1];
		primaryKey[0] = "username";
		String sql1 = "select firstname from bank_customers";
		
		Statement mystate = null;
		PreparedStatement ps = null;
		CallableStatement myCall = null;
	
		Scanner input = new Scanner(System.in);
		Boolean keepGoing = true;
		int options;
		
		double deposit;
		double withdrawal;
		
		while(keepGoing) 
		{
			
			System.out.println("\nEnter 1: Create an Account");
			System.out.println("Enter 2: View Account");
			System.out.println("Enter 3: Delete Account");
			System.out.println("Enter 4: Deposit");
			System.out.println("Enter 5: Withdrawl");
			System.out.println("Enter 6: Logout");
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
				logger.info("\nYou've created a new account!\n");
			}
			else if(options == 2) 
			{
				ps = myConn.prepareStatement("select * from bank_customers where username = ?");
				//System.out.print("Enter username: ");
				//String op2 = input.next();
				ps.setString(1, opUsername);
				
				rs = ps.executeQuery();
				
				display(rs);
			}
			else if(options == 3) 
			{
				myCall = myConn.prepareCall(" {call delete_account(?)} ");
				myCall.setString(1, opUsername);
				myCall.execute();
				logger.info("If checkings = $0.00, account has been deleted.");
			}
			else if(options == 4) 
			{
				//callable statment
				String cos = "";
				System.out.print("From Checkings or Savings: ");
				cos = input.next();
				
				if(cos.equals("checkings")) 
				{
					//this will increase the checkings amount
					myCall = myConn.prepareCall(" {call INCREASE_CHECKINGS(?,?)} ");
					logger.info("Deposit Amount: ");
					deposit = input.nextDouble();
					myCall.setString(1, opUsername);
					myCall.setDouble(2, deposit);
					
					myCall.execute();
					
					logger.info("\n$"+deposit+" has been deposited to "+cos+" account: "+opUsername+"\n");
				}
				else if(cos.equals("savings")) 
				{
					myCall = myConn.prepareCall(" {call INCREASE_SAVINGS(?,?)} ");
					logger.info("Deposit Amount: ");
					deposit = input.nextDouble();
					myCall.setString(1, opUsername);
					myCall.setDouble(2, deposit);
					
					myCall.execute();
					
					logger.info("\n$"+deposit+" has been deposited to "+cos+" account: "+opUsername+"\n");
				}
				else 
				{
					System.out.println("oh well.");
				}
				
			}
			else if(options == 5) 
			{
				System.out.print("From checkings or savings: ");
				String cos = input.next();
				
				if(cos.equals("checkings"))
				{
					//callable statment
					//this will subtract from the checkings account. 
					myCall = myConn.prepareCall(" {call WITHDRAWAL(?,?)} ");
					logger.info("Withdrawal Amount: ");
					withdrawal = input.nextDouble();
					myCall.setString(1, opUsername);
					myCall.setDouble(2, withdrawal);
					
					myCall.execute();
					
					logger.info("\n$"+withdrawal+" has been deposited to "+cos+" account: "+opUsername+"\n");
				}
				else if(cos.equals("savings")) 
				{
					myCall = myConn.prepareCall(" {call WITHDRAWAL_SAVINGS(?,?)} ");
					logger.info("Withdrawal Amount: ");
					withdrawal = input.nextDouble();
					myCall.setString(1, opUsername);
					myCall.setDouble(2, withdrawal);
					
					myCall.execute();
					
					logger.info("\n$"+withdrawal+" has been deposited to "+cos+" account: "+opUsername+"\n");
				}
				else 
				{
					System.out.println("oh well.");
				}
			}
			else if(options == 6)
			{
				System.out.println("Logging out...\n");
				keepGoing = false;
			}
			
		}
		myConn.close();
	}
	
	
	
	
	
	private static void display(ResultSet myRs) throws SQLException 
	{
		while (myRs.next()) 
		{
			String lastName = myRs.getString("lastname");
			String firstName = myRs.getString("firstname");
			double checkings = myRs.getDouble("checkings");
			double savings = myRs.getDouble("savings");
			
			logger.info("\nLast Name: "+lastName+"\n"+"First Name: "+firstName+"\n"+"Checkings: "+
					checkings+"\n"+"Savings: "+savings+"\n");
			
			//System.out.printf("\n%s, %s, %.2f, %s\n", lastName, firstName, checkings, savings);
		}
	}
	
	

}
