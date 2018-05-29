package com.bank.intro.login.customer;

import java.io.File;
import java.util.Scanner;

public class Customer {
	private String username;

	public Customer() {
	}

	public Customer(String str) {
		username = str;
		Scanner input = new Scanner(System.in);
		Loop1: while (true) {
			System.out.println("Welcome back " + str + "!\nWhat would you like to do today?\n"
					+ "1 - Withdraw from account\n2 - Deposit into account\n3 - Transfer funds between accounts\n"
					+ "4 - Exit account");
			switch (input.nextInt()) {
			case 1:
				System.out.println("Withdrawing from account. Current balance is: " + getBalance());
				break;
			case 2:
				break;

			case 3:
				break;
			case 4:
				System.out.println("Exiting account to main menu.");
				break Loop1;
			default:
				System.out.println("Error: Please try again.");
			}
		}
	}

	/* The getBalance method retrieves the current balance using the user name */
	private double getBalance() {
		try {
			Scanner input = new Scanner(new File("src\\com\\bank\\data\\Person.txt"));
			while (input.hasNext()) {
				String t = input.next();
				t = t.replace(',', ' ');
				String[] words = t.split("\\s+");
				if (username.equals(words[2])) {
					return Double.parseDouble(words[2]);
				}
			}

		} catch (Exception ex) {
			System.out.println("Error: Something went wrong.");
		}
		return 0.0;
	}
}
