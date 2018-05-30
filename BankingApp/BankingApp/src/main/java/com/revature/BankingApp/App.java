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
    				System.out.println("Are you a customer, employee, or the admin (Enter your title or c to cancel): ");
    				
    				input = scan.nextLine().toLowerCase();
    				
    				switch(input) {
    				case("customer"):
    					Customer c = si.customerLogin();
    					if(c != null)
    						b.customerMenu(c);
    					break;
    				case("employee"):
    					Employee e = si.employeeLogin();
						if(e != null)
							b.employeeMenu(e);
						break;
    				case("admin"):
    					if(si.adminLogin())
    						b.adminMenu();
						break;
    				case("c"):
    					flag = false;
    					break loop;
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
    
    public static boolean serialize(Customer c) {
    	try {
    		File file = new File("data/customers/" + c.getUsername() + ".cus");
    	
    		if(!file.exists())
    			file.createNewFile();
    	
    		ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
    		
    		oos.writeObject(c);
    	
    		oos.close();
    		return true;
    	}catch(IOException e) {
    		return false;
    	}
    }
    
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
    
    public static Customer deserializeCustomer(String username) {
    	try {
    		File file = new File("data/customers/" + username + ".cus");
    	
    		if(!file.exists())
    			return null;
    	
    		ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
    		
    		Customer c = (Customer) ois.readObject();
    	
    		ois.close();
    		return c;
    	}catch(IOException | ClassNotFoundException e) {
    		return null;
    	}
    }
    
    public static Employee deserializeEmployee(String username) {
    	try {
    		File file = new File("data/employees/" + username + ".cus");
    	
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
    
    public static boolean deleteCustomer(Customer c) {
    	File file = new File("data/customers/" + c.getUsername() + ".cus");
    	
    	return file.delete();
    }
}
