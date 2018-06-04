package com.revature.JDBCBank;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.revature.beans.*;
import com.revature.daoimpl.AccountDAOImpl;
import com.revature.daoimpl.CustomerDAOImpl;
import com.revature.daoimpl.EmployeeDAOImpl;
import com.revature.exceptions.InvalidInputException;
import com.revature.exceptions.NoUserExistsException;

public class App 
{
	// Creates a Scanner object to process user input and an ArrayList to store the commands a user has access to
		private static Scanner scan = new Scanner(System.in);
		private static ArrayList<String> commands = new ArrayList<>();
	    
	    public static void main(String[] args) {
	    	// Welcomes the user and sets an input loop boolean to true
	    	System.out.println("Welcome to Loyd National Bank!");
	    	boolean flag = true;
	    	
	    	// Stores the main menu commands
	    	ArrayList<String> mainMenu = new ArrayList<>();
	    	mainMenu.add("Customer Login");
	    	mainMenu.add("Employee Login");
	    	mainMenu.add("Admin Login");
	    	mainMenu.add("Customer Registration");
	    	mainMenu.add("Exit");
	    	commands.addAll(mainMenu);
	    	
	    	SignIn si = new SignIn(scan);
	    	
	    	// Executes while the input loop boolean is true
	    	while(flag) {
	    		System.out.println("Please enter a command: ");
	    		for(String s : mainMenu) {
	    			System.out.println(s);
	    		}
	    		
	    		String input = scan.nextLine().toLowerCase();
	    		
	    		switch(input) {
	    			// Executes if the user is a customer requesting to login
	    			case("customer login"):
	    				// Validate the users login credentials
	    				Customer c = si.customerLogin();
	    				// Executes if the customer successfully logged in
	    				if(c != null) {
	    					try {
	    						customerMenu(c);
	    					}catch(SQLException e) {
	    						System.out.println("System is down! Please try again later!");
	    					}
	    				}
	    				commands.clear();
	    				commands.addAll(mainMenu);
	    				break;
	    			// Executes if the user is an employee requesting to login
	    			case("employee login"):
	    				// Validate the users login credentials
	    				Employee emp = si.employeeLogin();
	    				// Executes if the employee successfully logged in
	    				if(emp != null) {
	    					try {
	    						employeeMenu(emp);
	    					}catch(SQLException e) {
	    						System.out.println("System is down! Please try again later!");
	    					}
	    				}
	    				commands.clear();
	    				commands.addAll(mainMenu);
	    				break;
	    			// Executes if the customer is the administrator requesting to login
	    			case("admin login"):
	        			// Validate the users login credentials and executes if the admin successfully logged in
	        			if(si.adminLogin()) {
	        				try {
	        					adminMenu();
	        				}catch(SQLException e) {
	        					System.out.println("System is down! Please try again later!");
	        				}
	        			}
	        			commands.clear();
	        			commands.addAll(mainMenu);
	        			break;
	        		// Executes if the user is a new customer wishing to register
	    			case("customer registration"):
	    				SignUp su = new SignUp(scan);
	    				try {
	    					su.customerSignUp();
	    				}catch(SQLException sqle) {
	    					System.out.println("Couldn't connect to database! Please try again later!");
	    				}
	    				commands.clear();
	    				commands.addAll(mainMenu);
	    				break;
	    			// Breaks out of the loop if exit is entered
	    			case("exit"):
	    				flag = false;
	    				break;
	    			// Executes if anything else is entered
	    			default: System.out.println("Please enter your input as it appears in the list!");
	    		}
	    	}
	    	// Closes the scanner
	    	scan.close();
	    }
	    
	    private static void customerMenu(Customer c) throws SQLException{
	    	Bank bank = new Bank(scan);
	    	
	    	// Clears the current command list and enters the commands a customer has access to
	    	commands.clear();
	    	ArrayList<String> menu = new ArrayList<>();
	    	menu.add("Withdraw");
	    	menu.add("Deposit");
	    	menu.add("Transfer");
	    	menu.add("Open Account");
	    	menu.add("Close Account");
	    	menu.add("View Account Balance");
	    	menu.add("View Open Accounts");
	    	menu.add("View Transactions");
	    	menu.add("Exit");
	    	menu.add("Logout");
	    	commands.addAll(menu);
	    	
	    	boolean flag = true;
	    	
	    	AccountDAOImpl adi = new AccountDAOImpl();
	    	
	    	// Executes while the input loop boolean is true
	    	while(flag) {
	    		System.out.println("Please enter a command: ");
	    		for(String s : menu) {
	    			System.out.println(s);
	    		}
	    		
	    		String input = scan.nextLine().toLowerCase();
	    		
	    		switch(input) {
	    			// Opens the withdraw menu so the user can make a withdrawal
	    			case("withdraw"):
	    				bank.withdraw(c);
	    				commands.clear();
	    				commands.addAll(menu);
	    				break;
	    			// Opens the withdraw menu so the user can make a withdrawal
	    			case("deposit"):
	    				bank.deposit(c);
	    				commands.clear();
	    				commands.addAll(menu);
	    				break;
	    			// Opens the withdraw menu so the user can make a withdrawal
	    			case("transfer"):
	    				bank.transfer(c);
	    				commands.clear();
	    				commands.addAll(menu);
	    				break;
	    			// Opens the withdraw menu so the user can make a withdrawal
	    			case("open account"):
	    				bank.openAccount(c);
	    				commands.clear();
	    				commands.addAll(menu);
	    				break;
	    			// Opens the withdraw menu so the user can make a withdrawal
	    			case("close account"):
	    				bank.closeAccount(c);
	    				commands.clear();
	    				commands.addAll(menu);
	    				break;
	    			// Opens the withdraw menu so the user can make a withdrawal
	    			case("view account balance"):
	    				bank.accountBalance(c);
	    				commands.clear();
	    				commands.addAll(menu);
	    				break;
	    			// Prints out the account name and account type of all the users accounts
	    			case("view open accounts"):
	    				try {
	    					ArrayList<Account> accounts = adi.listAccounts(c.getId());
	    					System.out.println("Account Name : Account Type");
	    					for(Account a : accounts) {
	    						System.out.println(a.getName() + " : " + a.getType());
	    					}
	    				// Executes if the database couldn't be connected to
	    				}catch(SQLException e) {
	    					System.out.println("Couldn't connect to database! Please try again later!");
	    				}
	    				break;
	    			case("view transactions"):
	    				bank.viewTransactions(c);
	    			case("logout"):
	    				flag = false;
	    				break;
	    			// Exits the program if exit is entered
	    			case("exit"):
	    				scan.close();
	    				System.exit(1);
	    			default: System.out.println("Please enter your input as it appears in the list!");
	    		}
	    	}
	    }
	    
	    private static void employeeMenu(Employee e) throws SQLException{
	    	// Clears the current command list and enters the commands an employee has access to
	    	commands.clear();
	    	ArrayList<String> menu = new ArrayList<>();
	    	menu.add("View Customer Account");
	    	menu.add("View Account Information");
	    	menu.add("Exit");
	    	menu.add("Logout");
	    	commands.addAll(menu);
	    	
	    	boolean flag = true;
	    	
	    	CustomerDAOImpl cdi = new CustomerDAOImpl();
	    	AccountDAOImpl adi = new AccountDAOImpl();
	    	SignUp su = new SignUp(scan);
	    	
	    	// Executes while the input loop boolean is true
	    	while(flag) {
	    		System.out.println("Please enter a command: ");
	    		for(String s : menu) {
	    			System.out.println(s);
	    		}
	    		
	    		String input = scan.nextLine().toLowerCase();
	    		
	    		switch(input) {
	    			case("view customer account"):
	    				String view = null;
						while(view == null) {
							// Requests input from the user
							System.out.println("Enter the username of the user whose information you want to view(Enter c to cancel): ");
					
							view = scan.nextLine().toLowerCase();
				
							// Tests for the escape character
							if(view.equalsIgnoreCase("c"))
								break;
						
							// Retrieves any user with the entered username
							ArrayList<Customer> customers = cdi.customerExists(view);
						
							// Executes if a customer matches the entered username
							if(!customers.isEmpty()) {
								// Retrieves the customer's information
								Customer c = customers.get(0);
							
								// Prints out the customer's personal information
								System.out.println("Customer ID: " + c.getId());
								System.out.println("Username: " + c.getUsername());
								System.out.println("Password: " + c.getPassword());
								System.out.println("Name: " + c.getFirstName() + " " + c.getMiddleInitial() + " " + c.getLastName());
								System.out.println("Age: " + c.getAge() + " years old");
								System.out.println("Address: " + c.getAddress() + ", " + c.getCity() + ", " + c.getZip() + ", " + c.getState());
							
								// Prints out the customer's account information
								ArrayList<Account> customerAccounts = adi.listAccounts(c.getId());
								System.out.println("Account ID: Account Name : Account Type : Account Balance : Shared With");
								for(Account a : customerAccounts) {
									System.out.println(a.getId() + " : " + a.getName() + " : " + a.getType() + " : $" + a.getBalance() + " : " + a.getShared());
								}
							}
						}
						commands.clear();
						commands.addAll(menu);
						break;
	    			case("view account information"):
	    				String viewAccount = null;
	    				while(viewAccount == null) {
	    					// Requests input from the user
							System.out.println("Enter the account id of the account whose information you want to view(Enter c to cancel): ");
					
							viewAccount = scan.nextLine().toLowerCase();
				
							// Tests for the escape character
							if(viewAccount.equalsIgnoreCase("c"))
								break;
							
							try {
								su.validNumericInput(viewAccount);
								// Retrieves any user with the entered username
								ArrayList<Account> accounts = adi.listAccounts(viewAccount);
						
								// Executes if a customer matches the entered username
								if(!accounts.isEmpty()) {
									// Retrieves the customer's information
									Account a = accounts.get(0);
							
									// Prints out the customer's personal information
									System.out.println("Account ID: " + a.getId());
									System.out.println("Account Name: " + a.getName());
									System.out.println("Account Type: " + a.getType());
									System.out.println("Account Balance: $" + a.getBalance());
								}
							}catch(InvalidInputException ex) {
								viewAccount = null;
							}
	    				}
					case("logout"):
						flag = false;
	    				break;
	    				// Exits the program if exit is entered
					case("exit"):
						scan.close();
	    				System.exit(1);
					default: System.out.println("Please enter your input as it appears in the list!");
					}
	    	}
	    }
	    
	    private static void adminMenu() throws SQLException{
	    	// Clears the current command list and enters the commands the admin has access to
	    	commands.clear();
	    	ArrayList<String> menu = new ArrayList<>();
	    	menu.add("View Account");
	    	menu.add("Update Account");
	    	menu.add("Create Account");
	    	menu.add("Delete Account");
	    	menu.add("Exit");
	    	menu.add("Logout");
	    	commands.addAll(menu);
	    	
	    	boolean flag = true;
	    	
	    	CustomerDAOImpl cdi = new CustomerDAOImpl();
	    	AccountDAOImpl adi = new AccountDAOImpl();
	    	EmployeeDAOImpl edi = new EmployeeDAOImpl();
	    	
	    	// Executes while the input loop boolean is true
	    	while(flag) {
	    		System.out.println("Please enter a command: ");
	    		for(String s : menu) {
	    			System.out.println(s);
	    		}
	    		
	    		String input = scan.nextLine().toLowerCase();
	    		
	    		switch(input) {
	    			// Opens the view account menu for the admin
	    			case("view account"):
	    				String view = null;
						while(view == null) {
							// Requests input from the user
							System.out.println("Enter the username of the user whose information you want to view(Enter c to cancel): ");
						
							view = scan.nextLine().toLowerCase();
						
							// Tests for the escape character
							if(view.equalsIgnoreCase("c"))
								break;
							
							// Retrieves any user with the entered username
							ArrayList<Customer> customers = cdi.customerExists(view);
							ArrayList<Employee> employees = edi.employeeExists(view);
							
							// Executes if a customer matches the entered username
							if(!customers.isEmpty()) {
								// Retrieves the customer's information
								Customer c = customers.get(0);
								
								// Prints out the customer's personal information
								System.out.println("Username: " + c.getUsername());
								System.out.println("Password: " + c.getPassword());
								System.out.println("Name: " + c.getFirstName() + " " + c.getMiddleInitial() + " " + c.getLastName());
								System.out.println("Age: " + c.getAge() + " years old");
								System.out.println("Address: " + c.getAddress() + ", " + c.getCity() + ", " + c.getZip() + ", " + c.getState());
								
								// Prints out the customer's account information
								ArrayList<Account> customerAccounts = adi.listAccounts("CUSTID = " + c.getId());
		    					System.out.println("Account Name : Account Type : Account Balance : Shared With");
		    					for(Account a : customerAccounts) {
		    						System.out.println(a.getName() + " : " + a.getType() + " : $" + a.getBalance() + " : " + a.getShared());
		    					}
							}
							// Executes if an employee matches the entered username
							if(!employees.isEmpty()) {
								// Retrieves the employee's information
								Employee emp = employees.get(0);
								
								// Prints out the employees's personal information
								System.out.println("Username: " + emp.getUsername());
								System.out.println("Password: " + emp.getPassword());
								System.out.println("Name: " + emp.getFirstName() + " " + emp.getMiddleInitial() + " " + emp.getLastName());
								System.out.println("Age: " + emp.getAge() + " years old");
								System.out.println("Address: " + emp.getAddress() + ", " + emp.getCity() + ", " + emp.getZip() + ", " + emp.getState());
								System.out.println("Department of Employment: " + emp.getDepartment());
								System.out.println("Wage: $" + emp.getPay() + " per hour");
							}
							else
								System.out.println("Please enter employee, customer, or c!");
						}
	    				commands.clear();
	    				commands.addAll(menu);
	    				break;
	    			// Opens the update account menu
	    			case("update account"):
	    				String update = null;
	    				
						while(update == null) {
							System.out.println("Update an employee account or a customer account(Enter c to cancel): ");
						
							update = scan.nextLine().toLowerCase();
						
							customerLoop:
							if(update.equals("customer")) {
								Customer cus = null;
								
								while(cus == null) {
									System.out.println("Please enter the username of the customer you want to update(Enter c to cancel): ");
									
									String s = scan.nextLine();
									
									try {
										if(s.equalsIgnoreCase("c"))
											break customerLoop;
									
										ArrayList<Customer> customers = cdi.customerExists(s);
									
										if(!customers.isEmpty())
											cus = customers.get(0);
										else
											throw new NoUserExistsException(s);
									}catch(NoUserExistsException e) {
										System.out.println();
									}
										
								}
								
								boolean customerUpdate = true;
								
								customerUpdateLoop:
								while(customerUpdate) {
									System.out.println("What would you like to update?");
									System.out.println("Name");
									System.out.println("Age");
									System.out.println("Address");
									System.out.println("(Enter what you would like to change, save to save the changes, or c to cancel changes): ");
									
									String s = scan.nextLine().toLowerCase();
									
									switch(s) {
										// Executes if the admin wants to edit the customer's name
										case("name"):
											String[] newName = updateName(cus.getFirstName(), cus.getMiddleInitial(), cus.getLastName());
											cus.setFirstName(newName[0]);
											cus.setMiddleInitial(newName[1].charAt(0));
											cus.setLastName(newName[2]);
											break;
										// Executes if the admin wants to edit the customer's age
										case("age"):
											int newAge = updateAge(cus.getAge());
											cus.setAge(newAge);
											break;
										// Executes if the admin wants to update the customer's address
										case("address"):
											String[] newAddress = updateAddress(cus.getAddress(), cus.getCity(), cus.getZip(), cus.getState());
											cus.setAddress(newAddress[0]);
											cus.setCity(newAddress[1]);
											cus.setZip(Integer.parseInt(newAddress[2]));
											cus.setState(newAddress[3]);
											break;
										// Executes if the admin wants to save the changes made to the customer
										case("save"):
											cdi.updateCustomer(cus);
											break customerLoop;
										// Cancels any changes made to the customer
										case("c"):
											break customerUpdateLoop;
										// Executes if anything else is entered
										default: System.out.println("Please enter a valid option!");
									}
								}
							}
							employeeLoop:
							if(update.equals("employee")) {
								Employee emp = null;
								
								while(emp == null) {
									System.out.println("Please enter the username of the employee you want to update(Enter c to cancel): ");
									
									String s = scan.nextLine();
									
									try {
										if(s.equalsIgnoreCase("c"))
											break employeeLoop;
										
										ArrayList<Employee> employees = edi.employeeExists(s);
									
										if(!employees.isEmpty())
											emp = employees.get(0);
										else
											throw new NoUserExistsException(s);
									}catch(NoUserExistsException e) {
										System.out.println();
									}
										
								}
								
								boolean customerUpdate = true;
								
								employeeUpdateLoop:
								while(customerUpdate) {
									System.out.println("What would you like to update?");
									System.out.println("Name");
									System.out.println("Age");
									System.out.println("Address");
									System.out.println("Department");
									System.out.println("Pay");
									System.out.println("(Enter what you would like to change, save to save the changes, or c to cancel changes): ");
									
									String s = scan.nextLine().toLowerCase();
									
									switch(s) {
										// Executes if the admin wants to edit the employee's name
										case("name"):
											String[] newName = updateName(emp.getFirstName(), emp.getMiddleInitial(), emp.getLastName());
											emp.setFirstName(newName[0]);
											emp.setMiddleInitial(newName[1].charAt(0));
											emp.setLastName(newName[2]);
											break;
										// Executes if the admin wants to edit the employee's age
										case("age"):
											int newAge = updateAge(emp.getAge());
											emp.setAge(newAge);
											break;
										// Executes if the admin wants to update the employee's address
										case("address"):
											String[] newAddress = updateAddress(emp.getAddress(), emp.getCity(), emp.getZip(), emp.getState());
											emp.setAddress(newAddress[0]);
											emp.setCity(newAddress[1]);
											emp.setZip(Integer.parseInt(newAddress[2]));
											emp.setState(newAddress[3]);
											break;
										// Executes if the admin wants to update the employee's department
										case("department"):
											String newDepartment = updateDepartment(emp.getDepartment());
											emp.setDepartment(newDepartment);
											break;
										// Executes if the admin wants to update the employee's pay
										case("pay"):
											double newPay = updatePay(emp.getPay());
											emp.setPay(newPay);
											break;
										// Executes if the admin wants to save the changes made to the customer
										case("save"):
											edi.updateEmployee(emp);
											break employeeLoop;
										// Cancels any changes made to the customer
										case("c"):
											break employeeUpdateLoop;
										// Executes if anything else is entered
										default: System.out.println("Please enter a valid option!");
									}
								}
							}
							else if(update.equals("c"))
								break;
							else
								System.out.println("Please enter employee, customer, or c!");
						}
	    				commands.clear();
	    				commands.addAll(menu);
	    				break;
	    			// Opens the delete account menu
	    			case("delete account"):
	    				String delete = null;
	    				deleteLoop:
	    				while(delete == null) {
	    					System.out.println("Delete an employee account or a customer account(Enter c to cancel): ");
						
	    					delete = scan.nextLine().toLowerCase();
						
	    					if(delete.equals("customer")) {
	    						System.out.println("Please enter the username of the customer you'd like to delete(Enter c to cancel)");
	    							
	    						String cus = scan.nextLine();
	    							
	    						ArrayList<Customer> customers = cdi.customerExists(cus);
	    							
	    						try{
	    							if(customers.isEmpty()) 
	    								throw new NoUserExistsException(cus);
	    							cdi.deleteCustomer(customers.get(0).getId());
	    						}catch(NoUserExistsException e) {
	    							System.out.println();
	    						}
	    						
	    					}
	    					else if(delete.equals("employee")) {
	    						System.out.println("Please enter the username of the employee you'd like to delete(Enter c to cancel)");
								
	    						String cus = scan.nextLine();
	    							
	    						ArrayList<Employee> employees = edi.employeeExists(cus);
	    							
	    						try{
	    							if(employees.isEmpty()) 
	    								throw new NoUserExistsException(cus);
	    							edi.deleteEmployee(employees.get(0).getId());
	    						}catch(NoUserExistsException e) {
	    							System.out.println();
	    						}
	    					}
	    					else if(delete.equals("c"))
								break deleteLoop;
	    					else {
	    						System.out.println("Please enter employee, customer, or c!");
	    						delete = null;
	    					}
	    				}
	    				commands.clear();
	    				commands.addAll(menu);
	    				break;
	    			// Opens the create account menu
	    			case("create account"):
	    				String open = null;
	    				SignUp su = new SignUp(scan);
	    				loop:
	    				while(open == null) {
	    					System.out.println("Open an employee account or a customer account(Enter c to cancel): ");
	    					
	    					open = scan.nextLine().toLowerCase();
	    					
	    					try {
	    						if(open.equals("customer")) {
	    							su.customerSignUp();
	    							break loop;
	    						}
	    						else if(open.equals("employee")) {
	    							su.employeeSignUp();
	    							break loop;
	    						}
	    						else if(open.equals("c"))
	    							break loop;
	    						else
	    						System.out.println("Please enter employee, customer, or c!");
	    					}catch(SQLException e) {
	    						System.out.println("Error! Couldn't connect to the database! Please try again later!");
	    					}
	    				}
	    				commands.clear();
	    				commands.addAll(menu);
	    				break;
	    			case("logout"):
	    				flag = false;
	    				break;
	    			// Exits the program if exit is entered
	    			case("exit"):
	    				scan.close();
	    				System.exit(1);
	    			default: System.out.println("Please enter your input as it appears in the list!");
	    		}
	    	}
	    }
	    
	    private static String[] updateName(String firstName, char middleInitial, String lastName) {
	    	String[] name = {firstName, middleInitial + "", lastName};
	    	SignUp su = new SignUp(scan);
	    	
	    	// Executes while the first name is being entered
	    	firstLoop:
	    	while(true) {
	    		// Requsts the new first name
	    		System.out.println("Please enter the first name, enter / to skip: ");
	    		
	    		String fName = scan.nextLine();
	    		
	    		// Tests for escape character
	    		if(fName.equalsIgnoreCase("/"))
	    			break firstLoop;
	    		
	    		try {
	    			su.validAlphabeticInput(fName);
	    			
	    			if(fName.length() > 50) {
	    				System.out.println("Last name must be less than 50 characters!");
	    				throw new InvalidInputException();
	    			}
	    			
	    			name[0] = fName;
	    			break firstLoop;
	    		}catch(InvalidInputException e) {
	    			System.out.println();
	    		}
	    	}
	    	secondLoop:
	        	while(true) {
	        		System.out.println("Please enter the middle initial, enter / to skip: ");
	        		
	        		String middleI = scan.nextLine();
	        		
	        		if(middleI.equalsIgnoreCase("s"))
	        			break secondLoop;
	        		
	        		try {
	        			su.validAlphabeticInput(middleI);
	        			
	        			if(middleI.length() != 1) {
	        				System.out.println("Middle initial must be one character!");
	        				throw new InvalidInputException();
	        			}
	        			
	        			name[1] = middleI;
	        			break secondLoop;
	        		}catch(InvalidInputException e) {
	        			System.out.println();
	        		}
	        	}
	    	thirdLoop:
	        while(true) {
	        	System.out.println("Please enter the last name, enter / to skip: ");
	        		
	        	String lName = scan.nextLine();
	        		
	        	if(lName.equalsIgnoreCase("/"))
	        		break thirdLoop;
	        		
	        	try {
	        		su.validAlphabeticInput(lName);
	        		
	        		if(lName.length() > 50) {
	    				System.out.println("Last name must be less than 50 characters!");
	    				throw new InvalidInputException();
	    			}
	        			
	        		name[2] = lName;
	        		break thirdLoop;
	        	}catch(InvalidInputException e) {
	        		System.out.println();
	        	}
	        }
	    	
	        	// Returns the updated name
	    	return name;
	    }
	    
	    private static String[] updateAddress(String street, String city, int zip, String state) {
	    	String[] address = {street, city, Integer.toString(zip), state};
	    	
	    	SignUp su = new SignUp(scan);
	    	
	    	// Executes while the first name is being entered
	    	firstLoop:
	    	while(true) {
	    		// Requsts the new first name
	    		System.out.println("Please enter the street address, enter / to skip: ");
	    		
	    		String newAddress = scan.nextLine();
	    		
	    		// Tests for escape character
	    		if(newAddress.equalsIgnoreCase("/"))
	    			break firstLoop;
	    		
	    		try {
	    			su.validAlphabeticInput(newAddress);
	    			
	    			if(newAddress.length() > 100) {
	    				System.out.println("Street address must be less than 100 characters!");
	    				throw new InvalidInputException();
	    			}
	    			
	    			address[0] = newAddress;
	    			break firstLoop;
	    		}catch(InvalidInputException e) {
	    			System.out.println();
	    		}
	    	}
	    	secondLoop:
	       	while(true) {
	       		System.out.println("Please enter the city, enter / to skip: ");
	        		
	       		String newCity = scan.nextLine();
	        		
	       		if(newCity.equalsIgnoreCase("/"))
	       			break secondLoop;
	        		
	       		try {
	       			su.validAlphabeticInput(newCity);
	        			
	       			if(newCity.length() > 100) {
	       				System.out.println("City name must be less than 100 characters!");
	       				throw new InvalidInputException();
	       			}
	        			
	       			address[1] = newCity;
	       			break secondLoop;
	       		}catch(InvalidInputException e) {
	       			System.out.println();
	       		}
	       	}
	    	thirdLoop:
	        while(true) {
	        	System.out.println("Please enter the zip code, enter / to skip: ");
	        		
	        	String newZip = scan.nextLine();
	        		
	        	if(newZip.equalsIgnoreCase("/"))
	        		break thirdLoop;
	        		
	        	try {
	        		su.validNumericInput(newZip);
	        		
	        		if(newZip.length() != 5) {
	    				System.out.println("Zip code must be 5 characters!");
	    				throw new InvalidInputException();
	    			}
	        			
	        		address[2] = newZip;
	        		break thirdLoop;
	        	}catch(InvalidInputException e) {
	        		System.out.println();
	        	}
	        }
	        fourthLoop:
	        while(true) {
	        	System.out.println("Please enter the state, enter / to skip: ");
	                		
	           	String newState = scan.nextLine();
	               		
	            if(newState.equalsIgnoreCase("/"))
	         		break fourthLoop;
	                		
	            try {
	               	su.validAlphabeticInput(newState);
	                		
	               	if(newState.length() != 2) {
	           			System.out.println("State must be in SN format! Example: Florida is FL!");
	           			throw new InvalidInputException();
	          		}
	                			
	              	address[3] = newState;
	               	break fourthLoop;
	            }catch(InvalidInputException e) {
	           		System.out.println();
	           	}
	        }
	    	
	    	return address;
	    }
	    
	    private static int updateAge(int age) {
	    	SignUp su = new SignUp(scan);
	    	
	    	loop:
	    	while(true) {
	    		System.out.println("Please enter the new age: ");
	    		
	    		String input = scan.nextLine();
	    		
	    		try {
	    			su.validNumericInput(input);
	    			int newAge = Integer.parseInt(input);
	    			
	    			if(newAge < 0) {
	    				System.out.println("Please enter a positive number!");
	    				throw new InvalidInputException();
	    			}
	    			else if(newAge < age) {
	    				System.out.println("People can't age backwards!");
	    				throw new InvalidInputException();
	    			}
	    			else
	    				age = newAge;
	    			
	    			break loop;
	    		}catch(InvalidInputException e) {
	    			System.out.println();
	    		}
	    	}
	    	
	    	return age;
	    }
	    
	    private static String updateDepartment(String department) {
	    	SignUp su = new SignUp(scan);
	    	
	    	loop:
	    	while(true) {
	    		System.out.println("Please enter the new department: ");
	    		
	    		String input = scan.nextLine();
	    		
	    		try {
	    			su.validAlphabeticInput(input);

	    			department = input;
	    			
	    			break loop;
	    		}catch(InvalidInputException e) {
	    			System.out.println();
	    		}
	    	}

	    	return department;
	    }
	    
	    private static double updatePay(double pay) {
	    	SignUp su = new SignUp(scan);
	    	
	    	loop:
	    	while(true) {
	    		System.out.println("Please enter the hourly wage: ");
	    		
	    		String input = scan.nextLine();
	    		
	    		try {
	    			su.validNumericInput(input);
	    			double newPay = Double.parseDouble(input);
	    			
	    			if(newPay < 0) {
	    				System.out.println("Can't pay someone a negative wage!");
	    				throw new InvalidInputException();
	    			}
	    			else
	    				pay = newPay;
	    			
	    			break loop;
	    		}catch(InvalidInputException e) {
	    			System.out.println();
	    		}
	    	}
	    	return pay;
	    }
}
