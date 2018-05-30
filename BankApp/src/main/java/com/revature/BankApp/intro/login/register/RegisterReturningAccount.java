package com.revature.BankApp.intro.login.register;


import java.util.Date;
import java.util.Scanner;
import com.revature.BankApp.intro.login.*;

public class RegisterReturningAccount {
	private String username;
	private String password;
	private int status;
	private int accountNumber;

	public RegisterReturningAccount() {
		Scanner input = new Scanner(System.in);
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
						errorCommandMessage();
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
				errorCommandMessage();
			}
		}
		exitMessage();
	}

	private void registerUser(String username2, String password2) {
		String[] names = getName(username, password);
		new RegisterNewAccount(names[0], names[1], username, password);
	}

	private void welcomeMessage() {
		System.out.println("Thank you for choosing to apply for an additional account as a returning user!");
	}

	private void greetingMessage() {
		String[] name = getName(username, password);
		System.out.println("Greetings, " + name[0] + " " + name[1]
				+ "!\n\tPlease confirm that you are applying for an additional account using your previous credentials."
				+ "\n\t1 - Yes, I would like to apply for an additional account using my previous credentials.\n\t2 - No, I would like to exit the application.");

	}

	private void usernameMessage() {
		System.out.print("\tPlease enter your username: ");
	}

	private void passwordMessage() {
		System.out.print("\tPlease enter your password: ");
	}

	private void errorCommandMessage() {
		System.out.println("Sorry, we didn't understand your command. Please try again.");
	}

	private void errorUnableToFindUsernameOrPassword() {
		System.out.print(
				"We're sorry. We were unable to find your username or password. Would you like to try again? \n\t1 - retry\n\t2 - exit");
	}

	private void exitMessage() {
		System.out.println("Thank you for applying for a bank account with Tiffany's Banking App. "
				+ "Your application is currently being reviewed by our employees.\nOnce your account has been approved "
				+ "you should be able to withdraw, deposit, and transfer funds between accounts. We will now take you "
				+ "to the previous menu.");
	}

	private String[] getName(String username, String password) {
		GetName gm = new GetName();
		return gm.GetUser(username, password);
	}

	private boolean checkUser(String username2, String password2) {
		CheckUser chk = new CheckUser();
		return chk.CheckIfUserValid(username2, password2);
	}

	public boolean checkUsername(String str) {
		CheckUsername chk = new CheckUsername();
		if (chk.CheckUsernameExists(str)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean CheckNameIfValid(String str) {
		CheckName chk = new CheckName();
		return chk.CheckNameIfValid(str);
	}

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
