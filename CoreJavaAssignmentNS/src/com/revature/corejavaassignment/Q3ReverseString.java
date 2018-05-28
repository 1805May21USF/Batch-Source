package com.revature.corejavaassignment;

/**
 * Reverses a String.
 * @author Nathaniel Simpson
 *
 */
public class Q3ReverseString {
	
	/*
	 * Reverses a String by swapping the outer characters
	 * in the String and working its way to the middle
	 * character.
	 * @param input - the String to be reversed.
	 * @return reversed String.
	 */
	public static String reverseString(String input) {
		
		char[] charArray = input.toCharArray();
		
		for (int i = 0; i < charArray.length / 2; i++) {
			char temp = charArray[i];
			charArray[i] = charArray[charArray.length - i - 1];
			charArray[charArray.length - i - 1] = temp;
		}
		
		return new String(charArray);
		
	}
	
	/*
	 * Demonstrates outputting a reversed String in the console.
	 * @param input - String to be reversed.
	 */
	public static void reverseStringDemo(String input) {
		System.out.print("Q3. Reverse String\n");
		System.out.println("\tBefore Reverse: " + input);
		System.out.println("\tAfter Reverse: " + reverseString(input));
		System.out.println(); //Making room for Q4
	}
	
	/*
	 * Used for testing
	 */
	public static void main(String[] args) {
		reverseStringDemo("Hello, how are you? Roll Tide!");
	}

}
