package com.revature.driver;

import java.util.Scanner;

import com.revature.beans.Messages;

/* BankApp Assignment created by Tiffany Tran
 * Due: Monday June 4th at 5pm
 * Log-file: log.txt is found in the Batch-Source folder
 * */
public class Driver {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		/*
		 * Create a switch-case statement to iterate on the multiple choices as initial
		 * menu
		 */
		while (true) {

			getWelcome();
			getPleaseEnterANumberPrompt();
			/*
			 * The switch-case after the welcome prompts the user if they would like to
			 * register for an account or to login if they already have an account
			 */
			try {
				switch (input.next()) {
				/*
				 * Case 1: Register and apply for a bank account A RegisterNewAccount object is
				 * created and prints a welcome string. The user is prompted to enter a unique
				 * user name and password
				 */
				case "1":
					new Register();
					break;
				/*
				 * Case 2: The user is prompted to enter a user name and password. If the user
				 * name and password is found in the Person.txt, then more options will appear
				 * for the user depending on the user status.
				 */
				case "2":
					new Login();
					break;
				/* Case 3: The user can exit the banking app. */
				case "3":
					getExit();
					input.close();
					System.exit(0);
				default:
					getError();
				}
			} catch (Exception ex) {
				System.out.print("Exception: Caught at Driver. " + ex.getMessage());
			}
		}

		// SuperHeroDAOImpl shdi = new SuperHeroDAOImpl();

		// try {
		// shdi.createSuperHero("One Punch Man");
		// System.out.print(shdi.getSuperHeroList());
		// } catch (Exception ex) {
		// System.out.print("Error in main method: " + ex.getMessage());
		// }
	}

	private static void getWelcome() {
		System.out.print(new Messages().getIntroWelcome());
	}

	private static void getPleaseEnterANumberPrompt() {
		System.out.print(new Messages().getPleaseEnterANumberPrompt());
	}

	private static void getExit() {
		System.out.print(new Messages().getIntroExit());
	}

	private static void getError() {
		System.out.print(new Messages().getIntroError());
	}

}
