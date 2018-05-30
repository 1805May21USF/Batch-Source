package com.revature.BankApp.intro.login.bankadmin;

import java.text.DecimalFormat;
import java.util.Scanner;

import com.revature.BankApp.intro.login.customer.CustomerDeposit;
import com.revature.BankApp.intro.login.customer.CustomerTransfer;
import com.revature.BankApp.intro.login.customer.CustomerWithdraw;

public class BankAdmin {

	private String username;
	protected DecimalFormat df = new DecimalFormat("$###,###,##0.00");

	public BankAdmin(String str) {
		username = str;
		Scanner input = new Scanner(System.in);
		Loop1: while (true) {
			System.out.println("Welcome back " + str + "!");
			optionsMessage();
			switch (input.next()) {
			/* Case 1: The user wants to apply or deny open applications */
			case "1":
				new BankAdminViewOpenApplications();
				break;
			/* Case 2: The user wants to view and edit customer info */
			case "2":
				new BankAdminViewEditAccount();
				break;
			/* Case 3: The user wants to withdraw from other accounts */
			case "3":
				new BankAdminWithdraw();
				break;
			/* Case 4: The user wants to deposit to other accounts */
			case "4":
				break;
			/* Case 5: The user wants to transfer funds between users */
			case "5":
				break;
			/* Case 6: The user wants to cancel accounts */
			case "6":
				new BankAdminCancelAccount();
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

	/* Prints message for the options for the user. */
	private void optionsMessage() {
		System.out.println("What would you like to do today?\n"
				+ "\t1 - Approve/deny open applications\n\t2 - View and edit customer info\n\t3 - Withdraw from"
				+ " an account\n\t4 - Deposit to an account\n\t5 - Transfer funds between accounts per user\n\t6 - Cancel an account\n\t7 - Exit menu");
	}
}
