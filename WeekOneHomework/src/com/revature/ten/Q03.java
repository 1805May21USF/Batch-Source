/****************************************************
 * 		Name: Q03									*
 * 		Purpose: Reverse a provided String without  *
 * 				 using the reverse method or a   	*
 * 				 temporary variable                 *
 * 		Author: Thomas Loyd							*
 ****************************************************/
package com.revature.ten;

public class Q03 {
	public static void reverse() {
		// The String to be reversed
		String input = "What do you do with a sleeping whaler?";
		// Prints the initial String
		System.out.println(input);
		// Prints the String in reverse
		for(int i = input.length() - 1; i >= 0; i--) {
			System.out.print(input.charAt(i));
		}
		// Moves to the next line on the console
		System.out.println();
	}
}
