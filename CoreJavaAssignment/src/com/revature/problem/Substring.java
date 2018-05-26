package com.revature.problem;

public class Substring {
	public static String substring(String str, int idx) {
		char[] letters = str.toCharArray();
		StringBuilder result = new StringBuilder();
		
		for (int i = 0; i < idx; i++) {
			result.append(letters[i]);
		}
		
		return result.toString();
	}
}
