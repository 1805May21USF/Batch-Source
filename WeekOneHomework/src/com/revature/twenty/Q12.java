/****************************************************
 * 		Name: Q12									*
 * 		Purpose: Prints all the even numbers between*
 * 				 1 and 100 using an enhanced for    *
 * 				 loop								*
 * 		Author: Thomas Loyd							*
 ****************************************************/
package com.revature.twenty;

public class Q12 {
	public static void printEven() {
		// Creates and fills an integer array with all the numbers from 1 to 100
		int[] numbers = new int[100];
		for(int i = 0; i < numbers.length; i++) {
			numbers[i] = i + 1;
		}
		// Uses an enhanced for loop to print the even numbers stored in the numbers array
		for(int i : numbers) {
			if((i % 2) == 0)
				System.out.println(i);
		}
	}
}
