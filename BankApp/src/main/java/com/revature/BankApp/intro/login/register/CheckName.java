package com.revature.BankApp.intro.login.register;

public class CheckName {
	public boolean CheckNameIfValid(String str) {
		try {
			boolean flag = false;
			for (int i = 0; i < str.length(); i++) {
				if (str.toUpperCase().charAt(i) >= 'A' && str.toUpperCase().charAt(i) <= 'Z') {
					flag = true;
				}
			}
			return flag;
		} catch (Exception ex) {
			System.out.println("Error: Something went wrong.");
		}
		return false;
	}
}
