package com.revature.BankingApp;

import java.util.ArrayList;
import java.util.Scanner;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Banking {
	private static String user;
	private static ArrayList<String> accounts = new ArrayList<>();
	private static ArrayList<Double> balance = new ArrayList<>();
	private static ArrayList<String> sharedAccounts = new ArrayList<>();
	private static Logger log = Logger.getLogger(Banking.class.getName());
	private static Scanner scan = App.getScanner();
	
	// Executes when a customer logs in
	public static void customer(String username) {
		user = username;
		System.out.println("Welcome, " + user);
		
		try {
			File account = new File("data/accounts/" + user + ".txt");
			BufferedReader br = new BufferedReader(new FileReader(account));
			String input;
			while((input = br.readLine()) != null) {
				String[] line = input.split(":");
				accounts.add(line[0]);
				balance.add(Double.parseDouble(line[1]));
				sharedAccounts.add(line[2]);
			}
			
			br.close();
		}catch(IOException e) {
			System.out.println("Error! System is down!");
			return;
		}
		
		customerMenu();
	}
	
	// Executes the customer's menu
	private static void customerMenu() {
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
					String[] withdraw = withdraw(user);
					if(withdraw != null)
						withdraw(withdraw[0], Integer.parseInt(withdraw[1]), Double.parseDouble(withdraw[2]));
					break;
				// Executes when deposit is entered and begins the deposit process
				case("deposit"):
					String[] deposit = deposit(user);
					if(deposit != null)
						withdraw(deposit[0], Integer.parseInt(deposit[1]), Double.parseDouble(deposit[2]));
					break;
				// Executes when transfer is entered and begins the transfer process
				case("transfer"):
					String[] transfer = transfer(user);
					if(transfer != null) {
						if(transfer.length == 4)
							transfer(transfer[0], Integer.parseInt(transfer[1]), Integer.parseInt(transfer[2]), 
									 Double.parseDouble(transfer[3]));
						else
							transfer(transfer[0], Integer.parseInt(transfer[1]), transfer[2], Integer.parseInt(transfer[3]), 
									 Double.parseDouble(transfer[4]));
					}
					break;
				// Executes when account open is entered and starts the account opening process
				case("open account"):
					String[] open = openAccount(user);
					if(open != null)
						openAccount(open[0], open[1], Double.parseDouble(open[2]), open[3]);
					break;
				// Executes when close account is entered and starts the account closure process
				case("close account"):
					String[] close = closeAccount(user);
					if(confirm()) {
						closeAccount(close[0], Integer.parseInt(close[1]));
					}
					break;
				case("view account balance"):
					viewBalance();
					break;
				// Executes when view accounts is entered and displays a user's accounts
				case("view accounts"):
					viewAccount(user);
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
	private static String[] withdraw(String username) {
		// Sets the loop flag, and creates a String array to store input
		boolean flag = true;
		String[] values = new String[3];
		
		while(flag) {
			// Requests the account to be withdrawn from
			System.out.println("Which account would you like to withdraw from (Enter c to cancel): ");
			
			// Prints the names of the available accounts
			for(int i = 0; i < accounts.size(); i++) {
				System.out.println(accounts.get(i) + ": $" + balance.get(i));
			}
					
			// Assigns input and sets amount equal to 0
			String input = scan.nextLine();
			double amount = 0;
			
			// Tests if the escape character was entered
			if(input.equalsIgnoreCase("c"))
				return null;
			
			// Tests if the account name entered exists
			if(accounts.contains(input)) {
				// Sets the loop flag and the index of the account
				boolean flag2 = true;
				int index = accounts.indexOf(input);
				
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
						else if(amount > balance.get(index)) {
							System.out.println("Not enough funds to cover withdrawl!");
							amount = 0;
						}
						else {
							// Stores the username of the account holder, the account index, and amount to be withdrawn
							values[0] = username;
							values[1] = Integer.toString(index);
							values[2] = Double.toString(amount);
							
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
	private static void withdraw(String username, int account, double amount) {
		// Changes the balance
		balance.set(account, balance.get(account) - amount);
		// Commits the transactions and lets the user know the transaction was successful and the new account balance
		if(commit(user)) {
			System.out.println("$" + amount + " successfully withdrawn from account " + accounts.get(account) + "!");
			System.out.println("Total balance in account: $" + balance.get(account));
			
			// Prints the transaction information to the log file
			log.info("Info:\nAccount " + accounts.get(account) + " belonging to " + username + "had $" + amount + 
					 " withdrawn from it by " + user + ", making the total amount in the account $" + balance.get(account) + "\n");
		}
		// Alerts the user that the commit failed, restore the original account balance, and log the error
		else {
			System.out.println("Error! Couldn't commit changes to the account balance!");
			balance.set(account, balance.get(account) + amount);
			log.error("Error:\nCouldn't commit changes to account " + accounts.get(account) + " belonging to " + username + "\n");
		}
	}
	
	// Executes when a deposit is requested
	private static String[] deposit(String username) {
		// Sets the loop flag, and creates a String array to store input
		boolean flag = true;
		String[] values = new String[3];
		
		while(flag) {
			// Requests the account to be deposited to
			System.out.println("Which account would you like to deposit (Enter c to cancel): ");
			
			// Prints the names of the available accounts
			for(int i = 0; i < accounts.size(); i++) {
				System.out.println(accounts.get(i) + ": $" + balance.get(i));
			}
					
			// Assigns input and sets amount equal to 0
			String input = scan.nextLine();
			double amount = 0;
			
			// Tests if the escape character was entered
			if(input.equalsIgnoreCase("c"))
				return null;
			
			// Tests if the account name entered exists
			if(accounts.contains(input)) {
				// Sets the loop flag and the index of the account
				boolean flag2 = true;
				int index = accounts.indexOf(input);
				
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
							values[0] = username;
							values[1] = Integer.toString(index);
							values[2] = Double.toString(amount);
							
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
	private static void deposit(String username, int account, double amount) {
		// Changes the balance
		balance.set(account, balance.get(account) + amount);
		// Commits the transactions and lets the user know the transaction was successful and the new account balance
		if(commit(user)) {
			System.out.println("$" + amount + " successfully deposited into account " + accounts.get(account) + "!");
			System.out.println("Total balance in account: $" + balance.get(account));
			
			// Prints the transaction information to the log file
			log.info("Info:\nAccount " + accounts.get(account) + " belonging to " + username + "had $" + amount + 
					 " deposited into it by " + user + ", making the total amount in the account $" + balance.get(account) + "\n");
		}
		// Alerts the user that the transaction failed before fixing the account balance and logging the error
		else {
			System.out.println("Error! Couldn't commit changes to the account balance!");
			balance.set(account, balance.get(account) - amount);
			log.error("Error:\nCouldn't commit changes to account " + accounts.get(account) + " belonging to " + username + "\n");
		}
	}
	
	// Executes when a transfer is requested
	private static String[] transfer(String username) {
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
						for(int i = 0; i < accounts.size(); i++) {
							System.out.println(accounts.get(i) + ": $" + balance.get(i));
						}
					
						String accountOne = scan.nextLine();
					
						// Executes if an escape character was entered
						if(accountOne.equalsIgnoreCase("c"))
							return null;
						else if(accountOne.equalsIgnoreCase("b")) {
							flag2 = false;
							break;
						}
						
						if(accounts.contains(accountOne)) {
							// Creates a loop control boolean and stores the index of the withdrawal account
							boolean flag3 = true;
							int indexOne = accounts.indexOf(accountOne);
							
							while(flag3) {
								// Requests the deposit account
								System.out.println("Please select an account to deposit into(Enter c to cancel or b to select withdrawl account): ");
								
								// Prints the remaining accounts
								for(int i = 0; i < accounts.size(); i++) {
									if(i != indexOne)
										System.out.println(accounts.get(i) + ": $" + balance.get(i));
								}
								
								String accountTwo = scan.nextLine();
								
								// Executes if an escape character was entered
								if(accountTwo.equalsIgnoreCase("c"))
									return null;
								else if(accountTwo.equalsIgnoreCase("b")) {
									flag3 = false;
									break;
								}
								
								// Executes if the deposit account exists
								if(accounts.contains(accountTwo)) {
									// Creates a loop control boolean and stores the index of the deposit account
									boolean flag4 = true;
									int indexTwo = accounts.indexOf(accountTwo);
									
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
											else if(balance.get(indexOne) < amount)
												System.out.println("Not enough funds to cover the tranfer!");
											else {
												// Sets the storage amount for the values array and stores the necessary transfer information
												values = new String[4];
												values[0] = username;
												values[1] = Integer.toString(indexOne);
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
						for(int i = 0; i < accounts.size(); i++) {
							System.out.println(accounts.get(i) + ": $" + balance.get(i));
						}
					
						String accountOne = scan.nextLine();
					
						// Executes if an escape character was entered
						if(accountOne.equalsIgnoreCase("c"))
							return null;
						else if(accountOne.equalsIgnoreCase("b")) {
							flag2 = false;
							break;
						}
						
						if(accounts.contains(accountOne)) {
							// Creates a loop control boolean and stores the index of the withdrawal account
							boolean flag3 = true;
							int indexOne = accounts.indexOf(accountOne);
							
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
									
									ArrayList<String> secondAccounts = getAccounts(userTwo);
									
									while(flag4) {
										// Requests the deposit account
										System.out.println("Select the account to deposit into (Enter c to cancel or b to enter a different user): ");
										
										for(String s : secondAccounts) {
											System.out.println(s);
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
										
										if(secondAccounts.contains(accountTwo)) {
											// Creates a loop control boolean and stores the index of the second account
											boolean flag5 = true;
											int indexTwo = secondAccounts.indexOf(accountTwo);
											
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
													else if(balance.get(indexOne) < amount)
														System.out.println("Not enough funds to cover the tranfer!");
													else {
														// Sets the storage amount for the values array and stores the necessary transfer information
														values = new String[5];
														values[0] = username;
														values[1] = Integer.toString(indexOne);
														values[2] = userTwo;
														values[3] = Integer.toString(indexTwo);
														values[4] = Double.toString(amount);
														
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
	private static void transfer(String username, int indexOne, int indexTwo, double amount) {
		// Sets the new account balances
		balance.set(indexOne, balance.get(indexOne) - amount);
		balance.set(indexTwo, balance.get(indexTwo) + amount);
			
		// Executes if the commit failed
		if(!commit(username)) {
			// Lets the user know the transaction failed
			System.out.println("System is down! Please try again later!");
			// Reverts the account balance
			balance.set(indexOne, balance.get(indexOne) + amount);
			balance.set(indexTwo, balance.get(indexTwo) - amount);
			// Prints the error information to the log file
			log.error("Error:\nTransfer between " + username + "'s accounts " + accounts.get(indexOne) + " and " + accounts.get(indexTwo) + 
					  " failed\n");
		}
		// Prints a success message for the user and logs the transaction
		else {
			System.out.println("Transfer successful!");
			// Prints the transaction information to the log file
			log.info("Info:\nTransfer between " + username + "'s accounts " + accounts.get(indexOne) + " and " + accounts.get(indexTwo) + 
					 " succeeded\n");
		}
	}
		
	// Performs a gloabal transfer
	private static void transfer(String usernameOne, int indexOne, String usernameTwo, int indexTwo, double amount) {
		// Changes the first account's balance
		balance.set(indexOne, balance.get(indexOne) - amount);
			
		// Executes if the commit was successful
		if(commit(usernameOne)) {
			// Retrieves the second user's information to put into the storage ArrayLists
			accounts = getAccounts(usernameTwo);
			balance = getBalance(usernameTwo);
			sharedAccounts = getSharedAccounts(usernameTwo);
				
			// Changes the second account's balance
			balance.set(indexTwo, balance.get(indexTwo) + amount);
				
			// Executes if the commit failed
			if(!commit(usernameTwo)) {
				System.out.println("System is down! Please try again later!");
				// Return to the initial user's account information
				accounts = getAccounts(usernameOne);
				balance = getBalance(usernameTwo);
				sharedAccounts = getSharedAccounts(usernameTwo);
					
				// Reverts the first account's balance
				balance.set(indexOne, balance.get(indexOne) + amount);
				
				// Executes if the first transaction couldn't be reverted
				if(!commit(usernameOne)) {
					System.out.println("Transaction was lost! Sent request to admin!");
					lostTransaction(usernameOne, accounts.get(indexOne), amount);
				}
				// Prints a success message for the user and logs the transaction
				else {
					System.out.println("Transfer successful!");
					// Prints the transaction information to the log file
					log.info("Info:\nTransfer between " + usernameOne + "'s account + " + accounts.get(indexOne) + " and " + usernameTwo + 
							 "'s account " + getAccounts(usernameTwo).get(indexTwo) + " of $" + amount + " succeeded\n");
				}
			}
				
			// Returns the ArrayLists to their original values
			accounts = getAccounts(usernameOne);
			balance = getBalance(usernameTwo);
			sharedAccounts = getSharedAccounts(usernameTwo);
		}
		else {
			System.out.println("System is down! Please try again later!");
			// Prints the error information to the log file
			log.error("Error:\nTransfer between " + usernameOne + "'s account + " + accounts.get(indexOne) + " and " + usernameTwo + 
					  "'s account " + getAccounts(usernameTwo).get(indexTwo) + " of $" + amount + " failed!\n");
			balance.set(indexOne,  balance.get(indexOne) + amount);
		}
	}
	
	// Executes the account closure process
	private static String[] closeAccount(String username) {
		// Creates a storage array and a boolean loop condition
		String[] close = new String[2];
		boolean flag = true;
		
		while(flag) {
			// Requests the account to be closed
			System.out.println("Please select the account you want to close (Balance will be transfered to primary account): ");
			
			// Prints the account names
			for(String s : accounts) {
				System.out.println(s);
			}
			
			System.out.println("Enter the account name as it appears in the above list (Enter c to cancel): ");
			
			String input = scan.nextLine();
			
			// Executes if the escape character was entered
			if(input.equalsIgnoreCase("c"))
				return null;
			
			// Executes if the account exists
			if(accounts.contains(input)) {
				// Stores the necessary values
				close[0] = username;
				close[1] = Integer.toString(accounts.indexOf(input));
				
				// Breaks the loop
				flag = false;
			}
			// Executes if the account doesn't exist
			else {
				System.out.println("Account doesn't exist! Please enter account name as it appears in the above list!");
			}
		}
		
		return close;
	}
		
	// Performs an account closure
	private static void closeAccount(String username, int closedAccount) {
		try {
			// Retrieves the user's account file, creates a FileWriter, and stores the closed accounts name for logging purposes
			File file = new File("data/accounts/" + username + ".txt");
			FileWriter fw = new FileWriter(file, false);
			String accountName = accounts.get(closedAccount);
			
			// Executes if there's only one account associated with the user
			if(accounts.size() == 1) {
				// Stops the account closure process
				System.out.println("Can't remove account! Users must have at least one account!");
				fw.close();
				throw new IOException();
			}
			else {
				// Removes the account information from local ArrayLists
				accounts.remove(closedAccount);
				balance.remove(closedAccount);
				sharedAccounts.remove(closedAccount);
				
				// Writes the current account information
				for(int i = 0; i < accounts.size(); i++) {
					fw.write(accounts.get(i) + ":" + balance.get(i) + ":" + sharedAccounts.get(i));
				}
				
				// Closes fw and logs the transaction
				fw.close();
				log.info("Info:\n" + username + "'s account " + accountName + " was successfully closed");
			}
		// Executes if the account couldn't be deleted
		}catch(IOException e) {
			System.out.println("Account couldn't be closed!");
			log.error("Error:\nCouldn't close " + username + "'s account " + accounts.get(closedAccount) + "\n");
		}
	}
	
	// Executed by a user to request an account
	private static String[] openAccount(String username) {
		// Creates a storage array and a boolean loop value
		String[] input = new String[4];
		boolean flag = true;
		
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
									input[0] = username;
									input[1] = name;
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
										input[0] = username;
										input[1] = name;
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
	private static void openAccount(String username, String account, double amount, String sharedAccount) {
		try {
			// Retrieves the user's account file and puts it into a FileWriter
			File file = new File("data/requests/accounts.txt");
			FileWriter fw = new FileWriter(file, true);
			
			// Executes if the user already has an account by the entered name
			if(accounts.contains(account)) {
				// Prints the error message then exits the process
				System.out.println("You can't have two accounts with the same name!");
				fw.close();
				throw new IOException();
			}
			else {
				// Writes the information into the user's account file
				fw.write(username + ":" + account + ":" + amount + ":" + sharedAccount + "\n");
			
				// Closes fw and writes the transaction information to the log
				log.info("Info:\n" + username + " requested a new account " + account + "\n");
				fw.close();
			}
		// Executes if the account couldn't be created
		}catch(IOException e) {
			System.out.println("Couldn't request account!");
			log.error("Error:\n" + username + " couldn't request a new account\n");
		}
	}
		
	// Executed by a user to view the balance of a specific account
	private static void viewBalance() {
		// Creates a boolean loop value
		boolean flag = true;
		
		while(flag) {
			// Requests the user enter an account name
			System.out.println("Enter an account name to view the account balance: ");
			
			for(String s : accounts) {
				System.out.println(s);
			}
			
			System.out.println("Please enter the account name as it appears above (Enter c to cancel): ");
			
			String input = scan.nextLine();
			
			// Executes if an escape character was entered
			if(input.equalsIgnoreCase("c")) 
				return;
			
			if(accounts.contains(input)) {
				// Displays the account name and balance, then asks the user if they want to view another account
				int index = accounts.indexOf(input);
				System.out.println(accounts.get(index) + ": $" + balance.get(index));
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
		
	// Executed to view a user's total account information
	private static void viewAccount(String username) {
		try {
			File account = new File("data/accounts/" + username + ".txt");
			File login = new File("data/login/" + username + ".txt");
			File info = new File("data/info/" + username + "txt");
				
			BufferedReader accountReader = new BufferedReader(new FileReader(account));
			BufferedReader loginReader = new BufferedReader(new FileReader(login));
			BufferedReader infoReader = new BufferedReader(new FileReader(info));
				
			String input;
			
			// Prints the username and password of the account to be viewed
			System.out.println("Username: " + username);
			while((input = loginReader.readLine()) != null) {
				System.out.println("Password: " + input);
			}
			loginReader.close();
			// Prints the user's personal information from the user's info file
			while((input = infoReader.readLine()) != null) {
				String[] line = input.split(":");
				System.out.printf("First name: %s\nMiddle initial: %s\nLast name: %s\nAge %i\n", line[0], line[1], line[2], 
								  Integer.parseInt(line[3]));
			}
			infoReader.close();
			// Prints the account information from the user's account file
			while((input = accountReader.readLine()) != null) {
				String[] line = input.split(":");
				System.out.printf("Account name: %s\nAccount balance: $%d\nAccount shared with: %s\n", line[0], Double.parseDouble(line[1]),
								  line[2]);
				}
			accountReader.close();
		// Executes if the information couldn't be retrieved
		}catch(IOException e) {
			System.out.println("Couldn't retrieve data!");
		}
	}
	
	// Executes when an admin logs in
	public static void admin() {
		// Sets user equal to admin, prints a welcome message, and then opens the admin menu
		user = "admin";
		System.out.println("Welcome, admin!");
		adminMenu();
	}
	
	// Executes the admin's menu
	private static void adminMenu() {
		// Reads the stored requests
		readRequests();
		
		// Creates a boolean loop value and a username for account management
		boolean flag = true;
		String username;
		
		while(flag) {
			// Prints the commands that can be performed and requests input
			System.out.println("What would you like to do: ");
			System.out.println("Withdraw");
			System.out.println("Deposit");
			System.out.println("Transfer");
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
					username = retrieveUserInformation();
					if(username != null) {
						String[] withdraw = withdraw(username);
						if(withdraw != null)
							withdraw(withdraw[0], Integer.parseInt(withdraw[1]), Double.parseDouble(withdraw[2]));
					}
					break;
				// Executes if deposit is entered
				case("deposit"):
					// Retrieves user information and then starts the deposit process
					username = retrieveUserInformation();
					if(username != null) {
						String[] deposit = deposit(username);
						if(deposit != null)
							withdraw(deposit[0], Integer.parseInt(deposit[1]), Double.parseDouble(deposit[2]));
					}
					break;
				// Executes if transfer is entered
				case("transfer"):
					// Retrieves user information and then starts the transfer process
					username = retrieveUserInformation();
					if(username != null) {
						String[] transfer = transfer(username);
						if(transfer != null) {
							if(transfer.length == 4)
								transfer(transfer[0], Integer.parseInt(transfer[1]), Integer.parseInt(transfer[2]), 
										 Double.parseDouble(transfer[3]));
							else
								transfer(transfer[0], Integer.parseInt(transfer[1]), transfer[2], Integer.parseInt(transfer[3]), 
										 Double.parseDouble(transfer[4]));
						}
					}
					break;
				// Executes if open account is entered
				case("open account"):
					// Retrieves user information and then starts the account opening process
					username = retrieveUserInformation();
					if(username != null) {
						String[] open = openAccount(username);
						if(open != null)
							openAccount(open[0], open[1], Double.parseDouble(open[2]), open[3]);
					}
					break;
				// Executes if close account is entered
				case("close account"):
					// Retrieves user information and then starts the account closing process
					username = retrieveUserInformation();
					if(username != null) {
						String[] close = closeAccount(username);
						if(confirm()) 
							closeAccount(close[0], Integer.parseInt(close[1]));
					}
					break;
				// Executes if view accounts is entered
				case("view accounts"):
					// Retrieves user information and then provides account information about the user
					username = retrieveUserInformation();
					if(username != null) {
						viewAccount(username);
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
	
	// Retrieves a user's information for the admin
	private static String retrieveUserInformation() {
		// Creates a boolean loop value and a username String to return
		boolean flag = true;
		String username = null;
		
		while(flag) {
			// Requests the username of the user whose accounts you want access to
			System.out.println("Please enter the username of the user whose account you want to access (Press c to cancel): ");
			
			String input = scan.nextLine();
			
			// Executes if the escape character was entered
			if(input.equalsIgnoreCase("c"))
				return null;
			
			// Executes if the user exists
			if(userExists(input)) {
				// Retrieves the user's account information
				accounts = getAccounts(input);
				balance = getBalance(input);
				sharedAccounts = getSharedAccounts(input);
				// Sets username equal to the confirmed username
				username = input;
				// Breaks the loop
				flag = false;
			}
			// Executes if the user doesn't exist
			else {
				System.out.println("User doesn't exist! Please try again!");
			}
		}
		
		// Returns the username
		return username;
	}
	
	private static void readRequests() {	
		try {
			// Retrieves the request files
			File accountRequests = new File("data/requests/requests.txt");
			File lost = new File("data/requests/lostTransactions.txt");
			
			// Creates BufferedReaders to read the request files
			BufferedReader ar = new BufferedReader(new FileReader(accountRequests));
			BufferedReader lr = new BufferedReader(new FileReader(lost));
			
			// Creates ArrayLists to store passed requests
			ArrayList<String> accountsPassed = new ArrayList<>();
			ArrayList<String> lostPassed = new ArrayList<>();
			
			String input;
			// Reads through the account requests files
			while((input = ar.readLine()) != null) {
				// Creates a boolean loop value and splits the file line using the separator character
				boolean flag = true;
				String[] lines = input.split(":");
				
				while(flag) {
					// Prints the account opening request and then requests input
					System.out.printf("%s is requesting to open account %s with initial amount %s to be shared with %s\n", lines[0], lines[1],
								  	  lines[2], lines[3]);
					System.out.println("Approve or deny the account (Enter confirm, deny, or pass): ");
					
					String temp = scan.nextLine().toLowerCase();
					
					switch(temp) {
						// Executes if approve was entered
						case("approve"):
							// Approves the customer's request to open a new account and logs the transaction
							approveAccount(lines[0], lines[1], Double.parseDouble(lines[2]), lines[3]);
							log.info("Info:\nAdmin approved " + lines[0] + " request to open account " + lines[1] + " with initial amount " +
									 lines[2] + " to be shared with " + lines[3] + "\n");
							// Breaks the loop
							flag = false;
							break;
						// Executes if deny was entered
						case("deny"):
							//Denies the customer's request to open a new account and logs the transaction
							denyAccount(lines[0], lines[1], 0, Double.parseDouble(lines[2]));
							log.info("Info:\nAdmin denied " + lines[0] + "'s request to open new account " + lines[1] + "\n");
							// Breaks the loop
							flag = false;
							break;
						// Executes if pass was entered
						case("pass"):
							// Adds the request into accountsPassed, then logs the transaction
							accountsPassed.add(lines[0] + ":" + lines[1] + ":" + lines[2] + ":" + lines[3]);
							log.info("Info:\nAdmin passed account opening request by " + lines[0] + "\n");
							// Breaks the loop
							flag = false;
							break;
						// Executes if anything else was entered
						default: System.out.println("Not a valid command!");
						
					}
				}
				
			}
			// Reads through the lost transactions file
			while((input = lr.readLine()) != null) {
				// Creates a boolean loop value and splits the file line using the separator character
				boolean flag = true;
				String[] lines = input.split(":");
				
				while(flag) {
					// Prints out the information about the lost transaction and requests how to handle the lost transaction
					System.out.printf("%s lost $%s from account %s during a transaction\n", lines[0], lines[2], lines[1]);
					System.out.println("How do you want to reimburse (Enter deposit, mail, or pass): ");
					
					String temp = scan.nextLine().toLowerCase();
					
					switch(temp) {
						// Executes if deposit was entered
						case("deposit"):
							// Retrieves the customer's account information
							accounts = getAccounts(lines[0]);
							balance = getBalance(lines[0]);
							sharedAccounts = getSharedAccounts(lines[0]);
							// Deposits the money into the customer's account and logs the transaction
							deposit(lines[0], accounts.indexOf(lines[2]), Double.parseDouble(lines[1]));
							log.info("Info:\nAdmin deposited $" + lines[2] + " lost by " + lines[0] + " into account + " + lines[1] + "\n");
							// Breaks the loop
							flag = false;
							break;
						// Executes if mail was entered
						case("mail"):
							// Alerts the admin that the check is being sent through the mail and logs the transaction
							System.out.println("Sending check through the mail!");
							log.info("Info:\nAdmin sent $" + lines[2] + " lost by " + lines[0] + " through the mail\n");
							// Breaks the loop
							flag = false;
							break;
						// Executes if pass was entered
						case("pass"):
							// Adds the transaction to lostPassed to be put back into the file, then logs the transaction
							lostPassed.add(lines[0] + ":" + lines[2] + ":" + lines[1]);
							log.info("Info:\nAdmin passed lost money request by " + lines[0] + " for $" + lines[2] + "\n");
							// Breaks the loop
							flag = false;
							break;
						// Executes if anything else was entered
						default: System.out.println("Not a valid command!");
					}
				}
				
			}
			// Closes the BufferedReaders
			ar.close();
			lr.close();
			
			// Executes if there were passed account opening requests
			if(accountsPassed.size() > 0) {
				// Rewrites the account requests file
				FileWriter fw = new FileWriter(accountRequests, false);
				
				for(String s : accountsPassed) {
					fw.write(s + "\n");
				}
				
				// Closes fw
				fw.close();
			}
			// Executs if there were passed lost transaction requests
			if(lostPassed.size() > 0) {
				// Rewrites the lost transactions file
				FileWriter fw = new FileWriter(lost, false);
				
				for(String s : lostPassed) {
					fw.write(s + "\n");
				}
				
				// Closes fw
				fw.close();
			}
			
			// Logs that the admin read through the requests
			log.info("Info:\nAdmin read through requests\n");
		// Executes if the admin couldn't read requests and logs the error
		}catch(IOException e) {
			System.out.println("Couldn't read requests!");
			log.error("Error:\nAdmin couldn't read request files!\n");
		}
	}
	
	// Executed by the admin when an account is approved
	private static void approveAccount(String username, String account, double amount, String shared) {
		try {
			// Retrieves the user's account file
			File file = new File("data/accounts/" + username + ".txt");
			FileWriter fw = new FileWriter(file, true);
			
			// Appends the new account information to the user's account file
			fw.write("\n" + account + ":" + amount + ":" + shared);
			
			// Logs the transaction and closes the file writer
			log.info("Info:\n" + account + " account successfully approved for " + username + "\n");
			fw.close();
		// Prints an error message and logs the error
		}catch(IOException e) {
			System.out.println("Couldn't open account");
			log.info("Error:\nCouldn't open account " + account + " for " + username + "\n");
		}
	}
	
	// Executed by the admin when an account is denied
	private static void denyAccount(String username, String deniedAccount, int account, double amount) {
		System.out.println("Notice sent to + " + username + " about denial of account " + deniedAccount + " and $" + 
						   " was put back into their account " + accounts.get(account) + "!");
		deposit(username, account, amount);
		log.info("Info:\n" + username + "'s request for account + " + account + " was denied\n");
	}
	
	// Commits the changes to the user's accounts
	private static boolean commit(String username) {
		try {
			// Opens the user's account file and puts it into a FileWriter
			File file = new File("data/accounts/" + username + ".txt");
			FileWriter fw = new FileWriter(file, false);
			
			// Loops through the accounts
			for(int i = 0; i < accounts.size(); i++) {
				// Tests if the account is shared and runs commitSharedAccount if the account is shared
				if(!sharedAccounts.get(i).equals("none")) {
					// Only commits the information if the shared account is committed first
					if(commitSharedAccount(sharedAccounts.get(i), username, balance.get(i)))
						fw.write(accounts.get(i) + ":" + balance.get(i) + ":" + sharedAccounts.get(i));
				}
				else
					// Writes the account information into the file
					fw.write(accounts.get(i) + ":" + balance.get(i) + ":" + sharedAccounts.get(i));
			}
			
			// Closes fw and returns true
			fw.close();
			return true;
		// Returns false if the commit failed
		} catch (IOException e) {
			return false;
		}
	}
	
	// Commits changes to shared accounts
	private static boolean commitSharedAccount(String usernameOne, String usernameTwo, double amount) {
		try {
			// Opens the user's account file and puts it into a BufferedReader and FileWriter
			File file = new File("data/accounts/" + usernameOne + ".txt");
			BufferedReader br = new BufferedReader(new FileReader(file));
			FileWriter fw = new FileWriter(file, false);
			
			// Creates ArrayLists to store account information
			ArrayList<String> userAccounts = new ArrayList<>();
			ArrayList<Double> userBalance = new ArrayList<>();
			ArrayList<String> userSharedAccounts = new ArrayList<>();
			
			// Transfers the account information into the ArrayLists
			String input;
			while((input = br.readLine()) != null) {
				String[] line = input.split(":");
				userAccounts.add(line[0]);
				userBalance.add(Double.parseDouble(line[1]));
				userSharedAccounts.add(line[2]);
			}
			
			// Closes br
			br.close();
			
			// Finds the index of the shared account and changes the amount stored in the shared account
			int index = userSharedAccounts.indexOf(usernameTwo);
			userBalance.set(index, amount);
			
			// Writes the updated information into the user's account file
			for(int i = 0; i < accounts.size(); i++) {
				fw.write(userAccounts.get(i) + ":" + userBalance.get(i) + ":" + userSharedAccounts.get(i));
			}
			
			// Closes fw and returns true
			fw.close();
			// Prints the transaction information to the log file
			log.info("Info:\nShared account " + userAccounts.get(index) + " belonging to " + usernameOne + " and " + usernameTwo + 
					 " had $" + amount + " removed from it by, making the total amount in the account $" + balance.get(index) + "\n");
			return true;
		// Returns false if the information can't be committed
		} catch (IOException e) {
			return false;
		}
	}
	
	// Tests if the user possesses an account
	static boolean userExists(String username) {
		File file = new File("data/accounts/" + username + ".txt");
		
		// Returns true if the account file exists, false if it doesn't
		if(file.exists())
			return true;
		else
			return false;
	}
	
	// Gets a user's accounts for the admin or transfers between accounts
	private static ArrayList<String> getAccounts(String username){
		try {
			// Retries the provided user's account file and puts it into a BufferedReader
			File account = new File("data/accounts/" + username + ".txt");
			BufferedReader br = new BufferedReader(new FileReader(account));
			
			// Creates an ArrayList to store the accounts
			ArrayList<String> acc = new ArrayList<>();
			
			// Adds the accounts to acc
			String input;
			while((input = br.readLine()) != null) {
				String[] line = input.split(":");
				acc.add(line[0]);
			}
			
			// Closes br and returns acc
			br.close();
			return acc;
		// Returns null and reports the system is down
		}catch(IOException e) {
			System.out.println("Error! System is down!");
			return null;
		}
	}
	
	// Gets a user's account balance for the admin or transfers between accounts
	private static ArrayList<Double> getBalance(String username){
		try {
			// Retries the provided user's account file and puts it into a BufferedReader
			File account = new File("data/accounts/" + username + ".txt");
			BufferedReader br = new BufferedReader(new FileReader(account));
			
			// Creates an ArrayList to store the balances
			ArrayList<Double> bal = new ArrayList<>();
			
			String input;
			while((input = br.readLine()) != null) {
				String[] line = input.split(":");
				bal.add(Double.parseDouble(line[1]));
			}
			
			// Closes br and returns bal
			br.close();
			return bal;
		// Returns null and reports the system is down
		}catch(IOException e) {
			System.out.println("Error! System is down!");
			return null;
		}
	}
		
	// Gets a user's shared accounts for the admin or transfers between accounts
	private static ArrayList<String> getSharedAccounts(String username){
		try {
			// Retries the provided user's account file and puts it into a BufferedReader
			File account = new File("data/accounts/" + username + ".txt");
			BufferedReader br = new BufferedReader(new FileReader(account));
			
			// Creates an ArrayList to store the shared accounts
			ArrayList<String> shared = new ArrayList<>();
			
			String input;
			while((input = br.readLine()) != null) {
				String[] line = input.split(":");
				shared.add(line[2]);
			}
			
			// Closes br and returns shared
			br.close();
			return shared;
		// Returns null and reports the system is down
		}catch(IOException e) {
			System.out.println("Error! System is down!");
			return null;
		}
	}
	
	private static void lostTransaction(String username, String account, double amount) {
		try {
			File file = new File("data/requests/lostTransactions.txt");
			FileWriter fw = new FileWriter(file, true);
			
			fw.write("\n" + username + ":" + account + ":" + amount);
			
			// Prints the error information to the log file
			log.error(username + " lost $" + amount + " from " + account + " in a failed transaction\n");
			fw.close();
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
	private static boolean confirm() {
		boolean flag = true;
		
		while(flag) {
			System.out.println("Are you sure?");
			System.out.println("(Y for yes, N for no): ");
			
			String input = scan.nextLine().toLowerCase();
			
			switch(input) {
				case("y"): return true;
				case("n"): return false;
				default: System.out.println("Please enter y or n!");
			}
		}
		return true;
	}
}
