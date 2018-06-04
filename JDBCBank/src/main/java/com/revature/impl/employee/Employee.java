package com.revature.impl.employee;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

import com.revature.beans.Messages;
import com.revature.daoimpl.EmployeeDAOImpl;

public class Employee {
	private String username;
	protected DecimalFormat df = new DecimalFormat("$###,###,##0.00");
	Scanner input = new Scanner(System.in);

	public Employee(String str) {
		username = str;
		Loop1: while (true) {
			System.out.println("Welcome back " + username + "!");
			optionsMessage();
			switch (input.next()) {
			// Case 1 : Opens a list of approve/deny open applications for the employee to
			// approve
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
								new EmployeeDAOImpl().EmployeeApproveApplication(
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
								new EmployeeDAOImpl().EmployeeDenyApplication(
										listOfAccountNumbers.get(Integer.parseInt(accountChoices)));
								System.out.println("The application has been successfully denied. ");
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
			// Case 2: View Customer Info. The employee should not be able to edit customer
			// information.
			case "2":
				ArrayList<String> list = listOfCustomerInfo();
				for (String st : list) {
					String t = st;
					t = t.replace(',', ' ');
					String[] words = t.split("\\s+");
					//words[0] = first name, words[1] = last name, words[2] = account number
					System.out.println("\tName: " + words[0] + " " + words[1] + "\n\t\tAccount Number: " + words[2]);
				}
				break;
			case "3":
				System.out.println("Exiting account to main menu.");
				return;
			default:
				getError();
			}
		}
	}

	private void optionsMessage() {
		System.out.println(new Messages().getEmployeePrompt());
	}

	private boolean checkIfDigit(String t) {
		return t.matches("[0-9]*");
	}

	private static void getError() {
		System.out.print(new Messages().getIntroError());
	}

	private ArrayList<String> getOpenApplications() {
		return new EmployeeDAOImpl().ListOfOpenApplications();
	}

	private ArrayList<String> listOfCustomerInfo() {
		return new EmployeeDAOImpl().EmployeeViewAccountInfo();
	}

}
