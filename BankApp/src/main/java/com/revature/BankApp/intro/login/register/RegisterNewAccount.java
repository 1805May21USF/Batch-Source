package com.revature.BankApp.intro.login.register;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Scanner;

public class RegisterNewAccount {
	private String newFirstName;
	private String newLastName;
	private String newUsername;
	private String newPassword;
	private int status;
	private int accountNumber;
	Scanner input = new Scanner(System.in);

	public RegisterNewAccount() {
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
		usernameMessage();
		Loop2: while (true) {
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
	 * name and one password.
	 */
	public RegisterNewAccount(String firstName, String lastName, String username, String password) {
		String tempAccountNumber = dateGenerator();
		// Write into the Person.txt
		try (FileWriter fw = new FileWriter("src\\main\\java\\com\\revature\\BankApp\\data\\Person.txt", true);
				BufferedWriter bw = new BufferedWriter(fw);
				PrintWriter out = new PrintWriter(bw)) {
			out.println(firstName + "," + lastName + "," + username + "," + password + "," + status + ","
					+ tempAccountNumber);
		} catch (Exception ex) {
			System.out.println("Exception was caught at accessing Person.txt: " + ex.getMessage());
		}
		// Write into the PersonBalance.txt
		try (FileWriter fw = new FileWriter("src\\main\\java\\com\\revature\\BankApp\\data\\PersonBalance.txt", true);
				BufferedWriter bw = new BufferedWriter(fw);
				PrintWriter out = new PrintWriter(bw)) {
			out.println(username + "," + tempAccountNumber + ",0.00");
		} catch (Exception ex) {
			System.out.println("Exception was caught at accessing PersonBalance.txt: " + ex.getMessage());
		}
	}

	/*
	 * This method is used for a joint account. It accepts two user names and two
	 * passwords, but assigns the same account number.
	 */
	public RegisterNewAccount(String firstName1, String lastName1, String username1, String password1,
			String firstName2, String lastName2, String username2, String password2) {
		String tempAccountNumber = dateGenerator();
		
		try (FileWriter fw = new FileWriter("src\\main\\java\\com\\revature\\BankApp\\data\\Person.txt", true);
				BufferedWriter bw = new BufferedWriter(fw);
				PrintWriter out = new PrintWriter(bw)) {
			out.println(firstName1 + "," + lastName1 + "," + username1 + "," + password1 + "," + status + ","
					+ tempAccountNumber);
			out.println(firstName2 + "," + lastName2 + "," + username2 + "," + password2 + "," + status + ","
					+ tempAccountNumber);
		} catch (Exception ex) {
			System.out.println("Exception was caught at accessing Person.txt: " + ex.getMessage());
		}
		// Write into the PersonBalance.txt
		try (FileWriter fw = new FileWriter("src\\main\\java\\com\\revature\\BankApp\\data\\Person.txt", true);
				BufferedWriter bw = new BufferedWriter(fw);
				PrintWriter out = new PrintWriter(bw)) {
			out.println(username1 + "," + tempAccountNumber + ",0.00");
			out.println(username2 + "," + tempAccountNumber + ",0.00");
		} catch (Exception ex) {
			System.out.println("Exception was caught at accessing PersonBalance.txt: " + ex.getMessage());
		}
	}

	/*
	 * A method that calls onto the class CheckUsername to check if the user name is
	 * unique.
	 */
	private boolean checkUsername(String str) {
		CheckUsername chk = new CheckUsername();
		if (chk.CheckUsernameExists(str)) {
			return true;
		} else {
			return false;
		}
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

	/*
	 * A method that calls onto the class CheckName to check if the user name the
	 * user entered is valid.
	 */
	private boolean CheckNameIfValid(String str) {
		CheckName chk = new CheckName();
		return chk.CheckNameIfValid(str);
	}

	/* Welcomes the user with a greeting on their selection. */
	private void welcomeMessage() {
		System.out.println("Thank you for choosing to apply for an account as a new user!");
	}

	/* Prompt the user to enter their first name. */
	private void firstNameMessage() {
		System.out.print("\tPlease enter your first name: ");
	}

	/* Prompt the user to enter their last name. */
	private void lastNameMessage() {
		System.out.print("\tPlease enter your last name: ");
	}

	/* Prompt the user to enter their username. */
	private void usernameMessage() {
		System.out.print("\tPlease enter a username: ");
	}

	/*
	 * Prompt the user to enter their password. Password must be between 5 to 15
	 * characters.
	 */
	private void passwordMessage() {
		System.out.print("\tPlease enter a password between 5 - 15 characters: ");
	}

	/*
	 * Prompts the user that the user name they have entered cannot be used.
	 * Therefore the user must enter a different user name.
	 */
	private void errorUsernameMessage() {
		System.out.println("Sorry, but the username \"" + newUsername + "\" already exists. Please enter a username: ");
	}

	/* */
	private void errorPasswordMessage() {
		System.out.print("Sorry, but your password is not valid. Please enter a new password: ");
	}

	/* Prints a message that their application was submitted or not. */
	private void exitMessage() {
		System.out.println("Thank you for applying for a bank account with Tiffany's Banking App. "
				+ "Your application is currently being reviewed by our employees.\nOnce your account has been approved "
				+ "you should be able to withdraw, deposit, and transfer funds between accounts. We will now take you "
				+ "to the previous menu.");
	}

	/*
	 * Prompts the user that there was a error in their name and to try again with a
	 * different name.
	 */
	private void errorNameMessage() {
		System.out.println("Error: A name does not contain numbers or symbols. Please try again.");
	}

	private String dateGenerator() {
		Date t = new Date();
		return t.getTime() + "";
	}

	public String getNewFirstName() {
		return newFirstName;
	}

	public void setNewFirstName(String newFirstName) {
		this.newFirstName = newFirstName;
	}

	public String getNewLastName() {
		return newLastName;
	}

	public void setNewLastName(String newLastName) {
		this.newLastName = newLastName;
	}

	public String getNewUsername() {
		return newUsername;
	}

	public void setNewUsername(String newUsername) {
		this.newUsername = newUsername;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public Scanner getInput() {
		return input;
	}

	public void setInput(Scanner input) {
		this.input = input;
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

	@Override
	public String toString() {
		return "RegisterNewAccount [newFirstName=" + newFirstName + ", newLastName=" + newLastName + ", newUsername="
				+ newUsername + ", newPassword=" + newPassword + ", status=" + status + ", accountNumber="
				+ accountNumber + ", input=" + input + "]";
	}

}
