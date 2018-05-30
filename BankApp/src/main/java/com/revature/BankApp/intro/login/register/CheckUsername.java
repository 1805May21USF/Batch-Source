package com.revature.BankApp.intro.login.register;

import java.io.File;
import java.util.Scanner;

public class CheckUsername {
	/* Check if the user name exists in the Person.txt file */
	public boolean CheckUsernameExists(String str) {
		try {
			Scanner input = new Scanner(new File("src\\main\\java\\com\\revature\\BankApp\\data\\Person.txt"));
			while (input.hasNext()) {
				String t = input.next();
				t = t.replace(',', ' ');
				String[] words = t.split("\\s+");
				if (str.toLowerCase().equals(words[0].toLowerCase())) {
					return true;
				}
			}

		} catch (Exception ex) {
			System.out.println("Error: Something went wrong.");
		}
		return false;
	}
}
