/****************************************************
 * 		Name: Q05									*
 * 		Purpose: Takes input and an index and prints*
 * 				 a substring of the input       	*
 * 		Author: Thomas Loyd							*
 ****************************************************/
package com.revature.ten;

import java.util.Scanner;

public class Q05 {
	public static void substring(Scanner scan) {
		// Requests that the user enter a String
		System.out.println("Please enter a string: ");
		
		String input = scan.nextLine();
		
		boolean flag = true;
		
		// Runs until the user enters a valid number
		while(flag) {
			// Requests the user enter a number
			System.out.println("Please enter a number: ");
			try {
				int idx = Integer.parseInt(scan.nextLine());
				
				// Tests f the entered number larger than the length of the String or is less than 0
				if(idx > input.length())
					System.out.println("Index is larger than the word!");
				else if (idx < 0)
					System.out.println("Index must be greater than 0");
				// Executes if the entered number is valid
				else {
					System.out.println("Substring is " + substring(input, idx));
					flag = false;
				}
			// Executes if the user doesn't enter a number
			}catch(NumberFormatException e) {
				System.out.println("That wasn't a number!");
			}
		}
	}
	
	public static String substring(String str, int idx) {
		// Creates an empty StringBuilder
		StringBuilder sub = new StringBuilder("");
		
		// Uses the StringBuilder and a for loop to create a substring
		for(int i = 0; i < idx; i++) {
			sub.append(str.charAt(i));
		}
		
		// Returns the substring
		return sub.toString();
	}
}
