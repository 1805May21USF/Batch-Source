/****************************************************
 * 		Name: Q13									*
 * 		Purpose: Uses a nested for loop to print a  *
 * 				 alternating binary triangle        *
 * 		Author: Thomas Loyd							*
 ****************************************************/
package com.revature.twenty;

public class Q13 {
	public static void triangle() {
		// Sets the number to be print
		int value = 0;
		
		// A nested for loop used to structure an image
		for(int i = 1; i <= 4; i++) {
			for(int j = 0; j < i ; j++) {
				// Prints the value the required number of times
				System.out.print(value);
				// Alternates the value to be print
				if(value == 0)
					value = 1;
				else
					value = 0;
			}
			// Moves to the next line
			System.out.println();
		}
	}
}