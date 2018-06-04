package com.revature.impl.customer;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

import com.revature.beans.Messages;
import com.revature.daoimpl.CustomerDAOImpl;
import com.revature.daoimpl.GetUserInfoDAOImpl;

public class Customer {
	private String username;
	protected DecimalFormat df = new DecimalFormat("$###,###,##0.00");

	public Customer(String str) {
		Scanner input = new Scanner(System.in);
		username = str;

		Loop1: while (true) {
			System.out.println("Welcome back " + username + "!\nAccounts Overview:");
			ArrayList<String> results = getUserAccountAndBalanceNumbers(username);
			String[] actualAccountValue = new String[results.size()];
			int accountNum = 0;
			for (String res : results) {
				String t = res;
				t = t.replace(',', ' ');
				String[] words = t.split("\\s+");
				actualAccountValue[accountNum] = words[0];
				System.out
						.println("Account " + accountNum++ + " | Balance: " + df.format(Double.parseDouble(words[1])));
			}
			/*
			 * Ask the user which options they would like to do. 1 - Withdraw, 2 - Deposit,
			 * 3 - Transfer funds, 4 - Exit
			 */
			optionsMessage();
			getPleaseEnterANumberPrompt();
			switch (input.next()) {
			// Customer wants to withdraw
			case "1":
				System.out.println("Which account would you like to withdraw from?");
				String account = input.next();
				if (Integer.parseInt(account) > accountNum) {
					getError();
					break;
				} else {
					double newBalance = 0;
					String amount = "";
					LoopB: while (true) {
						System.out.println("How much would you like to withdraw? Your current balance is: "
								+ df.format(Double.parseDouble(
										getBalanceFromAccountNumber(actualAccountValue[Integer.parseInt(account)])))
								+ "\nEnter 'exit' into the console if you would like to exit the withdraw process.");
						amount = input.next();
						if (amount.contains("exit")) {
							return;
						}
						// Check if the user input is a digit. If it is, then the new balance is
						// calculated to be updated in the database.
						if (checkIfDigit(amount)) {
							newBalance = Double.parseDouble(
									getBalanceFromAccountNumber(actualAccountValue[Integer.parseInt(account)]))
									- Double.parseDouble(amount);
							if (newBalance <= 0) {
								getError();
							} else {
								break;
							}
						} else {
							getError();
						}

					}
					System.out.println(
							"Please confirm that you want to withdraw from this account: \n\t1 - Yes, withdraw from account\n\t2 - No!");

					switch (input.next()) {
					case "1":
						new CustomerDAOImpl().CustomerWithdraw(username, actualAccountValue[Integer.parseInt(account)],
								newBalance + "");
						break;
					case "2":
						break;
					default:
						getError();
					}

				}

			case "2":
				System.out.println("Which account would you like to deposit from?");
				String account2 = input.next();
				if (Integer.parseInt(account2) > accountNum) {
					getError();
					break;
				} else {
					double newBalance = 0;
					String amount2 = "";
					LoopB: while (true) {
						System.out.println("How much would you like to deposit? Your current balance is: "
								+ df.format(Double.parseDouble(
										getBalanceFromAccountNumber(actualAccountValue[Integer.parseInt(account2)])))
								+ "\nEnter 'exit' into the console if you would like to exit the deposit process.");
						amount2 = input.next();
						if (amount2.contains("exit")) {
							return;
						}
						// Check if the user input is a digit. If it is, then the new balance is
						// calculated to be updated in the database.
						if (checkIfDigit(amount2)) {
							newBalance = Double.parseDouble(
									getBalanceFromAccountNumber(actualAccountValue[Integer.parseInt(account2)]))
									+ Double.parseDouble(amount2);
							break;
						} else {
							getError();
						}
					}
					System.out.println(
							"Please confirm that you want to deposit into this account: \n\t1 - Yes, deposit into account\n\t2 - No!");

					switch (input.next()) {
					case "1":
						new CustomerDAOImpl().CustomerDeposit(username, actualAccountValue[Integer.parseInt(account2)],
								newBalance + "");
						break;
					case "2":
						break;
					default:
						getError();
					}

				}

			case "3":
				if (results.size() >= 2) {

				} else {
					System.out.println(
							"We're sorry, but you are unable to transfer funds between accounts. Exiting transfer process.");
					break;
				}
				new CustomerDAOImpl().CustomerTransfer(username);
				break;
			/*
			 * The user wants to delete their account. They can only delete from their
			 * account if the account balance is 0
			 */
			case "4":
				System.out.println("Which account would you like to delete?");
				String account3 = input.next();
				if (Integer.parseInt(account3) > accountNum) {
					getError();
					break;
				} else {
					if (Double.parseDouble(
							getBalanceFromAccountNumber(actualAccountValue[Integer.parseInt(account3)])) == 0) {
						System.out.println(
								"Please confirm that you want to delete this account: \n\t1 - Yes, delete account\n\t2 - No!");

						switch (input.next()) {
						case "1":
							deleteUserAccount(actualAccountValue[Integer.parseInt(account3)]);
							System.out.println("Account deletion successful!");
							return;

						case "2":
							break;
						default:
							getError();
						}

					} else {
						System.out.println(
								"We're sorry, but you cannot delete an account if the balance is greater than 0.");
						break;
					}
				}
			case "5":
				System.out.println("Exiting account to main menu.");
				return;
			default:
				getError();
			}
		}

	}

	private boolean checkIfDigit(String t) {
		return t.matches("[0-9]*");
	}

	private ArrayList<String> getUserAccountAndBalanceNumbers(String username) {
		return new GetUserInfoDAOImpl().getUserAccountAndBalanceNumbers(username);
	}

	private void optionsMessage() {
		System.out.println(new Messages().getCustomerPrompt());
	}

	private static void getError() {
		System.out.print(new Messages().getIntroError());
	}

	private static void getPleaseEnterANumberPrompt() {
		System.out.print(new Messages().getPleaseEnterANumberPrompt());
	}

	private static String getBalanceFromAccountNumber(String accountNumber) {
		return new GetUserInfoDAOImpl().getUserBalance(accountNumber);
	}

	private static void deleteUserAccount(String accountNumber) {
		new CustomerDAOImpl().CustomerCancelAccount(accountNumber);
	}
}
