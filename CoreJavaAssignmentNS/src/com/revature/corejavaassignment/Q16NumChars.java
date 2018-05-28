package com.revature.corejavaassignment;

/**
 * Finds the number of characters in a String from
 * the program arguments from the run
 * configurations.
 * @author Nathaniel Simpson
 *
 */
public class Q16NumChars {
	
	/*
	 * Finds the length of a String.
	 * @param input - String to find the length of
	 * @return the length of the input String 
	 */
	private static int numChars(String input) {
		return input.length();
	}
	
	/*
	 * Demonstrates the numChars method.
	 */
	public static void numCharsDemo(String[] args) {
		System.out.println("Q16. NumChars");
		try {
			String input = args[0];
			System.out.println("\tThere are " + numChars(input) + " characters in " + input + ".");
			System.out.println();
		} catch (Exception e) {
			System.out.println("Please provide arguments for the thing.");
			System.out.println();
		}
	}
	
	/*
	 * For testing
	 */
	public static void main(String[] args) {
		numCharsDemo(args);
	}

}
