package com.revature.BankApp.data.get;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class GetAccounts {
	
	public GetAccounts() {

	}

	/* Check the Person.txt for each matching user name and pulling their balance. */
	public ArrayList<String> getAccounts(String username) {
		ArrayList<String> results = new ArrayList<String>();
		try {
			Scanner input = new Scanner(new File("src\\main\\java\\com\\revature\\BankApp\\data\\PersonBalance.txt"));
			while (input.hasNext()) {
				String t = input.next();
				t = t.replace(',', ' ');
				String[] words = t.split("\\s+");
				if (username.equals(words[0])) {
					results.add(words[2]);
				}
			}
			return results;
		} catch (Exception ex) {
			System.out.println("Error: Something went wrong.");
		}

		return results;
	}

}
