package com.revature.BankingApp;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import com.revature.storage.*;

public class App 
{
	// Creates a Scanner object to process user input
	private static Scanner scan = new Scanner(System.in);
    
    public static void main(String[] args) {
    	// Creates a String to hold input
    	String input = "";
    	SignIn si = new SignIn();
    	Banking b = new Banking();
    	
    	// Executes while the input isn't exit, ex, or e
    	while(!input.equalsIgnoreCase("exit")) {
    		// Requests input from the user
           	System.out.println("What do you want to do? (Sign-In, Sign-Up, Exit): ");
        	
    		input = scan.nextLine();
    		
    		// Executes if the user wants to sign in
    		if(input.equalsIgnoreCase("sign-in") || input.equalsIgnoreCase("si") || input.equalsIgnoreCase("signin")) {
    			boolean flag = true;
    			
    			loop:
    			while(flag) {
    				// Requests what account the user uses
    				System.out.println("Are you a customer, employee, or the admin (Enter your title or c to cancel): ");
    				
    				input = scan.nextLine().toLowerCase();
    				
    				switch(input) {
    				// Executes if the user is a Customer
    				case("customer"):
    					// Signs in as a Customer
    					Customer c = si.customerLogin();
    					if(c != null)
    						b.customerMenu(c);
    					break loop;
    				// Executes if the user is an Employee
    				case("employee"):
    					// Signs in as an Employee
    					Employee e = si.employeeLogin();
						if(e != null)
							b.employeeMenu(e);
						break loop;
					// Executes if the user is the admin
    				case("admin"):
    					// Signs in as admin
    					if(si.adminLogin())
    						b.adminMenu();
						break loop;
					// Executes if the escape command is entered
    				case("c"):
    					// Breaks out of the loop
    					flag = false;
    					break loop;
    				// Executes if anything else is entered
    				default: System.out.println("Please enter customer, employee, admin, or c!");
    				}
    			}
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
    
    // Serializes a Customer object
    public static boolean serialize(Customer c) {
    	try {
    		// Names the Customer's file
    		File file = new File("data/customers/" + c.getUsername() + ".cus");
    	
    		// If the file doesn't exist, create it
    		if(!file.exists())
    			file.createNewFile();
    	
    		// Serialize the Customer
    		ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
    		oos.writeObject(c);
    	
    		// Close the ObjectOutputStream and return true
    		oos.close();
    		return true;
    	// Return false if serialization couldn't occur
    	}catch(IOException e) {
    		return false;
    	}
    }
    
    // Serializes an Employee object
    public static boolean serialize(Employee e) {
    	try {
    		File file = new File("data/employees/" + e.getUsername() + ".emp");
    	
    		if(!file.exists())
    			file.createNewFile();
    	
    		ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
    		
    		oos.writeObject(e);
    	
    		oos.close();
    		return true;
    	}catch(IOException ex) {
    		return false;
    	}
    }
    
    // Deserializes a Customer object
    public static Customer deserializeCustomer(String username) {
    	try {
    		// Retrieve's the Customer's file
    		File file = new File("data/customers/" + username + ".cus");
    	
    		// Returns null if the Customer doesn't exist
    		if(!file.exists())
    			return null;
    	
    		// Deserializes the retrieved file
    		ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
    		Customer c = (Customer) ois.readObject();
    		
    		// Closes the ObjectInputStream and returns the deserialized Customer
    		ois.close();
    		return c;
    	}catch(IOException | ClassNotFoundException e) {
    		return null;
    	}
    }
    
    // Deserializes an Employee object
    public static Employee deserializeEmployee(String username) {
    	try {
    		File file = new File("data/employees/" + username + ".emp");
    	
    		if(!file.exists())
    			return null;
    	
    		ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
    		
    		Employee e = (Employee) ois.readObject();
    	
    		ois.close();
    		return e;
    	}catch(IOException | ClassNotFoundException ex) {
    		return null;
    	}
    }
    
    // Deletes a Customer's information from the system
    public static boolean deleteCustomer(Customer c) {
    	// Retrieves the Customer's file
    	File file = new File("data/customers/" + c.getUsername() + ".cus");
    	
    	// Returns whether the file was successfully deleted or not
    	return file.delete();
    }
    
    // Deletes an Employee's information from the system
    public static boolean deleteEmployee(Employee e) {
    	File file = new File("data/employees/" + e.getUsername() + ".emp");
    	
    	return file.delete();
    }
}
