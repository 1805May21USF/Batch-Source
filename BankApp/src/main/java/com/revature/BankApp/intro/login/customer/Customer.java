package com.revature.BankApp.intro.login.customer;

import java.io.File;
import java.text.DecimalFormat;

import com.revature.BankApp.data.get.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Customer {
	private String username;
	protected DecimalFormat df = new DecimalFormat("$###,###,##0.00");
	PersonDataManager pdm = new PersonDataManager();

	public Customer() {
	}

	public Customer(String str) {
		username = str;
		Scanner input = new Scanner(System.in);
		Loop1: while (true) {
			System.out.println("Welcome back " + str + "!\nAccounts Overview:");
			int numberOfAccounts = 0;
			for (String t : pdm.getAccountsOf(str)) {
				System.out.println("\tAccount " + numberOfAccounts++ + " | Balance: "
						+ df.format(getAccBalance(Long.parseLong(t))));
			}
			optionsMessage();
			switch (input.next()) {
			/* Case 1: The user wants to withdraw from their account */
			case "1":
				new CustomerWithdraw(username);
				break;
			/* Case 2: The user wants to deposit to their account */
			case "2":
				new CustomerDeposit(username);
				break;
			case "3":
				new CustomerTransfer(username);
				break;
			case "4":
				System.out.println("Exiting account to main menu.");
				break Loop1;
			default:
				System.out.println("Error: Please try again.");
			}
		}
	}

	/* Get the account balance of the user */
	private double getAccBalance(long accountNo) {
		double result = 0.0;
		try {
			Scanner input = new Scanner(new File("src\\main\\java\\com\\revature\\BankApp\\data\\PersonBalance.txt"));
			while (input.hasNext()) {
				String t = input.next();
				t = t.replace(',', ' ');
				String[] words = t.split("\\s+");
				if (words[0].equals("username")) {

				} else {
					if (accountNo == Long.parseLong(words[1])) {
						result = Double.parseDouble(words[2]);
					}
				}

			}

		} catch (Exception ex) {
			System.out.println("Error caught at getAccBalance in Customer " + ex.getMessage());
		}
		return result;
	}

	/* Return a String of accounts for the user. */
	private ArrayList<String> getAccounts(String username) {
		GetAccounts gt = new GetAccounts();
		ArrayList<String> result = gt.getAccounts(username);
		return result;
	}

	/* Prints message for the options for the user. */
	private void optionsMessage() {
		System.out.println("What would you like to do today?\n"
				+ "\t1 - Withdraw from account\n\t2 - Deposit into account\n\t3 - Transfer funds between accounts Note: You must own more than one account\n"
				+ "\t4 - Exit account");
	}
}
