package com.revature.impl.register;

//import java.io.BufferedWriter;
//import java.io.File;
//import java.io.FileWriter;
//import java.io.PrintWriter;
import java.util.Date;
import java.util.Scanner;

import com.revature.beans.Messages;
import com.revature.daoimpl.CheckUsernameDAOImpl;
import com.revature.daoimpl.RegistrationDAOImpl;
import com.revature.impl.CheckPassword;

public class RegisterNewAccount {

	private String newFirstName;
	private String newLastName;
	private String newUsername;
	private String newPassword;
	// private int status;
	// private int accountNumber;

	public RegisterNewAccount() {
		Scanner input = new Scanner(System.in);
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
		new RegisterNewAccount(newFirstName, newLastName, newUsername, newPassword);
	
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
	private boolean CheckNameIfValid(String str) {
		boolean flag = false;
		for (int i = 0; i < str.length(); i++) {
			if (str.toUpperCase().charAt(i) >= 'A' && str.toUpperCase().charAt(i) <= 'Z') {
				flag = true;
			}
		}
		return flag;
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
}
