package com.revature.corejavaassignment;

public class Q16NumChars {
	
	private static int numChars(String[] args) {
		return args.length;
	}
	
	public static void numCharsDemo() {
		int numChars;
		String[] input;
		
		System.out.println("Q16. NumChars");
		
		System.out.println("\tI demand the offering of one String. In return,"
				+ " I will give you the number of characters in the String "
				+ "and make it rain in Florida.");
		
		System.out.print("\tString offering: ");
		
		input = AssignmentDemo.in.nextLine().toString(); //Using the static scanner in demo class
		//in.close();
		
		numChars = numChars(input);
		System.out.println("\tThere are " + numChars + " characters in " + input + ".");
		System.out.println("\tPlease allow 0 to 7 business days for Florida rain.\n");
		
	}
	
	public static void main(String[] args) {
		numCharsDemo();
	}

}
