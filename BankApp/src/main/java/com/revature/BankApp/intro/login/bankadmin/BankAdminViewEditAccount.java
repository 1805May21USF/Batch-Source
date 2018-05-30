package com.revature.BankApp.intro.login.bankadmin;

import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class BankAdminViewEditAccount {
	Scanner input = new Scanner(System.in);
	private DecimalFormat df = new DecimalFormat("###,###,##0.00");

	BankAdminViewEditAccount() {
		System.out.println("Viewing Account Informations: ");
		ArrayList<String> arr = getAccountInfo();
		for (String str : arr) {
			System.out.println(str + "\n");
		}
		LoopA: while (true) {
			System.out.println(
					"Would you like to edit any of these accounts?\n\t1 - Yes, edit account information\n\t2 - No, exit to previous menu");
			switch (input.next()) {
			case "1":
				new BankAdminEditAccount();
				break LoopA;
			case "2":
				return;
			default:
				System.out.println("We're sorry, but we do not understand your command. Please try again.");
			}
		}
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
					switch (words[4]) {
					case "-2":
						status = "Cancelled Account";
						break;
					case "-1":
						status = "Denied Application";
						break;
					case "0":
						status = "Open Application";
						break;
					case "1":
						status = "Customer";
						break;
					case "2":
						status = "Employee";
						break;
					case "3":
						status = "Bank Admin";
						break;
					}
					accounts.add("\tFirst Name: " + words[0] + "\n\tLast Name: " + words[1] + "\n\tUsername: "
							+ words[2] + "\n\tPassword: " + words[3] + "\n\tStatus: " + status + "\n\tAccount Number: "
							+ words[5] + "\n\tBalance: $" + df.format(Double.parseDouble(words2[2])));
				}
			}
		} catch (Exception ex) {
			System.out.println(
					"Error occurred at open applications in employee view open applications " + ex.getMessage());
		}
		return accounts;
	}
}
