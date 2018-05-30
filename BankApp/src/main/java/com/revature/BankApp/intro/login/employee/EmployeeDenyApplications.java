package com.revature.BankApp.intro.login.employee;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import com.revature.BankApp.data.get.PersonDataManager;

public class EmployeeDenyApplications {
	Scanner input = new Scanner(System.in);

	EmployeeDenyApplications() {
		LoopB: while (true) {
			System.out.println("Deny Mode - Here are the list of open applications:");
			int count = 0;
			ArrayList<String> op = getOpenApplcations();
			for (String t : op) {
				System.out.println("\t" + count++ + " - " + t);
			}
			System.out.println("Please enter a number on which application you want to approve: ");
			String t = input.next();
			if (Integer.parseInt(t) >= count) {
				System.out.println("Sorry, but we are unable to process your command. Please try again");
			} else {
				String tmp = op.get(Integer.parseInt(t)).replace(',', ' ');
				String[] words = tmp.split("\\s+");
				denyApplication(t, getAccountNumber(words));
				break LoopB;
			}
		}
	}

	/* Returns the user's account number from the value that they entered. */
	private long getAccountNumber(String[] position) {
		/*
		 * Check the Person.txt for each matching user name and pulling their balance.
		 */
		String result = "";
		try {
			Scanner input = new Scanner(new File("src\\main\\java\\com\\revature\\BankApp\\data\\Person.txt"));
			int count = 0;
			while (input.hasNext()) {
				String t = input.next();
				t = t.replace(',', ' ');
				String[] words = t.split("\\s+");
				if (words[0].equals("FirstName")) {

				} else {
					if (position[0].equals(words[0]) && position[1].equals(words[1])) {
						result = words[5];
					}
				}
				count++;
			}
		} catch (Exception ex) {
			System.out.println("Error caught at getAccountNumber");
		}
		return Long.parseLong(result);
	}

	/* Returns the user's account number from the value that they entered. */
	private long getUsername(String position) {
		/*
		 * Check the Person.txt for each matching user name and pulling their balance.
		 */
		ArrayList<String> results = new ArrayList<String>();
		try {
			Scanner input = new Scanner(new File("src\\main\\java\\com\\revature\\BankApp\\data\\Person.txt"));
			int count = 0;
			while (input.hasNext()) {
				String t = input.next();
				t = t.replace(',', ' ');
				String[] words = t.split("\\s+");
				if (count == Integer.parseInt(position)) {
					results.add(words[1]);
				}
			}
		} catch (Exception ex) {
			System.out.println("Error caught at getAccountNumber");
		}
		return Long.parseLong(results.get(Integer.parseInt(position)));
	}

	/* Deny account. The method will update the user's status from 0 to -1 */
	private void denyApplication(String username, long accountNo) {
		PersonDataManager pdm = new PersonDataManager();
		ArrayList<String> tempArray = new ArrayList<>();
		for (String temp : pdm.getAccounts()) {
			tempArray.add(temp);
		}

		for (int i = 0; i < tempArray.size(); i++) {
			String tmp = tempArray.get(i).replace(',', ' ');
			String[] words = tmp.split("\\s+");
			if (Long.parseLong(words[5]) == accountNo) {
				String tempVar = tempArray.get(i);
				tempArray.add(words[0] + "," + words[1] + "," + words[2] + "," + words[3] + ",-1," + accountNo);
				tempArray.remove(tempVar);
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
		System.out.println("Deny succeeded.");
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
