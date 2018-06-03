package com.revature.driver;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.revature.beans.Account;
import com.revature.beans.User;
import com.revature.daoImpl.AccountDAOImpl;
import com.revature.daoImpl.UserDAOImpl;

public class Driver {

	public final static Scanner input = new Scanner(System.in);
	public final static UserDAOImpl usd = new UserDAOImpl();
	public final static AccountDAOImpl acd = new AccountDAOImpl();
	
	public static void main(String[] args) {
		/*UserDAOImpl userdao = new UserDAOImpl();
		
		try {
			System.out.println(userdao.getUserList());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		mainMenu();
	}
	
	public static void mainMenu() {
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
					break;
				
				default:
					System.out.println("===========================================");
					System.out.println("Invalid Option Entered");
					System.out.println("===========================================");
					break;
			}
			//input.close();
	}
	
	public static void userLogin() {
		
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
					System.out.println("===========================================");
					System.out.println("Login Successful");
					System.out.println("===========================================");
					System.out.println("Welcome, " + u.getFirstName() + " " + u.getLastName());
					userMenu(u);
				}
		System.out.println("===========================================");
		System.out.println("Incorrect Credential. Try again");
		System.out.println("===========================================");
		userLogin();
	}
	
	public static void signUp() {
		String firstname, lastname, username, password;
		
		
		System.out.println("===========================================");
		System.out.println("            ***Registration***             ");
		System.out.println("Enter your Firstname:");
		firstname = input.next();
		System.out.println("Enter your Lastname:");
		lastname = input.next();
		System.out.println("Enter your Username:");
		username = input.next();
		System.out.println("Enter your Password");
		password = input.next();
			try {
				/*if(user.usernameExists(username)) {
					System.out.println("Username already exists");
				}else {*/
					usd.registerUser(firstname, lastname, username, password);
					System.out.println("===========================================");
					System.out.println("Successfully registered");
					System.out.println("===========================================");
					mainMenu();
				//}
			} catch (SQLException e) {
				e.printStackTrace();;;
			}
	}
	
	public static void adminLogin() {
		
	}
	
	public static void userMenu(User u) {
		
		
		
		char c = '\0';
		
		System.out.println("V: View Account");
		System.out.println("D: Deposit");
		System.out.println("W: Withdraw");
		System.out.println("L: Logout");
		System.out.println("\n");
		System.out.println("Enter an option:");
		
		c = input.next().charAt(0);
			
			switch(c){
				
				case 'V':
					viewUserAccount(u);
					userMenu(u);
					break;
					
				case 'D':
					System.out.println("===========================================");
					System.out.println("Enter an amount to deposit: ");
					
					break;
					
				case 'W':
					
					break;
					
				case 'L':
					System.out.println("===========================================");
					System.out.println("Successfully logged out");
					System.out.println("===========================================");
					mainMenu();
					break;
					
				default:
					System.out.println("Invalid Option");
					userMenu(u);
					break;
			}
			
	}
	
	public static void viewUserAccount(User u) {
		Account ac = new Account();
		System.out.println("===========================================");
		System.out.println("Account ID: " + u.getAccountID());
		System.out.println("Balance: " + ac.getBalance());
		System.out.println("===========================================");
	}
}
