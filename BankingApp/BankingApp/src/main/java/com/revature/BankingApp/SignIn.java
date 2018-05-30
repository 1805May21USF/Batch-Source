package com.revature.BankingApp;

import java.io.File;
import java.util.Scanner;

import com.revature.storage.Customer;
import com.revature.storage.Employee;

public class SignIn {
	// Retrieves the Scanner from App
	private static Scanner scan = App.getScanner();
	
	// Starts the customer login process
	public Customer customerLogin() {
		String input = "";
		
		while(!input.equalsIgnoreCase("exit")) {
			// Requests the Customer's username
			System.out.println("Please enter your username (c to cancel, e to exit): ");
		
			String user = scan.nextLine();
			
			if(user.equalsIgnoreCase("c")){
				return null;
			}
			
			boolean flag = true;
			
			password:
			while(flag) {
				// Requests the Customer's password
				System.out.println("Please enter your password(c to cancel, b to re-enter username): ");
			
				String pass = scan.nextLine();
			
				if(pass.equalsIgnoreCase("c")) {
					return null;
				}
				else if(pass.equalsIgnoreCase("b")) {
					break password;
				}
				
				// Returns the Customer information if the Customer exists
				if(customerLogin(user, pass)) {
					return getCustomer(user);
				}
			}
		}
		
		return null;
	}
	
	// Starts the Employee login process
	public Employee employeeLogin() {
		String input = "";
		
		while(!input.equalsIgnoreCase("exit")) {
			// Requests the Employee's username
			System.out.println("Please enter your username (c to cancel, e to exit): ");
		
			String user = scan.nextLine();
			
			if(user.equalsIgnoreCase("c")){
				return null;
			}
			
			boolean flag = true;
			
			password:
			while(flag) {
				// Requests the Employee's password
				System.out.println("Please enter your password(c to cancel, b to re-enter username): ");
			
				String pass = scan.nextLine();
			
				if(pass.equalsIgnoreCase("c")) {
					return null;
				}
				else if(pass.equalsIgnoreCase("b")) {
					break password;
				}
				
				// Returns the Employee information if the Employee exists
				if(employeeLogin(user, pass)) {
					return getEmployee(user);
				}
			}
		}
		// Returns null by default
		return null;
	}
	
	// Starts the login process for admin
	public boolean adminLogin() {
		String input = "";
		
		while(!input.equalsIgnoreCase("exit")) {
			// Requests the admin username
			System.out.println("Please enter admin username (c to cancel, e to exit): ");
		
			String user = scan.nextLine();
			
			// Executes if the escape character was entered
			if(user.equalsIgnoreCase("c")){
				return false;
			}
			
			boolean flag = true;
			
			password:
			while(flag) {
				// Requests the admin password
				System.out.println("Please enter admin password(c to cancel, b to re-enter username): ");
			
				String pass = scan.nextLine();
			
				// Tests if an escape character was entered
				if(pass.equalsIgnoreCase("c")) {
					return false;
				}
				else if(pass.equalsIgnoreCase("b")) {
					break password;
				}
				
				// Returns true if the username and password match
				if(user.equals("admin") & pass.equals("rolltide")) {
					return true;
				}
			}
		}
		// Returns false by default
		return false;
	}
	
	// Takes the username and password and sees if it matche an Customers
	boolean customerLogin(String username, String password) {
		// Retrieves the Customer's information
		Customer c = null;
		if(customerExists(username))
			c = App.deserializeCustomer(username);
		else
			return false;
					
		// Returns whether the password matches or not
		return c.getPassword().equals(password);
	}
	
	// Takes the username and password and sees if it matches any Employee
	boolean employeeLogin(String username, String password) {
		Employee e = null;
		if(employeeExists(username))
			e = App.deserializeEmployee(username);
		else
			return false;
		
		return e.getPassword().equals(password);
	}
	
	// Retrieves Customer information from a file
	public Customer getCustomer(String username) {
		return App.deserializeCustomer(username);
	}
	
	// Retrieves Employee information from a file
	public Employee getEmployee(String username) {
		return App.deserializeEmployee(username);
	}
	
	// Tests if the Customer exists
	public boolean customerExists(String username) {
		return new File("data/customers/" + username + ".cus").exists();
	}
	
	// Tests if the Employee exists
	public boolean employeeExists(String username) {
		return new File("data/employees/" + username + ".emp").exists();
	}
}
