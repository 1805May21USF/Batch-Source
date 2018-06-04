package com.revature.JDBCBank;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;

import com.revature.beans.Customer;
import com.revature.beans.Employee;
import com.revature.daoimpl.CustomerDAOImpl;
import com.revature.daoimpl.EmployeeDAOImpl;
import com.revature.exceptions.IncorrectPasswordException;

public class SignIn {
	// Retrieves the Scanner from Main
	private Scanner scan = null;;
	
	public SignIn(Scanner s) {
		scan = s;
	}
	
	// Starts the customer login process
	public Customer customerLogin() {
		String input = "";
		
		while(!input.equalsIgnoreCase("exit")) {
			// Requests the Customer's username
			System.out.println("Please enter your username (c to cancel, e to exit): ");
		
			String user = scan.nextLine();
			
			if(user.equalsIgnoreCase("c"))
				return null;
			
			boolean flag = true;
			
			password:
			while(flag) {
				// Requests the Customer's password
				System.out.println("Please enter your password(c to cancel, b to re-enter username): ");
			
				String pass = scan.nextLine();
			
				if(pass.equalsIgnoreCase("c")) 
					return null;
				else if(pass.equalsIgnoreCase("b")) 
					break password;
				
				// Returns the Customer information if the Customer exists
				try{
					if(customerLogin(user, pass))
						return getCustomer(user);
					else
						throw new IncorrectPasswordException();
					}catch(IncorrectPasswordException e) {break password;}
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
				try {
					if(employeeLogin(user, pass)) {
						return getEmployee(user);
					}
					else {
						throw new IncorrectPasswordException();
					}
				}catch(IncorrectPasswordException e){break password;}
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
			if(user.equalsIgnoreCase("c"))
				return false;
			
			boolean flag = true;
			
			password:
			while(flag) {
				// Requests the admin password
				System.out.println("Please enter admin password(c to cancel, b to re-enter username): ");
			
				String pass = scan.nextLine();
			
				// Tests if an escape character was entered
				if(pass.equalsIgnoreCase("c")) 
					return false;
				else if(pass.equalsIgnoreCase("b"))
					break password;
				
				
				try {
					// Retrieves the properties file that contains the username and password of the admin
					Properties prop = new Properties();
					prop.load(new FileReader(new File("database.properties")));
					// Returns true if the username and password match the admins password
					if(user.equals(prop.getProperty("admin_usr")) & pass.equals(prop.getProperty("admin_pass"))) {
						return true;
					}
				// Executes if the properties file couldn't be retrieved
				}catch(IOException e) {
					System.out.println("Couldn't locate properties file!");
				}
			}
		}
		// Returns false by default
		return false;
	}
	
	// Takes the username and password and sees if it matche an Customers
	public boolean customerLogin(String username, String password) throws IncorrectPasswordException{
		try {
			// Uses CustomerDAOImpl to retrieve any customers who have the username and password provided by the user
			CustomerDAOImpl cdi = new CustomerDAOImpl();
			ArrayList<Customer> customers = cdi.customerExists(username, password);
		
			// Returns true if there is a customer that matches the provided username and password
			if(!customers.isEmpty())
				return true;
		// Executes if the database couldn't be reached
		}catch(SQLException e) {
			System.out.println("Couldn't connect to database! Please try again later!");
		}
		// Returns false if the username and password don't match
		return false;
	}
	
	// Takes the username and password and sees if it matches any Employee
	public boolean employeeLogin(String username, String password) throws IncorrectPasswordException{
		try {
			// Uses EmployeeDAOImpl to retrieve anyemployees who have the username and password provided by the user
			EmployeeDAOImpl edi = new EmployeeDAOImpl();
			ArrayList<Employee> employees = edi.employeeExists(username, password);
		
			// Returns true if there is a customer that matches the provided username and password
			if(!employees.isEmpty())
				return true;
		// Executes if the database couldn't be reached
		}catch(SQLException e) {
			System.out.println("Couldn't connect to database! Please try again later!");
		}
		// Returns false if the username and password don't match
		return false;
	}
	
	// Retrieves Customer information from a database
	public Customer getCustomer(String username) {
		// Attempts to retrieve and return the customer information from the database
		try {
			CustomerDAOImpl cdi = new CustomerDAOImpl();
			ArrayList<Customer> customers = cdi.customerExists(username);
			// Returns the customer that matches the username provided
			return customers.get(0);
		// Executes if the database couldn't be reached
		}catch(SQLException e) {
			System.out.println("Couldn't establish connection with the database! Please try again later!");
		}
		// Returns null by default
		return null;
	}
	
	// Retrieves Employee information from a database
	public Employee getEmployee(String username) {
		// Attempts to retrieve and return the employee information from the database
		try {
			EmployeeDAOImpl edi = new EmployeeDAOImpl();
			ArrayList<Employee> employees = edi.employeeExists(username);
			// Returns the employee that matches the username provided
			return employees.get(0);
		// Executes if the database couldn't be reached
		}catch(SQLException e) {
			System.out.println("Couldn't establish connection with the database! Please try again later!");
		}
		// Returns null by default
		return null;
	}
}
