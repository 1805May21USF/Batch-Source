package com.revature.BankingApp;

import java.util.Scanner;

public class App 
{
	// Creates a Scanner object to process user input
	private static Scanner scan = new Scanner(System.in);
	
    public static void main( String[] args ){
    	menu();
    }
    
    public static void menu() {
    	Scanner scan = new Scanner(System.in);
    	
    	// Creates a String to hold input
    	String input = "";
    	
    	// Executes while the input isn't exit, ex, or e
    	while(!input.equalsIgnoreCase("exit")) {
    		// Requests input from the user
           	System.out.println("What do you want to do? (Sign-In, Sign-Up, Exit): ");
        	
    		input = scan.nextLine();
    		
    		// Executes if the user wants to sign in
    		if(input.equalsIgnoreCase("sign-in") || input.equalsIgnoreCase("si") || input.equalsIgnoreCase("signin")) {
    			SignIn si = new SignIn();
    			si.login();
    		}
    		// Executes if the user wants to sign up
    		else if (input.equalsIgnoreCase("sign-up") || input.equalsIgnoreCase("su") || input.equalsIgnoreCase("signup")) {
    			SignUp su = new SignUp();
    			su.signUp();
    		}
    		// Executes if the user enters shorthand for exit
    		else if (input.equalsIgnoreCase("exit") || input.equalsIgnoreCase("ex") || input.equalsIgnoreCase("e")) {
    			// Closes the Scanner and program
    			scan.close();
    			System.exit(0);
    		}
    		// Executes if the user enters anything else
    		else {
    			System.out.println("Please privde valid input (sign-in, signin, si, sign-up, signup, su, exit, ex, e): ");
    		}
    	}
    	
    	scan.close();
    }
    
    // Retrieves the scanner
    public static Scanner getScanner() {
    	return scan;
    }
}
