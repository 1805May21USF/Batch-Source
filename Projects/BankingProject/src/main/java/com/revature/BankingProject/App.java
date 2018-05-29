package com.revature.BankingProject;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/*
 * Main driver for banking interaction.
 */
public class App 
{
	public final static Scanner sc = new Scanner(System.in);
	private static RegistrationActions b = new RegistrationActions();
	static Logger log = LogManager.getLogger(App.class);
	
    public static void main( String[] args )
    {
    	if (!RegistrationActions.usernameExists("admin"))
    		createAdmin();
    	boolean done = false;
    	String option;
    		
    	while (!done) {
    		System.out.println("1. Login\n2. Register\n-1 Exit");
    		
    		option = sc.nextLine();
    		if (option.equals("1")) {
    			optionLogin();
    		} else if (option.equals("2")) {
    			optionRegister(0);
    		} else if (option.equals("-1")) {
    			break;
    		} else {
    			System.out.println("Invalid entry");
    		}
    	}
    	sc.close();
    	System.out.println("Closed.");
    }
    
    /*
     * Creates a default admin account.
     */
    private static void createAdmin() {
    	b.register("admin", "pass", 2);
	}

    /*
     * Allows users to login.
     */
	private static void optionLogin() {
    	String username = getUsername();
		String password = getPassword();
		
		if (b.login(username, password)) 
			b.userOptions(username);
		else 
			System.out.println("Invalid login");
	}

	/*
	 * Allows users to register for an account.
	 */
	protected static void optionRegister(int type) {
    	boolean succeeded = false;  	
    	String username = "";
    	
		while (!succeeded) {
			username = getUsername();
			succeeded = b.register(username, getPassword(), type);			
		}
		//Creates customer, adds and saves a new apply for a bank account
		if (type == 0) {
			CustomerAccount customerAccount = CustomerActions.createCustomerAccount(username, getName(), getAddress(), getAge());
			customerAccount.addApply(UserActions.createBankAccount());
			CustomerActions.saveCustomerAccount(customerAccount);
		}

		System.out.println("Account created successfully.");
	}

	/*
	 * Username input prompt.
	 */
	private static String getUsername() {
    	System.out.println("Username: ");
		return sc.nextLine();
    }
    
	/*
	 * Password input prompt.
	 */
    private static String getPassword() {
		System.out.println("Password: ");
		return sc.nextLine();
    }
    
    /*
     * Name input prompt.
     */
	private static String getName() {
		System.out.println("Name: ");
		return sc.nextLine();
	}
	
	/*
	 * Address input prompt.
	 */
	private static String getAddress() {
		System.out.println("Address: ");
		return sc.nextLine();
	}
	
	/*
	 * Age input prompt.
	 */
	private static String getAge() {
		System.out.println("Age: ");
		return sc.nextLine();
	}
}
