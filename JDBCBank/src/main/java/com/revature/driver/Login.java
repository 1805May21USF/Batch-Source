package com.revature.driver;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.beans.Messages;
import com.revature.daoimpl.CheckUserDAOImpl;
import com.revature.daoimpl.GetUserInfoDAOImpl;
import com.revature.impl.bankadmn.BankAdmin;
import com.revature.impl.customer.Customer;
import com.revature.impl.employee.Employee;

public class Login {

	private static Logger log = Logger.getLogger(Login.class.getName());

	public Login() {

		Scanner input = new Scanner(System.in);

		Loop1: while (true) {
			System.out.println("LOGIN:");
			usernameMessage();
			String username = input.next();
			passwordMessage();
			String password = input.next();
			if (checkUser(username, password)) {
				switch (getUserStatus(username)) {
				case -1:
					System.out.println("We have reviewed your application and it has been denied. Please speak "
							+ "to an employee about your application if you have any questions or concerns.");
					break;
				case 0:
					System.out.println("Your account application is currently being reviewed. Please try again later.");
					break;
				case 1:
					log.info(username + " has logged into their account.");
					new Customer(username);
					break;
				case 2:
					log.info(username + " has logged into their account.");
					new Employee(username);
					break;
				case 3:
					log.info(username + " has logged into their account.");
					new BankAdmin(username);
					break;
				default:
					getError();
				}
				break Loop1;
			} else {
				errorUnableToFindUsernameOrPassword();
				switch (input.next()) {
				case "1":
					break;
				case "2":
					return;
				default:
					getError();

				}
			}
		}
	}

	/* Prompt the user to enter their user name. */
	private void usernameMessage() {
		System.out.print(new Messages().getUsernamePrompt());
	}

	/*
	 * Prompt the user to enter their password. Password must be between 5 to 15
	 * characters.
	 */
	private void passwordMessage() {
		System.out.print(new Messages().getPasswordPrompt());
	}

	/* Checks if the user is in the database */
	private boolean checkUser(String username2, String password2) {
		return new CheckUserDAOImpl().checkUserAndPassword(username2, password2);
	}

	/* Return the status of the user from the database */
	private int getUserStatus(String username2) {
		return Integer.parseInt(new GetUserInfoDAOImpl().getUserStatus(username2));
	}

	// Return to the user that there was no matching username or password
	private void errorUnableToFindUsernameOrPassword() {
		System.out.println(new Messages().getErrorUsernameOrPasswordMessage());
	}

	private static void getError() {
		System.out.print(new Messages().getIntroError());
	}
}
