package com.revature.BankingProject;

import java.util.Scanner;

public class App 
{
	public final static Scanner sc = new Scanner(System.in);
	private static RegistrationActions b = new RegistrationActions();
	
    public static void main( String[] args )
    {
    	boolean done = false;
    	String option;
    		
    	while (!done) {
    		System.out.println("Select 1 for Login, 2 for Register, -1 for Exit");
    		
    		option = sc.nextLine();
    		if (option.equals("1")) {
    			optionLogin();
    		} else if (option.equals("2")) {
    			optionRegister();
    		} else if (option.equals("-1")) {
    			break;
    		} else {
    			System.out.println("Invalid entry, please select 1 for Login, 2 for Register, 5 for Exit.");
    		}
    	}
    	
    	sc.close();
    	
    	System.out.println("Closed.");
    }
    
    private static void optionLogin() {
    	String username = getUsername();
		String password = getPassword();
		
		if (b.login(username, password)) 
			b.userOptions(username);
		else 
			System.out.println("Invalid login, try again.");
	}

	private static void optionRegister() {
    	boolean succeeded = false;  	
    	int accountType = getAccountType();
    	String username = "";
    	
		while (!succeeded) {
			username = getUsername();
			succeeded = b.register(username, getPassword(), accountType);			
		}
		//Create customerAccount and bankAccount, linking them together
		//change this if I get to employees accept/denying accounts
		CustomerAccount customerAccount = CustomerActions.createCustomerAccount(username, getName(), getAddress(), getAge());
		customerAccount.addBankAccountID(UserActions.createBankAccount());
		CustomerActions.saveCustomerAccount(customerAccount);
		//write the customerAccount back to file

		System.out.println("Account created successfully.");
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
    	System.out.println("Account Type (0 for customer, 1 for employee, 2 for admin): ");
    	String input;
    	
    	while (true) {
	    	input = sc.nextLine();
			
			if (input.equals("0") || input.equals("1") || input.equals("2"))
				return Integer.parseInt(input);
				
			System.out.println("Invalid entry, please enter (0 for customer, 1 for employee, 2 for admin). ");
    	}
    }
    
	private static String getName() {
		System.out.println("Name: ");
		return sc.nextLine();
	}
	
	private static String getAddress() {
		System.out.println("Address: ");
		return sc.nextLine();
	}
	
	private static String getAge() {
		System.out.println("Age: ");
		return sc.nextLine();
	}
}
