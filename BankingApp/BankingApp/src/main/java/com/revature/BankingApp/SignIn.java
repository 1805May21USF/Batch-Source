package com.revature.BankingApp;

import java.util.Scanner;

import com.revature.storage.Customer;
import com.revature.storage.Employee;

public class SignIn {
	private static Scanner scan = App.getScanner();
	
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
		
		return null;
	}
	
	public boolean adminLogin() {
		String input = "";
		
		while(!input.equalsIgnoreCase("exit")) {
			// Requests the admin username
			System.out.println("Please enter admin username (c to cancel, e to exit): ");
		
			String user = scan.nextLine();
			
			if(user.equalsIgnoreCase("c")){
				return false;
			}
			
			boolean flag = true;
			
			password:
			while(flag) {
				// Requests the admin password
				System.out.println("Please enter admin password(c to cancel, b to re-enter username): ");
			
				String pass = scan.nextLine();
			
				if(pass.equalsIgnoreCase("c")) {
					return false;
				}
				else if(pass.equalsIgnoreCase("b")) {
					break password;
				}
				
				// Launches the BankingApp class as an admin if the admin username and password were entered
				if(user.equals("admin") & pass.equals("rolltide")) {
					return true;
				}
			}
		}
		return false;
	}
	
	boolean customerLogin(String username, String password) {
		Customer c = App.deserializeCustomer(username);
					
		if(c.getPassword().equals(password))
			return true;
		else
			return false;
	}
	
	boolean employeeLogin(String username, String password) {
		Employee e = App.deserializeEmployee(username);
		
		if(e.getPassword().equals(password))
			return true;
		else
			return false;
	}
	
	// Retrieves Customer information from a file
	public Customer getCustomer(String username) {
		return App.deserializeCustomer(username);
	}
	
	// Retrieves Employee information from a file
	public Employee getEmployee(String username) {
		return App.deserializeEmployee(username);
	}
}
