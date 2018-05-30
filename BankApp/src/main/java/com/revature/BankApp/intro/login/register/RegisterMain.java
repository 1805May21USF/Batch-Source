package com.revature.BankApp.intro.login.register;

import java.util.Scanner;

import com.revature.BankApp.intro.login.register.RegisterNewAccount;
import com.revature.BankApp.intro.login.register.RegisterNewAccountJoint;
import com.revature.BankApp.intro.login.register.RegisterReturningAccount;

public class RegisterMain {

	public RegisterMain() {
		Scanner input = new Scanner(System.in);
		while (true) {
			System.out.print("Thank you for choosing to apply for a new account. Please read all the choices carefully."
					+ "\nAre you:\n\t1 - applying as a new user?\n\t2 - applying as a new user for a joint account? Please note that you are limited to only two users for a joint account at this time."
					+ "\n\t3 - applying for an additional account as a returning user?\n\t4 - return to main menu\nPlease enter a number on what you would like to do next: ");
			switch (input.next()) {
			case "1":
				new RegisterNewAccount();
				break;
			case "2":
				new RegisterNewAccountJoint();
				break;
			case "3":
				new RegisterReturningAccount();
				break;
			case "4":
				return;
			default:
				System.out.println("Sorry, we didn't understand that. Please try again.");
			}
		}

	}
}
