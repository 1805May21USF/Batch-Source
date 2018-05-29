package com.revature.BankingApp;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.apache.log4j.FileAppender;

public class SignIn {
	private static Scanner scan = App.getScanner();
	
	public static void login() {
		String input = "";
		
		while(!input.equalsIgnoreCase("exit")) {
			System.out.println("Please enter your username (c to cancel): ");
		
			String user = scan.nextLine();
			
			if(user.equalsIgnoreCase("c")){
				return;
			}
		
			System.out.println("Please enter your password(c to cancel, b to re-enter username): ");
		
			String pass = scan.nextLine();
			
			if(pass.equals("c")) {
				return;
			}
			
			if(exists(user, pass)) {
				if(user.equals("admin")) {
					Banking.admin();
					input = "exit";
				}
				else {
					Banking.customer(user);
					input = "exit";
				}
			}
			else if(!pass.equalsIgnoreCase("b")) {
				System.out.println("Username and password do not match any customer records.");
			}
		}
	}
	
	static boolean exists(String username, String password) {
		// Retrieves the login file for the entered user
		try {
			// Tests if the user file exists
			File file = new File("data/login/" + username + ".txt");
			// Returns false if the user doesn't exist
			if(!file.exists())
				return false;
			
			BufferedReader br = new BufferedReader(new FileReader(file));
			
			String input;
			
			// Tests if the saved password matches the entered password
			while((input = br.readLine()) != null) {
				// Returns true if the passwords match
				if(input.equals(password)) {
					br.close();
					return true;
				}
			}
			
			// Returns false if the password doesn't match
			br.close();
			return false;
		// Executes if the user isn't found
		} catch (IOException e) {
			return false;
		}
	}
}
