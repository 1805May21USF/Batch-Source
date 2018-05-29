package com.bank.intro.register;

import java.io.File;
import java.util.Scanner;

public class CheckUsername {

	public boolean CheckUsernameExists(String str) {
		try {
			Scanner input = new Scanner(new File("src\\com\\bank\\data\\Person.txt"));
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
