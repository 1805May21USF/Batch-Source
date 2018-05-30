package com.revature.BankApp.intro.login.bankadmin;

import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

import com.revature.BankApp.data.get.PersonDataManager;

public class BankAdminWithdraw {
	Scanner input = new Scanner(System.in);

	protected DecimalFormat df = new DecimalFormat("$###,###,##0.00");

	PersonDataManager pdm = new PersonDataManager();

	BankAdminWithdraw() {
		System.out.println("Customer Info:");
		String accNo = "";
		ArrayList<String> acc = getAccountInfo();
		int count = 0;
		for (String str : acc) {
			System.out.println("\t" + count++ + " - " + str);
		}
		LoopB: while (true) {
			System.out.println("Please enter a number based on the account that you would like to withdraw.");
			String accChoice = input.next();
			if (checkIfDigit(accChoice)) {
				accNo = getAccountNumber(accChoice);
				break LoopB;
			} else {
				System.out.println("We're sorry, but we did not understand your command. Please try again.");
			}
		}
		new BankAdminWithdraw(accNo);
	}

	public BankAdminWithdraw(String username) {
		LoopA: while (true) {
			int desiredAccount = 0;
			System.out.println("Withdraw - Which account would you like to withdraw from?");
			for (String t : pdm.getAccountsOf(username)) {
				System.out.println("\t" + desiredAccount + " - Account " + desiredAccount++);
			}
			System.out.println("Please enter the desired account number you would like to withdraw from: ");
			String position = input.next();
			if (!position.matches("\\d+")) {
				System.out.println("Sorry, we didn't understand that. Please try again.");
			} else if (Integer.parseInt(position) > getAccBalance(username, getAccountNumber(username, position))) {
				// User must re-try input if the value is greater than the actual number of
				// accounts
				System.out.println("Your input is invalid. Please try again.");
			} else {
				long accNo = getAccountNumber(username, position);
				double balance = getAccBalance(username, accNo);
				System.out.println(
						"Your current balance is $" + df.format(balance) + ". How much would you like to withdraw?");
				String bal = input.next();
				if (!bal.matches("\\d+(\\.*)(\\d*)")) {
					System.out.println("Sorry, we didn't understand that. Please try again.");
				} else if (Double.parseDouble(bal) > balance) {
					// User must re-try input if the value is greater than the actual balance
					System.out.println("Your input is invalid. Please try again.");
				} else {
					withdrawBalance(username, accNo, balance, bal);
				}
				break LoopA;
			}
		}
	}

	/*
	 * This method will withdraw the balance from the user's account. It accesses
	 * the PersonBalance.txt to change the value of the user's balance.
	 */
	private void withdrawBalance(String username, long accountNo, double balance, String bal) {
		pdm.updateNewBalanceAdd(username, accountNo, bal);
	}

	/* Returns the user's account number from the value that they entered. */
	private long getAccountNumber(String username, String position) {
		/*
		 * Check the Person.txt for each matching user name and pulling their balance.
		 */
		ArrayList<String> results = new ArrayList<String>();
		try {
			Scanner input = new Scanner(new File("src\\main\\java\\com\\revature\\BankApp\\data\\PersonBalance.txt"));
			while (input.hasNext()) {
				String t = input.next();
				t = t.replace(',', ' ');
				String[] words = t.split("\\s+");
				if (username.equals(words[0])) {
					results.add(words[1]);
				}
			}
		} catch (Exception ex) {
			System.out.println("Error caught at getAccountNumber in CustomerWithdraw " + ex.getMessage());
		}
		return Long.parseLong(results.get(Integer.parseInt(position)));
	}

	/**/
	private double getAccBalance(String username, long accountNo) {
		double result = 0.0;
		try {
			Scanner input = new Scanner(new File("src\\main\\java\\com\\revature\\BankApp\\data\\PersonBalance.txt"));
			while (input.hasNext()) {
				String t = input.next();
				t = t.replace(',', ' ');
				String[] words = t.split("\\s+");
				if (username.equals(words[0]) && accountNo == Long.parseLong(words[1])) {
					result = Double.parseDouble(words[2]);
				}
			}

		} catch (Exception ex) {
			System.out.println("Error was caught at getAccBalance in CustomerWithdraw " + ex.getMessage());
		}
		return result;
	}

	private String getAccountNumber(String choice) {
		String result = "";
		try {
			Scanner input = new Scanner(new File("src\\main\\java\\com\\revature\\BankApp\\data\\Person.txt"));
			Scanner input2 = new Scanner(new File("src\\main\\java\\com\\revature\\BankApp\\data\\PersonBalance.txt"));
			while (input.hasNext() && input2.hasNext()) {
				String t = input.next();
				String t2 = input2.next();
				String status = "";
				t = t.replace(',', ' ');
				t2 = t2.replace(',', ' ');
				String[] words = t.split("\\s+");
				String[] words2 = t2.split("\\s+");
				if (words[0].equals("FirstName")) {

				} else {
					result = words[5];
				}
			}
		} catch (Exception ex) {
			System.out.println(
					"Error occurred at open applications in employee view open applications " + ex.getMessage());
		}
		return result;
	}

	private boolean checkIfDigit(String t) {
		return t.matches("[0-9]");
	}

	private ArrayList<String> getAccountInfo() {
		ArrayList<String> accounts = new ArrayList<>();
		try {
			Scanner input = new Scanner(new File("src\\main\\java\\com\\revature\\BankApp\\data\\Person.txt"));
			Scanner input2 = new Scanner(new File("src\\main\\java\\com\\revature\\BankApp\\data\\PersonBalance.txt"));
			while (input.hasNext() && input2.hasNext()) {
				String t = input.next();
				String t2 = input2.next();
				String status = "";
				t = t.replace(',', ' ');
				t2 = t2.replace(',', ' ');
				String[] words = t.split("\\s+");
				String[] words2 = t2.split("\\s+");
				if (words[0].equals("FirstName")) {

				} else {
					accounts.add("Username: " + words[2] + "\n\t    Password: " + words[3] + "\n\t    Account Number: "
							+ words[5] + "\n\t    Balance: $" + words2[2]);
				}
			}
		} catch (Exception ex) {
			System.out.println(
					"Error occurred at open applications in employee view open applications " + ex.getMessage());
		}
		return accounts;
	}

	private ArrayList<String> editAccountInfo(String user) {
		ArrayList<String> accounts = new ArrayList<>();
		try {
			Scanner input = new Scanner(new File("src\\main\\java\\com\\revature\\BankApp\\data\\Person.txt"));
			Scanner input2 = new Scanner(new File("src\\main\\java\\com\\revature\\BankApp\\data\\PersonBalance.txt"));
			while (input.hasNext() && input2.hasNext()) {
				String t = input.next();
				String t2 = input2.next();
				String status = "";
				t = t.replace(',', ' ');
				t2 = t2.replace(',', ' ');
				String[] words = t.split("\\s+");
				String[] words2 = t2.split("\\s+");
				if (words[5].equals(user)) {
					accounts.add("First Name: " + words[0]);
					accounts.add("Last Name: " + words[1]);
					accounts.add("Username: " + words[2]);
					accounts.add("Password: " + words[3]);
					accounts.add("Status: " + words[4]);
					accounts.add("Account Number: " + words[5]);
				}
			}
		} catch (Exception ex) {
			System.out.println(
					"Error occurred at open applications in employee view open applications " + ex.getMessage());
		}
		return accounts;
	}
}
