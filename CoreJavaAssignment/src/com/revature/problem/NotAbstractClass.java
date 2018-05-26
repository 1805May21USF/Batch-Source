package com.revature.problem;

public class NotAbstractClass extends AbstractClass {
	@Override
	public boolean checkForUppercase(String str) {
		char[] letters = str.toCharArray();
		
		for (char letter : letters) {
			if (Character.isUpperCase(letter)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String convertToUppercase(String str) {
		return str.toUpperCase();
	}

	@Override
	public int convertStringToInt(String str) {
		return Integer.parseInt(str) + 10;
	}	
}
