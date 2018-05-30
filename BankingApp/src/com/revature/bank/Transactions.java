package com.revature.bank;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public interface Transactions {
	
	String accountsFileName = "accounts.txt";
	
	public static void transaction(int accountNumber, double amount, boolean isDeposit) {
		Scanner accountsScanner = null;
		
		File file = new File(accountsFileName);
		
		if (!file.exists())
			System.out.println("No accounts available for deposit.");
		else if (amount <= 0) {
			System.out.println("Amount must be positive and greater than 0.");
		} else {
			try {
				accountsScanner = new Scanner(new File(accountsFileName));
			} catch (FileNotFoundException e) {
				System.out.println("Unable to locate accounts file.");
			}
			while (accountsScanner.hasNextLine()) {
				String account = accountsScanner.nextLine();
				String[] accountInfo = account.split(":");
				for (String i : accountInfo) {
					if (i == String.valueOf(accountNumber)) {
						int currentAmount = Integer.valueOf(accountInfo[accountInfo.length - 1]);
						if (isDeposit)
							currentAmount += amount;
					}
				}
				accountsScanner.
				
			}
		}
	}

}
