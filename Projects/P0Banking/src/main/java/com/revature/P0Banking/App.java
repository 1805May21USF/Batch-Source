package com.revature.P0Banking;


import java.io.File;
import java.io.IOException;
import java.util.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
/**
 * Hello world!
 *
 */
public class App 
{
	static final Scanner sc = new Scanner(System.in);
	static final File file = new File("AccountDatabase.txt");
	static final Logger log = LogManager.getLogger(App.class);
	
	/*
	 * Name: makeBankAdmin(), makeEmployee()
	 * Inputs: None
	 * Description: Registers accounts for bank admin and make employee if necessary
	 */
//	private static void makeBankAdmin() throws IOException {
//		ArrayList<Partner> accounts;
//    	accounts = User.registerAcct("BankAdmin");
//    	User.saveToFile(accounts);
//	}
//	private static void makeEmployee() throws IOException {
//		ArrayList<Partner> accounts;
//    	accounts = User.registerAcct("Employee");
//    	User.saveToFile(accounts);
//	}
	//******************************************************************************
	
    public static void main( String[] args ) throws IOException, ClassNotFoundException
    {
    	//Create a user object
    	ArrayList<Partner> accounts;
//    	makeBankAdmin();
//    	makeEmployee();
    	//Driver Interface to begin using banking app
    	System.out.println( "Hello Bank Partner!" );
        while(true){
        	System.out.print("What would you like to do? \n 1)Login\n 2)Register\n 3)Exit App\n");
            int choice = sc.nextInt();
            sc.nextLine();  
	        switch(choice) {
		        case 1://Login
		        	accounts = User.loginAcct();
		        	User.saveToFile(accounts);
		        	break;
		        case 2://Register
		        	accounts = User.registerAcct("Customer");
		        	User.saveToFile(accounts);
		        	break;
		        case 3://Exit
		        	sc.close();
		        	System.exit(1);
		        	break;
	        default:
	        	System.out.println("Error: Please choose one of the options!");
	        	break;
	        }
        }
    }
}
