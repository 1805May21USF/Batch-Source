package com.revature.BankApp.intro.login.employee;

import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

import com.revature.BankApp.data.get.GetAccounts;

public class Employee {
	private String username;
	protected DecimalFormat df = new DecimalFormat("$###,###,##0.00");

	public Employee(String str) {
		username = str;
		Scanner input = new Scanner(System.in);
		Loop1: while (true) {
			System.out.println("Welcome back " + str + "!");
			optionsMessage();
			switch (input.next()) {
			/* Case 1: The user can look at a list of approve/deny open applications */
			case "1":
				new EmployeeViewOpenApplications();
				break;
			/*
			 * Case 2: The user wants to view a list of customer info by Account Info,
			 * Account Balance, Personal Info
			 */
			case "2":
				new EmployeeViewAccountInfo();
				break;
			case "3":
				System.out.println("Exiting account to main menu.");
				return;
			default:
				System.out.println("Error: Please try again.");
			}
		}
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

	/* Prints message for the options for the user. */
	private void optionsMessage() {
		System.out.println("What would you like to do today?\n"
				+ "\t1 - Approve/deny open applications\n\t2 - View customer info\n\t3 - Exit account");
	}

}
