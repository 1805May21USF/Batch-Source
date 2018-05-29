package com.bank.intro.register;

public class CheckPassword {

	public boolean CheckPasswordIfValid(String str) {
		try {
			if (str.length() < 5 || str.length() > 15) {
				return false;
			} else {
				return true;
			}
		} catch (Exception ex) {
			System.out.println("Error: Something went wrong.");
		}
		return false;
	}

}
