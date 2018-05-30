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

	private String userName2;
	private String firstName2;
	private String lastName2;
	private String password2;


	private double initialDeposit;
	private boolean isJointAccount;

	private static final String CUSTOMER_DIR = "src\\Data\\Customers\\";

	public void createAccount() {

		boolean validJointAccount = false;
		boolean validUserName = false;
		boolean validUserName2 = false;

		System.out.println("Thank you for choosing Bank of Roll Tide!");
		System.out.print("Is this going to be a joint account? (Y/N): ");

		/*
		 * Joint account
		 */
		while (!validJointAccount) {

			String input = Menu.in.nextLine();

			if (input.equalsIgnoreCase("Y")) {
				isJointAccount = true;
				validJointAccount = true;
			} else if (input.equalsIgnoreCase("N")) {
				isJointAccount = false;
				validJointAccount = true;
			} else {
				System.out.print("Invalid selection. Please enter \"Y\" or \"N\"");
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

			String desiredUserName = Menu.in.nextLine();

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
		firstName = Menu.in.nextLine();
		System.out.print("Please enter your last name: ");
		lastName = Menu.in.nextLine();

		System.out.print("Please create a password: ");
		password = Menu.in.nextLine();

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

				String desiredUserName = Menu.in.nextLine();

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
			firstName2 = Menu.in.nextLine();
			System.out.print("Please enter your last name: ");
			lastName2 = Menu.in.nextLine();

			System.out.print("Please create a password: ");
			password2 = Menu.in.nextLine();
		}

		Customer customer = new Customer(firstName, lastName, generateAccountNumber(), password);

		try {
			FileOutputStream fileOut = new FileOutputStream(CUSTOMER_DIR + userName + ".txt");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(customer);
			out.close();
			fileOut.close();
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/*
	 * Generates an account number using the date and time.
	 */
	private String generateAccountNumber() {
		return new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
	}

}
