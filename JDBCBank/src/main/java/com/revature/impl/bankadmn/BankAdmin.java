package com.revature.impl.bankadmn;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

import com.revature.beans.Messages;
import com.revature.daoimpl.BankAdminDAOImpl;
import com.revature.daoimpl.GetUserInfoDAOImpl;

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
								System.out.println(
										"Please confirm that you want to approve of this account: \n\t1 - Yes, approve account\n\t2 - No!");
								switch (input.next()) {
								case "1":
									new BankAdminDAOImpl().BankAdminApproveApplication(
											listOfAccountNumbers.get(Integer.parseInt(accountChoice)));
									System.out.println("The application has been successflly approved.");
								case "2":
									break;
								default:
									getError();
								}

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
								System.out.println(
										"Please confirm that you want to deny this account: \n\t1 - Yes, deny account\n\t2 - No!");

								switch (input.next()) {
								case "1":
									new BankAdminDAOImpl().BankAdminDenyApplication(
											listOfAccountNumbers.get(Integer.parseInt(accountChoices)));
									System.out.println("The application has been successfully denied.");
								case "2":
									break;
								default:
									getError();
								}

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
				System.out.println("List of accounts:");
				ArrayList<String> listOfAllAccounts5 = getAllApplications();
				ArrayList<String> listOfAccountNumbers5 = new ArrayList<>();
				int accountCount5 = 0;

				for (String rst : listOfAllAccounts5) {
					String t = rst;
					t = t.replace(',', ' ');
					String[] words = t.split("\\s+");
					System.out.println(accountCount5++ + " - " + words[0] + " " + words[1] + " | Account Number: "
							+ words[2] + " | Balance: " + words[3]);
					listOfAccountNumbers5.add(words[2]);
				}
				System.out.print(
						"\nEnter the account id to edit the account's information or enter 'exit' into the console to exit the process: ");
				String option5 = input.next();
				if (option5.contains("exit")) {
					System.out.println("Exiting to previous menu");
					break;
				}
				if (checkIfDigit(option5)) {
					if (Integer.parseInt(option5) > accountCount5) {
						getError();
						break;
					} else {
						String accountNo5 = listOfAccountNumbers5.get(Integer.parseInt(option5));
						System.out.println(
								"Enter the what information you would like to edit:\n\t1 - First Name \n\t2 - Last Name"
										+ " \n\t3 - Username \n\t4 - Password \n\t5 - Status\n\t6 - Account Number");
						switch (input.next()) {
						case "1":
							String newFirstName = "";
							LoopA: while (true) {
								System.out.println("Please enter the new first name: ");
								newFirstName = input.next();
								if (CheckNameIfValid(newFirstName)) {
									break LoopA;
								} else {
									errorNameMessage();
								}
							}
							System.out.println(
									"Please confirm that you want to change the first name: \n\t1 - Yes!\n\t2 - No!");

							switch (input.next()) {
							case "1":
								getWithdrawProcess(accountNo, newBalance + "");
								System.out.println("Withdrawal successful!");
							case "2":
								break;
							default:
								getError();
							}
							break;
						case "2":
							break;
						case "3":
							break;
						case "4":
							break;
						case "5":
							break;
						case "6":
							break;
						default:
							getError();
							break;
						}
						String amountWithdraw5 = input.next();
						double newBalance5 = Double.parseDouble(getBalance(accountNo5))
								- Double.parseDouble(amountWithdraw5);
						if (newBalance5 < 0) {
							getError();
							break;
						} else {
							System.out.println(
									"Please confirm that you want to withdraw from this account: \n\t1 - Yes, withdraw from account\n\t2 - No!");

							switch (input.next()) {
							case "1":
								getWithdrawProcess(accountNo5, newBalance5 + "");
								System.out.println("Withdrawal successful!");
							case "2":
								break;
							default:
								getError();
							}

						}
					}
				} else {
					getError();
					break;
				}
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
				System.out.print("\nEnter the account to withdraw from: ");
				String option = input.next();
				if (checkIfDigit(option)) {
					if (Integer.parseInt(option) > accountCount) {
						getError();
						break;
					} else {
						String accountNo = listOfAccountNumbers2.get(Integer.parseInt(option));
						System.out.println("Enter the amount you would like to withdraw: ");
						String amountWithdraw = input.next();
						double newBalance = Double.parseDouble(getBalance(accountNo))
								- Double.parseDouble(amountWithdraw);
						if (newBalance < 0) {
							getError();
							break;
						} else {
							System.out.println(
									"Please confirm that you want to withdraw from this account: \n\t1 - Yes, withdraw from account\n\t2 - No!");

							switch (input.next()) {
							case "1":
								getWithdrawProcess(accountNo, newBalance + "");
								System.out.println("Withdrawal successful!");
							case "2":
								break;
							default:
								getError();
							}

						}
					}
				} else {
					getError();
					break;
				}
				break;
			/* Case 4: The user wants to deposit to other accounts */
			case "4":
				System.out.println("List of accounts:");
				ArrayList<String> listOfAllAccounts3 = getAllApplications();
				ArrayList<String> listOfAccountNumbers3 = new ArrayList<>();
				int accountCount3 = 0;

				for (String rst : listOfAllAccounts3) {
					String t = rst;
					t = t.replace(',', ' ');
					String[] words = t.split("\\s+");
					System.out.println(accountCount3++ + " - " + words[0] + " " + words[1] + " | Account Number: "
							+ words[2] + " | Balance: " + words[3]);
					listOfAccountNumbers3.add(words[2]);
				}
				System.out.print("\nEnter the account to deposit to: ");
				String option3 = input.next();
				if (checkIfDigit(option3)) {
					if (Integer.parseInt(option3) > accountCount3) {
						getError();
						break;
					} else {
						String accountNo3 = listOfAccountNumbers3.get(Integer.parseInt(option3));
						System.out.println("Enter the amount you would like to deposit: ");
						String amountWithdraw3 = input.next();
						double newBalance3 = Double.parseDouble(getBalance(accountNo3))
								+ Double.parseDouble(amountWithdraw3);
						if (newBalance3 < 0) {
							getError();
							break;
						} else {
							System.out.println(
									"Please confirm that you want to deposit into this account: \n\t1 - Yes, deposit to account\n\t2 - No!");

							switch (input.next()) {
							case "1":
								getWithdrawProcess(accountNo3, newBalance3 + "");
								System.out.println("Deposit successful!");
							case "2":
								break;
							default:
								getError();
							}

						}
					}
				} else {
					getError();
					break;
				}
				break;
			/* Case 5: The user wants to transfer funds between users */
			case "5":
				break;
			/* Case 6: The user wants to cancel accounts */
			case "6":
				System.out.println("List of accounts:");
				ArrayList<String> listOfAllAccounts4 = getAllApplications();
				ArrayList<String> listOfAccountNumbers4 = new ArrayList<>();
				int accountCount4 = 0;

				for (String rst : listOfAllAccounts4) {
					String t = rst;
					t = t.replace(',', ' ');
					String[] words = t.split("\\s+");
					System.out.println(accountCount4++ + " - " + words[0] + " " + words[1] + " | Account Number: "
							+ words[2] + " | Balance: " + words[3]);
					listOfAccountNumbers4.add(words[2]);
				}
				System.out.print("\nEnter the account to cancel: ");
				String option4 = input.next();
				if (checkIfDigit(option4)) {
					if (Integer.parseInt(option4) > accountCount4) {
						getError();
						break;
					} else {
						String accountNo4 = listOfAccountNumbers4.get(Integer.parseInt(option4));
						System.out.println(
								"Please confirm that you want to cancel this account: \n\t1 - Yes, cancel account\n\t2 - No!");

						switch (input.next()) {
						case "1":
							getCancelProcess(accountNo4);
							System.out.println("Account Cancellation successful!");
						case "2":
							break;
						default:
							getError();
						}
					}
				} else {
					getError();
					break;
				}
				break;
			/* Case 7: The user exits to the previous menu */
			case "7":
				System.out.println("Exiting to previous menu.");
				return;
			default:
				getError();
			}
		}
	}

	/*
	 * A method that calls onto the class CheckName to check if the user name the
	 * user entered is valid.
	 */
	private boolean CheckNameIfValid(String str) {
		boolean flag = false;
		for (int i = 0; i < str.length(); i++) {
			if (str.toUpperCase().charAt(i) >= 'A' && str.toUpperCase().charAt(i) <= 'Z') {
				flag = true;
			}
		}
		return flag;
	}

	/*
	 * Prompts the user that there was a error in their name and to try again with a
	 * different name.
	 */
	private void errorNameMessage() {
		System.out.print(new Messages().getErrorNameMessage());
	}

	private void getWithdrawProcess(String account, String amount) {
		new BankAdminDAOImpl().BankAdminWithdraw(account, amount);
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

	private String getBalance(String acc) {
		return new GetUserInfoDAOImpl().getUserBalance(acc);
	}
}
