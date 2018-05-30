package com.revature.bank;

import java.util.Scanner;

public class Menu {
	
	static Scanner in = new Scanner(System.in);

	private void initializeMenu() {
		createMenu();
	}

	private void createMenu() {
		printHeader();
		
		int selection = getSelection();
		performSelection(selection);
	}

	private int getSelection() {

		int selection = 0;

		System.out.println("Please make a selection:");

		do {

			System.out.println("1. Create new Account");
			System.out.println("2. Customer Login");
			System.out.println("3. Employee Login");
			System.out.println("4. Admin Login");
			System.out.println("0. Exit");
			System.out.print("Selection: ");

			try {

				selection = Integer.parseInt(in.nextLine());

			} catch (NumberFormatException e) {
				System.out.println("Selection must be a number.");
			} 

			if (selection < 0 || selection > 4)
				System.out.println("Please select a value within range.");

		} while(selection < 0 || selection > 4);

		System.out.println();

		return selection;
	}
	
	private void performSelection(int selection) {
		switch (selection) {
		case 1: 
			CreateCustomerAccount cca = new CreateCustomerAccount();
			cca.createAccount();
			break;
		case 2: // Login
		case 3:
			System.out.println("Thank you for choosing Bank of Roll Tide! Have a great day!");
			System.exit(0);
			break;
		case 9: // Employee login
		case 0: // Admin login
		default:
			System.out.println("An unknown error has occurred. Please contact the Bank of Roll Tide support team.");
			System.exit(1);
		}
	}

	private void printHeader() {
		System.out.println("+---------------------------------+");
		System.out.println("|--Welcome to Bank of Roll Tide!--|");
		System.out.println("+---------------------------------+");
		System.out.println();
	}

	public static void main(String[] args) {
		Menu menu = new Menu();
		menu.initializeMenu();
	}

}
