/****************************************************
 * 		Name: Q04									*
 * 		Purpose: Takes a numerical input and prints *
 * 				 the factorial of the entered    	*
 * 				 number                             *
 * 		Author: Thomas Loyd							*
 ****************************************************/
package com.revature.ten;

import java.util.Scanner;

public class Q04 {
	public static void factorial(Scanner scan) {
		// Creates a flag to keep requesting input until a number is entered
		boolean flag = true;
		
		while(flag) {
			// Requests a number
			System.out.println("Please enter a factorial: ");
			String input = scan.nextLine();
		
			try {
				// Creates long to store the factorial
				long value = 1;
				
				// Calculates the factorial
				for(int i = Integer.parseInt(input); i > 0; i--) {
					value *= i;
				}
				
				// Prints the initial value and the factorial value
				System.out.println(input + " factorial is " + value);
				
				flag = false;
			// Executes if a number wasn't provided
			}catch(NumberFormatException e) {
				System.out.println("That wasn't a number!");
			}
		}
	}
}
