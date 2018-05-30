package com.revature.BankApp.intro.login.register;


import java.io.File;
import java.util.Scanner;

public class GetName {
	public String[] GetUser(String username, String password) {
		try {
			String[] result = new String[2];
			Scanner input = new Scanner(new File("src\\main\\java\\revature\\BankApp\\data\\Person.txt"));
			while (input.hasNext()) {
				String t = input.next();
				t = t.replace(',', ' ');
				String[] words = t.split("\\s+");
				if (username.equals(words[2]) && password.equals(words[3])) {
					result[0] = words[0];
					result[1] = words[1];
					return result;
				}
			}

		} catch (Exception ex) {
			System.out.println("Error: Something went wrong.");
		}
		return new String[2];
	}
}
