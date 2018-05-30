package com.revature.bank;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class CustomerUI {

	private static final String CUSTOMER_DIR = "src\\Data\\Customers\\";
	private static final String ACCOUNT_DIR = "src\\Data\\Accounts\\";
	private static final String SAVINGS_DIR = "src\\Data\\Savings\\";

	//private static final String ACCOUNTS = "Accounts";
	//private static final String SAVINGS = "Savings";

	String firstName;
	String lastName;
	String account;
	String savings;
	String password;

	double accountFunds;
	double savingsFunds;

	Account a;
	Account s;

	private boolean validUserName = false;

	private String username = "";

	public void login() {

		while(!validUserName) {
			System.out.print("Please enter your username: ");

			Menu.in.next();

			File folder = new File(CUSTOMER_DIR);

			if (!folder.exists()) {
				folder.mkdirs();
			}

			File[] listOfFiles = folder.listFiles();
			ArrayList<String> fileNames = new ArrayList<>();

			if(folder.exists()) {
				for (int i = 0; i < listOfFiles.length; i++) {
					if (listOfFiles[i].isFile())
						fileNames.add(listOfFiles[i].getName().toString());
				}
				/*try {
				FileOutputStream out = new FileOutputStream(CUSTOMER_DIR + "placeholder.txt");
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}*/
			} 

			//System.out.println(fileNames.toString());

			String input = Menu.in.next();

			for (String i : fileNames) {
				if ((input + ".txt").equals(i)) {
					username = input;
					Customer customer = deserialize(CUSTOMER_DIR, username);
					initializeCustomer(customer);
					this.a = deserializeAccount(ACCOUNT_DIR, account);
					this.s = deserializeAccount(SAVINGS_DIR, savings);
					initializeAccounts(a, s);
					unlock();
					validUserName = true;
					break;
				} else {
					System.out.println("User not found in database.");
					validUserName = false;
					break;
				}
			}
		}
	}

	private void unlock() {
		System.out.print("Please enter your password: ");
		String input = Menu.in.next();
		if(input.equals(password)) {
			manageAccount();
		}
	}

	private void manageAccount() {

		System.out.println("Welcome to your account!");

		printCustomer();

		boolean exit = false;

		int selection = 0;

		double amount = 0;

		while(!exit) {
			System.out.println("Account management: ");
			System.out.println("1. Withdraw");
			System.out.println("2. Deposit");
			System.out.println("3. Transfer");

			try {
			selection = Integer.parseInt(Menu.in.next());
			} catch(Exception e) {
				System.out.println("Please select a number.");
			}

			switch(selection) {
			case 1:
				System.out.print("Which account are you withdrawing from? :(checking/savings)");
				boolean done = false;
				while(!done) {
					try {
						if(Menu.in.next().equalsIgnoreCase("checking")) {
							System.out.print("How much would you like to withdraw?: ");
							amount = Integer.parseInt(Menu.in.next());
							a.withdraw(amount);
							System.out.print("Remaining balance: $");
							System.out.println(a.getBalance());
						} else if(Menu.in.next().equalsIgnoreCase("savings")) {
							System.out.print("How much would you like to withdraw?: ");
							s.withdraw(amount);
							System.out.println("Remaining balance: $");
							System.out.println(s.getBalance());
						} else if(Menu.in.next().equalsIgnoreCase("done")) {
							System.out.println("Exiting withdrawal menu.");
							done = true;
						}
					} catch(Exception e) {
						System.out.println("Please contact a bank administrator.");
					}
				}
			case 2:

			case 3:
			default:

			}
		}
	}



	private Customer deserialize(String dir, String name) {
		File file = new File(dir + name + ".txt");
		//File file = new File("src\\Data\\Customers\\" + username + ".txt");
		try {

			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			Customer c = (Customer)ois.readObject();

			ois.close();
			fis.close();

			return c;

		} catch (FileNotFoundException e) {
			System.out.println("Unable to retrieve account details.");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return null;

	}

	private Account deserializeAccount(String dir, String name) {
		File file = new File(dir + name + ".txt");
		//File file = new File("src\\Data\\Customers\\" + username + ".txt");
		try {

			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			Account a = (Account)ois.readObject();

			ois.close();
			fis.close();

			return a;

		} catch (FileNotFoundException e) {
			System.out.println("Unable to retrieve account details.");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return null;
	}

	private void initializeAccounts(Account a, Account s) {
		accountFunds = a.getBalance();
		savingsFunds = s.getBalance();
	}

	private void initializeCustomer(Customer c) {
		firstName = c.getFirstName();
		lastName = c.getLastName();
		account = c.getAccount();
		savings = c.getSavings();
		password = c.getPassword();
	}

	public void printCustomer() {
		System.out.println("First Name: " + firstName);
		System.out.println("Last Name: " + lastName);
		System.out.println("Checking #: " + account);
		System.out.println("Savings #: " + savings);
		System.out.println("Checking balance: " + accountFunds);
		System.out.println("Savings balance: " + savingsFunds);
	}

}
