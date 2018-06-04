package com.revature.impl.register;

import java.util.Date;
import java.util.Scanner;

import com.revature.beans.Messages;
import com.revature.daoimpl.CheckUserDAOImpl;
import com.revature.daoimpl.GetUserInfoDAOImpl;

public class RegisterReturningAccount {
	private String username;
	private String password;
	private int status;
	private int accountNumber;
	Scanner input = new Scanner(System.in);

	public RegisterReturningAccount() {
		welcomeMessage();

		/*
		 * To apply for an additional account as a returning user, the person must enter
		 * a user name and password that is saved in the Person.txt
		 */
		Loop2: while (true) {
			usernameMessage();
			username = input.next();
			passwordMessage();
			password = input.next();
			if (checkUser(username, password)) {
				break Loop2;
			} else {
				Loop3: while (true) {
					errorUnableToFindUsernameOrPassword();
					String in = input.next();
					if (in.equals("2")) {
						return;
					} else if (in.equals("1")) {
						break Loop3;
					} else {
						getError();
					}
				}
			}
		}
		/*
		 * After a successful login, the getName method will be used to retrieve the
		 * user's first and last name for the greeting. The user will be greeted and
		 * then asked if they are sure they want to send in an application based on
		 * their previous information
		 */
		Loop4: while (true) {
			greetingMessage();
			String in = input.next();
			if (in.equals("1")) {
				registerUser(username, password);
				break Loop4;
			} else if (in.equals("2")) {
				return;
			} else {
				getError();
			}
		}
		exitMessage();
	}

	// Return to the user that there was no matching user name or password
	private void errorUnableToFindUsernameOrPassword() {
		System.out.println(new Messages().getErrorUsernameOrPasswordMessage());
	}

	/* Welcomes the user with a greeting on their selection. */
	private void welcomeMessage() {
		System.out.println(new Messages().getRegisterNewAccountWelcome());
	}

	private void greetingMessage() {
		String[] name = getName(username);
		System.out.println("Greetings, " + name[0] + " " + name[1]
				+ "!\n\tPlease confirm that you are applying for an additional account using your previous credentials."
				+ "\n\t1 - Yes, I would like to apply for an additional account using my previous credentials.\n\t2 - No, I would like to exit the application.");
	}

	/* Prompt the user to enter their username. */
	private void usernameMessage() {
		System.out.print(new Messages().getUsernamePrompt());
	}

	/* Informs the user there was an error in their input */
	private static void getError() {
		System.out.print(new Messages().getIntroError());
	}

	/*
	 * Prompt the user to enter their password. Password must be between 5 to 15
	 * characters.
	 */
	private void passwordMessage() {
		System.out.print(new Messages().getPasswordPrompt());
	}
	
	/* Prints a message that their application was submitted. */
	private void exitMessage() {
		System.out.print(new Messages().getRegisterExitMessage());
	}

	private void registerUser(String username2, String password2) {
		String[] names = getName(username);
		new RegisterNewAccount(names[0], names[1], username, password);
	}

	private String[] getName(String username) {
		String[] result = new String[2];
		result[0] = new GetUserInfoDAOImpl().getUserFirstName(username);
		result[1] = new GetUserInfoDAOImpl().getUserLastName(username);
		return result;
	}

	/* Checks if the user is in the database*/
	private boolean checkUser(String username2, String password2) {
		return new CheckUserDAOImpl().checkUserAndPassword(username2, password2);
	}
//
//	public boolean checkUsername(String str) {
//		CheckUsername chk = new CheckUsername();
//		if (chk.CheckUsernameExists(str)) {
//			return true;
//		} else {
//			return false;
//		}
//	}
//
//	public boolean CheckNameIfValid(String str) {
//		CheckName chk = new CheckName();
//		return chk.CheckNameIfValid(str);
//	}

	public String dateGenerator() {
		Date t = new Date();
		return t.getTime() + "";
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
