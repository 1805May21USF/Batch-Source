package com.revature.BankApp.intro.login.customer;

import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

import com.revature.BankApp.data.get.GetAccounts;
import com.revature.BankApp.data.get.PersonDataManager;

public class CustomerTransfer {
	private Scanner input = new Scanner(System.in);
	private String username;
	private DecimalFormat df = new DecimalFormat("##.##");
	PersonDataManager pdm = new PersonDataManager();

	public CustomerTransfer(String username) {
		if (checkNumberOfAccounts(username)) {

			int desiredAccount;
			String transferFrom;
			String amountTransfer;
			ArrayList<String> tempArray = pdm.getAccountsOf(username);

			LoopB: while (true) {
				desiredAccount = 0;
				System.out.println(
						"Transfer funds between accounts - Select the account you want to transfer money from: ");
				for (String t : pdm.getAccountsOf(username)) {
					System.out.println("\t" + desiredAccount + " - Account " + desiredAccount++ + " | " + "Balance: $"
							+ df.format(getAccBalance(username, Long.parseLong(t))));
				}
				transferFrom = input.next();
				if (!checkIfDigit(transferFrom)
						|| Integer.parseInt(transferFrom) > pdm.getAccountsOf(username).size()) {
					System.out.println("Sorry, we didn't understand that. Please try again.");
				} else {
					break LoopB;
				}
			}

			System.out.println("Select how much you want to transfer from $" + df.format(getAccBalance(username,
					Long.parseLong(pdm.getAccountsOf(username).get(Integer.parseInt(transferFrom))))));
			amountTransfer = input.next();

			pdm.updateNewBalanceTransfer(username,
					Long.parseLong(pdm.getAccountsOf(username).get(Integer.parseInt(transferFrom))), getAccBalance(username,
							Long.parseLong(pdm.getAccountsOf(username).get(Integer.parseInt(transferFrom)))), amountTransfer);

			// long transferFromAccount = getAccountNumber(username, transferFrom);
			// tempArray.remove(Integer.parseInt(transferFrom));
			// desiredAccount = 0;
			// for (String t : tempArray) {
			// System.out.println("\t" + desiredAccount + " - Account " + t);
			// }
			// System.out.println("Please enter the desired account number you would like to
			// deposit to: ");
			// String position = input.next();
			// if (!position.matches("\\d+")) {
			// System.out.println("Sorry, we didn't understand that. Please try again.");
			// } else if (Integer.parseInt(position) > getAccBalance(username,
			// getAccountNumber(username, position))) {
			// // User must re-try input if the value is greater than the actual number of
			// // accounts
			// System.out.println("Your input is invalid. Please try again.");
			// } else {
			// long accNo = getAccountNumber(username, position);
			// double balance = getAccBalance(username, accNo);
			// System.out.println(
			// "Your current balance is $" + df.format(balance) + ". How much would you like
			// to deposit?");
			// String bal = input.next();
			// if (!bal.matches("\\d+(\\.*)(\\d*)")) {
			// System.out.println("Sorry, we didn't understand that. Please try again.");
			// } else {
			// // depositAccount(username, accNo, balance, bal);
			// }
			// break LoopA;
			// }

		} else {
			System.out.println(
					"We're sorry, but you are unable to transfer funds if you do not have more than one account.");
		}
	}

	private boolean checkNumberOfAccounts(String username2) {
		if (pdm.getAccountsOf(username2).size() == 1) {
			return false;
		} else {
			return true;
		}
	}

	private boolean checkIfDigit(String t) {
		return t.matches("[0-9]");
	}

	/* Return a String of accounts for the user. */
	private ArrayList<String> getAccounts(String username) {
		GetAccounts gt = new GetAccounts();
		ArrayList<String> result = gt.getAccounts(username);
		return result;
	}

	/*
	 * The getBalance method retrieves the current balance using the user name and
	 * account number
	 */
	private double getBalance(String accountNo) {
		ArrayList<String> accounts = new ArrayList<>();
		try {
			Scanner input = new Scanner(new File("src\\main\\java\\com\\revature\\BankApp\\data\\PersonBalance.txt"));
			while (input.hasNext()) {
				String t = input.next();
				t = t.replace(',', ' ');
				String[] words = t.split("\\s+");
				if (username.equals(words[0])) {
					accounts.add(words[2]);
				}
			}

		} catch (Exception ex) {
			System.out.println("Error: Something went wrong.");
		}
		return Double.parseDouble(accounts.get(Integer.parseInt(accountNo)));
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
			System.out.println("Error caught at getAccountNumber");
		}
		return Long.parseLong(results.get(Integer.parseInt(position)));
	}

	/* Get the account balance of the user */
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
			System.out.println("Error: Something went wrong.");
		}
		return result;
	}
}
