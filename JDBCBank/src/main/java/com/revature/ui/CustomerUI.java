package com.revature.ui;

import java.sql.SQLException;

import com.revature.beans.User;
import com.revature.daoimpl.AccountDAOImpl;
import com.revature.daoimpl.UserDAOImpl;
import com.revature.driver.Driver;

public class CustomerUI {

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

		System.out.println("Please wait...");

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

			System.out.println("Customer console");

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
			viewAccounts();
			break;
		case 2:
			//make a deposit
			break;
		case 3:
			//withdraw from account
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

	}

	private void manageAccounts() {
		boolean validInputType = false;
		boolean validSelection = false;
		int selection = 0;
		double amount = 0;

		while(!validInputType || !validSelection) {

			validInputType = false;
			validSelection = false;

			System.out.println("Account Manager");
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
			while (!validAmount) {
				System.out.println("Initial deposit: ");
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
			try {
				System.out.println("Creating account...");
				
				int beforeSize = adi.retrieveAccount(user.getId()).size();
				adi.createAccount(amount, DEFAULT_ACCT_STATUS, user.getId());
				
				if (adi.retrieveUserAccounts(user.getId()).size() > beforeSize) {
					System.out.println("Account successfully created.\n");
				}
			} catch (SQLException e) {
				System.out.println("Unable to create account.");
			}
			manageAccounts();
		case 2:
			// Close account
			break;
		case 0:
			System.out.println();
			customerMenu();
			break;
		default:
			System.out.println("Something went wrong in the account manager");
		}
	}
}
