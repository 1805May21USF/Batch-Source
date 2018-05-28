package com.revature.corejavaassignment;

/**
 * Creates a substring from an input String by adding 
 * the first n characters to a new String.
 * @author Nathaniel Simpson
 *
 */
public class Q5Substring {
	
	/*
	 * Creates a substring from an input String.
	 * @param str - input String
	 * @param idx - index for where to end the substring.
	 * @return the substring
	 */
	private static String substring(String str, int idx) {
		if (idx >= str.length())
			return str;
		
		String substring = "";
		for (int i = 0; i < idx; i++) {
			substring += str.charAt(i);
		}
		
		return substring;
	}
	
	/*
	 * Demonstrates creating substrings.
	 * @param str - input String
	 * @param idx - index for where to end the substring.
	 */
	public static void substringDemo(String str, int idx) {
		System.out.println("\tIndex = " + idx + ": " + substring(str, idx));
	}
	
	/*
	 * For testing
	 */
	public static void main(String[] args) {
		substringDemo("Roll Tide!", 5);
		substringDemo("Roll Tide!", 7);
		substringDemo("Roll Tide!", 700);
	}

}
