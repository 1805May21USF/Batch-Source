package com.revature.corejavaassignment;

public class Q16NumChars {
	
	private static int numChars(String input) {
		return input.length();
	}
	
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
		/*int numChars;
		String[] input;
		
		System.out.println("Q16. NumChars");
		
		System.out.println("\tI demand the offering of one String. In return,"
				+ " I will give you the number of characters in the String "
				+ "and make it rain in Florida.");
		
		System.out.print("\tString offering: ");
		
		String input = AssignmentDemo.in.toString();
		
		numChars = numChars(input);
		System.out.println("\tThere are " + numChars + " characters in " + input + ".");
		System.out.println("\tPlease allow 0 to 7 business days for Florida rain. Roll Tide!\n");
		*/
	}
	
	public static void main(String[] args) {
		numCharsDemo(args);
	}

}
