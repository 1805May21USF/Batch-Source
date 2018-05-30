package com.revature.BankApp.intro.login.bankadmin;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class BankAdminViewOpenApplications {
	Scanner input = new Scanner(System.in);

	BankAdminViewOpenApplications() {
		LoopA: while (true) {
			System.out.println("Here are the list of open applications:");
			ArrayList<String> op = getOpenApplcations();
			for (String t : op) {
				System.out.println("\t" + t);
			}
			System.out.print(
					"\nWhat would you like to do next?\n\t1 - Approve accounts\n\t2 - Deny accounts\n\t3 - Exit to previous menu\n");
			switch (input.next()) {
			case "1":
				new BankAdminApproveApplications();
				break;
			case "2":
				new BankAdminDenyApplications();
				break;
			case "3":
				return;
			default:
				System.out.println("Sorry, we didn't understand that. Please try again.");

			}
		}
	}

	/* Return an arraylist of open applications */
	public ArrayList<String> getOpenApplcations() {
		ArrayList<String> accounts = new ArrayList<>();
		try {
			Scanner input = new Scanner(new File("src\\main\\java\\com\\revature\\BankApp\\data\\Person.txt"));
			while (input.hasNext()) {
				String t = input.next();
				t = t.replace(',', ' ');
				String[] words = t.split("\\s+");
				if (words[4].equals("0")) {
					accounts.add(words[0] + " " + words[1]);
				}
			}
		} catch (Exception ex) {
			System.out.println(
					"Error occured at open applications in employee view open applications " + ex.getMessage());
		}
		return accounts;
	}
}
