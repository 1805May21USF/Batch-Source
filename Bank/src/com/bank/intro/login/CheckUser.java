package com.bank.intro.login;

import java.io.File;
import java.util.Scanner;

public class CheckUser {

	/*
	 * This method opens the Person.txt and reads each line. Each line is converted
	 * into a String array. We know that the user name and password array positions
	 * at words[2] and words[3]
	 */
	public boolean CheckIfUserValid(String username, String password) {
		try {
			Scanner input = new Scanner(new File("src\\com\\bank\\data\\Person.txt"));
			while (input.hasNext()) {
				String t = input.next();
				t = t.replace(',', ' ');
				String[] words = t.split("\\s+");
				if (username.equals(words[2]) && password.equals(words[3])) {
					return true;
				}
			}

		} catch (Exception ex) {
			System.out.println("Error: Something went wrong.");
		}
		return false;
	}

	/*
	 * THis method opens the Person.txt and reads each line. Each line is converted
	 * into a String array. We know the status position in the array at words[4].
	 * The reason that we want to know of the person's status is to determine what
	 * permissions they are given.
	 */
	public int CheckUserStatus(String username, String password) {
		try {
			Scanner input = new Scanner(new File("src\\com\\bank\\data\\Person.txt"));
			while (input.hasNext()) {
				String t = input.next();
				t = t.replace(',', ' ');
				String[] words = t.split("\\s+");
				if (username.equals(words[2]) && password.equals(words[3])) {
					return Integer.parseInt(words[4]);
				}
			}

		} catch (Exception ex) {
			System.out.println("Error: Something went wrong.");
		}
		return 0;
	}

}
