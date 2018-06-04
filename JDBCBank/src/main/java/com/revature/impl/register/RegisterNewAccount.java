package com.revature.impl.register;

//import java.io.BufferedWriter;
//import java.io.File;
//import java.io.FileWriter;
//import java.io.PrintWriter;
import java.util.Date;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.beans.Messages;
import com.revature.daoimpl.CheckUsernameDAOImpl;
import com.revature.daoimpl.RegistrationDAOImpl;
import com.revature.impl.CheckPassword;
import com.revature.impl.customer.Customer;

public class RegisterNewAccount {

	private String newFirstName;
	private String newLastName;
	private String newUsername;
	private String newPassword;
	private static Logger log = Logger.getLogger(Customer.class.getName());

	public RegisterNewAccount() {
		Scanner input = new Scanner(System.in);
		Loop1: while (true) {
			welcomeMessage();
			// LoopA is used to check if the name the user entered is valid.
			LoopA: while (true) {
				firstNameMessage();
				newFirstName = input.next();
				if (CheckNameIfValid(newFirstName)) {
					break LoopA;
				} else {
					errorNameMessage();
				}
			}
			// LoopB is used to check if the name the user entered is valid
			LoopB: while (true) {
				lastNameMessage();
				newLastName = input.next();
				if (CheckNameIfValid(newLastName)) {
					break LoopB;
				} else {
					errorNameMessage();
				}
			}
			// Check if the user name already exists in the database

			Loop2: while (true) {
				usernameMessage();
				newUsername = input.next();
				if (checkUsername(newUsername)) {
					errorUsernameMessage();
				} else {
					passwordMessage();
					Loop3: while (true) {
						newPassword = input.next();
						if (!checkPassword(newPassword)) {
							errorPasswordMessage();
						} else {
							break Loop3;
						}
					}
					break Loop2;
				}
			}
			confirmMessage(newFirstName, newLastName, newUsername, newPassword);

			switch (input.next()) {
			case "1":
				break Loop1;
			case "2":
				break;
			case "3":
				return;
			default:
				getError();
			}
		}

		new RegisterNewAccount(newFirstName, newLastName, newUsername, newPassword);
		log.info(newFirstName + " " + newLastName + " has registered for an account. Username: " + newUsername
				+ " Password: " + newPassword);
		exitMessage();
	}

	/*
	 * This method is used for a single account for a new user. It accepts one user
	 * name and one password. Creates a new object to the DAO and sends the Java
	 * code to the database.
	 */
	public RegisterNewAccount(String firstName, String lastName, String username, String password) {
		String tempAccountNumber = dateGenerator();
		new RegistrationDAOImpl().RegisterNewAccount(firstName, lastName, username, password, tempAccountNumber);
	}

	private String dateGenerator() {
		Date t = new Date();
		return t.getTime() + "";
	}

	/* Welcomes the user with a greeting on their selection. */
	private void welcomeMessage() {
		System.out.println(new Messages().getRegisterNewAccountWelcome());
	}

	/* Prompt the user to enter their first name. */
	private void firstNameMessage() {
		System.out.print(new Messages().getFirstNamePrompt());
	}

	/* Prompt the user to enter their last name. */
	private void lastNameMessage() {
		System.out.print(new Messages().getLastNamePrompt());
	}

	/* Prompt the user to enter their username. */
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

	/*
	 * Prompts the user that the user name they have entered cannot be used.
	 * Therefore the user must enter a different user name.
	 */
	private void errorUsernameMessage() {
		System.out.println(new Messages().getErrorUsernameMessage());
	}

	/* */
	private void errorPasswordMessage() {
		System.out.println(new Messages().getErrorPasswordMessage());
	}

	/* Prints a message that their application was submitted. */
	private void exitMessage() {
		System.out.print(new Messages().getRegisterExitMessage());
	}

	/*
	 * Prompts the user that there was a error in their name and to try again with a
	 * different name.
	 */
	private void errorNameMessage() {
		System.out.print(new Messages().getErrorNameMessage());
	}

	/*
	 * A method that calls onto the class CheckName to check if the user name the
	 * user entered is valid.
	 */
	public static boolean CheckNameIfValid(String str) {
		return str.matches("[A-z]*");
	}

	/*
	 * A method that calls onto the class CheckUsername to check if the user name
	 * exists in the database.
	 */
	private boolean checkUsername(String str) {
		return new CheckUsernameDAOImpl().checkUsername(str);
	}

	/*
	 * A method that calls onto the class CheckPassword to check if the pass word
	 * the user entered is valid. The requirements can be changed in the
	 * CheckPassword class.
	 */
	private boolean checkPassword(String str) {
		CheckPassword chk = new CheckPassword();
		return (chk.CheckPasswordIfValid(str) && !(str.equals(newUsername)));
	}

	private void confirmMessage(String newFirstName12, String newLastName12, String newUsername12,
			String newPassword12) {
		System.out.print("Is the following information correct?\n\tFirst Name: " + newFirstName12 + "\n\tLast Name: "
				+ newLastName12 + "\n\tUsername: " + newUsername12 + "\n\tPassword: " + newPassword12
				+ "\n1 - Yes, the information above is correct. Continue to Person 2.\n2 - No, I would"
				+ " like to go back and re-enter the information.\n3 - Exit to Main Menu.\n"
				+ "\nPlease enter a number on what you would like to do next: ");

	}

	private static void getError() {
		System.out.print(new Messages().getIntroError());
	}
}
