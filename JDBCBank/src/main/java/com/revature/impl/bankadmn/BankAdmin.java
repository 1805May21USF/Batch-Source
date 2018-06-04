package com.revature.impl.bankadmn;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

import com.revature.beans.Messages;
import com.revature.daoimpl.BankAdminDAOImpl;

public class BankAdmin {
	private String username;
	protected DecimalFormat df = new DecimalFormat("$###,###,##0.00");
	Scanner input = new Scanner(System.in);

	public BankAdmin(String str) {
		username = str;
		Loop1: while (true) {
			System.out.println("Welcome back " + username + "!");
			optionsMessage();
			switch (input.next()) {
			/* Case 1: The user wants to apply or deny open applications */
			case "1":
				System.out.println("List of open applications:");
				ArrayList<String> listOfOpenApps = getOpenApplications();
				ArrayList<String> listOfAccountNumbers = new ArrayList<>();
				if (listOfOpenApps.isEmpty()) {
					System.out.println("There are no open applications.");
					break;
				} else {
					int accountCount = 0;
					for (String rst : listOfOpenApps) {
						String t = rst;
						t = t.replace(',', ' ');
						String[] words = t.split("\\s+");
						System.out.println(accountCount++ + " - " + words[0] + " " + words[1]);
						listOfAccountNumbers.add(words[2]);
					}
					System.out.print(
							"\nWhat would you like to do next?\n\t1 - Approve accounts\n\t2 - Deny accounts\n\t3 - Exit to previous menu\n");
					String option = input.next();
					switch (option) {
					case "1":
						System.out.println("Enter the account number to be approved: ");
						String accountChoice = input.next();
						if (checkIfDigit(accountChoice)) {
							if (Integer.parseInt(accountChoice) > accountCount) {
								getError();
								break;
							} else {
								new BankAdminDAOImpl().BankAdminApproveApplication(
										listOfAccountNumbers.get(Integer.parseInt(accountChoice)));
								System.out.println("The application has been successflly approved.");
							}
						} else {
							getError();
							break;
						}
						break;
					case "2":
						System.out.println("Enter the account number to be denied:");
						String accountChoices = input.next();
						if (checkIfDigit(accountChoices)) {
							if (Integer.parseInt(accountChoices) > accountCount) {
								getError();
								break;
							} else {
								new BankAdminDAOImpl().BankAdminDenyApplication(
										listOfAccountNumbers.get(Integer.parseInt(accountChoices)));
								System.out.println("The application has been successfully denied.");
							}
						} else {
							getError();
							break;
						}
						break;
					case "3":
						break;
					default:
						getError();
					}
				}
				break;
			/* Case 2: The user wants to view and edit customer info */
			case "2":
				//new BankAdminViewEditAccount();
				break;

			/* Case 3: The user wants to withdraw from other accounts */
			case "3":
				System.out.println("List of accounts:");
				ArrayList<String> listOfAllAccounts = getAllApplications();
				ArrayList<String> listOfAccountNumbers2 = new ArrayList<>();
				int accountCount = 0;

				for (String rst : listOfAllAccounts) {
					String t = rst;
					t = t.replace(',', ' ');
					String[] words = t.split("\\s+");
					System.out.println(accountCount++ + " - " + words[0] + " " + words[1] + " | Account Number: "
							+ words[2] + " | Balance: " + words[3]);
					listOfAccountNumbers2.add(words[2]);
				}
				System.out.print(
						"\nEnter the account to withdraw from: ");
				String option = input.next();
				if (option.contains("exit")) {
					return;
				} else if (checkIfDigit(option)) {
					if (Integer.parseInt(option) > accountCount) {
						getError();
						break;
					} else {
						
					}
				} else {
					getError();
					break;
				}

				// getWithdrawProcess();
				break;
			/* Case 4: The user wants to deposit to other accounts */
			case "4":
				break;
			/* Case 5: The user wants to transfer funds between users */
			case "5":
				break;
			/* Case 6: The user wants to cancel accounts */
			case "6":
				//getCancelProcess();
				break;
			/* Case 7: The user exits to the previous menu */
			case "7":
				System.out.println("Exiting to previous menu.");
				return;
			default:
				System.out.println("Error: Please try again.");
			}
		}
	}

	private void getWithdrawProcess(String username, String account, String amount) {
		new BankAdminDAOImpl().BankAdminWithdraw(username, account, amount);
	}

	private void getCancelProcess(String username) {
		new BankAdminDAOImpl().BankAdminCancelAccount(username);
	}

	private void optionsMessage() {
		System.out.println(new Messages().getBankAdminPrompt());
	}

	private ArrayList<String> getOpenApplications() {
		return new BankAdminDAOImpl().ListOfOpenApplications();
	}

	private ArrayList<String> getAllApplications() {
		return new BankAdminDAOImpl().ListOfAllAccounts();
	}

	private boolean checkIfDigit(String t) {
		return t.matches("[0-9]*");
	}

	private static void getError() {
		System.out.print(new Messages().getIntroError());
	}
}
