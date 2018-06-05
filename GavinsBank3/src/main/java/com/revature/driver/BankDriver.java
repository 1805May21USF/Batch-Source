package com.revature.driver;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class BankDriver {
	static Scanner input = new Scanner(System.in); 
	public static int rank = 0;
	public static int id = 0;
	public static String user = null;
	static BankPerson  bp = new BankPerson();		
	static Account acc = new Account();


	
	public static void changeUser() {
		
		Connection conn = cf.getConnection();
		
		String tempUser;
		String tempPass;
		
		System.out.print("Enter your username: ");
		tempUser = input.next();
		System.out.print("Enter your password: ");
		tempPass = input.next();
		
		Statement stmt;
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM USER WHERE USERNAME = " + tempUser );
			
			if(!(rs.next())) {
				System.out.println("That is an unknown user and password combination.");
			} else if (!(rs.getString(3).equals(tempPass))) {
				System.out.println("That is an unknown user and password combination.");
			} else {
				rank = rs.getInt(4);
				user = tempUser;
				id = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
	}
	public static ConnFactory cf = ConnFactory.getInstance();
	public static void quit() {
		System.out.println("Goodbye!");
		System.exit(0);
	}
	public static void creation() {
		String fn,ln,pass,tempUser;
		System.out.print("\n\nPlease enter your first name: ");
		fn = input.next();
		System.out.print("Please enter your last name: ");
		ln = input.next();
		System.out.print("Please enter your username: ");
		tempUser = input.next();
		System.out.print("Please ender your password");
		pass = input.next();
		
		if(bp.userExists(tempUser)) {
			do {
				System.out.println("That username has alreay been taken. Please choose another.");
				tempUser = input.next();
			} while (bp.userExists(tempUser));
		}
	
		bp.createBankPerson(user,pass,1,fn,ln);
		rank = 1;
		System.out.println("Roll Tide! Your user has been created. Log in to apply for accounts!");
		
	}
	
	public static void logout() {
		rank = 0;
		id = 0;
		user = null;
	}
	
	public static void main(String[] args) {
		

//		ArrayList<>
		int temp = 0;
		String tempStr;
		
		int mode = 0;
		while(true)
			switch(rank) {
			
				case 0:
					System.out.println("Hello!");
					System.out.println("Press 0 to exit");
					System.out.println("Press 1 to create a new user account.");
					System.out.println("Press 2 to log into a previously made account");
					temp = input.nextInt();
					if(temp == 0) {
						quit();
					}
					if(temp == 1) {						
						creation();
					}
				
					if(temp == 2) {
						changeUser();
					}
				
					break;
					
				case 1:
					System.out.println("Hello!");
					System.out.println("Press 0 to log out.");
					System.out.println("Press 1 to view your account(s), approved and not.");
					System.out.println("Press 2 to apply for an account.");
					temp = input.nextInt();
					if(temp == 0) {
						logout();
					}
					
					//log out
					if(temp == 1) {
						
					}
					//view accounts
					if(temp == 2) {
						System.out.println("Sounds good! What is this account for? ");
						tempStr = input.nextLine();
						acc.createAccount( user,  tempStr);
						System.out.println("Alrighty! The account has been sent for approval.");
					}
					//apply for accounts
					
					
					
				case 2:
				case 3:
		
		}
		
		
		
		
	}
	
	

}
