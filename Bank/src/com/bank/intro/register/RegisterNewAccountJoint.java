package com.bank.intro.register;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Scanner;

public class RegisterNewAccountJoint {
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private String newFirstName1;
	private String newLastName1;
	private String newUsername1;
	private String newPassword1;
	private String newFirstName2;
	private String newLastName2;
	private String newUsername2;
	private String newPassword2;
	private int status;
	private int accountNumber;
	Scanner input = new Scanner(System.in);

	public RegisterNewAccountJoint() {
		System.out.print("Thank you for choosing to apply for an account as a new user! ");
		/* Input the information for Person 1 */
		LoopA: while (true) {
			// LoopD is used to check if the name the user entered is valid.
			LoopD: while (true) {
				System.out.print(
						"Please enter the necessary information " + "for each person. \n\tPerson 1's First Name: ");
				newFirstName1 = input.next();
				if (CheckNameIfValid(newFirstName1)) {
					break LoopD;
				} else {
					System.out.println("Error: A name does not contain numbers or symbols. Please try again.");
				}
			}
			// LoopB is used to check if the name the user entered is valid
			LoopB: while (true) {
				System.out.print("\tPerson 1's Last Name: ");
				newLastName1 = input.next();
				if (CheckNameIfValid(newLastName1)) {
					break LoopB;
				} else {
					System.out.println("Error: A name does not contain numbers or symbols. Please try again.");
				}
			}

			// Check if the user name already exists in the database
			System.out.print("\tPerson 1's Username: ");
			Loop2: while (true) {
				newUsername1 = input.next();
				if (checkUsername(newUsername1)) {
					System.out.println("Sorry, but the username \"" + newUsername1
							+ "\" already exists. Please enter a username for Person 1: ");
				} else {
					System.out.print("\tPerson 1's Password between 5 - 15 characters: ");
					Loop3: while (true) {
						newPassword1 = input.next();
						if (!checkPassword(newPassword1)) {
							System.out.print(
									"Sorry, but your password is not valid. Please enter a new password for Person 1: ");
						} else {
							break Loop3;
						}
					}
					break Loop2;
				}
			}
			System.out.print("Is the following information correct?\n\tFirst Name: " + newFirstName1 + "\n\tLast Name: "
					+ newLastName1 + "\n\tUsername: " + newUsername1 + "\n\tPassword: " + newPassword1
					+ "\n1 - Yes, the information above is correct. Continue to Person 2.\n2 - No, I would"
					+ " like to go back and re-enter the information.\n3 - Exit to Main Menu."
					+ "\nPlease enter a number on what you would like to do next: ");
			switch (input.next()) {
			case "1":
				break LoopA;
			case "2":
				break;
			case "3":
				return;
			default:
				System.out.println("Sorry, we didn't understand that. Please try again.");
			}
		}
		/* Input the information for Person 2 */
		LoopA: while (true) {
			// LoopA is used to check if the name the user entered is valid.
			LoopD: while (true) {
				System.out.print(
						"Please enter the necessary information " + " for each person. \n\tPerson 2's First Name: ");
				newFirstName2 = input.next();
				if (CheckNameIfValid(newFirstName2)) {
					break LoopD;
				} else {
					System.out.println("Error: A name does not contain numbers or symbols. Please try again.");
				}
			}
			// LoopB is used to check if the name the user entered is valid
			LoopB: while (true) {
				System.out.print("\tPerson 2's Last Name: ");
				newLastName2 = input.next();
				if (CheckNameIfValid(newLastName2)) {
					break LoopB;
				} else {
					System.out.println("Error: A name does not contain numbers or symbols. Please try again.");
				}
			}
			// Check if the user name already exists in the database
			System.out.print("\tPerson 2's Username: ");
			Loop2: while (true) {
				newUsername2 = input.next();
				if (checkUsername(newUsername2)) {
					System.out.println("Sorry, but the username \"" + newUsername1
							+ "\" already exists. Please enter a username for Person 2: ");
				} else {
					System.out.print("\tPerson 2's Password between 5 - 15 characters: ");
					Loop3: while (true) {
						newPassword2 = input.next();
						if (!checkPassword(newPassword1)) {
							System.out.print(
									"Sorry, but your password is not valid. Please enter a new password for Person 2: ");
						} else {
							break Loop3;
						}
					}
					break Loop2;
				}
			}
			System.out.print("Is the following information correct?\n\tFirst Name: " + newFirstName2 + "\n\tLast Name: "
					+ newLastName2 + "\n\tUsername: " + newUsername2 + "\n\tPassword: " + newPassword2
					+ "\n1 - Yes, the information above is correct. Submit account application.\n2 - No, I would"
					+ " like to go back and re-enter the information.\n3 - Exit to Main Menu"
					+ "\nPlease enter a number on what you would like to do next: ");
			switch (input.next()) {
			case "1":
				break LoopA;
			case "2":
				break;
			case "3":
				return;
			default:
				System.out.println("Sorry, we didn't understand that. Please try again.");
			}
		}

		RegisterNewAccount r = new RegisterNewAccount(newFirstName1, newLastName1, newUsername1, newPassword1,
				newFirstName2, newLastName2, newUsername2, newPassword2);
		System.out.println("Thank you for applying for a bank account with Tiffany's Banking App. "
				+ "Your application is currently being reviewed by our employees.\nOnce your account has been approved "
				+ "you should be able to withdraw, deposit, and transfer funds between accounts. We will now take you "
				+ "to the main menu.");
	}

	public boolean CheckNameIfValid(String str) {
		CheckName chk = new CheckName();
		return chk.CheckNameIfValid(str);
	}

	public RegisterNewAccountJoint(String firstName, String lastName, String username, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
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
		return (chk.CheckPasswordIfValid(str) && !(str.equals(username)));
	}

	public String dateGenerator() {
		Date t = new Date();
		return t.getTime() + "";
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
		return "RegisterNewAccount [firstName=" + firstName + ", lastName=" + lastName + ", username=" + username
				+ ", password=" + password + ", accountNumber=" + accountNumber + "]";
	}

}
