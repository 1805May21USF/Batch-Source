package com.revature.driver;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.revature.beans.Account;
import com.revature.beans.Admin;
import com.revature.beans.User;
import com.revature.daoImpl.AccountDAOImpl;
import com.revature.daoImpl.UserDAOImpl;

public class Driver {

	public final static Scanner input = new Scanner(System.in);
	public final static UserDAOImpl usd = new UserDAOImpl();
	public final static AccountDAOImpl acd = new AccountDAOImpl();
	
	public static void main(String[] args) {
		mainMenu();
	}
	
	public static void mainMenu() {
		//main display that appears when you first run the app
		
		char c = '\0';
		
		System.out.println("Enter an option to login or signup:");
		System.out.println("U: User Login");
		System.out.println("A: Admin Login");
		System.out.println("S: Sign Up");
		
		c = input.next().charAt(0);
			
			switch(c){
				
				case 'U':
					userLogin();
					break;
					
				case 'A':
					adminLogin();
					break;
					
				case 'S':
					signUp();
					mainMenu();
					break;
				
				default:
					System.out.println("===========================================");
					System.out.println("Invalid Option Entered");
					System.out.println("===========================================");
					System.out.println("Scanner is being closed. Please run the app again");
					System.out.println("===========================================");
					input.close();
					break;
			}

	}
	
	public static void userLogin() {
		//this method generates the login screen for the user
		
		String username, password;
		
		System.out.println("===========================================");
		System.out.println("            ***User Login***             ");
		System.out.println("Username:");
		username = input.next();
		System.out.println("Password");
		password = input.next();
		
		List<User> users = null;
		try {
			users = usd.getUserList();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(users != null)
			for(User u: users)
				if(u.getUsername().equals(username) && u.getPassword().equals(password)) { 
					//checks the validation of the username and password
					
					System.out.println("===========================================");
					System.out.println("Login Successful");
					System.out.println("===========================================");
					System.out.println("Welcome, " + u.getFirstName() + " " + u.getLastName());
					System.out.println("===========================================");
					userMenu(u);
				}else {
						System.out.println("===========================================");
						System.out.println("Incorrect Credential. Try again");
						System.out.println("===========================================");
						userLogin();
				}
	}
	
	public static void signUp() {
		//this method generates the signup screen for the new users
		
		String firstname, lastname, username, password;
		
		List<User> users = null;
		try {
			users = usd.getUserList();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("===========================================");
		System.out.println("          ***User Registration***          ");
		System.out.println("Enter user Firstname:");
		firstname = input.next();
		System.out.println("Enter user Lastname:");
		lastname = input.next();
		System.out.println("Enter Username:");
		username = input.next();
		System.out.println("Enter Password");
		password = input.next();
		
			if(users != null) {
				for(User user: users)
					if(user.getFirstName().equals(firstname) && user.getLastName().equals(lastname)
							&& user.getUsername().equals(username) && user.getPassword().equals(password)) {
						//checks if the user already exists
						
						System.out.println("===========================================");
						System.out.println("User already exists");
						System.out.println("===========================================");
					}else {
						try {
							usd.registerUser(firstname, lastname, username, password);
							System.out.println("===========================================");
							System.out.println("Successfully Registered");
							System.out.println("===========================================");
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
			}
			
	}
	
	public static void adminLogin() {
		//this method generates the admin login screen
		
		String adminUsername, adminPassword;
		
		Admin su = new Admin();
		
		System.out.println("===========================================");
		System.out.println("            ***Admin Login***             ");
		System.out.println("Admin Username:");
		adminUsername = input.next();
		System.out.println("Admin Password");
		adminPassword = input.next();
		
		if(su.getUsername().equals(adminUsername) && su.getPassword().equals(adminPassword)) {
			//validation check for admin username and password
			
			System.out.println("===========================================");
			System.out.println("Welcome, Admin " + su.getSuperUserName());
			System.out.println("===========================================");
			adminMenu(su);
		}else {
			System.out.println("===========================================");
			System.out.println("Incorrect login. Try again.");
			System.out.println("===========================================");
			adminLogin();
		}
	}
	
	public static void userMenu(User u) {
		//usermenu after a user has logged in
		
		Account ac = new Account();
		
		char c = '\0';
		
		System.out.println("V: View Account");
		System.out.println("C: Create Account");
		System.out.println("D: Deposit");
		System.out.println("W: Withdraw");
		System.out.println("L: Logout");
		System.out.println("Enter an option:");
		
		c = input.next().charAt(0);
			
			switch(c){
				
				case 'V':
					try {
						u.viewUserAccount();
					} catch (SQLException e) {
						e.printStackTrace();
					}
					userMenu(u);
					break;
					
				case 'C':
					try {
						u.createBankAccount();
					} catch (SQLException e) {
						e.printStackTrace();
					}
					break;
				case 'D':
					System.out.println("===========================================");
					System.out.println("Enter an amount to deposit: ");
					float amount = input.nextFloat();
					ac.deposit(amount);
					userMenu(u);
					break;
					
				case 'W':
					System.out.println("===========================================");
					System.out.println("Enter an amount to withdraw: ");
					amount = input.nextFloat();
					ac.withdraw(amount);
					userMenu(u);
					break;
					
				case 'L':
					System.out.println("===========================================");
					System.out.println("Successfully logged out");
					System.out.println("===========================================");
					mainMenu();
					break;
					
				default:
					System.out.println("Invalid Option");
					break;
			}

	}
	
	public static void adminMenu(Admin ad) {
		//admin view after an admin has logged in
		
		char c = '\0';
		int userID;
		
		System.out.println("V: View All Users");
		System.out.println("C: Create A User");
		System.out.println("D: Delete A User");
		System.out.println("U: Update A User");
		System.out.println("L: Logout");
		System.out.println("Enter an option:");
		
		c = input.next().charAt(0);
		
		switch(c){
		
		case 'V':
			try {
				ad.viewUsers();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			adminMenu(ad);
			break;
			
		case 'C':
			signUp();
			adminMenu(ad);
			break;
		case 'D':
			try {
				ad.deleteUser();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			adminMenu(ad);
			break;
			
		case 'U':
			try {
				ad.updateUser();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			adminMenu(ad);
			break;
			
		case 'L':
			System.out.println("===========================================");
			System.out.println("Successfully logged out");
			System.out.println("===========================================");
			mainMenu();
			break;
			
		default:
			System.out.println("Invalid Option");
			input.close();
			break;
	}	
	}
	
}
