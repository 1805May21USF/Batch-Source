package com.revature.ui;

import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.List;

import com.revature.beans.Account;
import com.revature.beans.User;
import com.revature.daoimpl.AccountDAOImpl;
import com.revature.daoimpl.UserDAOImpl;
import com.revature.driver.Driver;

public class CustomerUI {
	
	DecimalFormat df = new DecimalFormat("$#.00");

	private static final int PENDING = 0;
	private static final int CUSTOMER = 1;
	private static final String DEFAULT_ACCT_STATUS = "OPEN";

	UserDAOImpl udi = new UserDAOImpl();
	AccountDAOImpl adi = new AccountDAOImpl();
	User user = null;

	private String username;
	private String password;

	private int terminateCount = 1;
	private final int TERMINATE_LIMIT = 3;
	private boolean validCredentials = false;

	public void initializeCUI() {
		System.out.println("Customer Login");
		inputCredentials();
	}

	private void inputCredentials() {
		System.out.print("Username: ");
		username = Menu.in.next();
		System.out.print("Password: ");
		password = Menu.in.next();
		verifyCredentials(username);
	}

	private void verifyCredentials(String inputUser) {
		User tempUser = null;

		System.out.println("Logging in. Please wait...");

		try {
			tempUser = udi.retrieveUser(inputUser);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		while (!validCredentials && terminateCount < TERMINATE_LIMIT) {
			if (tempUser == null) {
				System.out.println("Credentials do not match.");
				terminateCount++;
				inputCredentials();
			} else if (tempUser.getPassword().equals(password)) {
				user = tempUser;
				validCredentials = true;
				System.out.println("Login successful. Verifying account...");
				verifyAccountStatus();
			} else {
				System.out.println("Credentials do not match.");
				terminateCount++;
				inputCredentials();
			}
		}

		if (terminateCount >= TERMINATE_LIMIT) {
			System.out.println("\n\nPlease contact a bank administrator.");
			System.exit(0);
		}
	}

	private void verifyAccountStatus() {
		if (user.getStatus() == CUSTOMER) {
			System.out.println("Account verified.");
			System.out.println("\nWelcome back " + user.getFirstName() + "!");
			customerMenu();
		} else if (user.getStatus() == PENDING) {
			System.out.println("Account has not yet been verified.");
		} else {
			System.out.println("Invalid account type.");
		}
	}

	private void customerMenu() {

		boolean validInputType = false;
		boolean validSelection = false;
		int selection = 0;

		while(!validInputType || !validSelection) {

			validInputType = false;
			validSelection = false;

			System.out.println("\nCustomer Console");

			System.out.println("\t1. View account balances");
			System.out.println("\t2. Make a deposit");
			System.out.println("\t3. Withdraw from account");
			System.out.println("\t4. Transfer funds");
			System.out.println("\t5. Manage accounts");
			System.out.println("\t0. Logout");

			System.out.print("\nSelection: ");

			try {
				selection = Integer.parseInt(Menu.in.next());
				validInputType = true;
			} catch (NumberFormatException e) {
				System.out.println("Selection must be a number");
			}

			if (selection >= 0 && selection <= 5) {
				validSelection = true;
			} else {
				System.out.println("Please select a number within range.");
			}
		}

		menuSelection(selection);
	}

	private void menuSelection(int selection) {
		switch (selection) {
		case 1:
			System.out.println("Retrieving accounts...");
			viewAccounts();
			customerMenu();
			break;
		case 2:
			depositAccount();
			customerMenu();
			break;
		case 3:
			withdrawAccount();
			customerMenu();
			break;
		case 4:
			//transfer funds
			break;
		case 5:
			manageAccounts();
			break;
		case 0:
			System.out.println("You have been successfully logged out.\n");
			Driver.reinitialize();
		}
	}

	private void viewAccounts() {
		List<Account> accounts = null;

		System.out.println("\nAccounts");

		try {
			accounts = adi.retrieveUserAccounts(user.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		for (Account a : accounts) {
			if (a.getAccountStatus().equals("OPEN")) {
				System.out.println("\t" + a.toCustomerString());
			}
		}
		System.out.println();
	}

	private void depositAccount() {
		viewAccounts();

		List<Account> accounts = null;

		System.out.println("Which account would you like to deposit to?");
		int acctNum = 0;
		boolean isValidAccount = false;

		while (!isValidAccount) {
			System.out.print("Account number: ");
			try {
				acctNum = Integer.parseInt(Menu.in.next());
			} catch (Exception e) {
				System.out.println("Account number must be an integer.");
			}

			try {
				accounts = adi.retrieveUserAccounts(user.getId());
			} catch (SQLException e) {
				e.printStackTrace();
			}

			for (Account a : accounts) {
				if (a.getAccountNumber() == acctNum) {
					isValidAccount = true;
				}
			}

			if (!isValidAccount) {
				System.out.println("Account does not exist.");
			}
		}

		double deposit = 0;

		if(isValidAccount) {
			boolean isValidAmount = false;

			while(!isValidAmount) {
				System.out.print("Amount to deposit: ");
				try {
					deposit = Menu.in.nextDouble();
				} catch (InputMismatchException e) {
					System.out.println("Deposit must be a number value.");
					Menu.in.next();
				}
				if (deposit <= 0.0) {
					System.out.println("Deposit must be a positive value.");
				} else {
					isValidAmount = true;
				}
			}
		}

		Account depositAcct = null;
		String beforeBalance = null;
		String afterBalance = null;
		try {
			depositAcct = adi.retrieveAccount(acctNum);
			beforeBalance = depositAcct.toBalanceString();
			adi.updateAccount(acctNum, depositAcct.getBalance() + deposit);
			depositAcct = adi.retrieveAccount(acctNum);
			afterBalance = depositAcct.toBalanceString();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("You have deposited " 
				+ df.format(deposit));
		System.out.println("Previous balance: " + beforeBalance);
		System.out.println("Current balance: " + afterBalance);
	}
	
	private void withdrawAccount() {
		viewAccounts();

		List<Account> accounts = null;

		System.out.println("Which account would you like to withdraw from?");
		int acctNum = 0;
		boolean isValidAccount = false;

		while (!isValidAccount) {
			System.out.print("Account number: ");
			try {
				acctNum = Integer.parseInt(Menu.in.next());
			} catch (Exception e) {
				System.out.println("Account number must be an integer.");
			}

			try {
				accounts = adi.retrieveUserAccounts(user.getId());
			} catch (SQLException e) {
				e.printStackTrace();
			}

			for (Account a : accounts) {
				if (a.getAccountNumber() == acctNum) {
					isValidAccount = true;
				}
			}

			if (!isValidAccount) {
				System.out.println("Account does not exist.");
			}
		}

		double withdraw = 0;
		double acctBalance = 0;
		Account withdrawAcct = null;

		if(isValidAccount) {
			boolean isValidAmount = false;
			
			System.out.println("Retrieving account information...\n");
			try {
				acctBalance = adi.retrieveAccount(acctNum).getBalance();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

			while(!isValidAmount) {
				System.out.print("Amount to withdraw: ");
				try {
					withdraw = Menu.in.nextDouble();
				} catch (InputMismatchException e) {
					System.out.println("Withdraw must be a number value.");
					Menu.in.next();
				}
				if (withdraw <= 0.0) {
					System.out.println("Withdraw must be a positive value.");
				} else if (withdraw > acctBalance) {
					System.out.println("Insufficient funds.");
				} else {
					isValidAmount = true;
				}
			}
		}

		String beforeBalance = null;
		String afterBalance = null;
		try {
			withdrawAcct = adi.retrieveAccount(acctNum);
			beforeBalance = withdrawAcct.toBalanceString();
			adi.updateAccount(acctNum, withdrawAcct.getBalance() - withdraw);
			withdrawAcct = adi.retrieveAccount(acctNum);
			afterBalance = withdrawAcct.toBalanceString();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("You withdrew " 
				+ df.format(withdraw));
		System.out.println("Previous balance: " + beforeBalance);
		System.out.println("Current balance: " + afterBalance);
	}
	
	private void transferFunds() {
		viewAccounts();

		List<Account> accounts = null;
		int acctNum1 = 0;
		int acctNum2 = 0;
		
		System.out.println("Which account are you transferring from?");
		
		boolean isValidAccount1 = false;

		while (!isValidAccount1) {
			System.out.print("Account number: ");
			try {
				acctNum1 = Integer.parseInt(Menu.in.next());
			} catch (Exception e) {
				System.out.println("Account number must be an integer.");
			}

			try {
				accounts = adi.retrieveUserAccounts(user.getId());
			} catch (SQLException e) {
				e.printStackTrace();
			}

			for (Account a : accounts) {
				if (a.getAccountNumber() == acctNum1) {
					isValidAccount1 = true;
				}
			}

			if (!isValidAccount1) {
				System.out.println("Account does not exist.");
			}
		}
		
		System.out.println("Which account are you transferring to?");
		
		boolean isValidAccount2 = false;

		while (!isValidAccount2) {
			System.out.print("Account number: ");
			try {
				acctNum2 = Integer.parseInt(Menu.in.next());
			} catch (Exception e) {
				System.out.println("Account number must be an integer.");
			}

			try {
				accounts = adi.retrieveUserAccounts(user.getId());
			} catch (SQLException e) {
				e.printStackTrace();
			}

			for (Account a : accounts) {
				if (a.getAccountNumber() == acctNum1) {
					isValidAccount2 = true;
				}
			}

			if (!isValidAccount2) {
				System.out.println("Account does not exist.");
			}
		}
	}

	private void manageAccounts() {
		boolean validInputType = false;
		boolean validSelection = false;
		int selection = 0;
		double amount = 0;

		while(!validInputType || !validSelection) {

			validInputType = false;
			validSelection = false;

			System.out.println("\nAccount Manager");
			System.out.println("\t1. Create account");
			System.out.println("\t2. Close account");
			System.out.println("\t0. Return to user menu");

			System.out.print("\nSelection: ");

			try {
				selection = Integer.parseInt(Menu.in.next());
				validInputType = true;
			} catch (NumberFormatException e) {
				System.out.println("Selection must be a number.");
			}

			if (selection >= 0 && selection <= 4) {
				validSelection = true;
			} else {
				System.out.println("Please select a number within range.");
			}
		}

		boolean validAmount = false;
		if (selection == 1) {
			System.out.println("Account Creation");
			while (!validAmount) {
				System.out.print("\nInitial deposit: ");
				try {
					amount = Menu.in.nextDouble();
				} catch (NumberFormatException e) {
					System.out.println("Deposit must be a number value.");
				}
				if (amount <= 0.0) {
					System.out.println("Deposit must be a positive value.");
				} else {
					validAmount = true;
				}
			}
		}

		switch (selection) {
		case 1:
			createAccount(amount);
			manageAccounts();
		case 2:
			// close account
			break;
		case 0:
			System.out.println();
			customerMenu();
			break;
		default:
			System.out.println("Something went wrong in the account manager");
		}
	}

	private void createAccount(double amount) {
		try {
			System.out.println("\nCreating account...");

			int beforeSize = adi.retrieveUserAccounts(user.getId()).size();
			adi.createAccount(amount, DEFAULT_ACCT_STATUS, user.getId());

			if (adi.retrieveUserAccounts(user.getId()).size() > beforeSize) {
				System.out.println("Account successfully created.\n");
			}
		} catch (SQLException e) {
			System.out.println("Unable to create account.");
		}
	}
}
