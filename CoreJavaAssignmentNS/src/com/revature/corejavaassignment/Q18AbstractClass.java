package com.revature.corejavaassignment;

/**
 * Super class for analyzing and
 * manipulating Strings.
 * @author Nathaniel Simpson
 *
 */
public abstract class Q18AbstractClass {
	
	/*
	 * Determines if a String has upper case characters.
	 * @param str - input String
	 * @return true if has upper case, false if not
	 */
	public static boolean hasUpperCase(String str) {
		
		char[] characters = str.toCharArray();
		
		for(char c : characters) {
			if (Character.isUpperCase(c))
				return true;
		}
		return false;
	}
	
	/*
	 * Creates a new String from an input String
	 * with all upper case characters.
	 * @param str - input String
	 * @return upper case String
	 */
	public static String toUpperCase(String str) {
		
		char[] characters = str.toCharArray();
		
		for(int i = 0; i < str.length(); i++) {
			if(Character.isLowerCase(str.charAt(i)))
				characters[i] = Character.toUpperCase(str.charAt(i));
		}
		
		return new String(characters);
		
	}
	
	/*
	 * Returns an integer from the sum of a String
	 * number value and 10.
	 * @param str - input String
	 * @return str number value + 10
	 */
	public static int stringToIntPlus10(String str) {
		return Integer.parseInt(str) + 10;
	}

}
