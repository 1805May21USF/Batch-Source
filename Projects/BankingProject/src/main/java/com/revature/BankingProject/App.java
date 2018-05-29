package com.revature.BankingProject;

import java.util.Scanner;

public class App 
{
	public final static Scanner sc = new Scanner(System.in);
	private static RegistrationActions b = new RegistrationActions();
	
    public static void main( String[] args )
    {
    	createAdmin();
    	boolean done = false;
    	String option;
    		
    	while (!done) {
    		System.out.println("Select 1 for Login, 2 for Register, -1 for Exit");
    		
    		option = sc.nextLine();
    		if (option.equals("1")) {
    			optionLogin();
    		} else if (option.equals("2")) {
    			optionRegister(0);
    		} else if (option.equals("-1")) {
    			break;
    		} else {
    			System.out.println("Invalid entry, please select 1 for Login, 2 for Register, 5 for Exit.");
    		}
    	}
    	sc.close();
    	System.out.println("Closed.");
    }
    
    private static void createAdmin() {
    	b.register("admin", "pass", 2);
	}

	private static void optionLogin() {
    	String username = getUsername();
		String password = getPassword();
		
		if (b.login(username, password)) 
			b.userOptions(username);
		else 
			System.out.println("Invalid login, try again.");
	}

	protected static void optionRegister(int type) {
    	boolean succeeded = false;  	
    	String username = "";
    	
		while (!succeeded) {
			username = getUsername();
			succeeded = b.register(username, getPassword(), type);			
		}
		//Creates customer, add and saves a new apply
		if (type == 0) {
			CustomerAccount customerAccount = CustomerActions.createCustomerAccount(username, getName(), getAddress(), getAge());
			customerAccount.addApply(UserActions.createBankAccount());
			CustomerActions.saveCustomerAccount(customerAccount);
		}

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
