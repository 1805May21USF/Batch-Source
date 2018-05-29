package com.revature.bank;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class AccountCreation {

	private static final String CUSTOMERS_FILE_NAME = "customers.txt";
	private static final String ACCOUNTS_FILE_NAME = "accounts.txt";
	private static final String CUSTOMER_ACCOUNT_OWNERSHIP = "account_ownership.txt";

	private void createAccount() {
		String firstName;
		String lastName;
		String userName = null;
		String password;
		String accountType = null;
		double initialDeposit = 0;

		boolean validAccountType = false;
		boolean validInitialDeposit = false;
		boolean validUserName = false;

		while(!validAccountType) {
			System.out.println("What type of account would you like to open?");
			System.out.print("Account type (checking/savings): ");
			accountType = Menu.in.nextLine();
			if (accountType.equalsIgnoreCase("checking") || accountType.equalsIgnoreCase("savings")) {
				validAccountType = true;
			} else if (accountType.equalsIgnoreCase("roll tide")) {
				System.out.println("Our premium account is still under development."
						+ " Please choose \"checking\" or \"savings\" in the meantime.");
			} else {
				System.out.println("Invalid account type. Please choose \"checking\" or \"savings\"");
			}
		}

		System.out.print("Please enter your first name: ");
		firstName = Menu.in.nextLine();
		System.out.print("Please enter your last name: ");
		lastName = Menu.in.nextLine();

		ArrayList<String> usernames = getUsernames(CUSTOMERS_FILE_NAME);
		System.out.println(usernames);
		while(!validUserName) {
			System.out.print("Please enter your desired user name: ");
			userName = Menu.in.nextLine();
			if (usernames.contains(userName))
				System.out.println("Username already exists. Please choose a different one.");
			validUserName = true;
		}

		System.out.print("Please enter your password: ");
		password = Menu.in.nextLine();

		while(!validInitialDeposit) {

			System.out.print("Initial deposit: ");

			try {
				initialDeposit = Double.parseDouble(Menu.in.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Please enter a number value.");
			}

			validInitialDeposit = true;

		}

		addAccount(firstName, lastName, userName, password, accountType, initialDeposit);
	}

	public void initializeAccount() {
		createAccount();
	}

	private void addAccount(String firstName, String lastName, 
			String userName, String password, String accountType, double initialDeposit) {

		String accountNumber = generateAccountNumber();

		File customersFile = new File(CUSTOMERS_FILE_NAME);
		File accountsFile = new File(ACCOUNTS_FILE_NAME);
		File accountOwnershipFile = new File(CUSTOMER_ACCOUNT_OWNERSHIP);

		String customerInfo = userName + ":" + lastName + ":" + firstName + ":" 
				+ password;
		String accountInfo = accountNumber + ":" + accountType + ":" + initialDeposit;
		String accountOwnershipInfo = userName + ":" + accountNumber;

		appendFile(customersFile, CUSTOMERS_FILE_NAME, customerInfo);
		appendFile(accountsFile, ACCOUNTS_FILE_NAME, accountInfo);
		appendFile(accountOwnershipFile, CUSTOMER_ACCOUNT_OWNERSHIP, accountOwnershipInfo);
	}

	/*
	 * Adds new users to the appropriate text files.
	 */
	private void appendFile(File file, String fileName, String info) {

		boolean isNewFile = false;

		if (!file.exists()) {
			try {
				file.createNewFile();
				isNewFile = true;
			} catch (IOException e) {
				printException();
			}
		}

		try {
			BufferedWriter output = new BufferedWriter(new FileWriter(fileName, true));
			if (!isNewFile)
				output.newLine();
			output.write(info);
			output.close();
		} catch (FileNotFoundException e) {
			printException();
		} catch (IOException e) {
			printException();
		}
	}

	private ArrayList<String> getUsernames(String fileName) {
		Scanner fileIn = null;
		ArrayList<String> usernames = new ArrayList<>();

		File file = new File(CUSTOMERS_FILE_NAME);

		if(file.exists()) {
			try {
				fileIn = new Scanner(new File(CUSTOMERS_FILE_NAME));
			} catch (FileNotFoundException e) {
				printException();
			}

			while(fileIn.hasNextLine()) {
				String[] username = fileIn.nextLine().split(":");
				usernames.add(username[0]);
			}
		}
		return usernames;
	}
	
	/*
	 * Generates an account number using the date and time.
	 */
	private String generateAccountNumber() {
		return new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
	}

	/*
	 * Prints an exception message. Since the program runs through the console,
	 * a user-friendly exception is printed instead of a detailed one.
	 */
	private void printException() {
		System.out.println("Something went wrong. Please contact the Bank of Roll Tide support team.");
	}

}
