package com.revature.problem;

public class Reverse {
	public static String reverse(String str) {
		char[] letters = str.toCharArray();
		StringBuilder result = new StringBuilder();
		
		for (int i = letters.length-1; i >= 0; i--) {
			result.append(letters[i]);
		}
		
		return result.toString();
	}
}
