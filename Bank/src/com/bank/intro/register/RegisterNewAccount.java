package com.bank.intro.register;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
		System.out.println("Thank you for choosing to apply for an account as a new user!");
		// LoopA is used to check if the name the user entered is valid.
		LoopA: while (true) {
			System.out.print("Please enter your first name: ");
			newFirstName = input.next();
			if (CheckNameIfValid(newFirstName)) {
				break LoopA;
			} else {
				System.out.println("Error: A name does not contain numbers or symbols. Please try again.");
			}
		}
		// LoopB is used to check if the name the user entered is valid
		LoopB: while (true) {
			System.out.print("\tPlease enter your last name: ");
			newLastName = input.next();
			if (CheckNameIfValid(newLastName)) {
				break LoopB;
			} else {
				System.out.println("Error: A name does not contain numbers or symbols. Please try again.");
			}
		}
		
		// Check if the user name already exists in the database
		System.out.print("\tPlease enter a username: ");
		Loop2: while (true) {
			newUsername = input.next();
			if (checkUsername(newUsername)) {
				System.out.println(
						"Sorry, but the username \"" + newUsername + "\" already exists. Please enter a username: ");
			} else {
				System.out.print("\tPlease enter a password between 5 - 15 characters: ");
				Loop3: while (true) {
					newPassword = input.next();
					if (!checkPassword(newPassword)) {
						System.out.print("Sorry, but your password is not valid. Please enter a new password: ");
					} else {
						break Loop3;
					}
				}
				break Loop2;
			}
		}
		new RegisterNewAccount(newFirstName, newLastName, newUsername, newPassword);
		System.out.println("Thank you for applying for a bank account with Tiffany's Banking App. "
				+ "Your application is currently being reviewed by our employees.\nOnce your account has been approved "
				+ "you should be able to withdraw, deposit, and transfer funds between accounts. We will now take you "
				+ "to the main menu.");
	}

	public RegisterNewAccount(String firstName, String lastName, String username, String password) {
		String tempAccountNumber = dateGenerator();

		try (FileWriter fw = new FileWriter("src\\com\\bank\\data\\Person.txt", true);
				BufferedWriter bw = new BufferedWriter(fw);
				PrintWriter out = new PrintWriter(bw)) {
			out.println(firstName + "," + lastName + "," + username + "," + password + "," + status + ","
					+ tempAccountNumber);
		} catch (Exception ex) {
			System.out.println("Exception was caught at accessing Person.txt: " + ex.getMessage());
		}
	}

	public RegisterNewAccount(String firstName1, String lastName1, String username1, String password1,
			String firstName2, String lastName2, String username2, String password2) {
		String tempAccountNumber = dateGenerator();

		try (FileWriter fw = new FileWriter("src\\com\\bank\\data\\Person.txt", true);
				BufferedWriter bw = new BufferedWriter(fw);
				PrintWriter out = new PrintWriter(bw)) {
			out.println(firstName1 + "," + lastName1 + "," + username1 + "," + password1 + "," + status + ","
					+ tempAccountNumber);
			out.println(firstName2 + "," + lastName2 + "," + username2 + "," + password2 + "," + status + ","
					+ tempAccountNumber);
		} catch (Exception ex) {
			System.out.println("Exception was caught at accessing Person.txt: " + ex.getMessage());
		}
	}

	public boolean checkUsername(String str) {
		CheckUsername chk = new CheckUsername();
		if (chk.CheckUsernameExists(str)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean checkPassword(String str) {
		CheckPassword chk = new CheckPassword();
		return (chk.CheckPasswordIfValid(str) && !(str.equals(newUsername)));
	}

	public boolean CheckNameIfValid(String str) {
		CheckName chk = new CheckName();
		return chk.CheckNameIfValid(str);
	}

	public String dateGenerator() {
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
