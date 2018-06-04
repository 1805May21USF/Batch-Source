package com.revature.driver;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.beans.CustomerAccount;
import com.revature.daoimpl.BankAccountDAOImpl;
import com.revature.daoimpl.CustomerAccountDAOImpl;
import com.revature.daoimpl.UserTransactionDAOImpl;
import com.revature.main.BankingActions;
import com.revature.util.Helpers;

/*
 * Main driver for the banking app.
 */
public class Driver {
	public final static Scanner sc = new Scanner(System.in);
	public final static CustomerAccountDAOImpl cadi = new CustomerAccountDAOImpl();
	public final static BankAccountDAOImpl badi = new BankAccountDAOImpl();
	public final static UserTransactionDAOImpl uadi = new UserTransactionDAOImpl();
	public static Logger log = LogManager.getLogger(Driver.class);
	
	public static void main(String[] args) {		
    	boolean done = false;
    	String option;
    		
    	while (!done) {
    		System.out.println("1. Login\n2. Register\n-1 Exit");
    		
    		option = sc.nextLine();
    		if (option.equals("1")) {
    			optionLogin();
    		} else if (option.equals("2")) {
    			optionRegister();
    		} else if (option.equals("admin")) {
    			optionAdmin();	
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
	 * Grants admin access if the correct password is inputed.
	 */
	private static void optionAdmin() {
		String password = getPassword();
		if (password.equals("pass")) {
			System.out.println("Admin access granted");
			BankingActions.AdminOptions();
		}
	}

	/*
     * Allows users to login.
     */
	private static void optionLogin() {
    	String username = getUsername();
		String password = getPassword();
		List<CustomerAccount> customerAccounts = null;
		try {
			customerAccounts = cadi.getCustomerAccounts();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		}
		if (customerAccounts != null)
			for (CustomerAccount cus : customerAccounts) 
				if (cus.getUsername().equals(username) && cus.getPassword().equals(password)) {
					BankingActions.userOptions(cus);
					return;
				}
	
		System.out.println("Invalid login");
	}

	/*
	 * Allows users to register for an account.
	 */
	public static void optionRegister() {
		try {
			String username = getUsernameForReg();
			cadi.createCustomerAccount(
					new CustomerAccount(0, username, getPassword(), getFirstName(), getLastName()));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Account created successfully.");
	}

	/*
	 * Username input prompt.
	 */
	private static String getUsernameForReg() {
		while (true) {
	    	System.out.println("Username: ");
			String username = sc.nextLine();
			if (!Helpers.usernameExists(username))
				return username;
			System.out.println("Username taken.");
		}
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
	private static String getFirstName() {
		System.out.println("First Name: ");
		return sc.nextLine();
	}
	
    /*
     * Name input prompt.
     */
	private static String getLastName() {
		System.out.println("Last Name: ");
		return sc.nextLine();
	}

}
