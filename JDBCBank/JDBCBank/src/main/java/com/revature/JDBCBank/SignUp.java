package com.revature.JDBCBank;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.revature.beans.Customer;
import com.revature.beans.Employee;
import com.revature.daoimpl.CustomerDAOImpl;
import com.revature.daoimpl.EmployeeDAOImpl;
import com.revature.exceptions.InvalidInputException;
import com.revature.exceptions.UserExistsException;

public class SignUp {
	// Retrieves Main's Scanner
	private static Scanner scan = null;
	
	// A public constructor to receive a Scanner for input
	public SignUp(Scanner s) {
		scan = s;
	}
	
	// Launches the Customer sign up process
	public void customerSignUp() throws SQLException{
		// Creates an empty customer to store customer information and a boolean flag variable to wait for input
		Customer cus = new Customer(0, null, null, null, ' ', null, 0, null, null, 0, null);
		boolean flag = true;
		
		// Starts the main loop and provides a label to allow for a complete exit from the loop
		mainLoop:
		while(flag) {
			// Executes while the customer's username is null
			while(cus.getUsername() == null) {
				// Requests input from the user
				System.out.println("Please enter a username made up of no special characters and no more than 20 characters");
				System.out.println("(Enter c to cancel):");
					
				try {
					String input = scan.nextLine();
				
					// Tests if an escape character was entered or if the input was too large
					if(input.equalsIgnoreCase("c"))
						break mainLoop;
					if(input.length() > 20) {
						System.out.println("Input must be less than 20 characters!");
						throw new InvalidInputException();
					}
						
					// Tests to see if the input is valid and if a customer already possesses that username
					validAlphaNumericInput(input);
					employeeExists(input);
						
					// Sets the customer's username equal to the entered input
					cus.setUsername(input);
				// Executes if the user exists or the entered input was invalid
				}catch(UserExistsException | InvalidInputException e) {
					System.out.println();
				}
			}
				
			// Executes while the customer's password is null
			while(cus.getPassword() == null) {
				System.out.println("Please enter a password made up of no special characters and no more than 20 characters");
				System.out.println("(Enter c to cancel or b to enter a different username):");
							
				try {
					String input = scan.nextLine();
							
					if(input.equalsIgnoreCase("c"))
						break mainLoop;
					if(input.equalsIgnoreCase("b")) {
						cus.setUsername(null);
						continue mainLoop;
					}
					if(input.length() > 20) { 
						System.out.println("Input must be less than 20 characters!");
						throw new InvalidInputException();
					}
								
					validAlphaNumericInput(input);
								
					cus.setPassword(input);
				}catch(InvalidInputException e) {
					System.out.println();
				}
			}
				
			// Executes while the customer's firstName is null
			while(cus.getFirstName() == null) {
				System.out.println("Please enter your first name");
				System.out.println("(Enter c to cancel or b to enter a different password):");
										
				try {
					String input = scan.nextLine();
									
					if(input.equalsIgnoreCase("c"))
						break mainLoop;
					if(input.equalsIgnoreCase("b")) {
						cus.setPassword(null);
						continue mainLoop;
					}
					if(input.length() > 50) {
						System.out.println("Input must be less than 50 characters!");
						throw new InvalidInputException();
					}
											
					validAlphabeticInput(input);
								
					cus.setFirstName(input);
				}catch(InvalidInputException e) {
					System.out.println("No numerical or special characters allowed!");
					System.out.println();
				}
			}
			
			// Executes while the customer's lastName is null
			while(cus.getLastName() == null) {
				System.out.println("Please enter your last name");
				System.out.println("(Enter c to cancel or b to enter a different first name):");
													
				try {
					String input = scan.nextLine();
													
					if(input.equalsIgnoreCase("c"))
						break mainLoop;
					if(input.equalsIgnoreCase("b")) {
						cus.setFirstName(null);
						continue mainLoop;
					}
					if(input.length() > 50) {
						System.out.println("Input must be less than 50 characters!");
						throw new InvalidInputException();
					}
													
					validAlphabeticInput(input);
										
					cus.setLastName(input);
				}catch(InvalidInputException e) {
					System.out.println("No numerical or special characters allowed!");
					System.out.println();
				}
			}
						
			// Executes while the customer's middle initial is empty
			while(cus.getMiddleInitial() == ' ') {
				System.out.println("Please enter your middle initial");
				System.out.println("(Enter c to cancel or b to enter a different last name):");
												
				try {
					String input = scan.nextLine();
									
					if(input.equalsIgnoreCase("c"))
						break mainLoop;
					if(input.equalsIgnoreCase("b")) {
						cus.setLastName(null);
						continue mainLoop;
					}
					if(input.length() != 1) {
						System.out.println("Input must be one character!");
						throw new InvalidInputException();
					}
														
					validAlphabeticInput(input);
										
					cus.setMiddleInitial(input.charAt(0));
				}catch(InvalidInputException e) {
					System.out.println("No numerical or special characters allowed!");
					System.out.println();
				}
			}
						
			// Executes while the customer's age is unassigned
			while(cus.getAge() == 0) {
				System.out.println("Please enter your age");
				System.out.println("(Enter c to cancel or b to enter a different middle initial):");
												
				try {
					String input = scan.nextLine();
					
												
					if(input.equalsIgnoreCase("c"))
						break mainLoop;
					if(input.equalsIgnoreCase("b")) {
						cus.setMiddleInitial(' ');
						continue mainLoop;
					}
					
					validNumericInput(input);
					
					int num = Integer.parseInt(input);
					
					if(num < 0) {
						System.out.println("Input must be a positive number!");
						throw new InvalidInputException();
					}
					if(num < 16) {
						System.out.println("You must be 16 or older to open an account at Loyd National Bank!");
						break mainLoop;
					}
													
					cus.setAge(num);
				}catch(InvalidInputException e) {
					System.out.println();
				}
			}	
							
			// Executes while the customer's address is null
			while(cus.getAddress() == null) {
				System.out.println("Please enter your street address without any special characters");
				System.out.println("(Enter c to cancel or b to enter a different age):");
													
				try {
					String input = scan.nextLine();
									
					if(input.equalsIgnoreCase("c"))
						break mainLoop;
					if(input.equalsIgnoreCase("b")) {
						cus.setAge(0);
						continue mainLoop;
					}
					if(input.length() > 100) {
						System.out.println("Input must be less than 100 characters!");
						throw new InvalidInputException();
					}
														
					validAlphaNumericInput(input);
												
					cus.setAddress(input);
				}catch(InvalidInputException e) {
					System.out.println();
				}
			}
				
			// Executes while the customer's city is null
			while(cus.getCity() == null) {
				System.out.println("Please enter your city without any special characters or numbers");
				System.out.println("(Enter c to cancel or b to enter a different street address):");
													
				try {
					String input = scan.nextLine();
												
					if(input.equalsIgnoreCase("c"))
						break mainLoop;
					if(input.equalsIgnoreCase("b")) {
						cus.setAddress(null);
						continue mainLoop;
					}
					if(input.length() > 100) {
						System.out.println("Input must be less than 100 characters!");
						throw new InvalidInputException();
					}
														
					validAlphabeticInput(input);
											
					cus.setCity(input);
				}catch(InvalidInputException e) {
					System.out.println();
				}
			}
							
			// Executes while the customer's zip code is unassigned
			while(cus.getZip() == 0) {
				System.out.println("Please enter your valid 5 digit zip code");
				System.out.println("(Enter c to cancel or b to enter a different city):");
													
				try {
					String input = scan.nextLine();
												
					if(input.equalsIgnoreCase("c"))
						break mainLoop;
					if(input.equalsIgnoreCase("b")) {
						cus.setCity(null);
						continue mainLoop;
					}
					if(input.length() != 5) {
						System.out.println("Input must be 5 characters!");
						throw new InvalidInputException();
					}
														
					validNumericInput(input);
											
					cus.setZip(Integer.parseInt(input));
				}catch(InvalidInputException e) {
					System.out.println();
				}
			}
							
			// Executes while the customer's state is null
			while(cus.getState() == null) {
				System.out.println("Please enter your state in SN format (Example: Florida would be FL)");
				System.out.println("(Enter c to cancel or b to enter a different zip code):");
													
				try {
					String input = scan.nextLine();
											
					if(input.equalsIgnoreCase("c"))
						break mainLoop;
					if(input.equalsIgnoreCase("b")) {
						cus.setZip(0);
						continue mainLoop;
					}
					if(input.length() != 2) {
						System.out.println("Input must be 2 characters!");
						throw new InvalidInputException();
					}
														
					validAlphabeticInput(input);
											
					cus.setState(input.toUpperCase());
					cus.setId(-1);
					break mainLoop;
				}catch(InvalidInputException e) {
					System.out.println();
				}
			}
		}
			
		// Executes if an employee was successfully registered
		if(cus.getId() == -1) {
			// Sends the employee information to the database to be entered
			createCustomer(cus);
		}
	}
	
	// Launches the employee sign up process
	public void employeeSignUp() throws SQLException{
		// Creates an empty employee to store employee information and a boolean flag variable to wait for input
		Employee emp = new Employee(0, null, null, null, ' ', null, 0, null, null, 0, null, null, 0);
		boolean flag = true;
		
		// Starts the main loop and provides a label to allow for a complete exit from the loop
		mainLoop:
		while(flag) {
			// Executes while the employee's username is null
			while(emp.getUsername() == null) {
				// Requests input from the user
				System.out.println("Please enter a username made up of no special characters and no more than 20 characters");
				System.out.println("(Enter c to cancel):");
				
				try {
					String input = scan.nextLine();
				
					// Tests if an escape character was entered or if the input was too large
					if(input.equalsIgnoreCase("c"))
						break mainLoop;
					if(input.length() > 20) {
						System.out.println("Input must be less than 20 characters!");
						throw new InvalidInputException();
					}
					
					// Tests to see if the input is valid and if an employee already possesses that username
					validAlphaNumericInput(input);
					employeeExists(input);
					
					// Sets the employee's username equal to the entered input
					emp.setUsername(input);
				// Executes if the user exists or the entered input was invalid
				}catch(UserExistsException | InvalidInputException e) {
					System.out.println();
				}
			}
			
			// Executes while the employee's password is null
			while(emp.getPassword() == null) {
				System.out.println("Please enter a password made up of no special characters and no more than 20 characters");
				System.out.println("(Enter c to cancel or b to enter a different username):");
							
				try {
					String input = scan.nextLine();
							
					if(input.equalsIgnoreCase("c"))
						break mainLoop;
					if(input.equalsIgnoreCase("b")) {
						emp.setUsername(null);
						continue mainLoop;
					}
					if(input.length() > 20) { 
						System.out.println("Input must be less than 20 characters!");
						throw new InvalidInputException();
					}
								
					validAlphaNumericInput(input);
								
					emp.setPassword(input);
				}catch(InvalidInputException e) {
					System.out.println();
				}
			}
			
			// Executes while the employee's firstName is null
			while(emp.getFirstName() == null) {
				System.out.println("Please enter your first name");
				System.out.println("(Enter c to cancel or b to enter a different password):");
										
				try {
					String input = scan.nextLine();
									
					if(input.equalsIgnoreCase("c"))
						break mainLoop;
					if(input.equalsIgnoreCase("b")) {
						emp.setPassword(null);
						continue mainLoop;
					}
					if(input.length() > 50) {
						System.out.println("Input must be less than 50 characters!");
						throw new InvalidInputException();
					}
											
					validAlphabeticInput(input);
								
					emp.setFirstName(input);
				}catch(InvalidInputException e) {
					System.out.println("No numerical or special characters allowed!");
					System.out.println();
				}
			}
			
			// Executes while the employee's lastName is null
			while(emp.getLastName() == null) {
				System.out.println("Please enter your last name");
				System.out.println("(Enter c to cancel or b to enter a different first name):");
													
				try {
					String input = scan.nextLine();
												
					if(input.equalsIgnoreCase("c"))
						break mainLoop;
					if(input.equalsIgnoreCase("b")) {
						emp.setFirstName(null);
						continue mainLoop;
					}
					if(input.length() > 50) {
						System.out.println("Input must be less than 50 characters!");
						throw new InvalidInputException();
					}
													
					validAlphabeticInput(input);
										
					emp.setLastName(input);
				}catch(InvalidInputException e) {
					System.out.println("No numerical or special characters allowed!");
					System.out.println();
				}
			}
						
			// Executes while the employee's middle initial is empty
			while(emp.getMiddleInitial() == ' ') {
				System.out.println("Please enter your middle initial");
				System.out.println("(Enter c to cancel or b to enter a different last name):");
												
				try {
					String input = scan.nextLine();
									
					if(input.equalsIgnoreCase("c"))
						break mainLoop;
					if(input.equalsIgnoreCase("b")) {
						emp.setLastName(null);
						continue mainLoop;
					}
					if(input.length() != 1) {
						System.out.println("Input must be one character!");
						throw new InvalidInputException();
					}
														
					validAlphabeticInput(input);
										
					emp.setMiddleInitial(input.charAt(0));
				}catch(InvalidInputException e) {
					System.out.println("No numerical or special characters allowed!");
					System.out.println();
				}
			}
						
			// Executes while the employee's age is unassigned
			while(emp.getAge() == 0) {
				System.out.println("Please enter your age");
				System.out.println("(Enter c to cancel or b to enter a different middle initial):");
												
				try {
					String input = scan.nextLine();
					
												
					if(input.equalsIgnoreCase("c"))
						break mainLoop;
					if(input.equalsIgnoreCase("b")) {
						emp.setMiddleInitial(' ');
						continue mainLoop;
					}
					
					validNumericInput(input);
					
					int num = Integer.parseInt(input);
					
					if(num < 0) {
						System.out.println("Input must be a positive number!");
						throw new InvalidInputException();
					}
					if(num < 18) {
						System.out.println("You must be 18 or older to work at Loyd National Bank!");
						break mainLoop;
					}
													
					emp.setAge(num);
				}catch(InvalidInputException e) {
					System.out.println();
				}
			}	
						
			// Executes while the employee's address is null
			while(emp.getAddress() == null) {
				System.out.println("Please enter your street address without any special characters");
				System.out.println("(Enter c to cancel or b to enter a different age):");
													
				try {
					String input = scan.nextLine();
									
					if(input.equalsIgnoreCase("c"))
						break mainLoop;
					if(input.equalsIgnoreCase("b")) {
						emp.setAge(0);
						continue mainLoop;
					}
					if(input.length() > 100) {
						System.out.println("Input must be less than 100 characters!");
						throw new InvalidInputException();
					}
														
					validAlphaNumericInput(input);
											
					emp.setAddress(input);
				}catch(InvalidInputException e) {
					System.out.println();
				}
			}
			
			// Executes while the employee's city is null
			while(emp.getCity() == null) {
				System.out.println("Please enter your city without any special characters or numbers");
				System.out.println("(Enter c to cancel or b to enter a different street address):");
													
				try {
					String input = scan.nextLine();
												
					if(input.equalsIgnoreCase("c"))
						break mainLoop;
					if(input.equalsIgnoreCase("b")) {
						emp.setAddress(null);
						continue mainLoop;
					}
					if(input.length() > 100) {
						System.out.println("Input must be less than 100 characters!");
						throw new InvalidInputException();
					}
													
					validAlphabeticInput(input);
											
					emp.setCity(input);
				}catch(InvalidInputException e) {
					System.out.println();
				}
			}
						
			// Executes while the employee's zip code is unassigned
			while(emp.getZip() == 0) {
				System.out.println("Please enter your valid 5 digit zip code");
				System.out.println("(Enter c to cancel or b to enter a different city):");
													
				try {
					String input = scan.nextLine();
												
					if(input.equalsIgnoreCase("c"))
						break mainLoop;
					if(input.equalsIgnoreCase("b")) {
						emp.setCity(null);
						continue mainLoop;
					}
					if(input.length() != 5) {
						System.out.println("Input must be 5 characters!");
						throw new InvalidInputException();
					}
														
					validNumericInput(input);
											
					emp.setZip(Integer.parseInt(input));
				}catch(InvalidInputException e) {
					System.out.println();
				}
			}
						
			// Executes while the employee's state is null
			while(emp.getState() == null) {
				System.out.println("Please enter your state in SN format (Example: Florida would be FL)");
				System.out.println("(Enter c to cancel or b to enter a different zip code):");
													
				try {
					String input = scan.nextLine();
											
					if(input.equalsIgnoreCase("c"))
						break mainLoop;
					if(input.equalsIgnoreCase("b")) {
						emp.setZip(0);
						continue mainLoop;
					}
					if(input.length() != 2) {
						System.out.println("Input must be 2 characters!");
						throw new InvalidInputException();
					}
														
					validAlphabeticInput(input);
											
					emp.setState(input.toUpperCase());
				}catch(InvalidInputException e) {
					System.out.println();
				}
			}
			
			// Executes while the employee's department is null
			while(emp.getDepartment() == null) {
				System.out.println("Please enter your department name");
				System.out.println("(Enter c to cancel or b to enter a different state):");
																
				try {
					String input = scan.nextLine();
													
					if(input.equalsIgnoreCase("c"))
						break mainLoop;
					if(input.equalsIgnoreCase("b")) {
						emp.setState(null);
						continue mainLoop;
					}
					if(input.length() > 50) {
						System.out.println("Input must be less than 50 characters!");
						throw new InvalidInputException();
					}
																	
					validAlphabeticInput(input);
														
					emp.setDepartment(input);
				}catch(InvalidInputException e) {
					System.out.println();
				}
			}
						
			// Executes while the employee's pay is unassigned
			while(emp.getPay() == 0) {
				System.out.println("Please enter your pay per hour");
				System.out.println("(Enter c to cancel or b to enter a different department):");
															
				try {
					String input = scan.nextLine();
														
					if(input.equalsIgnoreCase("c"))
						break mainLoop;
					if(input.equalsIgnoreCase("b")) {
						emp.setDepartment(null);
						continue mainLoop;
					}
																
					validNumericInput(input);
														
					emp.setPay(Double.parseDouble(input));
					emp.setId(-1);
					break mainLoop;
				}catch(InvalidInputException e) {
					System.out.println();
				}
			}
		}
		
		// Executes if an employee was successfully registered
		if(emp.getId() == -1) {
			createEmployee(emp);
		}
	}
	
	// Tests if the Customer exists
	boolean customerExists(String username) throws UserExistsException{
		// Retrieves any customers who possess the entered username
		try {
			CustomerDAOImpl cdi = new CustomerDAOImpl();
			ArrayList<Customer> customers = cdi.customerExists(username);
			// Executes if a customer already exists with that username
			if(customers.isEmpty())
				throw new UserExistsException(username);
				//return false;
			return true;
		// Executes if the database couldn't be connected to
		}catch(SQLException e) {
			System.out.println("Couldn't connect to the database! Please try again later!");
			e.printStackTrace();
			System.out.println(e.getMessage());
			throw new UserExistsException(">");
			//return false;
		}
	}
	
	// Tests if the Employee exists
	boolean employeeExists(String username) throws UserExistsException {
		// Retrieves any employees who possess the entered username
		try {
			EmployeeDAOImpl edi = new EmployeeDAOImpl();
			ArrayList<Employee> employees = edi.employeeExists(username);
			// Executes if a customer already exists with that username
			if(!employees.isEmpty())
				throw new UserExistsException(username);
				//return false;
			return true;
		// Executes if the database couldn't be connected to
		}catch(SQLException e) {
			System.out.println("Couldn't connect to the database! Please try again later!");
			e.printStackTrace();
			System.out.println(e.getMessage());
			throw new UserExistsException(">");
			//return false;
		}
	}
	
	// Creates a new Customer database entry
	Customer createCustomer(Customer c) {
		try {
			// Attempts to put the entered customer information into the database
			CustomerDAOImpl cdi = new CustomerDAOImpl();
			cdi.createCustomer(c.getUsername(), c.getPassword(), c.getFirstName(), c.getLastName(), c.getMiddleInitial(), 
							   c.getAge(), c.getAddress(), c.getCity(), c.getZip(), c.getState());
			return c;
		// Executes if the database couldn't be reached
		}catch(SQLException e) {
			System.out.println("Couldn't establish connection with the database! Please try again later!");
			return null;
		}
	}
	
	// Creates a new Employee database entry
	Employee createEmployee(Employee emp) {
		try {
			// Attempts to put the entered employee information into the database
			EmployeeDAOImpl edi = new EmployeeDAOImpl();
			edi.createEmployee(emp.getUsername(), emp.getPassword(), emp.getFirstName(), emp.getLastName(), emp.getMiddleInitial(), 
							   emp.getAge(), emp.getAddress(), emp.getCity(), emp.getZip(), emp.getState(), emp.getDepartment(), emp.getPay());
			return emp;
		// Executes if the database couldn't be reached
		}catch(SQLException e) {
			System.out.println("Couldn't establish connection with the database! Please try again later!");
			return null;
		}
	}
	
	// Tests if the provided input was numeric
	public boolean validNumericInput(String input) throws InvalidInputException{
		try {
			// Attempts to parse the input into a number and returns true if the input was a number
			Double.parseDouble(input);
			if(input.length() == 0)
				throw new NumberFormatException();
			return true;
		// Throws an InvalidInputException if the input isn't numeric
		}catch(NumberFormatException e) {
			throw new InvalidInputException();
			//return false;
		}
	}
	
	// Tests if the provided input was alphabetic
	public boolean validAlphabeticInput(String input) throws InvalidInputException{
		// Creates a pattern and matcher to determine if the input contains only alphabetic characters
		Pattern pattern = Pattern.compile("[^A-Za-z ]");
		Matcher match = pattern.matcher(input);
			
		// Throws an InvalidInputException if the input isn't alphabetic
		if(match.find() || input.length() == 0)
			throw new InvalidInputException();
			//return false;
		return true;
	}
	
	// Tests if the provided input was alphanumeric
	public boolean validAlphaNumericInput(String input) throws InvalidInputException{
		// Creates a pattern and matcher to determine if the input contains only alphanumeric characters
		Pattern pattern = Pattern.compile("[^A-Za-z0-9]");
		Matcher match = pattern.matcher(input);
				
		// Throws an InvalidInputException if the input isn't alphanumeric
		if(match.find() || input.length() == 0)
			throw new InvalidInputException();
			//return false;
		return true;
	}
}
