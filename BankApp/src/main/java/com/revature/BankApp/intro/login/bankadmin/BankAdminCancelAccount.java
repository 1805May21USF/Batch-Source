package com.revature.BankApp.intro.login.bankadmin;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import com.revature.BankApp.data.get.PersonDataManager;

public class BankAdminCancelAccount {
	Scanner input = new Scanner(System.in);

	BankAdminCancelAccount() {
		System.out.println("Canceling Account:");
		String accNo = "";
		ArrayList<String> acc = getAccountInfo();
		int count = 0;
		String accChoice;
		for (String str : acc) {
			System.out.println("\t" + count++ + " - " + str);
		}
		LoopB: while (true) {
			System.out.println("Please enter a number based on the account that you would like to cancel.");
			accChoice = input.next();
			if (checkIfDigit(accChoice)) {
				accNo = getAccountNumber(accChoice);
				break LoopB;
			} else {
				System.out.println("We're sorry, but we did not understand your command. Please try again.");
			}
		}
		new BankAdminCancelAccount(acc.get(Integer.parseInt(accChoice)),Long.parseLong(accNo));
	}

	public BankAdminCancelAccount(String username, long accountNo) {
		PersonDataManager pdm = new PersonDataManager();
		ArrayList<String> tempArray = new ArrayList<>();
		for (String temp : pdm.getAccounts()) {
			tempArray.add(temp);
		}

		for (int i = 0; i < tempArray.size(); i++) {
			String tmp = tempArray.get(i).replace(',', ' ');
			String[] words = tmp.split("\\s+");
			if (words[0].equals("FirstName")) {

			} else {
				if (Long.parseLong(words[5]) == accountNo) {
					String tempVar = tempArray.get(i);
					tempArray.add(words[0] + "," + words[1] + "," + words[2] + "," + words[3] + ",-2," + accountNo);
					tempArray.remove(tempVar);
				}
			}

		}
		// Write into the PersonBalance.txt

		try {
			PrintWriter out = new PrintWriter(new File("src\\main\\java\\com\\revature\\BankApp\\data\\Person.txt"));
			out.println("FirstName,LastName,Username,Password,status,accountNo");
			for (String arrStr : tempArray) {
				String tmp = arrStr.replace(',', ' ');
				String[] words = tmp.split("\\s+");
				out.println(
						words[0] + "," + words[1] + "," + words[2] + "," + words[3] + "," + words[4] + "," + words[5]);
			}
			out.close();
		} catch (Exception ex) {
			System.out.println("Exception was caught at accessing Person.txt: " + ex.getMessage());
		}
		System.out.println("Cancel succeeded.");
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

}
