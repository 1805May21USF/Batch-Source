package com.revature.bank;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class CreateCustomerAccount {

	private String userName;
	private String firstName;
	private String lastName;
	private String password;
	private double initialBalance;
	private double initialSavings;

	private String userName2;
	private String firstName2;
	private String lastName2;
	private String password2;
	private String initialBalance2;
	private String initialSavings2;

	private boolean isJointAccount;

	private static final String CUSTOMER_DIR = "src\\Data\\Customers\\";
	private static final String ACCOUNT_DIR = "src\\Data\\Accounts\\";
	private static final String SAVINGS_DIR = "src\\Data\\Savings\\";

	public void createAccount() {

		boolean validJointAccount = false;
		boolean validUserName = false;
		boolean validUserName2 = false;
		boolean validInitialBalance = false;
		boolean validInitialSavings = false;
		boolean validInitialBalance2 = false;
		boolean validInitialSavings2 = false;

		System.out.println("Thank you for choosing Bank of Roll Tide!");
		System.out.print("Is this going to be a joint account? (Y/N): ");

		/*
		 * Joint account
		 */
		while (!validJointAccount) {

			String input = Menu.in.next();

			if (input.equalsIgnoreCase("Y")) {
				isJointAccount = true;
				validJointAccount = true;
			} else if (input.equalsIgnoreCase("N")) {
				isJointAccount = false;
				validJointAccount = true;
			} else {
				System.out.print("Invalid selection. Please enter \"Y\" or \"N\": ");
				validJointAccount = false;
			}
		}

		/*
		 * Username
		 */
		while (!validUserName) {
			System.out.print("Please enter your desired username: ");

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

			String desiredUserName = Menu.in.next();

			for (String i : fileNames) {
				if ((desiredUserName + ".txt").equals(i)) {
					System.out.println("\nUsername already exists. Please pick a different one.");
					validUserName = false;
					break;
				} else {
					userName = desiredUserName;
					validUserName = true;
					break;
				}
			}
		}

		/*
		 * Customer name
		 */
		System.out.print("Please enter your first name: ");
		firstName = Menu.in.next();
		System.out.print("Please enter your last name: ");
		lastName = Menu.in.next();

		System.out.print("Please create a password: ");
		password = Menu.in.next();

		System.out.print("Please enter an initial deposit for your checking account: ");
		while(!validInitialBalance) {
			double input = 0;
			try {
				input = Menu.in.nextDouble();
			} catch(Exception e) {
				System.out.println("Value must be a dollar amount.");
			}
			if(input <= 0) {
				System.out.println("Value must be more than 0.");
			} else {
				initialBalance = input;
				validInitialBalance = true;
			}
		}
		
		System.out.print("Please enter an initial deposit for your savings account: ");
		while(!validInitialSavings) {
			double input = 0;
			try {
				input = Menu.in.nextDouble();
			} catch(Exception e) {
				System.out.println("Value must be a dollar amount.");
			}
			if(input <= 0) {
				System.out.println("Value must be more than 0.");
			} else {
				initialSavings = input;
				validInitialSavings = true;
			}
		}

		if (isJointAccount) {
			System.out.println("\nJoint account information -");
			while (!validUserName2) {
				System.out.print("Please enter your desired username: ");

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

				String desiredUserName = Menu.in.next();

				for (String i : fileNames) {
					if ((desiredUserName + ".txt").equals(i)) {
						System.out.println("\nUsername already exists. Please pick a different one.");
						validUserName2 = false;
						break;
					} else {
						userName2 = desiredUserName;
						validUserName2 = true;
						break;
					}
				}
			}

			/*
			 * Customer name
			 */
			System.out.print("Please enter your first name: ");
			firstName2 = Menu.in.next();
			System.out.print("Please enter your last name: ");
			lastName2 = Menu.in.next();

			System.out.print("Please create a password: ");
			password2 = Menu.in.next();

			System.out.print("Please enter an initial deposit: ");
			while(!validInitialBalance2) {
				double input = 0;
				try {
					input = Menu.in.nextDouble();
				} catch(Exception e) {
					System.out.println("Value must be a dollar amount.");
				}
				if(input <= 0) {
					System.out.println("Value must be more than 0.");
				} else {
					initialBalance = input;
					validInitialBalance2 = true;
				}
			}
		}

		String accountName = generateAccountNumber();
		String savingsName = generateAccountNumber();
		Customer customer = new Customer(firstName, lastName, accountName, savingsName, password);
		serializeCustomer(customer, userName);
		Account account = new Account(initialBalance);
		serializeAccount(account, accountName, ACCOUNT_DIR);
		Account savings = new Account(initialSavings);
		serializeAccount(savings, savingsName, SAVINGS_DIR);
		
		/*try {
			FileOutputStream fileOut = new FileOutputStream(CUSTOMER_DIR + userName + ".txt");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(customer);
			out.close();
			fileOut.close();
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}*/

		if (isJointAccount) {
			Customer customer2 = new Customer(firstName2, lastName2, accountName, savingsName, password2);
			serializeCustomer(customer2, userName2);

			/*try {
				FileOutputStream fileOut = new FileOutputStream(CUSTOMER_DIR + userName2 + ".txt");
				ObjectOutputStream out = new ObjectOutputStream(fileOut);
				out.writeObject(customer2);
				out.close();
				fileOut.close();
			} catch(FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}*/
		}

	}

	private void serializeAccount (Account a, String acctNum, String directory) {
		try {
			FileOutputStream fileOut = new FileOutputStream(directory + acctNum + ".txt");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(a);
			out.close();
			fileOut.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void serializeCustomer (Customer c, String user) {
		try {
			FileOutputStream fileOut = new FileOutputStream(CUSTOMER_DIR + user + ".txt");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(c);
			out.close();
			fileOut.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/*
	 * Generates an account number using the date and time.
	 */
	private String generateAccountNumber() {
		return new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()) + ((int) (Math.random() * 100));
	}

}
