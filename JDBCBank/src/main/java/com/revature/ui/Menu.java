package com.revature.ui;

import java.util.Scanner;

import com.revature.driver.Driver;

/**
 * Creates the main menu of the bank app.
 * @author Nathaniel Simpson
 *
 */
public class Menu {

	//A static scanner is used to prevent strange anomalies 
	static Scanner in = new Scanner(System.in);

	boolean validInputType = false;
	boolean validSelection = false;

	public void initializeMenu() {
		createMenu();
	}

	private void createMenu() {
		int selection = getSelection();
		performSelection(selection);
	}

	/*
	 * Outputs the menu options and collects user input.
	 */
	private int getSelection() {

		int selection = 0;

		while(!validInputType || !validSelection) {

			validInputType = false;
			validSelection = false;

			System.out.println("Please make a selection.");

			System.out.println("\t1. Create new Account");
			System.out.println("\t2. Customer Login");
			System.out.println("\t3. Employee Login");
			System.out.println("\t4. Admin Login");
			System.out.println("\t0. Exit");

			System.out.print("\nSelection: ");

			try {
				selection = Integer.parseInt(in.next());
				validInputType = true;
			} catch (NumberFormatException e) {
				System.out.println("Selection must be a number.\n");
			}

			if (selection >= 0 && selection <= 4) {
				validSelection = true;
			} else {
				System.out.println("Please select a number within range.\n");
			}

			/*try {
				if (in.hasNextInt() && selection >= 0 && selection <= 4) {
					selection = in.nextInt();
					validSelection = true;
				} else {
					System.out.println("Invalid selection.");
				}
			} catch (InputMismatchException e) {
				System.out.println("Selection must be a number");
			}*/
		}	

		System.out.println();

		return selection;
	}

	/*
	 * Performs the selection made by the user.
	 */
	private void performSelection(int selection) {
		switch (selection) {
		case 1:
			NewCustomerApplication nca = new NewCustomerApplication();
			nca.createApplication();
			Driver.reinitialize();
			break;
		case 2:
			CustomerUI cui = new CustomerUI();
			cui.initializeCUI();
			break;
		case 3:
			//employee
			break;
		case 4:
			//admin
			break;
		case 0:
			System.out.println("Thank you for choosing Bank of Roll Tide!");
			System.out.println("Have a wonderful day!");
			System.exit(0);
			break;
		default:
			System.out.println("Invalid selection.");
			getSelection();
		}
	}
}
