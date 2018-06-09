package com.revature.ui;

import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

import com.revature.beans.Account;
import com.revature.beans.User;
import com.revature.daoimpl.AccountDAOImpl;
import com.revature.daoimpl.UserDAOImpl;
import com.revature.driver.Driver;

/**
 * User interface class for allowing the customer to interact with their
 * bank accounts, including creating accounts, deleting accounts,
 * depositing into accounts, withdrawing from accounts, and
 * transferring funds between accounts.
 * @author Nathaniel Simpson
 *
 */
public class CustomerUI {

	// DecimalFormat is used to format values to USD
	DecimalFormat df = new DecimalFormat("$#0.00");

	// Status constants for user and bank accounts access level
	private static final int PENDING = 0;
	private static final int CUSTOMER = 1;
	private static final String DEFAULT_ACCT_STATUS = "OPEN";

	// Instantiating the DAO implementations for database
	// connectivity.
	UserDAOImpl udi = new UserDAOImpl();
	AccountDAOImpl adi = new AccountDAOImpl();
	User user = null;

	private String username;
	private String password;

	// Variables used for terminating the program 
	// to mitigate brute force attacks.
	private int terminateCount = 1;
	private final int TERMINATE_LIMIT = 5;
	private boolean validCredentials = false;

	/*
	 * Initializes the customer UI
	 */
	public void initializeCUI() {
		System.out.println("Customer Login");
		inputCredentials();
	}

	/*
	 * Retrieving customer credentials
	 */
	private void inputCredentials() {
		System.out.print("Username: ");
		username = Menu.in.next();
		System.out.print("Password: ");
		password = Menu.in.next();
		verifyCredentials(username);
	}

	/*
	 * Verifying customer credentials
	 */
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

	/*
	 * Verifies the status of the account to ensure that the user
	 * is allowed access to this information.
	 */
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

	/*
	 * Creates the menu for most customer input.
	 */
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

	/*
	 * Performs the selection from the menu.
	 */
	private void menuSelection(int selection) {
		switch (selection) {
		case 1:
			System.out.println("Retrieving accounts...");
			viewAccounts();
			customerMenu();
			break;
		case 2:
			System.out.println("Retrieving accounts...");
			viewAccounts();
			depositAccount();
			customerMenu();
			break;
		case 3:
			System.out.println("Retrieving accounts...");
			viewAccounts();
			withdrawAccount();
			customerMenu();
			break;
		case 4:
			System.out.println("Retrieving accounts...");
			viewAccounts();
			transferFunds();
			customerMenu();
			break;
		case 5:
			manageAccounts();
			break;
		case 0:
			System.out.println("You have been successfully logged out.\n");
			Driver.reinitialize();
		}
	}

	/*
	 * Allows user to view their bank accounts
	 */
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

	/*
	 * Deposits funds into a particular bank account
	 */
	private void depositAccount() {

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

			System.out.println("Retrieving accounts...");

			try {
				accounts = adi.retrieveUserAccounts(user.getId());
			} catch (SQLException e) {
				e.printStackTrace();
			}

			boolean isOpen = true;

			for (Account a : accounts) {
				if (a.getAccountNumber() == acctNum 
						&& a.getAccountStatus().equals(DEFAULT_ACCT_STATUS)) {
					isValidAccount = true;
					break;
				} else if (a.getAccountNumber() == acctNum 
						&& !a.getAccountStatus().equals(DEFAULT_ACCT_STATUS)) {
					isValidAccount = false;
					isOpen = false;
					break;
				}
			}

			if (!isValidAccount && isOpen) {
				System.out.println("Account does not exist.");
			} else if (!isValidAccount && !isOpen) {
				System.out.println("Account is inactive.");
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

		System.out.println("Processing deposit...\n");

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

	/*
	 * Withdraws funds from a particular bank account
	 */
	private void withdrawAccount() {

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

			System.out.println("Retrieving accounts...");

			try {
				accounts = adi.retrieveUserAccounts(user.getId());
			} catch (SQLException e) {
				e.printStackTrace();
			}

			boolean isOpen = true;

			for (Account a : accounts) {
				if (a.getAccountNumber() == acctNum 
						&& a.getAccountStatus().equals(DEFAULT_ACCT_STATUS)) {
					isValidAccount = true;
					break;
				} else if (a.getAccountNumber() == acctNum 
						&& !a.getAccountStatus().equals(DEFAULT_ACCT_STATUS)) {
					isValidAccount = false;
					isOpen = false;
					break;
				}
			}

			if (!isValidAccount && isOpen) {
				System.out.println("Account does not exist.");
			} else if (!isValidAccount && !isOpen) {
				System.out.println("Account is inactive.");
			}
		}

		double withdraw = 0;
		double acctBalance = 0;
		Account withdrawAcct = null;

		if(isValidAccount) {
			boolean isValidAmount = false;

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

		System.out.println("Processing withdrawal...\n");

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

	/*
	 * Transfers funds between two particular bank accounts.
	 */
	private void transferFunds() {

		List<Account> accounts = null;

		int withdrawAcctNum = 0;
		int depositAcctNum = 0;

		boolean isValidAccount1 = false;
		boolean isValidAccount2 = false;
		boolean isValidAmount = false;

		double transferAmount = 0;
		double withdrawAcctBalance = 0;
		Account withdrawAcct = null;
		Account depositAcct = null;

		String withdrawBeforeBalance = null;
		String withdrawAfterBalance = null;
		String depositBeforeBalance = null;
		String depositAfterBalance = null;

		System.out.println("Which account are you transferring from?");

		while (!isValidAccount1) {
			System.out.print("Account number: ");
			try {
				withdrawAcctNum = Integer.parseInt(Menu.in.next());
			} catch (Exception e) {
				System.out.println("Account number must be an integer.");
			}

			try {
				System.out.println("Verifying account...");
				accounts = adi.retrieveUserAccounts(user.getId());
				System.out.println("Account verified.\n");
			} catch (SQLException e) {
				e.printStackTrace();
			}

			boolean isOpen1 = true;

			for (Account a : accounts) {
				if (a.getAccountNumber() == withdrawAcctNum 
						&& a.getAccountStatus().equals(DEFAULT_ACCT_STATUS)) {
					isValidAccount1 = true;
					break;
				} else if (a.getAccountNumber() == withdrawAcctNum 
						&& !a.getAccountStatus().equals(DEFAULT_ACCT_STATUS)) {
					isValidAccount1 = false;
					isOpen1 = false;
					break;
				}
			}

			if (!isValidAccount1 && isOpen1) {
				System.out.println("Account does not exist.");
			} else if (!isValidAccount1 && !isOpen1) {
				System.out.println("Account is inactive.");
			}
		}

		System.out.println("Which account are you transferring to?");

		while (!isValidAccount2) {
			System.out.print("Account number: ");
			try {
				depositAcctNum = Integer.parseInt(Menu.in.next());
			} catch (Exception e) {
				System.out.println("Account number must be an integer.");
			}

			try {
				System.out.println("Verifying account...");
				accounts = adi.retrieveUserAccounts(user.getId());
				System.out.println("Account verified.\n");
			} catch (SQLException e) {
				e.printStackTrace();
			}

			boolean isOpen2 = true;

			for (Account a : accounts) {
				if (a.getAccountNumber() == depositAcctNum 
						&& a.getAccountStatus().equals(DEFAULT_ACCT_STATUS)) {
					isValidAccount2 = true;
					break;
				} else if (a.getAccountNumber() == depositAcctNum 
						&& !a.getAccountStatus().equals(DEFAULT_ACCT_STATUS)) {
					isValidAccount2 = false;
					isOpen2 = false;
					break;
				}
			}

			if (!isValidAccount2 && isOpen2) {
				System.out.println("Account does not exist.");
			} else if (!isValidAccount2 && !isOpen2) {
				System.out.println("Account is inactive.");
			}
		}

		try {
			withdrawAcctBalance = adi.retrieveAccount(withdrawAcctNum).getBalance();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		System.out.println("How much are you transferring?");
		while(!isValidAmount) {
			System.out.print("Amount to transfer: ");
			try {
				transferAmount = Menu.in.nextDouble();
			} catch (InputMismatchException e) {
				System.out.println("Withdraw must be a number value.");
				Menu.in.next();
			}
			if (transferAmount <= 0.0) {
				System.out.println("Withdraw must be a positive value.");
			} else if (transferAmount > withdrawAcctBalance) {
				System.out.println("Insufficient funds.");
			} else {
				isValidAmount = true;
			}
		}

		System.out.println("\nProcessing transfer...");

		try {
			withdrawAcct = adi.retrieveAccount(withdrawAcctNum);
			withdrawBeforeBalance = withdrawAcct.toBalanceString();
			adi.updateAccount(withdrawAcctNum, withdrawAcct
					.getBalance() - transferAmount);
			withdrawAcct = adi.retrieveAccount(withdrawAcctNum);
			withdrawAfterBalance = withdrawAcct.toBalanceString();

			depositAcct = adi.retrieveAccount(depositAcctNum);
			depositBeforeBalance = depositAcct.toBalanceString();
			adi.updateAccount(depositAcctNum, depositAcct
					.getBalance() + transferAmount);
			depositAcct = adi.retrieveAccount(depositAcctNum);
			depositAfterBalance = depositAcct.toBalanceString();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		System.out.println("You transferred " 
				+ df.format(transferAmount));

		System.out.println("\nPrevious withdraw "
				+ "account balance: " + withdrawBeforeBalance);
		System.out.println("Previous deposit "
				+ "account balance: " + depositBeforeBalance);

		System.out.println("\nCurrent withdraw "
				+ "account balance: " + withdrawAfterBalance);
		System.out.println("Current deposit "
				+ "account balance: " + depositAfterBalance);
	}

	/*
	 * Account manager for creating and closing bank accounts.
	 */
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

		int accountToClose = 0;

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
		} else if (selection == 2) {
			boolean validDeletionSelection = false;

			while(!validDeletionSelection) {
				System.out.println("\nAccount Deletion");
				System.out.println("Retrieving accounts...");
				viewAccounts();
				System.out.println("Which account are you deleting?");
				System.out.print("Account #: ");

				try {
					accountToClose = Integer.parseInt(Menu.in.next());
					validDeletionSelection = true;
				} catch (Exception e) {
					System.out.println("Value must be an integer.");
				}

			}

			System.out.println("Verifying account...");
			List<Account> listAccounts = null;
			try {
				listAccounts = adi.retrieveUserAccounts(user.getId());
			} catch (SQLException e) {
				e.printStackTrace();
			}
			for (Account a : listAccounts) {
				if(a.getAccountNumber() == accountToClose) {
					System.out.println("Account verified.");
				}
			}
		}

		switch (selection) {
		case 1:
			createAccount(amount);
			manageAccounts();
		case 2:
			closeAccount(accountToClose);
			manageAccounts();
			break;
		case 0:
			System.out.println();
			customerMenu();
			break;
		default:
			System.out.println("Something went wrong in the account manager");
		}
	}

	/*
	 * Uses the account DAO to create an account in the database.
	 */
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

	/*
	 * Uses the account DAO to close an account in the database
	 * using a stored procedure.
	 */
	private void closeAccount(int accountNumber) {
		try {
			if(adi.retrieveAccount(accountNumber).getBalance() > 0) {
				System.out.println("Please withdraw remaining funds "
						+ "before closing your account.");
			}
			else {
				System.out.println("\nClosing account...");
				adi.deleteAccount(accountNumber);
				if(adi.retrieveAccount(accountNumber) == null)
					System.out.println("Account successfully deleted.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
