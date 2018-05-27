package com.revature.corejavaassignment;

public class Q3ReverseString {
	
	public static String reverseString(String input) {
		
		char[] charArray = input.toCharArray();
		
		for (int i = 0; i < charArray.length / 2; i++) {
			char temp = charArray[i];
			charArray[i] = charArray[charArray.length - i - 1];
			charArray[charArray.length - i - 1] = temp;
		}
		
		return new String(charArray);
		
	}
	
	public static void reverseStringDemo(String input) {
		System.out.print("Q3. Reverse String\n");
		System.out.println("\tBefore Reverse: " + input);
		System.out.println("\tAfter Reverse: " + reverseString(input));
		System.out.println(); //Making room for Q4
	}
	
	public static void main(String[] args) {
		reverseStringDemo("Hello, how are you? Roll Tide!");
	}

}
