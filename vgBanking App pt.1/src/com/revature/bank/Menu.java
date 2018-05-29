package com.revature.bank;

import java.util.Scanner;

public class Menu {

	public static Scanner in = new Scanner(System.in);
	Bank bank = new Bank();

	private boolean exit = false;

	private void initializeMenu() {
		createMenu();
	}

	private void createMenu() {
		printHeader();

		while(!exit) {
			int selection = getSelection();
			performSelection(selection);
		}
	}

	private void printHeader() {
		System.out.println("+---------------------------------+");
		System.out.println("|--Welcome to Bank of Roll Tide!--|");
		System.out.println("+---------------------------------+");
		System.out.println();
	}

	private int getSelection() {

		int selection = 0;

		System.out.println("Please make a selection:");

		do {

			System.out.println("1. Create new Account");
			System.out.println("2. Login");
			System.out.println("3. Exit");
			System.out.println("9. Admin Login");
			System.out.print("Selection: ");

			try {

				selection = Integer.parseInt(in.nextLine());

			} catch (NumberFormatException e) {
				System.out.println("Selection must be a number.");
			} 

			if ((selection < 1 || selection > 3) && selection != 9)
				System.out.println("Please select a value within range.");

		} while((selection < 1 || selection > 3) && selection != 9);

		System.out.println();

		return selection;
	}

	private void performSelection(int selection) {
		switch (selection) {
		case 1:
			AccountCreation newAccount = new AccountCreation();
			newAccount.initializeAccount();
			break;
		case 2: // Login
		case 3:
			System.out.println("Thank you for choosing Bank of Roll Tide! Have a great day!");
			exit = true;
			break;
		case 9: // Admin login
		default:
			System.out.println("An unknown error has occurred. Please contact the Bank of Roll Tide support team.");
			System.exit(1);
		}
	}

	public static void main(String[] args) {
		Menu menu = new Menu();
		menu.initializeMenu();
	}

}
