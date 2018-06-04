package com.revature.main;

import java.util.ArrayList;
import java.util.Scanner;

import com.revature.beans.Account;
import com.revature.beans.Customer;
import com.revature.beans.Transaction;
import com.revature.daoimpl.AccountDAOImpl;
import com.revature.daoimpl.CustomerDAOImpl;
import com.revature.daoimpl.TransactionDAOImpl;
import com.revature.exceptions.InvalidInputException;
import com.revature.exceptions.NoUserExistsException;
import com.revature.exceptions.OverdraftException;

import java.sql.SQLException;

public class Bank {
	private static Scanner scan = null;
	
	public Bank(Scanner s) {
		scan = s;
	}
	
	public void withdraw(Customer c) throws SQLException {
		AccountDAOImpl adi = new AccountDAOImpl();
		ArrayList<Account> accounts = adi.listAccounts("CUSTOMERID = " + c.getId());
		SignUp su = new SignUp(scan);
		
		inputLoop:
		while(true) {
			System.out.println("Please select the account you want to withdraw from: ");
			
			for(Account a : accounts) {
				System.out.println(a.getName());
			}
			
			System.out.println("(Please enter the account name as it appears above, enter c to cancel): ");
			
			String name = scan.nextLine();
			
			if(name.equals("c"))
				break inputLoop;
			
			boolean exists = false;
			int index = 0;
			
			existLoop:
			for(Account a : accounts) {
				if(a.getName().equals(name)) {
					exists = true;
					break existLoop;
				}
				index++;
			}
			
			if(exists) {
				while(true) {
					System.out.println("Enter how much you wish to withdraw from the account: ");
					
					String input = scan.nextLine();
					
					try {
						su.validNumericInput(input);
						
						double amount = Double.parseDouble(input);
						
						if(amount < 0) {
							System.out.println("You must input a positive number!");
							throw new InvalidInputException();
						}
						else if(amount > accounts.get(index).getBalance()) {
							throw new OverdraftException(accounts.get(index).getName());
						}
						else {
							adi.withdraw(accounts.get(index).getId(), amount);
							TransactionDAOImpl tdi = new TransactionDAOImpl();
							tdi.addTransaction(new Transaction(0, c.getId(), accounts.get(index).getId(), 0, amount, "WITHDRAWAL"));
							break inputLoop;
						}
					}catch(InvalidInputException | OverdraftException e) {
						System.out.println();
					}
				}
			}
			else {
				System.out.println("Account doesn't exist! Please enter the account name as it appears in the list!");
			}
		}
	}
	
	public void deposit(Customer c) throws SQLException{
		AccountDAOImpl adi = new AccountDAOImpl();
		ArrayList<Account> accounts = adi.listAccounts("CUSTOMERID = " + c.getId());
		SignUp su = new SignUp(scan);
		
		inputLoop:
		while(true) {
			System.out.println("Please select the account you want to deposit into: ");
			
			for(Account a : accounts) {
				System.out.println(a.getName());
			}
			
			System.out.println("(Please enter the account name as it appears above, enter c to cancel): ");
			
			String name = scan.nextLine();
			
			if(name.equals("c"))
				break inputLoop;
			
			boolean exists = false;
			int index = 0;
			
			existLoop:
			for(Account a : accounts) {
				if(a.getName().equals(name)) {
					exists = true;
					break existLoop;
				}
				index++;
			}
			
			if(exists) {
				while(true) {
					System.out.println("Enter how much you wish to deposit into the account: ");
					
					String input = scan.nextLine();
					
					try {
						su.validNumericInput(input);
						
						double amount = Double.parseDouble(input);
						
						if(amount < 0) {
							System.out.println("You must input a positive number!");
							throw new InvalidInputException();
						}
						else {
							adi.deposit(accounts.get(index).getId(), amount);
							TransactionDAOImpl tdi = new TransactionDAOImpl();
							tdi.addTransaction(new Transaction(0, c.getId(), 0, accounts.get(index).getId(), amount, "DEPOSIT"));
							break inputLoop;
						}
					}catch(InvalidInputException e) {
						System.out.println();
					}
				}
			}
			else {
				System.out.println("Account doesn't exist! Please enter the account name as it appears in the list!");
			}
		}
	}
	
	public void transfer(Customer c) throws SQLException {
		AccountDAOImpl adi = new AccountDAOImpl();
		ArrayList<Account> accounts = adi.listAccounts("CUSTOMERID = " + c.getId());
		SignUp su = new SignUp(scan);
		
		inputLoop:
		while(true) {
			System.out.println("Please select the account you want to withdraw from: ");
			
			for(Account a : accounts) {
				System.out.println(a.getId() + " - " + a.getName());
			}
			
			System.out.println("(Please enter the account number as it appears above, enter c to cancel): ");
			
			String accountNumber = scan.nextLine();
			
			if(accountNumber.equalsIgnoreCase("c"))
				break inputLoop;
			
			int indexOne = 0;
			
			try {
				su.validNumericInput(accountNumber);
				indexOne = Integer.parseInt(accountNumber);
			}catch(InvalidInputException e){
				continue inputLoop;
			}
			
			boolean exists = false;
			
			exist:
			for(Account a : accounts) {
				if(a.getId() == indexOne) {
					exists = true;
					break exist;
				}
			}
			
			if(exists) {
				depositAccountLoop:
				while(true) {
					exists = false;
					
					System.out.println("Please enter the account number of the account you want to deposit into: ");
					
					for(Account a : accounts) {
						if(a.getId() != indexOne)
							System.out.println(a.getId() + " - " + a.getName());
					}
					
					System.out.println("(Enter the account number as it appears above, enter c to cancel or b to enter a different withdrawal account): ");
					
					accountNumber = scan.nextLine();
					
					if(accountNumber.equalsIgnoreCase("c")) 
						break inputLoop;
					if(accountNumber.equalsIgnoreCase("b"))
						continue inputLoop;
					
					int indexTwo = 0;
					try {
						su.validNumericInput(accountNumber);
						indexTwo = Integer.parseInt(accountNumber);
					}catch(InvalidInputException e) {
						continue depositAccountLoop;
					}
					
					if(indexOne == indexTwo) {
						System.out.println("Can't transfer to the same account!");
						continue depositAccountLoop;
					}
					
					ArrayList<Account> allAccounts = adi.listAccounts("n");
					
					exist:
					for(Account a : allAccounts) {
						if(a.getId() == indexTwo) {
							exists = true;
							break exist;
						}
					}
					
					if(exists) {
						amountLoop:
						while(true) {
							System.out.println("Please enter the amount you wish to transfer: ");
							System.out.println("(Enter c to cancel, b to select a different deposit account) ");
							
							String transfer = scan.nextLine();
							
							if(transfer.equalsIgnoreCase("c"))
								break inputLoop;
							if(transfer.equalsIgnoreCase("b"))
								continue depositAccountLoop;
							
							double amount = 0;
							
							try {
								su.validNumericInput(transfer);
								amount = Double.parseDouble(transfer);
							}catch(InvalidInputException e) {
								continue amountLoop;
							}
							
							int i = 0;
							int j = 0;
							
							get:
							for(Account a : accounts) {
								if(a.getId() == indexOne)
									break get;
								i++;
							}
							get:
							for(Account a : accounts) {
								if(a.getId() == indexOne)
									break get;
								j++;
							}
							
							try {
								if(amount < 0)
									System.out.println("Please enter a positive number!");
								else if(amount > accounts.get(i).getBalance())
									throw new OverdraftException(accounts.get(i).getName());
								else {
									adi.transfer(indexOne, indexTwo, amount);
									TransactionDAOImpl tdi = new TransactionDAOImpl();
									tdi.addTransaction(new Transaction(0, c.getId(), accounts.get(i).getId(), accounts.get(j).getId(), amount, "TRANSFER"));
									break inputLoop;
								}
							}catch(OverdraftException e) {
								continue amountLoop;
							}
						}
					}
					else {
						System.out.println("Account doesn't exist! Please enter a valid account number!");
					}
				}
			}
			else {
				System.out.println("Account doesn't exist! Please enter the account number as it appears in the list!");
			}
		}
	}
	
	public void openAccount(Customer c) throws SQLException {
		AccountDAOImpl adi = new AccountDAOImpl();
		CustomerDAOImpl cdi = new CustomerDAOImpl();
		ArrayList<Account> accounts = adi.listAccounts("CUSTOMERID = " + c.getId());
		ArrayList<Customer> customers = cdi.getCustomerList("n");
		Account newAcc = new Account(0, null, null, -1, -1);
		SignUp su = new SignUp(scan);
		
		inputLoop:
		while(true) {
			while(newAcc.getType() == null) {
				System.out.println("Please enter the account type (Checking or savings, enter c to cancel): ");
				
				String input = scan.nextLine();
				
				if(input.equalsIgnoreCase("c"))
					break inputLoop;
				
				if(input.equalsIgnoreCase("checking") || input.equalsIgnoreCase("savings"))
					newAcc.setType(input.toUpperCase());
				else
					System.out.println("Please enter either checking or savings!");
			}
			nameLoop:
			while(newAcc.getName() == null) {
				System.out.println("Please enter an account name (Enter c to cancel, b to choose a different account type): ");
				
				String input = scan.nextLine();
				
				if(input.equalsIgnoreCase("c"))
					break inputLoop;
				if(input.equalsIgnoreCase("b")) {
					newAcc.setType(null);
					continue inputLoop;
				}
				if(input.length() > 20) 
					System.out.println("Account name must be less than 20 characters!");

				for(Account a : accounts) {
					if(a.getName().equals(input)) {
						System.out.println("You already have an account with that name!");
						continue nameLoop;
					}
				}
				
				newAcc.setName(input);
			}
			balanceLoop:
			while(newAcc.getBalance() == -1) {
				System.out.println("Please enter an initial balance(Enter c to cancel, b to enter a different account name): ");
				
				String input = scan.nextLine();
				
				if(input.equalsIgnoreCase("c"))
					break inputLoop;
				if(input.equalsIgnoreCase("b")) {
					newAcc.setName(null);
					continue inputLoop;
				}
				
				try {
					su.validNumericInput(input);
					double amount = Double.parseDouble(input);
					
					if(amount < 0)
						System.out.println("Please enter a positive number!");
					else
						newAcc.setBalance(amount);
				}catch(InvalidInputException e) {
					continue balanceLoop;
				}
			}
			while(newAcc.getShared() == -1) {
				System.out.println("Is this a shared account? (Enter y or n)");
				
				String input = scan.nextLine();
				
				if(input.equalsIgnoreCase("y")) {
					while(true) {
						System.out.println("Enter the username of the person sharing the account(Enter c to cancel, b to enter a different initial deposit): ");
						
						input = scan.nextLine();
						
						if(input.equalsIgnoreCase("c"))
							break inputLoop;
						if(input.equalsIgnoreCase("b")) {
							newAcc.setBalance(-1);
							continue inputLoop;
						}
						
						int index = 0;
						
						exist:
						for(Customer cus : customers) {
							if(cus.getUsername().equals(input)) {
								index = cus.getId();
								break exist;
							}
						}
						
						try {
							if(index != 0) {
								newAcc.setShared(index);
								newAcc.setId(-1);
								break inputLoop;
							}
							else 
								throw new NoUserExistsException(input);
						}catch(NoUserExistsException e) {
							System.out.println();
						}
					}
				}
				else {
					newAcc.setShared(0);
					newAcc.setId(-1);
				}
			}
		}
		
		if(newAcc.getId() == -1) {
			adi.openAccount(c.getId(), newAcc);
		}
	}
	
	public void closeAccount(Customer c) throws SQLException {
		AccountDAOImpl adi = new AccountDAOImpl();
		ArrayList<Account> accounts = adi.listAccounts("CUSTOMERID = " + c.getId() + " AND BALANCE = 0");
		
		if(accounts.isEmpty()) {
			System.out.println("No accounts available for closure!");
			System.out.println("An account must have no balance to be available for closure!");
		}
		else {
			inputLoop:
			while(true) {
				System.out.println("Please enter the name of the account you want to close: ");
			
				for(Account a : accounts) {
					System.out.println(a.getName());
				}
				
				System.out.println("(Please enter the name as it appears above, enter c to cancel): ");
				
				String input = scan.nextLine();
				
				if(input.equalsIgnoreCase("c"))
					break inputLoop;
				
				boolean exists = false;
				int index = 0;
				
				exist:
				for(Account a : accounts) {
					if(a.getName().equals(input)) {
						index = a.getId();
						break exist;
					}
				}
				
				if(exists) {
					adi.closeAccount(index);
					break inputLoop;
				}
				else 
					System.out.println("Enter the account name as it appears above!");
			}
		}
	}
	
	public void accountBalance(Customer c) throws SQLException {
		AccountDAOImpl adi = new AccountDAOImpl();
		ArrayList<Account> accounts = adi.listAccounts("CUSTOMERID = " + c.getId() + " OR SHARED_ACCOUNT = " + c.getId());
		
		inputLoop:
		while(true) {
			System.out.println("Enter the name of the account you want to view the balance of: ");
			
			for(Account a : accounts) {
				System.out.println(a.getName());
			}
			
			System.out.println("(Enter the name as it appears in the above list, enter c to cancel): ");
			
			String input = scan.nextLine();
			
			if(input.equalsIgnoreCase("c"))
				break inputLoop;
			
			int index = 0;
			
			exist:
			for(Account a : accounts) {
				if(a.getName().equals(input)) {
					System.out.println(a.getName() + " : $" + a.getBalance());
					index = a.getId();
					break exist;
				}
			}
			
			if(index == 0) {
				System.out.println("Either the account doesn't exist or you don't have access to it!");
			}
		}
	}
	
	public void viewTransactions(Customer c) throws SQLException{
		TransactionDAOImpl tdi = new TransactionDAOImpl();
		ArrayList<Transaction> transactions = new ArrayList<>();

		inputLoop:
		while(true) {
			System.out.println("What type of transactions do you want to see(Enter withdrawal, deposit, transfer, all, or enter c to cancel): ");
			
			String input = scan.nextLine().toUpperCase();
			
			switch(input) {
				case("WITHDRAWAL"):
					transactions = tdi.listTransactions("WHERE CUSTOMERID = " + c.getId() + " AND TYPE = WITHDRAWAL");
					System.out.println("Username :  Amount : Type");
					for(Transaction t : transactions) {
						System.out.println(c.getUsername() + " : " + t.getAmount() + " : " + t.getType());
					}
					break;
				case("DEPOSIT"):
					transactions = tdi.listTransactions("WHERE CUSTOMERID = " + c.getId() + " AND TYPE = DEPOSIT");
					System.out.println("Username :  Amount : Type");
					for(Transaction t : transactions) {
						System.out.println(c.getUsername() + " : " + t.getAmount() + " : " + t.getType());
					}
					break;
				case("TRANSFER"):
					transactions = tdi.listTransactions("WHERE CUSTOMERID = " + c.getId() + " AND TYPE = TRANSFER");
					System.out.println("Username :  Amount : Type");
					for(Transaction t : transactions) {
						System.out.println(c.getUsername() + " : " + t.getAmount() + " : " + t.getType());
					}
					break;
				case("ALL"):
					transactions = tdi.listTransactions("WHERE CUSTOMERID = " + c.getId());
					System.out.println("Username :  Amount : Type");
					for(Transaction t : transactions) {
						System.out.println(c.getUsername() + " : " + t.getAmount() + " : " + t.getType());
					}
					break;
				case("c"):
					break inputLoop;
				default: System.out.println("Please enter one of the options listed!");
			}
		}
	}
}
