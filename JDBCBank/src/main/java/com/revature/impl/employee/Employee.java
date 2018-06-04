package com.revature.impl.employee;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.beans.Messages;
import com.revature.daoimpl.EmployeeDAOImpl;
import com.revature.impl.customer.Customer;

public class Employee {
	private String username;
	protected DecimalFormat df = new DecimalFormat("$###,###,##0.00");
	private static Logger log = Logger.getLogger(Employee.class.getName());
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
								log.info(username + " has approved of "
										+ listOfAccountNumbers.get(Integer.parseInt(accountChoice))
										+ "'s application.");
								System.out.println("The application has been successfully approved.");
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
								log.info(username + " has denied "
										+ listOfAccountNumbers.get(Integer.parseInt(accountChoices))
										+ "'s application.");
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
				int accountCount5 = 0;
				ArrayList<String> list = listOfCustomerInfo();
				System.out.println("ID - FIRSTNAME        LASTNAME      | ACCOUNT NUMBER  | STATUS   | BALANCE");
				System.out.println("---------------------------------------------------------------------------");
				for (String st : list) {
					String t = st;
					t = t.replace(',', ' ');
					String[] words = t.split("\\s+");
					System.out.printf("%s - %-15s %-15s | %-15s | %-10s | %-20s\n", accountCount5++, words[0], words[1],
							words[2], words[4], df.format(Double.parseDouble(words[3])));
				}
				break;
			case "3":
				System.out.println("Exiting account to main menu.");
				log.info(username + " has logged out of their account.");
				return;
			default:
				getError();
			}
		}
	}

	private void optionsMessage() {
		System.out.println(new Messages().getEmployeePrompt());
	}

	public static boolean checkIfDigit(String t) {
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
