package com.revature.BankingProject;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
	private static Scanner sc = new Scanner(System.in);
	
    public static void main( String[] args )
    {
    	boolean done = false;
    	
    	while (!done) {
    		System.out.println("Select 1 for Login, 2 for Register, 5 for Exit");
    		
    		String option = sc.nextLine();
    		if (option.equals("1")) {
    			//Login
    		} else if (option.equals("2")) {
    			//Register
    			boolean succeeded = false;
    			BankActions bank = new BankActions();
    			
    			while (!succeeded) {
    				int accountType = getAccountType();
    				if (accountType == -1)
    					break;
    				succeeded = bank.Register(getUsername(), getPassword(), accountType);
    			}
    		} else if (option.equals("5")) {
    			//Exit
    			break;
    		} else {
    			System.out.println("Invalid entry, please enter 1, 2, or 5.");
    		}
    	}
    	
    	sc.close();
    	
    	System.out.println("Closed.");
    }
    
    private static String getUsername() {
    	System.out.println("Username: ");
		return sc.nextLine();
    }
    
    private static String getPassword() {
		System.out.println("Password: ");
		return sc.nextLine();
    }
    
    private static int getAccountType() {
    	System.out.println("Account Type (0 for customer, 1 for employee, 2 for admin, 5 for exit): ");
    	String input = sc.nextLine();
		int accountType;
		
    	while (true) {
    		try {
    			accountType = Integer.parseInt(input);
    			if (accountType == 0 || accountType == 1 || accountType == 2)
    				return accountType;
    			if (accountType == 5)
    				return -1;
    		} catch (NumberFormatException e) {			
    		}
    		System.out.println("Invalid entry, please enter (0 for customer, 1 for employee, 2 for admin). ");
    	}
		
    }
}
