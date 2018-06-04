package com.revature.BankApp.intro.login.customer;


import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

import com.revature.BankApp.data.get.GetAccounts;
import com.revature.BankApp.data.get.PersonDataManager;

public class CustomerDeposit {
	private Scanner input = new Scanner(System.in);
	private String username;
	private DecimalFormat df = new DecimalFormat("##.##");
	PersonDataManager pdm = new PersonDataManager();

	public CustomerDeposit(String username) {
		LoopA: while (true) {
			int desiredAccount = 0;
			System.out.println("Withdraw - Which account would you like to deposit to?");
			for (String t : pdm.getAccountsOf(username)) {
				System.out.println("\t" + desiredAccount + " - Account " + desiredAccount++);
			}
			System.out.println("Please enter the desired account number you would like to deposit to: ");
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
						"Your current balance is $" + df.format(balance) + ". How much would you like to deposit?");
				String bal = input.next();
				if (!bal.matches("\\d+(\\.*)(\\d*)")) {
					System.out.println("Sorry, we didn't understand that. Please try again.");
				} else {
					depositAccount(username, accNo, balance, bal);
				}
				break LoopA;
			}
		}
	}

	private void depositAccount(String username2, long accountNo, double balance, String bal) {
		pdm.updateNewBalanceSubtract(username2, accountNo, bal);
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
			System.out.println("Error caught at getAccBalance in CustomerDeposit " + ex.getMessage());
		}
		return result;
	}
}