package com.revature.impl.register;

import java.util.Date;
import java.util.Scanner;

import com.revature.beans.Messages;
import com.revature.daoimpl.CheckUsernameDAOImpl;
import com.revature.daoimpl.RegistrationDAOImpl;
import com.revature.impl.CheckPassword;

public class RegisterNewAccountJoint {
	private String newFirstName1;
	private String newLastName1;
	private String newUsername1;
	private String newPassword1;
	private String newFirstName2;
	private String newLastName2;
	private String newUsername2;
	private String newPassword2;
	Scanner input = new Scanner(System.in);

	public RegisterNewAccountJoint() {
		welcomeMessage();
		/* Input the information for Person 1 */
		LoopA: while (true) {
			System.out.println("Please enter the following information for Person 1:");
			// LoopD is used to check if the name the user entered is valid.
			LoopD: while (true) {
				firstNameMessage();
				newFirstName1 = input.next();
				if (CheckNameIfValid(newFirstName1)) {
					break LoopD;
				} else {
					errorNameMessage();
				}
			}
			// LoopB is used to check if the name the user entered is valid
			LoopB: while (true) {
				lastNameMessage();
				newLastName1 = input.next();
				if (CheckNameIfValid(newLastName1)) {
					break LoopB;
				} else {
					errorNameMessage();
				}
			}

			// Check if the user name already exists in the database
			Loop2: while (true) {
				usernameMessage();
				newUsername1 = input.next();
				if (checkUsername(newUsername1)) {
					errorUsernameMessage();
				} else {
					passwordMessage();
					Loop3: while (true) {
						newPassword1 = input.next();
						if (!checkPassword(newPassword1, newUsername1)) {
							errorPasswordMessage();
						} else {
							break Loop3;
						}
					}
					break Loop2;
				}
			}
			confirmMessage(newFirstName1, newLastName1, newUsername1, newPassword1);

			switch (input.next()) {
			case "1":
				break LoopA;
			case "2":
				break;
			case "3":
				return;
			default:
				getError();
			}
		}

		/* Input the information for Person 1 */
		LoopA: while (true) {
			System.out.println("Please enter the following information for Person 2:");
			// LoopD is used to check if the name the user entered is valid.
			LoopD: while (true) {
				firstNameMessage();
				newFirstName2 = input.next();
				if (CheckNameIfValid(newFirstName2)) {
					break LoopD;
				} else {
					errorNameMessage();
				}
			}
			// LoopB is used to check if the name the user entered is valid
			LoopB: while (true) {
				lastNameMessage();
				newLastName2 = input.next();
				if (CheckNameIfValid(newLastName2)) {
					break LoopB;
				} else {
					errorNameMessage();
				}
			}

			// Check if the user name already exists in the database
			Loop2: while (true) {
				usernameMessage();
				newUsername2 = input.next();
				if (checkUsername(newUsername2)) {
					errorUsernameMessage();
				} else {
					passwordMessage();
					Loop3: while (true) {
						newPassword2 = input.next();
						if (!checkPassword(newPassword2, newUsername2)) {
							errorPasswordMessage();
						} else {
							break Loop3;
						}
					}
					break Loop2;
				}
			}
			confirmMessage(newFirstName2, newLastName2, newUsername2, newPassword2);

			switch (input.next()) {
			case "1":
				break LoopA;
			case "2":
				break;
			case "3":
				return;
			default:
				getError();
			}
		}
		new RegisterNewAccountJoint(newFirstName1, newLastName1, newUsername1, newPassword1, newFirstName2,
				newLastName2, newUsername2, newPassword2);
		exitMessage();
	}

	/*
	 * This method is used for a joint account for two new users. It creates a new
	 * object to the DAO and sends the Java code to the database.
	 */
	public RegisterNewAccountJoint(String firstName, String lastName, String username, String password,
			String firstName2, String lastName2, String username2, String password2) {
		String tempAccountNumber = dateGenerator();
		new RegistrationDAOImpl().RegisterNewAccount(firstName, lastName, username, password, firstName2, lastName2,
				username2, password2, tempAccountNumber);
	}

	private void confirmMessage(String newFirstName12, String newLastName12, String newUsername12,
			String newPassword12) {
		System.out.print("Is the following information correct?\n\tFirst Name: " + newFirstName12 + "\n\tLast Name: "
				+ newLastName12 + "\n\tUsername: " + newUsername12 + "\n\tPassword: " + newPassword12
				+ "\n1 - Yes, the information above is correct. Continue to Person 2.\n2 - No, I would"
				+ " like to go back and re-enter the information.\n3 - Exit to Main Menu.\n"
				+ "\nPlease enter a number on what you would like to do next: ");

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

	private static void getError() {
		System.out.print(new Messages().getIntroError());
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
	private boolean checkPassword(String str, String username) {
		CheckPassword chk = new CheckPassword();
		return (chk.CheckPasswordIfValid(str) && !(str.equals(username)));
	}

	private String dateGenerator() {
		Date t = new Date();
		return t.getTime() + "";
	}

}
