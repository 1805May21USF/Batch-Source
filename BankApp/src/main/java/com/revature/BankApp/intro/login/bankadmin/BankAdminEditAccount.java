package com.revature.BankApp.intro.login.bankadmin;

import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class BankAdminEditAccount {
	Scanner input = new Scanner(System.in);
	private DecimalFormat df = new DecimalFormat("###,###,##0.00");

	BankAdminEditAccount() {
		System.out.println("Editing Customer Info:");
		String accNo = "";
		ArrayList<String> acc = getAccountInfo();
		int count = 0;
		for (String str : acc) {
			System.out.println("\t" + count++ + " - " + str);
		}
		LoopB: while (true) {
			System.out.println("Please enter a number based on the account that you would like to edit.");
			String accChoice = input.next();
			if (checkIfDigit(accChoice)) {
				accNo = getAccountNumber(accChoice);
				break LoopB;
			} else {
				System.out.println("We're sorry, but we did not understand your command. Please try again.");
			}
		}
		new BankAdminEditAccount(accNo);
	}
	/* */
	BankAdminEditAccount(String user) {
		System.out.println("Editing " + user
				+ " information: \nNOTE: It is dangerous to edit the account number. Please be cautious when doing so.");
		ArrayList<String> t = editAccountInfo(user);
		int count = 0;
		for (String str : t) {
			System.out.println(count++ + " - " + str);
		}
		System.out.println("Please enter a number on your choice: ");
		String num = input.next();
		if (!checkIfDigit(num)) {
			System.out.println("Sorry, your input is invalid. Please try again.");
		} else {
			//editStuff();
			//break;
		}
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
							+ words[5]);
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
