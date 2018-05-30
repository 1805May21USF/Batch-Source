package com.revature.BankingApp;

import java.io.File;
import java.util.Scanner;
import java.util.Vector;
import com.revature.storage.Account;
import com.revature.storage.Customer;
import com.revature.storage.Employee;

public class SignUp {
	// Retrieves App's Scanner
	private static Scanner scan = App.getScanner();
	
	// Launches the Customer sign up process
	public void signUp() {
		String input = "";
		
		while(!input.equals("exit")) {
			// Requests a username for the account
			System.out.println("Please enter a username (type c to cancel): ");
		
			String username = scan.nextLine();
			
			// Executes if c is entered
			if(username.equalsIgnoreCase("c")) {
				input = "exit";
				break;
			}
			
			// Executes if the username doesn't exist
			if(!exists(username)) {
				// Executes if the username contains an illegal character
				if(username.contains("/") || username.contains("\\") || username.contains("?") || username.contains("%") ||
				   username.contains("*") || username.contains(":") || username.contains("|") || username.contains("\"") ||
				   username.contains("<") || username.contains(">") || username.contains(".") || username.contains(" ")) {
					System.out.println("Username cannot contain the /, \\, ?, %, *, :, |, \", <, >, ., or space characters!");
					break;
				}
				while(!input.equals("back") && !input.equals("exit")) {
					// Requests a password from the user
					System.out.println("Please enter a password (type b to go back, c to cancel): ");
				
					String password = scan.nextLine();
					
					// Executes if the back command is provided
					if(password.equalsIgnoreCase("b")) {
						input = "back";
						break;
					}
					// Executes if the cancel command is provided
					else if(password.equalsIgnoreCase("c")){
						input = "exit";
						break;
					}
					
					// Creates variables for a first and last name, middle initial, and age
					String firstName = null;
					char middleInitial = ' ';
					String lastName = null;
					String address = null;
					int age = 0;
					
					// Executes while a first name isn't provided
					while(firstName == null) {
						// Requests the user's first name
						System.out.println("Please enter your first name: ");
						// Assigns the input to the firstName variable
						firstName = scan.nextLine();
						// Executes if no input was provided
						if(firstName.length() == 0) {
							System.out.println("Please enter a value!");
							firstName = null;
						}
						// Executes if a special character was included
						else if(firstName.contains("1") || firstName.contains("2") || firstName.contains("3") ||
								firstName.contains("4") || firstName.contains("5") || firstName.contains("6") ||
								firstName.contains("7") || firstName.contains("8") || firstName.contains("9") ||
								firstName.contains("0") || firstName.contains("!") || firstName.contains("@") ||
								firstName.contains("#") || firstName.contains("$") || firstName.contains("%") ||
								firstName.contains("^") || firstName.contains("&") || firstName.contains("*") ||
								firstName.contains("(") || firstName.contains(")") || firstName.contains("-") ||
								firstName.contains("_") || firstName.contains("+") || firstName.contains("=") ||
								firstName.contains(",") || firstName.contains("<") || firstName.contains(">") ||
								firstName.contains(".") || firstName.contains("?")|| firstName.contains("/") ||
								firstName.contains("\"") || firstName.contains("\'") || firstName.contains("\\") ||
								firstName.contains(";") || firstName.contains(":") || firstName.contains("|") ||
								firstName.contains("{") || firstName.contains("}") || firstName.contains("[") ||
								firstName.contains("]")) {
							System.out.println("No special characters allowed!");
							firstName = null;
						}
					}
					// Executes while a middle initial isn't provided
					while(middleInitial == ' ') {
						// Requests the user's middle initial
						System.out.println("Please enter your middle initial: ");
						middleInitial = scan.nextLine().charAt(0);
						// Executes if a special character was entered
						if(middleInitial == '1' || middleInitial == '2' || middleInitial == '3' ||
						   middleInitial == '4' || middleInitial == '5' || middleInitial == '6' ||
					   	   middleInitial == '7' || middleInitial == '8' || middleInitial == '9' ||
						   middleInitial == '0' || middleInitial == '!' || middleInitial == '@' ||
						   middleInitial == '#' || middleInitial == '$' || middleInitial == '%' ||
						   middleInitial == '^' || middleInitial == '&' || middleInitial == '*' ||
						   middleInitial == '(' || middleInitial == ')' || middleInitial == '-' ||
						   middleInitial == '_' || middleInitial == '+' || middleInitial == '=' ||
						   middleInitial == ',' || middleInitial == '<' || middleInitial == '>' ||
						   middleInitial == '.' || middleInitial == '?' || middleInitial == '/' ||
						   middleInitial == '\"' || middleInitial == '\'' || middleInitial == '\\' ||
						   middleInitial == ';' || middleInitial == ':' || middleInitial == '|' ||
						   middleInitial == '{' || middleInitial == '}' || middleInitial == '[' ||
						   middleInitial == ']') {
							System.out.println("No special characters allowed!");
							middleInitial = ' ';
						}
					}
					// Executes while a last name isn't provided
					while(lastName == null) {
						// Requests the user's last name
						System.out.println("Please enter your last name: ");
						lastName = scan.nextLine();
						// Executes if no input was provided
						if(lastName.length() == 0) {
							System.out.println("Please enter a value!");
							lastName = null;
						}
						// Executes if a special character was entered
						else if(lastName.contains("1") || lastName.contains("2") || lastName.contains("3") ||
								lastName.contains("4") || lastName.contains("5") || lastName.contains("6") ||
								lastName.contains("7") || lastName.contains("8") || lastName.contains("9") ||
								lastName.contains("0") || lastName.contains("!") || lastName.contains("@") ||
								lastName.contains("#") || lastName.contains("$") || lastName.contains("%") ||
								lastName.contains("^") || lastName.contains("&") || lastName.contains("*") ||
								lastName.contains("(") || lastName.contains(")") || lastName.contains("-") ||
								lastName.contains("_") || lastName.contains("+") || lastName.contains("=") ||
								lastName.contains(",") || lastName.contains("<") || lastName.contains(">") ||
								lastName.contains(".") || lastName.contains("?")|| lastName.contains("/") ||
								lastName.contains("\"") || lastName.contains("\'") || lastName.contains("\\") ||
								lastName.contains(";") || lastName.contains(":") || lastName.contains("|") ||
								lastName.contains("{") || lastName.contains("}") || lastName.contains("[") ||
								lastName.contains("]")) {
							System.out.println("No special characters allowed!");
							lastName = null;
						}
					}
					// Executes while a first name isn't provided
					while(address == null) {
						// Requests the user's first name
						System.out.println("Please enter your address: ");
						// Assigns the input to the firstName variable
						address = scan.nextLine();
						// Executes if no input was provided
						if(address.length() == 0) {
							System.out.println("Please enter a value!");
							address = null;
						}
						// Executes if a special character was included
						else if(firstName.contains("!") || firstName.contains("@") || firstName.contains("]") ||
								firstName.contains("#") || firstName.contains("$") || firstName.contains("%") ||
								firstName.contains("^") || firstName.contains("&") || firstName.contains("*") ||
								firstName.contains("(") || firstName.contains(")") || firstName.contains("-") ||
								firstName.contains("_") || firstName.contains("+") || firstName.contains("=") ||
								firstName.contains(",") || firstName.contains("<") || firstName.contains(">") ||
								firstName.contains(".") || firstName.contains("?")|| firstName.contains("/") ||
								firstName.contains("\"") || firstName.contains("\'") || firstName.contains("\\") ||
								firstName.contains(";") || firstName.contains(":") || firstName.contains("|") ||
								firstName.contains("{") || firstName.contains("}") || firstName.contains("[")) {
							System.out.println("No special characters allowed!");
							address = null;
						}
					}
					// Executes while an age isn't provided
					while(age == 0) {
						// Requests an age
						System.out.println("Please enter your age: ");
						try {
							age = Integer.parseInt(scan.nextLine());
							
							// Executes if the age entered is negative
							if(age <= 0) {
								System.out.println("Please enter a positive number greater than 0");
								age = 0;
							}
							// Executes if the entered age is less than 16
							else if(age < 16) {
								System.out.println("You must be at least 16 years old to open an account with us!");
								System.out.println("The account creation process will now close!");
								// Exits the method
								return;
							}
						// Executes if the input wasn't numerical
						}catch(NumberFormatException e) {
							System.out.println("Please enter a valid number!");
							age = 0;
						}
					}
					
					// Creates and stores a default account for the user
					Vector<Account> accounts = new Vector<>();
					Account a = new Account("checking", "Personal Checking", 0, "none");
					accounts.add(a);
					// Creates a Customer object to represent the new customer
					Customer c = new Customer(username, password, firstName, middleInitial, lastName, age, address, accounts);
						
					// Creates the Customer file if it doesn't exist
					if(!exists(username))
						createCustomer(c);
					else
						System.out.println("Customer already exists!");
					return;
				}
			}
			else
				System.out.println("Username already in use");
		}
		return;
	}
	
	// Launches the employee sign up process
	public void employeeSignUp() {
		String input = "";
		
		while(!input.equals("exit")) {
			// Requests a username for the account
			System.out.println("Please enter a username (type c to cancel): ");
		
			String username = scan.nextLine();
			
			// Executes if c is entered
			if(username.equalsIgnoreCase("c")) {
				input = "exit";
				break;
			}
			
			// Executes if the username doesn't exist
			if(!exists(username)) {
				// Executes if the username contains an illegal character
				if(username.contains("/") || username.contains("\\") || username.contains("?") || username.contains("%") ||
				   username.contains("*") || username.contains(":") || username.contains("|") || username.contains("\"") ||
				   username.contains("<") || username.contains(">") || username.contains(".") || username.contains(" ")) {
					System.out.println("Username cannot contain the /, \\, ?, %, *, :, |, \", <, >, ., or space characters!");
					break;
				}
				while(!input.equals("back") && !input.equals("exit")) {
					// Requests a password from the user
					System.out.println("Please enter a password (type b to go back, c to cancel): ");
				
					String password = scan.nextLine();
					
					// Executes if the back command is provided
					if(password.equalsIgnoreCase("b")) {
						input = "back";
						break;
					}
					// Executes if the cancel command is provided
					else if(password.equalsIgnoreCase("c")){
						input = "exit";
						break;
					}
					
					// Creates variables for a first and last name, middle initial, and age
					String firstName = null;
					char middleInitial = ' ';
					String lastName = null;
					String address = null;
					int age = 0;
					
					// Executes while a first name isn't provided
					while(firstName == null) {
						// Requests the user's first name
						System.out.println("Please enter your first name: ");
						// Assigns the input to the firstName variable
						firstName = scan.nextLine();
						// Executes if no input was provided
						if(firstName.length() == 0) {
							System.out.println("Please enter a value!");
							firstName = null;
						}
						// Executes if a special character was included
						else if(firstName.contains("1") || firstName.contains("2") || firstName.contains("3") ||
								firstName.contains("4") || firstName.contains("5") || firstName.contains("6") ||
								firstName.contains("7") || firstName.contains("8") || firstName.contains("9") ||
								firstName.contains("0") || firstName.contains("!") || firstName.contains("@") ||
								firstName.contains("#") || firstName.contains("$") || firstName.contains("%") ||
								firstName.contains("^") || firstName.contains("&") || firstName.contains("*") ||
								firstName.contains("(") || firstName.contains(")") || firstName.contains("-") ||
								firstName.contains("_") || firstName.contains("+") || firstName.contains("=") ||
								firstName.contains(",") || firstName.contains("<") || firstName.contains(">") ||
								firstName.contains(".") || firstName.contains("?")|| firstName.contains("/") ||
								firstName.contains("\"") || firstName.contains("\'") || firstName.contains("\\") ||
								firstName.contains(";") || firstName.contains(":") || firstName.contains("|") ||
								firstName.contains("{") || firstName.contains("}") || firstName.contains("[") ||
								firstName.contains("]")) {
							System.out.println("No special characters allowed!");
							firstName = null;
						}
					}
					// Executes while a middle initial isn't provided
					while(middleInitial == ' ') {
						// Requests the user's middle initial
						System.out.println("Please enter your middle initial: ");
						middleInitial = scan.nextLine().charAt(0);
						// Executes if a special character was entered
						if(middleInitial == '1' || middleInitial == '2' || middleInitial == '3' ||
						   middleInitial == '4' || middleInitial == '5' || middleInitial == '6' ||
					   	   middleInitial == '7' || middleInitial == '8' || middleInitial == '9' ||
						   middleInitial == '0' || middleInitial == '!' || middleInitial == '@' ||
						   middleInitial == '#' || middleInitial == '$' || middleInitial == '%' ||
						   middleInitial == '^' || middleInitial == '&' || middleInitial == '*' ||
						   middleInitial == '(' || middleInitial == ')' || middleInitial == '-' ||
						   middleInitial == '_' || middleInitial == '+' || middleInitial == '=' ||
						   middleInitial == ',' || middleInitial == '<' || middleInitial == '>' ||
						   middleInitial == '.' || middleInitial == '?' || middleInitial == '/' ||
						   middleInitial == '\"' || middleInitial == '\'' || middleInitial == '\\' ||
						   middleInitial == ';' || middleInitial == ':' || middleInitial == '|' ||
						   middleInitial == '{' || middleInitial == '}' || middleInitial == '[' ||
						   middleInitial == ']') {
							System.out.println("No special characters allowed!");
							middleInitial = ' ';
						}
					}
					// Executes while a last name isn't provided
					while(lastName == null) {
						// Requests the user's last name
						System.out.println("Please enter your last name: ");
						lastName = scan.nextLine();
						// Executes if no input was provided
						if(lastName.length() == 0) {
							System.out.println("Please enter a value!");
							lastName = null;
						}
						// Executes if a special character was entered
						else if(lastName.contains("1") || lastName.contains("2") || lastName.contains("3") ||
								lastName.contains("4") || lastName.contains("5") || lastName.contains("6") ||
								lastName.contains("7") || lastName.contains("8") || lastName.contains("9") ||
								lastName.contains("0") || lastName.contains("!") || lastName.contains("@") ||
								lastName.contains("#") || lastName.contains("$") || lastName.contains("%") ||
								lastName.contains("^") || lastName.contains("&") || lastName.contains("*") ||
								lastName.contains("(") || lastName.contains(")") || lastName.contains("-") ||
								lastName.contains("_") || lastName.contains("+") || lastName.contains("=") ||
								lastName.contains(",") || lastName.contains("<") || lastName.contains(">") ||
								lastName.contains(".") || lastName.contains("?")|| lastName.contains("/") ||
								lastName.contains("\"") || lastName.contains("\'") || lastName.contains("\\") ||
								lastName.contains(";") || lastName.contains(":") || lastName.contains("|") ||
								lastName.contains("{") || lastName.contains("}") || lastName.contains("[") ||
								lastName.contains("]")) {
							System.out.println("No special characters allowed!");
							lastName = null;
						}
					}
					// Executes while a first name isn't provided
					while(address == null) {
						// Requests the user's first name
						System.out.println("Please enter your address: ");
						// Assigns the input to the firstName variable
						address = scan.nextLine();
						// Executes if no input was provided
						if(address.length() == 0) {
							System.out.println("Please enter a value!");
							address = null;
						}
						// Executes if a special character was included
						else if(firstName.contains("!") || firstName.contains("@") || firstName.contains("]") ||
								firstName.contains("#") || firstName.contains("$") || firstName.contains("%") ||
								firstName.contains("^") || firstName.contains("&") || firstName.contains("*") ||
								firstName.contains("(") || firstName.contains(")") || firstName.contains("-") ||
								firstName.contains("_") || firstName.contains("+") || firstName.contains("=") ||
								firstName.contains(",") || firstName.contains("<") || firstName.contains(">") ||
								firstName.contains(".") || firstName.contains("?")|| firstName.contains("/") ||
								firstName.contains("\"") || firstName.contains("\'") || firstName.contains("\\") ||
								firstName.contains(";") || firstName.contains(":") || firstName.contains("|") ||
								firstName.contains("{") || firstName.contains("}") || firstName.contains("[")) {
							System.out.println("No special characters allowed!");
							address = null;
						}
					}
					// Executes while an age isn't provided
					while(age == 0) {
						// Requests an age
						System.out.println("Please enter your age: ");
						try {
							age = Integer.parseInt(scan.nextLine());
							
							// Executes if the age entered is negative
							if(age <= 0) {
								System.out.println("Please enter a positive number greater than 0");
								age = 0;
							}
							// Executes if the entered age is less than 16
							else if(age < 16) {
								System.out.println("You must be at least 16 years old to open an account with us!");
								System.out.println("The account creation process will now close!");
								// Exits the method
								return;
							}
						// Executes if the input wasn't numerical
						}catch(NumberFormatException e) {
							System.out.println("Please enter a valid number!");
							age = 0;
						}
					}
					
					boolean emp = true;
					
					while(emp) {
						// Requests a department name
						System.out.println("Please enter department name: ");
						
						String dep = scan.nextLine();
						
						// Requests current salary
						System.out.println("Please enter current monthly salary: ");
						
						try {
							double pay = Double.parseDouble(scan.nextLine());
							
							// Executes if pay is negative
							if(pay < 0)
								System.out.println("Must have positive pay!");
							else {
								// Creates the new Employee
								Employee e = new Employee(username, password, firstName, middleInitial, lastName, age, address,
														  dep, pay);
								
								// Tests if the Employee exists or not
								if(!employeeExists(username))
									createEmployee(e);
								else
									System.out.println("Employee already exists!");
								return;
							}
						// Executes if a number isn't entered
						}catch(NumberFormatException e) {
							System.out.println("Please enter a number!");
						}
					}
				}
			}
			// Prints if the username already exists
			else
				System.out.println("Username already in use");
		}
		return;
	}
	
	// Tests if the Customer exists
	boolean exists(String username) {
		// Tests if the file exists
		File file = new File("data/customers/" + username + ".cus");
		// Returns true if the file exists false if it doesn't
		if(file.exists())
			return true;
		else
			return false;
	}
	
	// Tests if the Employee exists
	boolean employeeExists(String username) {
		File file = new File("data/employees/" + username + ".emp");

		if(file.exists())
			return true;
		else
			return false;
	}
	
	// Creates a new Customer file
	void createCustomer(Customer c) {
		App.serialize(c);
	}
	
	// Creates a new Employee file
	void createEmployee(Employee e) {
		App.serialize(e);
	}
}
