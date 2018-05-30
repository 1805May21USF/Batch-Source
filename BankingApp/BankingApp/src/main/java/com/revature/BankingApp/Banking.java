package com.revature.BankingApp;

import java.util.Scanner;
import java.util.Vector;

import org.apache.log4j.Logger;

import com.revature.storage.Account;
import com.revature.storage.Customer;
import com.revature.storage.Employee;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Banking {
	private static String user;
	private static Logger log = Logger.getLogger(Banking.class.getName());
	private static Scanner scan = App.getScanner();
	
	// Executes the customer's menu
	public void customerMenu(Customer customer) {
		System.out.println("Welcome, " + customer.getUsername());
		user = customer.getUsername();
		
		// Creates a boolean loop value
		boolean flag = true;
		
		while(flag) {
			// Prints a list of commands and requests input
			System.out.println("What would you like to do: ");
			System.out.println("Withdraw");
			System.out.println("Deposit");
			System.out.println("Transfer");
			System.out.println("Open Account");
			System.out.println("Close Account");
			System.out.println("View Account Balance");
			System.out.println("View Accounts");
			System.out.println("Exit");
			System.out.println("Logout");
			
			String input = scan.nextLine().toLowerCase();
			
			switch(input) {
				// Executes when withdraw is entered and begins the withdrawal process
				case("withdraw"):
					String[] withdraw = withdraw(customer);
					if(withdraw != null)
						withdraw(customer, Integer.parseInt(withdraw[0]), Double.parseDouble(withdraw[1]));
					break;
				// Executes when deposit is entered and begins the deposit process
				case("deposit"):
					String[] deposit = deposit(customer);
					if(deposit != null)
						deposit(customer, Integer.parseInt(deposit[0]), Double.parseDouble(deposit[1]));
					break;
				// Executes when transfer is entered and begins the transfer process
				case("transfer"):
					String[] transfer = transfer(customer);
					if(transfer != null) {
						if(transfer.length == 4)
							transfer(customer, Integer.parseInt(transfer[0]), Integer.parseInt(transfer[1]), 
									 Double.parseDouble(transfer[2]));
						else
							transfer(customer, Integer.parseInt(transfer[0]), transfer[1], Integer.parseInt(transfer[2]), 
									 Double.parseDouble(transfer[3]));
					}
					break;
				// Executes when account open is entered and starts the account opening process
				case("open account"):
					String[] open = openAccount(customer);
					if(open != null)
						openAccount(customer, open[0], open[1], Double.parseDouble(open[2]), open[3]);
					break;
				// Executes when close account is entered and starts the account closure process
				case("close account"):
					int close = closeAccount(customer);
					if(confirm()) {
						closeAccount(customer, close);
					}
					break;
				case("view account balance"):
					viewBalance(customer);
					break;
				// Executes when view accounts is entered and displays a user's accounts
				case("view accounts"):
					System.out.println(customer.toString());
					break;
				// Executes when exit is entered and closes the program
				case("exit"):	scan.close();
								System.exit(1);
				// Executes when logout is entered and breaks the loop
				case("logout"):	flag = false;
				// Executes when anything else is entered
				default:	System.out.println("Please enter the input as it's shown on your screen!");
			}
		}
	}
	
	// Executes when a withdrawal is requested
	private static String[] withdraw(Customer c) {
		// Sets the loop flag, and creates a String array to store input
		boolean flag = true;
		String[] values = new String[2];
		
		while(flag) {
			// Requests the account to be withdrawn from
			System.out.println("Which account would you like to withdraw from (Enter c to cancel): ");
			
			// Prints the names of the available accounts
			for(Account a : c.getAccounts()) {
				System.out.println(a.getName() + ": $" + a.getBalance());
			}
					
			// Assigns input and sets amount equal to 0
			String input = scan.nextLine();
			double amount = 0;
			
			// Tests if the escape character was entered
			if(input.equalsIgnoreCase("c"))
				return null;
			
			boolean exists = false;
			int index = 0;
			for(Account a : c.getAccounts()) {
				if(a.getName().equals(input)) {
					exists = true;
					index = c.getAccounts().indexOf(a);
					break;
				}
			}
			
			// Tests if the account name entered exists
			if(exists) {
				// Sets the loop flag and the index of the account
				boolean flag2 = true;
				
				while(flag2) {
					// Requests the amount to be withdrawn from the account
					System.out.println("Enter amount to withdraw (enter c to cancel b to select a different account): ");
					
					try {
						// Receives input
						String temp = scan.nextLine();
						
						// Test if the escape or back character were entered
						if(temp.equalsIgnoreCase("c"))
							return null;
						if(temp.equalsIgnoreCase("b")) {
							flag2 = false;
							break;
						}
						
						// Assigns input to a double
						amount = Double.parseDouble(temp);
						
						// Executes if a negative number or zero was entered
						if(amount <= 0)
							System.out.println("Please enter a positive number!");
						// Executes if a number greater than the balance was entered
						else if(amount > c.getAccounts().get(index).getBalance()) {
							System.out.println("Not enough funds to cover withdrawl!");
							amount = 0;
						}
						else {
							// Stores the username of the account holder, the account index, and amount to be withdrawn
							values[0] = Integer.toString(index);
							values[1] = Double.toString(amount);
							
							// Breaks out of the loops
							flag2 = false;
							flag = false;
						}
					// Executes if input wasn't numerical
					}catch(NumberFormatException e) {
						System.out.println("That wasn't a valid number!");
					}
				}
				
				// Tests if an amount was provided
				if(amount > 0)
					flag = false;
			}
			// Executes if the account doesn't exist
			else {
				System.out.println("Account doesn't exist! Write the account name as it appears in the list!");
			}
		}
		
		return values;
	}
	
	// Performs a withdrawal
	private static void withdraw(Customer c, int account, double amount) {
		// Changes the balance
		c.getAccounts().get(account).setBalance(c.getAccounts().get(account).getBalance() - amount);
		// Commits the transactions and lets the user know the transaction was successful and the new account balance
		if(commit(c)) {
			System.out.println("$" + amount + " successfully withdrawn from account " + c.getAccounts().get(account).getName() + "!");
			System.out.println("Total balance in account: $" + c.getAccounts().get(account).getBalance());
			
			// Prints the transaction information to the log file
			log.info("Info:\nAccount " + c.getAccounts().get(account).getName() + " belonging to " + c.getUsername() + "had $" + amount + 
					 " withdrawn from it by " + user + ", making the total amount in the account $" + 
					 c.getAccounts().get(account).getBalance() + "\n");
		}
		// Alerts the user that the commit failed, restore the original account balance, and log the error
		else {
			System.out.println("Error! Couldn't commit changes to the account balance!");
			c.getAccounts().get(account).setBalance(c.getAccounts().get(account).getBalance() + amount);
			log.error("Error:\nCouldn't commit changes to account " + c.getAccounts().get(account).getName() + " belonging to " 
					  + c.getUsername() + "\n");
		}
	}
	
	// Executes when a deposit is requested
	private static String[] deposit(Customer c) {
		// Sets the loop flag, and creates a String array to store input
		boolean flag = true;
		String[] values = new String[3];
		
		while(flag) {
			// Requests the account to be deposited to
			System.out.println("Which account would you like to deposit (Enter c to cancel): ");
			
			// Prints the names of the available accounts
			for(Account a : c.getAccounts()) {
				System.out.println(a.getName() + ": $" + a.getBalance());
			}
					
			// Assigns input and sets amount equal to 0
			String input = scan.nextLine();
			double amount = 0;
			
			// Tests if the escape character was entered
			if(input.equalsIgnoreCase("c"))
				return null;
			
			boolean exists = false;
			int index = 0;
			for(Account a : c.getAccounts()) {
				if(a.getName().equals(input)) {
					exists = true;
					index = c.getAccounts().indexOf(a);
					break;
				}
			}
			
			// Tests if the account name entered exists
			if(exists) {
				// Sets the loop flag and the index of the account
				boolean flag2 = true;
				
				while(flag2) {
					// Requests the amount to be deposited from the account
					System.out.println("Enter amount to deposit (enter c to cancel b to select a different account): ");
					
					try {
						// Receives input
						String temp = scan.nextLine();
						
						// Test if the escape or back character were entered
						if(temp.equalsIgnoreCase("c"))
							return null;
						if(temp.equalsIgnoreCase("b")) {
							flag2 = false;
							break;
						}
						
						// Assigns input to a double
						amount = Double.parseDouble(temp);
						
						// Executes if a negative number or zero was entered
						if(amount <= 0)
							System.out.println("Please enter a positive number!");
						else {
							// Stores the username of the account holder, the account index, and amount to be deposited
							values[0] = Integer.toString(index);
							values[1] = Double.toString(amount);
							
							// Breaks out of the loops
							flag2 = false;
							flag = false;
						}
					// Executes if input wasn't numerical
					}catch(NumberFormatException e) {
						System.out.println("That wasn't a valid number!");
					}
				}
				
				// Tests if an amount was provided
				if(amount > 0)
					flag = false;
			}
			// Executes if the account doesn't exist
			else {
				System.out.println("Account doesn't exist! Write the account name as it appears in the list!");
			}
		}
		
		return values;
	}
	
	// Performs a deposit
	private static void deposit(Customer c, int account, double amount) {
		// Changes the balance
		c.getAccounts().get(account).setBalance(c.getAccounts().get(account).getBalance() + amount);
		// Commits the transactions and lets the user know the transaction was successful and the new account balance
		if(commit(c)) {
			System.out.println("$" + amount + " successfully deposited into account " + c.getAccounts().get(account).getName() + "!");
			System.out.println("Total balance in account: $" + c.getAccounts().get(account).getBalance());
			
			// Prints the transaction information to the log file
			log.info("Info:\nAccount " + c.getAccounts().get(account).getName() + " belonging to " + c.getUsername() + "had $" + amount + 
					 " deposited into it by " + user + ", making the total amount in the account $" + 
					 c.getAccounts().get(account).getBalance() + "\n");
		}
		// Alerts the user that the transaction failed before fixing the account balance and logging the error
		else {
			System.out.println("Error! Couldn't commit changes to the account balance!");
			c.getAccounts().get(account).setBalance(c.getAccounts().get(account).getBalance() - amount);
			log.error("Error:\nCouldn't commit changes to account " + c.getAccounts().get(account).getName() + " belonging to " + 
					  c.getUsername() + "\n");
		}
	}
	
	// Executes when a transfer is requested
	private static String[] transfer(Customer c) {
		String[] values = null;
		boolean flag = true;
		
		while(flag) {
			// Requests the type of transfer and explains each transfer type
			System.out.println("What kind of transfer is being performed?");
			System.out.println("Local (Between accounts under the same user)");
			System.out.println("Global (Between accounts under different users)");
			System.out.println("Please type local or global, or c to cancel: ");
			
			String input = scan.nextLine().toLowerCase();
			
			// Determines which transfer was requested
			switch(input) {
				// Executes if local was entered
				case("local"):
					// Creates a loop control boolean
					boolean flag2 = true;
					
					while(flag2) {
						// Requests a withdrawal account
						System.out.println("Please select an account to withdraw from (Enter c to cancel or b to select transfer level): ");
				
						// Prints a list of the available accounts
						for(Account a : c.getAccounts()) {
							System.out.println(a.getName());
						}
					
						String accountOne = scan.nextLine();
					
						// Executes if an escape character was entered
						if(accountOne.equalsIgnoreCase("c"))
							return null;
						else if(accountOne.equalsIgnoreCase("b")) {
							flag2 = false;
							break;
						}
						
						boolean exists = false;
						int index = 0;
						for(Account a : c.getAccounts()) {
							if(a.getName().equals(input)) {
								exists = true;
								index = c.getAccounts().indexOf(a);
								break;
							}
						}
						
						if(exists) {
							// Creates a loop control boolean and stores the index of the withdrawal account
							boolean flag3 = true;
							
							while(flag3) {
								// Requests the deposit account
								System.out.println("Please select an account to deposit into(Enter c to cancel or b to select withdrawal account): ");
								
								// Prints the remaining accounts
								for(Account a : c.getAccounts()) {
									System.out.println(a.getName());
								}
								
								String accountTwo = scan.nextLine();
								
								// Executes if an escape character was entered
								if(accountTwo.equalsIgnoreCase("c"))
									return null;
								else if(accountTwo.equalsIgnoreCase("b")) {
									flag3 = false;
									break;
								}
								
								boolean exists2 = false;
								int indexTwo = 0;
								for(Account a : c.getAccounts()) {
									if(a.getName().equals(input)) {
										exists2 = true;
										indexTwo = c.getAccounts().indexOf(a);
										break;
									}
								}
								
								// Executes if the deposit account exists
								if(exists2) {
									// Creates a loop control boolean and stores the index of the deposit account
									boolean flag4 = true;
									
									while(flag4) {
										// Requests the amount to be transfered
										System.out.println("Enter the amount to be transfered (Enter c to cancel or b to select deposit account): ");
										
										String temp = scan.nextLine();
										
										// Executes if an escape character was entered
										if(temp.equalsIgnoreCase("c"))
											return null;
										else if(temp.equalsIgnoreCase("b")) {
											flag4 = false;
											break;
										}
										
										try {
											// Assigns the input to a double value
											double amount = Double.parseDouble(temp);
											
											// Executes if the amount is less than or equal to 0
											if(amount <= 0)
												System.out.println("Please enter a positive number greater than 0!");
											// Executes if the amount is greater than the balance of the withdrawal account
											else if(c.getAccounts().get(index).getBalance() < amount)
												System.out.println("Not enough funds to cover the tranfer!");
											else {
												// Sets the storage amount for the values array and stores the necessary transfer information
												values = new String[3];
												values[1] = Integer.toString(index);
												values[2] = Integer.toString(indexTwo);
												values[3] = Double.toString(amount);
												
												// Breaks out of the loop
												flag4 = false;
												flag3 = false;
												flag2 = false;
												flag = false;
											}
										// Executes if the input wasn't numerical
										}catch(NumberFormatException e) {
											System.out.println("Please enter a number or escape character!");
										}
									}
								}
								// Executes if the account name entered doesn't match the accounts on record
								else {
									System.out.println("Account doesn't exist! Please enter the account name as it shows up on the list!");
								}
							}
						}
						// Executes if the account name entered doesn't match the accounts on record
						else {
							System.out.println("Account doesn't exist! Please enter the account name as it shows up on the list!");
						}
					}
					break;
				case("global"):
					// Creates a loop control boolean
					boolean globalFlag = true;
					
					while(globalFlag) {
						// Requests a withdrawal account
						System.out.println("Please select an account to withdraw from (Enter c to cancel or b to select transfer level): ");
				
						// Prints a list of the available accounts
						for(Account a : c.getAccounts()) {
							System.out.println(a.getName());
						}
					
						String accountOne = scan.nextLine();
					
						// Executes if an escape character was entered
						if(accountOne.equalsIgnoreCase("c"))
							return null;
						else if(accountOne.equalsIgnoreCase("b")) {
							flag2 = false;
							break;
						}
						
						boolean exists = false;
						int index = 0;
						for(Account a : c.getAccounts()) {
							if(a.getName().equals(input)) {
								exists = true;
								index = c.getAccounts().indexOf(a);
								break;
							}
						}
						
						if(exists) {
							// Creates a loop control boolean and stores the index of the withdrawal account
							boolean flag3 = true;
							
							while(flag3) {
								// Requests the username of the deposit account holder
								System.out.println("Enter the username of the user you'ld like to transfer to(Enter c to cancel or b to select withdrawl account): ");
								
								String userTwo = scan.nextLine();
								
								// Executes if an escape character was entered
								if(userTwo.equalsIgnoreCase("c"))
									return null;
								else if(userTwo.equalsIgnoreCase("b")) {
									flag3 = false;
									break;
								}
								
								// Executes if the user exists
								if(userExists(userTwo)) {
									boolean flag4 = true;
									
									while(flag4) {
										// Requests the deposit account
										System.out.println("Select the account to deposit into (Enter c to cancel or b to enter a different user): ");
										
										for(Account a : c.getAccounts()) {
											System.out.println(a.getName());
										}
										
										System.out.println("Please enter account name as it appears above: ");
										
										String accountTwo = scan.nextLine();
										
										// Executes if an escape character was entered
										if(accountTwo.equalsIgnoreCase("c"))
											return null;
										else if(accountTwo.equalsIgnoreCase("b")) {
											flag4 = false;
											break;
										}
										
										boolean exists2 = false;
										int indexTwo = 0;
										
										exist:
										for(Account a : c.getAccounts()) {
											if(a.getName().equals(accountTwo)) {
												exists2 = true;
												break exist;
											}
											indexTwo++;
										}
										
										if(exists2) {
											// Creates a loop control boolean and stores the index of the second account
											boolean flag5 = true;
											
											while(flag5) {
												// Requests the amount to be transfered
												System.out.println("Enter the amount to be transfered (Enter c to cancel or b to select deposit account): ");
												
												String temp = scan.nextLine();
												
												// Executes if an escape character was entered
												if(temp.equalsIgnoreCase("c"))
													return null;
												else if(temp.equalsIgnoreCase("b")) {
													flag5 = false;
													break;
												}
												
												try {
													// Assigns the input to a double value
													double amount = Double.parseDouble(temp);
													
													// Executes if the amount is less than or equal to 0
													if(amount <= 0)
														System.out.println("Please enter a positive number greater than 0!");
													// Executes if the amount is greater than the balance of the withdrawal account
													else if(c.getAccounts().get(index).getBalance() < amount)
														System.out.println("Not enough funds to cover the tranfer!");
													else {
														// Sets the storage amount for the values array and stores the necessary transfer information
														values = new String[4];
														values[0] = Integer.toString(index);
														values[1] = userTwo;
														values[2] = Integer.toString(indexTwo);
														values[3] = Double.toString(amount);
														
														// Breaks out of the loop
														flag5 = false;
														flag4 = false;
														flag3 = false;
														globalFlag = false;
														flag = false;
													}
												// Executes if the input wasn't numerical
												}catch(NumberFormatException e) {
													System.out.println("Please enter a number or escape character!");
												}
											}
										}
										else {
											System.out.println("Account doesn't exist! Please enter account name as it appears in the list!");
										}
									}
								}
								// Executes if the account name entered doesn't match the accounts on record
								else {
									System.out.println("Account doesn't exist! Please enter the account name as it shows up on the list!");
								}
							}
						}
						// Executes if the account name entered doesn't match the accounts on record
						else {
							System.out.println("Account doesn't exist! Please enter the account name as it shows up on the list!");
						}
					}
					break;
				case("c"): return null;
				default: System.out.println("Please enter local or global!");
			}
		}
		
		return values;
	}
	
	// Performs a local transfer
	private static void transfer(Customer c, int indexOne, int indexTwo, double amount) {
		// Sets the new account balances
		c.getAccounts().get(indexOne).setBalance(c.getAccounts().get(indexOne).getBalance() - amount);
		c.getAccounts().get(indexTwo).setBalance(c.getAccounts().get(indexTwo).getBalance() + amount);
			
		// Executes if the commit failed
		if(!commit(c)) {
			// Lets the user know the transaction failed
			System.out.println("System is down! Please try again later!");
			// Reverts the account balance
			c.getAccounts().get(indexOne).setBalance(c.getAccounts().get(indexOne).getBalance() + amount);
			c.getAccounts().get(indexTwo).setBalance(c.getAccounts().get(indexTwo).getBalance() - amount);
			// Prints the error information to the log file
			log.error("Error:\nTransfer between " + c.getUsername() + "'s accounts " + c.getAccounts().get(indexOne) + " and " + 
					  c.getAccounts().get(indexTwo).getName() + " failed\n");
		}
		// Prints a success message for the user and logs the transaction
		else {
			System.out.println("Transfer successful!");
			// Prints the transaction information to the log file
			log.info("Info:\nTransfer between " + c.getUsername() + "'s accounts " + c.getAccounts().get(indexOne).getName() + " and " + 
					 c.getAccounts().get(indexTwo).getName() + " succeeded\n");
		}
	}
		
	// Performs a gloabal transfer
	private static void transfer(Customer c, int indexOne, String usernameTwo, int indexTwo, double amount) {
		// Changes the first account's balance
		c.getAccounts().get(indexOne).setBalance(c.getAccounts().get(indexOne).getBalance() - amount);
			
		// Executes if the commit was successful
		if(commit(c)) {
			SignIn s = new SignIn();
			// Retrieves the second user's information to put into the storage ArrayLists
			Customer c2 = s.getCustomer(usernameTwo);
			c2.getAccounts().get(indexTwo).setBalance(c2.getAccounts().get(indexTwo).getBalance() + amount);
				
			// Executes if the commit failed
			if(!commit(c2)) {
				System.out.println("System is down! Please try again later!");
				c2.getAccounts().get(indexTwo).setBalance(c2.getAccounts().get(indexTwo).getBalance() - amount);
				// Reverts the first account's balance
				c.getAccounts().get(indexOne).setBalance(c.getAccounts().get(indexOne).getBalance() - amount);
				
				// Executes if the first transaction couldn't be reverted
				if(!commit(c)) {
					System.out.println("Transaction was lost! Sent request to admin!");
					lostTransaction(c.getUsername(), c.getAccounts().get(indexOne).getName(), amount);
				}
				// Prints a success message for the user and logs the transaction
				else {
					System.out.println("Transfer successful!");
					// Prints the transaction information to the log file
					log.info("Info:\nTransfer between " + c.getUsername() + "'s account + " + c.getAccounts().get(indexOne).getName() + 
							" and " + c2.getUsername() + "'s account " + c2.getAccounts().get(indexTwo).getName() + " of $" + amount + 
							" succeeded\n");
				}
			}
		}
		else {
			System.out.println("System is down! Please try again later!");
			// Prints the error information to the log file
			log.error("Error:\nTransfer between " + c.getUsername() + "'s account + " + c.getAccounts().get(indexOne).getName() + " and " + 
					  usernameTwo + "'s account " + getAccounts(usernameTwo).get(indexTwo).getName() + " of $" + amount + " failed!\n");
			c.getAccounts().get(indexOne).setBalance(c.getAccounts().get(indexOne).getBalance() + amount);
		}
	}
	
	// Executes the account closure process
	private static int closeAccount(Customer c) {
		boolean flag = true;
		
		while(flag) {
			// Requests the account to be closed
			System.out.println("Please select the account you want to close (Balance will be transfered to primary account): ");
			
			for(Account a : c.getAccounts()) {
				System.out.println(a.getName());
			}
			
			System.out.println("Enter the account name as it appears in the above list (Enter c to cancel): ");
			
			String input = scan.nextLine();
			
			// Executes if the escape character was entered
			if(input.equalsIgnoreCase("c"))
				return -1;
			
			boolean exists = false;
			int index = 0;
			
			exist:
			for(Account a : c.getAccounts()) {
				if(a.getName().equals(input)) {
					exists = true;
					break exist;
				}
				index++;
			}
			
			// Executes if the account exists
			if(exists) {
				// Stores the necessary values
				return index;
			}
			// Executes if the account doesn't exist
			else {
				System.out.println("Account doesn't exist! Please enter account name as it appears in the above list!");
			}
		}
		
		return -1;
	}
		
	// Performs an account closure
	private static void closeAccount(Customer c, int closedAccount) {
		try {
			// Executes if there's only one account associated with the user
			if(c.getAccounts().size() == 1) {
				// Stops the account closure process
				System.out.println("Can't remove account! Users must have at least one account!");
				throw new IOException();
			}
			else {
				c.getAccounts().remove(closedAccount);
				App.serialize(c);
				
				log.info("Info:\n" + c.getUsername() + "'s account " + c.getAccounts().get(closedAccount).getName() + " was successfully closed");
			}
		// Executes if the account couldn't be deleted
		}catch(IOException e) {
			System.out.println("Account couldn't be closed!");
			log.error("Error:\nCouldn't close " + c.getUsername() + "'s account " + c.getAccounts().get(closedAccount).getName() + "\n");
		}
	}
	
	// Executed by a user to request an account
	private static String[] openAccount(Customer c) {
		// Creates a storage array and a boolean loop value
		String[] input = new String[4];
		boolean flag = true;
		String type = null;
		while(type == null) {
			System.out.println("What is the account type (Checking or savings): ");
			
			type = scan.nextLine().toLowerCase();
			
			switch(type) {
				case("cecking"):
					type = "Checking";
					break;
				case("savings"):
					type = "Savings";
					break;
				default: System.out.println("Please enter checking or savings!");
			}
		}
		while(flag) {
			// Requests an account name
			System.out.println("Please enter an account name (Enter c to cancel): ");
			
			String name = scan.nextLine();
			
			// Executes if the escape character was entered
			if(name.equalsIgnoreCase("c")) {
				return null;
			}
			
			// Executes if the username doesn't contain any illegal characters
			if(!name.contains(":")) {
				boolean flag2 = true;
				
				while(flag2) {
					// Requests the account's initial balance
					System.out.println("Please enter an initial amount for the account(Enter c to cancel b to enter a different account name): ");
					
					String temp = scan.nextLine();
					
					// Executes if an escape character was entered
					if(temp.equalsIgnoreCase("c")) {
						return null;
					}
					else if(temp.equalsIgnoreCase("b")) {
						flag2 = false;
						break;
					}
					
					try {
						// Stores the amount entered
						double amount = Double.parseDouble(temp);
						
						// Executes if a negative number was entered
						if(amount < 0)
							System.out.println("Please enter a positive number!");
						else {
							// Creates a boolean loop value
							boolean flag3 = true;
							
							while(flag3) {
								// Requests the username of the person sharing the account
								System.out.println("Enter the username of the person sharing this account: ");
								System.out.println("(Enter c to cancel, b to go back, or none if the account is only for you): ");
								
								String shared = scan.nextLine();
								
								// Executes if an escape character was entered
								if(temp.equalsIgnoreCase("c")) {
									return null;
								}
								else if(temp.equalsIgnoreCase("b")) {
									flag3 = false;
									break;
								}
								
								// Executes if the account isn't shared
								if(shared.equalsIgnoreCase("none")) {
									// Stores the necessary values
									input[0] = name;
									input[1] = type;
									input[2] = Double.toString(amount);
									input[3] = "none";
									
									// Break the loop
									flag3 = false;
									flag2 = false;
									flag = false;
								}
								else {
									// Executes if the user exists
									if(userExists(shared)) {
										// Store the necessary values
										input[0] = name;
										input[1] = type;
										input[2] = Double.toString(amount);
										input[3] = shared;
										
										// Break the loop
										flag3 = false;
										flag2 = false;
										flag = false;
									}
									// Executes if the user doesn't exist
									else {
										System.out.println("User doesn't exists! Please try again!");
									}
								}
							}
						}
					// Executes if the input isn't numerical
					}catch(NumberFormatException e) {
						System.out.println("Please enter a number!");
					}
				}
			}
			// Executes if the account name contains an illegal character
			else {
				System.out.println("Account name can't contain the : character!");
			}
		}
		
		// Returns the entered values
		return input;
	}
	
	// Opens an account
	private static void openAccount(Customer c, String account, String type, double amount, String sharedAccount) {
		try {
			// Retrieves the user's account file and puts it into a FileWriter
			File file = new File("data/requests/accounts.txt");
			ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
			
			boolean flag = true;
			test:
			for(Account a : c.getAccounts()) {
				if(a.getName().equals(account)) {
					flag = false;
					break test;
				}
			}
			// Executes if the user already has an account by the entered name
			if(flag) {
				// Prints the error message then exits the process
				System.out.println("You can't have two accounts with the same name!");
				oos.close();
				throw new IOException();
			}
			else {
				// Writes the information into the user's account file
				oos.writeObject(c.getUsername() + ":" + account + ":" + type + ":" + amount + ":" + sharedAccount + "\n");
			
				// Closes fw and writes the transaction information to the log
				log.info("Info:\n" + c.getUsername() + " requested a new account " + account + "\n");
				oos.close();
			}
		// Executes if the account couldn't be created
		}catch(IOException e) {
			System.out.println("Couldn't request account!");
			log.error("Error:\n" + c.getUsername() + " couldn't request a new account\n");
		}
	}
		
	// Executed by a user to view the balance of a specific account
	private void viewBalance(Customer c) {
		// Creates a boolean loop value
		boolean flag = true;
		
		while(flag) {
			// Requests the user enter an account name
			System.out.println("Enter an account name to view the account balance: ");
			
			for(Account a : c.getAccounts()) {
				System.out.println(a.getName());
			}
			
			System.out.println("Please enter the account name as it appears above (Enter c to cancel): ");
			
			String input = scan.nextLine();
			
			// Executes if an escape character was entered
			if(input.equalsIgnoreCase("c")) 
				return;
			
			boolean exists = false;
			int index = 0;
			
			exist:
			for(Account a : c.getAccounts()) {
				if(a.getName().equals(input)) {
					exists = true;
					break exist;
				}
				index++;
			}
			
			if(exists) {
				System.out.println(c.getAccounts().get(index).toString());
				System.out.println("Would you like to check another account?");
				System.out.println("(Please enter y for yes, anything else for no)");
				
				input = scan.nextLine();
				
				// Executes if y wsn't entered
				if(!input.equalsIgnoreCase("y"))
					flag = false;
			}
			else {
				System.out.println("Account doesn't exist! Please enter name as it appears in the list!");
			}
		}
	}
	
	public void employeeMenu(Employee e) {
		user = e.getUsername();
		System.out.println("Welcome, " + e.getUsername());
		
		// Reads the stored requests
		 File folder = new File("data/requests/");
		 File[] files = folder.listFiles();

		 for (File file : files) {
		     if (file.isFile()) {
		    	 if(file.getName().substring(file.getName().length() - 3, file.getName().length() - 1).equals("req"))
		    		 readRequests(e.getUsername(), file);
		    	 else
		    		 readLostTransactions(e.getUsername(), file);
		     }
		 }
		 
		 boolean flag = true;
		 
		 Customer c = null;
		 
		 while(flag) {
			// Prints the commands that can be performed and requests input
			System.out.println("Open Account");
			System.out.println("Close Account");
			System.out.println("View Accounts");
			System.out.println("Exit");
			System.out.println("Logout");
			
			String input = scan.nextLine().toLowerCase();
				
			switch(input) {
				// Executes if withdraw is entered
				case("withdraw"):
					// Retrieves customer information and then starts the withdrawal process
					c = retrieveUserInformation();
					if(c != null) {
						String[] withdraw = withdraw(c);
						if(withdraw != null)
							withdraw(c, Integer.parseInt(withdraw[0]), Double.parseDouble(withdraw[1]));
					}
					break;
				// Executes if deposit is entered
				case("deposit"):
					// Retrieves user information and then starts the deposit process
					c = retrieveUserInformation();
					if(c != null) {
						String[] deposit = deposit(c);
						if(deposit != null)
							deposit(c, Integer.parseInt(deposit[0]), Double.parseDouble(deposit[1]));
					}
					break;
				// Executes if transfer is entered
				case("transfer"):
					// Retrieves user information and then starts the transfer process
					c = retrieveUserInformation();
					if(c != null) {
						String[] transfer = transfer(c);
						if(transfer != null) {
							if(transfer.length == 3)
								transfer(c, Integer.parseInt(transfer[0]), Integer.parseInt(transfer[1]), 
										 Double.parseDouble(transfer[2]));
							else
								transfer(c, Integer.parseInt(transfer[0]), transfer[1], Integer.parseInt(transfer[2]), 
										 Double.parseDouble(transfer[3]));
						}
					}
					break;
				// Executes if open account is entered
				case("open account"):
					// Retrieves user information and then starts the account opening process
					c = retrieveUserInformation();
					if(c != null) {
						String[] open = openAccount(c);
						if(open != null)
							openAccount(c, open[0], open[1], Double.parseDouble(open[2]), open[3]);
					}
					break;
				// Executes if close account is entered
				case("close account"):
					// Retrieves user information and then starts the account closing process
					c = retrieveUserInformation();
					if(c != null) {
						int close = closeAccount(c);
						if(confirm()) 
							closeAccount(c, close);
					}
					break;
				// Executes if view accounts is entered
				case("view accounts"):
					// Retrieves user information and then provides account information about the user
					c = retrieveUserInformation();
					if(c != null) {
						c.toString();
					}
					break;
				// Executes if exit is entered and closes the program
				case("exit"):	scan.close();
								System.exit(1);
				// Executes if logout is entered and breaks the loop
				case("logout"):	flag = false;
				// Executes if anything else is entered
				default:	System.out.println("Please enter the input as it's shown on your screen!");
			}
		}
	}
	
	// Executes the admin's menu
	public void adminMenu() {
		user = "admin";
		System.out.println("Welcome, admin!");
		
		// Reads the stored requests
		File folder = new File("data/requests/");
		File[] files = folder.listFiles();

		for (File file : files) {
			if (file.isFile()) {
		    	 if(file.getName().substring(file.getName().length() - 3, file.getName().length() - 1).equals("req"))
				    readRequests("Admin", file);
			    else
					 readLostTransactions("Admin", file);
		     }
		 }
		
		// Creates a boolean loop value and a username for account management
		boolean flag = true;
		
		Customer c = null;
		
		while(flag) {
			// Prints the commands that can be performed and requests input
			System.out.println("What would you like to do: ");
			System.out.println("Withdraw");
			System.out.println("Deposit");
			System.out.println("Transfer");
			System.out.println("Open Account");
			System.out.println("Close Account");
			System.out.println("View Accounts");
			System.out.println("Create Employee Account");
			System.out.println("Delete Customer Account");
			System.out.println("Delete Employee Account");
			System.out.println("Exit");
			System.out.println("Logout");
			
			String input = scan.nextLine().toLowerCase();
			
			switch(input) {
				// Executes if withdraw is entered
				case("withdraw"):
					// Retrieves customer information and then starts the withdrawal process
					c = retrieveUserInformation();
					if(c != null) {
						String[] withdraw = withdraw(c);
						if(withdraw != null)
							withdraw(c, Integer.parseInt(withdraw[0]), Double.parseDouble(withdraw[1]));
					}
					break;
				// Executes if deposit is entered
				case("deposit"):
					// Retrieves user information and then starts the deposit process
					c = retrieveUserInformation();
					if(c != null) {
						String[] deposit = deposit(c);
						if(deposit != null)
							deposit(c, Integer.parseInt(deposit[0]), Double.parseDouble(deposit[1]));
					}
					break;
				// Executes if transfer is entered
				case("transfer"):
					// Retrieves user information and then starts the transfer process
					c = retrieveUserInformation();
					if(c != null) {
						String[] transfer = transfer(c);
						if(transfer != null) {
							if(transfer.length == 3)
								transfer(c, Integer.parseInt(transfer[0]), Integer.parseInt(transfer[1]), 
										 Double.parseDouble(transfer[2]));
							else
								transfer(c, Integer.parseInt(transfer[0]), transfer[1], Integer.parseInt(transfer[2]), 
										 Double.parseDouble(transfer[3]));
						}
					}
					break;
				// Executes if open account is entered
				case("open account"):
					// Retrieves user information and then starts the account opening process
					c = retrieveUserInformation();
					if(c != null) {
						String[] open = openAccount(c);
						if(open != null)
							openAccount(c, open[0], open[1], Double.parseDouble(open[2]), open[3]);
					}
					break;
				// Executes if close account is entered
				case("close account"):
					// Retrieves user information and then starts the account closing process
					c = retrieveUserInformation();
					if(c != null) {
						int close = closeAccount(c);
						if(confirm()) 
							closeAccount(c, close);
					}
					break;
				// Executes if view accounts is entered
				case("view accounts"):
					// Retrieves user information and then provides account information about the user
					c = retrieveUserInformation();
					if(c != null) {
						c.toString();
					}
					break;
				case("create employee account"):
					createEmployeeAccount();
					break;
				case("delete customer account"):
					c = deleteCustomerAccount();
					if(confirm())
						deleteAccount(c);
					break;
				case("delete employee account"):
					Employee e = deleteEmployeeAccount();
					if(confirm())
						deleteAccount(e);
				// Executes if exit is entered and closes the program
				case("exit"):	scan.close();
								System.exit(1);
				// Executes if logout is entered and breaks the loop
				case("logout"):	flag = false;
				// Executes if anything else is entered
				default:	System.out.println("Please enter the input as it's shown on your screen!");
			}
		}
	}
	
	// Launches the employee sign up process
	private void createEmployeeAccount() {
		SignUp su = new SignUp();
		su.employeeSignUp();
	}
	
	// Retrieves a user's information for the admin
	private Customer retrieveUserInformation() {
		// Creates a boolean loop value and a username String to return
		boolean flag = true;
		Customer c = null;
		SignIn si = new SignIn();
		
		while(flag) {
			// Requests the username of the user whose accounts you want access to
			System.out.println("Please enter the username of the user whose account you want to access (Press c to cancel): ");
			
			String input = scan.nextLine();
			
			// Executes if the escape character was entered
			if(input.equalsIgnoreCase("c"))
				return null;
			
			// Executes if the user exists
			if(userExists(input)) {
				c = si.getCustomer(input);
				// Breaks the loop
				flag = false;
			}
			// Executes if the user doesn't exist
			else {
				System.out.println("User doesn't exist! Please try again!");
			}
		}
		
		// Returns the Customer
		return c;
	}
	
	private void readRequests(String username, File file) {	
		try {
			// Retrieves the request files
			File accountRequests = new File("data/requests/" + username + ".req");
			
			
			SignIn si = new SignIn();
			
			ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(accountRequests)));
			
			String line = (String) ois.readObject();
			ois.close();
			
			
			boolean passed = false;
			
			// Reads through the account requests files
			while(line != null) {
				// Creates a boolean loop value and splits the file line using the separator character
				boolean flag = true;
				String[] lines = line.split(":");
				
				while(flag) {
					// Prints the account opening request and then requests input
					System.out.printf("%s is requesting to open account %s  of type %s with initial amount %s to be shared with %s\n", 
									  lines[0], lines[1], lines[2], lines[3], lines[4]);
					System.out.println("Approve or deny the account (Enter confirm, deny, or pass): ");
					
					Customer c = si.getCustomer(lines[0]);
					
					String temp = scan.nextLine().toLowerCase();
					
					switch(temp) {
						// Executes if approve was entered
						case("approve"):
							// Approves the customer's request to open a new account and logs the transaction
							approveAccount(c, lines[1], lines[2], Double.parseDouble(lines[3]), lines[4]);
							log.info("Info:\nAdmin approved " + lines[0] + "'s request to open account " + lines[1] + " of type " + lines[2] +
									 "with initial amount " + lines[3] + " to be shared with " + lines[4] + "\n");
							// Breaks the loop
							flag = false;
							line = null;
							file.delete();
							break;
						// Executes if deny was entered
						case("deny"):
							//Denies the customer's request to open a new account and logs the transaction
							denyAccount(c, lines[1], 0, Double.parseDouble(lines[2]));
							log.info("Info:\nAdmin denied " + lines[0] + "'s request to open new account " + lines[1] + "\n");
							// Breaks the loop
							flag = false;
							file.delete();
							line = null;
							break;
						// Executes if pass was entered
						case("pass"):
							// Adds the request into accountsPassed, then logs the transaction
							passed = true;
							log.info("Info:\nAdmin passed account opening request by " + lines[0] + "\n");
							// Breaks the loop
							flag = false;
							line = null;
							break;
						// Executes if anything else was entered
						default: System.out.println("Not a valid command!");
					}
				}
				
			}
			
			if(passed)
				log.info("Info:\n" + username + " read " + file.getName() + "\n");
			else
				log.info("Info:\n" + username + " resolved " + file.getName() + "\n");
		// Executes if the admin couldn't read requests and logs the error
		}catch(IOException | ClassNotFoundException e) {
			System.out.println("Couldn't read " + file.getName());
			log.error("Error:\n" + username + " could't read " + file.getName() + "\n");
		}
	}
	
	private void readLostTransactions(String username, File file) {
		try {
			boolean passed = false;
			SignIn si = new SignIn();
			
			File lost = new File("data/requests/+ " + username +".tra");
			ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(lost)));
			String line = (String) ois.readObject();
			ois.close();
			
			// Reads through the lost transactions file
			while(line != null) {
				// Creates a boolean loop value and splits the file line using the separator character
				boolean flag = true;
				String[] lines = line.split(":");
							
				while(flag) {
					// Prints out the information about the lost transaction and requests how to handle the lost transaction
					System.out.printf("%s lost $%s from account %s during a transaction\n", lines[0], lines[2], lines[1]);
					System.out.println("How do you want to reimburse (Enter deposit, mail, or pass): ");
								
					Customer c = si.getCustomer(lines[0]);
					int index = 0;
								
					index:
					for(Account a : c.getAccounts()) {
						if(a.getName().equals(lines[1])) {
							index = c.getAccounts().indexOf(a);
							break index;
						}
					}
					
					String temp = scan.nextLine().toLowerCase();
								
					switch(temp) {
						// Executes if deposit was entered
						case("deposit"):
							// Deposits the money into the customer's account and logs the transaction
							deposit(c, index, Double.parseDouble(lines[1]));
							log.info("Info:\nAdmin deposited $" + lines[2] + " lost by " + lines[0] + " into account + " + lines[1] + "\n");
							// Breaks the loop
							file.delete();
							flag = false;
							line = null;
							break;
						// Executes if mail was entered
						case("mail"):
							// Alerts the admin that the check is being sent through the mail and logs the transaction
							System.out.println("Sending check through the mail!");
							log.info("Info:\nAdmin sent $" + lines[2] + " lost by " + lines[0] + " through the mail\n");
							// Breaks the loop
							file.delete();
							flag = false;
							line = null;
							break;
						// Executes if pass was entered
						case("pass"):
							// Adds the transaction to lostPassed to be put back into the file, then logs the transaction
							passed = true;
							log.info("Info:\nAdmin passed lost money request by " + lines[0] + " for $" + lines[2] + "\n");
							// Breaks the loop
							flag = false;
							line = null;
							break;
						// Executes if anything else was entered
						default: System.out.println("Not a valid command!");
					}
							}
							
						}
			
			if(passed)
				log.info("Info:\n" + username + " read " + file.getName() + "\n");
			else
				log.info("Info:\n" + username + " resolved " + file.getName() + "\n");
		}catch(IOException | ClassNotFoundException e) {
			System.out.println("Couldn't read " + file.getName());
			log.error("Error:\n" + username + " could't read " + file.getName() + "\n");
		}
	}
	
	// Executed by the admin when an account is approved
	private void approveAccount(Customer c, String account, String type, double amount, String shared) {
		int size = c.getAccounts().size();
		try {
			// Creates the account and adds it to the Customer's file
			Account newAccount = new Account(type, account, amount, shared);
			c.getAccounts().addElement(newAccount);
			
			// Executes if c couldn't be serialized
			if(!App.serialize(c))
				throw new IOException();
			
			// Logs the transaction and closes the file writer
			log.info("Info:\n" + account + " account successfully approved for " + c.getUsername() + "\n");
		// Prints an error message and logs the error
		}catch(IOException e) {
			System.out.println("Couldn't open account");
			if(size < c.getAccounts().size())
				c.getAccounts().remove(c.getAccounts().size());
			log.info("Error:\nCouldn't open account " + account + " for " + c.getUsername() + "\n");
		}
	}
	
	// Executed by the admin when an account is denied
	private void denyAccount(Customer c, String deniedAccount, int account, double amount) {
		System.out.println("Notice sent to + " + c.getUsername() + " about denial of account " + deniedAccount + " and $" + 
						   " was put back into their account " + c.getAccounts().get(account).getName() + "!");
		// Puts the amount into a user's account
		deposit(c, account, amount);
		log.info("Info:\n" + c.getUsername() + "'s request for account + " + account + " was denied\n");
	}
	
	// Commits the changes to the user's accounts
	private static boolean commit(Customer c) {
		try {
			boolean flag = false;
			String shared = null;
			
			// Tests if the account is shared
			shared:
			for(Account a : c.getAccounts()) {
				if(!a.getShared().equals("none")) {
					flag = true;
					shared = a.getShared();
					break shared;
				}
			}
			
			// Executes if the account isn't shared
			if(flag)
				// Executes if c couldn't be serialized
				if(!App.serialize(c))
					throw new IOException();
			else
				commitSharedAccount(c, shared);
			
			return true;
		}catch(IOException e) {
			return false;
		}
	}
	
	// Commits changes to shared accounts
	private static boolean commitSharedAccount(Customer c, String username) {
		try {
			// Retrieves the information of the second shared account holder
			Customer c2 = App.deserializeCustomer(username);
			int index = 0;
			
			// Links the shared account balance
			shared:
			for(Account a1 : c.getAccounts()) {
				for(Account a2 : c2.getAccounts()) {
					if(a1.getName().equals(a2.getName()) & a1.getShared().equals(c2.getUsername()) & a2.getShared().equals(c.getUsername())) {
						a2.setBalance(a1.getBalance());
						break shared;
					}
					index++;
				}
			}
			
			// Executes if c or 2 couldn't be serialized
			if(!App.serialize(c))
				throw new IOException();
			if(App.serialize(c2))
				throw new IOException();
			
			// Prints the transaction information to the log file
			log.info("Info:\nShared account " + c.getAccounts().get(index).getName() + " belonging to " + c.getUsername() + " and " + 
					 username +  " now has a total amount of $" + c.getAccounts().get(index).getBalance() + "\n");
			return true;
		// Returns false if the information can't be committed
		} catch (IOException e) {
			return false;
		}
	}
	
	// Tests if the user possesses an account
	static boolean userExists(String username) {
		File file = new File("data/accounts/" + username + ".cus");
		
		// Returns true if the account file exists, false if it doesn't
		if(file.exists())
			return true;
		else
			return false;
	}
	
	// Tests if the user possesses an account
	static boolean employeeExists(String username) {
		File file = new File("data/employees/" + username + ".emp");
			
		// Returns true if the account file exists, false if it doesn't
		if(file.exists())
			return true;
		else
			return false;
		}
	
	// Gets a user's accounts for the admin or transfers between accounts
	private static Vector<Account> getAccounts(String username){
			Customer c = App.deserializeCustomer(username);

			return c.getAccounts();
	}
	
	// Stores lost transaction information
	private static void lostTransaction(String username, String account, double amount) {
		try {
			File file = new File("data/requests/" + username + ".tra");
			ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
			
			if(!file.exists())
				file.createNewFile();
			
			// Saves the lost transaction information
			oos.writeObject("\n" + username + ":" + account + ":" + amount);
			
			// Prints the error information to the log file
			log.error(username + " lost $" + amount + " from " + account + " in a failed transaction\n");
			oos.close();
		}catch(IOException e) {
			System.out.println("Couldn't log lost transaction! Please print the following message and visit your local branch:");
			System.out.println("Username: " + username);
			System.out.println("Account: " + account);
			System.out.println("Amount lost: " + amount);
			// Prints the error information to the log file
			log.error(username + " lost $" + amount + " from " + account + " in a failed transaction, couldn't create admin request\n");
		}
	}
	
	// Requests confirmation from the user
	private boolean confirm() {
		boolean flag = true;
		
		while(flag) {
			// Asks the user if they're sure
			System.out.println("Are you sure?");
			System.out.println("(Y for yes, N for no): ");
			
			String input = scan.nextLine().toLowerCase();
			
			switch(input) {
				// Returns true if y was entered, false if n was entered, and requests y or n if anything else is entered
				case("y"): return true;
				case("n"): return false;
				default: System.out.println("Please enter y or n!");
			}
		}
		return true;
	}
	
	// Starts the Customer account deletion process
	private static Customer deleteCustomerAccount() {
		while(true) {
			System.out.println("Enter the username of the customer you want to delete: ");
			
			String input = scan.nextLine();
			
			if(userExists(input)) {
				return App.deserializeCustomer(input);
			}
			else
				System.out.println("User doesn't exist!");
		}
	}
	
	// Deletes the Customer's file
	private static void deleteAccount(Customer c) {
		App.deleteCustomer(c);
	}
	
	// Starts the Employee account deletion process
	private static Employee deleteEmployeeAccount() {
		while(true) {
			System.out.println("Enter the username of the customer you want to delete: ");
			
			String input = scan.nextLine();
			
			if(employeeExists(input)) {
				return App.deserializeEmployee(input);
			}
			else
				System.out.println("User doesn't exist!");
		}
	}
	
	// Deletes the Employee's file
	private static void deleteAccount(Employee e) {
		App.deleteEmployee(e);
	}
}
