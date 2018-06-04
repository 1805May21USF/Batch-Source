package com.revature.bank;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Superuser extends View{
	
	//Connection myConn = null;
	public static String url = "jdbc:oracle:thin:@may21-1805raf.clfhd4artcrz.us-east-2.rds.amazonaws.com:1521:ORCL";
	public static String user = "rafaeltx";
	public static String password = "Zoombies30";
	
	Driver d = new Driver();
	
	//for superusers
		public void superuse() throws SQLException
		{
			Connection myConn = DriverManager.getConnection(url, user, password);
			ResultSet rs = null;
			String[] primaryKey = new String[1];
			primaryKey[0] = "username";
			String sql1 = "select firstname from bank_customers";
			
			//for option one
			PreparedStatement ps = null;
			Statement mystate = myConn.createStatement();
			CallableStatement myCall = null;
			
			View view = new View();
			
			Scanner input = new Scanner(System.in);
			Boolean keepGoing = true;
			int options;
			
			double deposit;
			double withdrawal;
			
			while(keepGoing) 
			{
				
				System.out.println("\nEnter 1: Create an Account");
				System.out.println("Enter 2: View an Account");
				System.out.println("Enter 3: Delete an Account");
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
					d.logger.info("\nYou've created a new account!\n");
				}
				else if(options == 2) 
				{
					ps = myConn.prepareStatement("select * from bank_customers where username = ?");
					d.logger.info("[Superuser]: Enter username: ");
					String op2 = input.next();
					ps.setString(1, op2);
					
					rs = ps.executeQuery();
					
					//from class view
					display(rs);
				}
				else if(options == 3) 
				{
					myCall = myConn.prepareCall(" {call delete_user(?)} ");
					d.logger.info("[Superuser]: Enter account username: ");
					String use = input.next();
					myCall.setString(1, use);
					myCall.execute();
					d.logger.info("Account deleted.");		
				}
				else if(options == 4) 
				{
					//callable statment
					String cos = "";
					System.out.print("From Checkings or Savings: ");
					cos = input.next();
					
					if(cos.equals("checkings")) 
					{
						myCall = myConn.prepareCall(" {call INCREASE_CHECKINGS(?,?)} ");
						d.logger.info("[Superuser]: Deposit Amount: ");
						deposit = input.nextDouble();
						d.logger.info("[Superuser]: Enter account username: ");
						String whichuser = input.next();
						myCall.setString(1, whichuser);
						myCall.setDouble(2, deposit);
						
						myCall.execute();
						
						d.logger.info("\n$"+deposit+" has been deposited to "+cos+" account: "+whichuser+"\n");
					}
					else if(cos.equals("savings")) 
					{
						myCall = myConn.prepareCall(" {call INCREASE_SAVINGS(?,?)} ");
						d.logger.info("[Superuser]: Deposit Amount: ");
						deposit = input.nextDouble();
						d.logger.info("[Superuser]: Enter account username: ");
						String whichuser = input.next();
						myCall.setString(1, whichuser);
						myCall.setDouble(2, deposit);
						
						myCall.execute();
						
						d.logger.info("\n$"+deposit+" has been deposited to "+cos+" account: "+whichuser+"\n");
					}
					else 
					{
						System.out.println("opps.");
					}
				}
				else if(options == 5) 
				{
					//callable statment
					System.out.print("From checkings or savings: ");
					String cos = input.next();
					
					if(cos.equals("checkings")) 
					{
						myCall = myConn.prepareCall(" {call WITHDRAWAL(?,?)} ");
						d.logger.info("[Superuser]: Withdrawal Amount: ");
						withdrawal = input.nextDouble();
						d.logger.info("[Superuser]: Enter account username: ");
						String whichuser = input.next();
						myCall.setString(1, whichuser);
						myCall.setDouble(2, withdrawal);
						
						myCall.execute();
						
						d.logger.info("\n$"+withdrawal+" has been deposited to "+cos+" account: "+whichuser+"\n");
					}
					else if(cos.equals("savings")) 
					{
						myCall = myConn.prepareCall(" {call WITHDRAWAL_SAVINGS(?,?)} ");
						d.logger.info("[Superuser]: Withdrawal Amount: ");
						withdrawal = input.nextDouble();
						d.logger.info("[Superuser]: Enter account username: ");
						String whichuser = input.next();
						myCall.setString(1, whichuser);
						myCall.setDouble(2, withdrawal);
						
						myCall.execute();
						
						d.logger.info("\n$"+withdrawal+" has been deposited to "+cos+" account: "+whichuser+"\n");
					}
					else 
					{
						System.out.println("ehh?");
					}
				}
			}
			myConn.close();
		}
		

}
