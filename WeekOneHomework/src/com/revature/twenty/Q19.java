/****************************************************
 * 		Name: Q19									*
 * 		Purpose: Prints all the numbers between 1   *
 * 				 and 10, and separately prints all  *
 * 				 the even, odd, and non-prime       *
 *               numbers between 1 and 10           *
 * 		Author: Thomas Loyd							*
 ****************************************************/
package com.revature.twenty;

import java.util.ArrayList;

public class Q19 {
	public static void printSpecial() {
		// Creates and fills an ArrayList to hold the numbers 1 through 10
		ArrayList<Integer> numbers = new ArrayList<>();
		for(int i = 0; i < 10; i++) {
			numbers.add(i + 1);
		}
		
		// Prints the numbers in the ArrayList
		System.out.println("Numbers 1 through 10:");
		for(int i : numbers) {
			System.out.println(i);
		}
		
		// Prints the even numbers in the ArrayList
		System.out.println("Even numbers between 1 and 10");
		for(int i : numbers) {
			if((i % 2) == 0)
				System.out.println(i);
		}
		
		// Prints the odd numbers in the ArrayList
		System.out.println("Odd numbers between 1 and 10:");
		for(int i : numbers) {
			if((i % 2) != 0)
				System.out.println(i);
		}
		
		// Tests if any of the numbers in the ArrayList are prime numbers, skips 1 because 1 is not a prime number
		for(int i = 1; i < numbers.size(); i++) {
			// Counts the number of pairs that can multiply into the provided number
			int count = 0;
			for(int j = 2; j <= numbers.get(i)/2; j++) {
				/* Takes the number and divides it by an increasing number.
				   If there's a remainder through all of the loops, the number is prime.
				   If there is no remainder, the count value is incremented, stating the number is not a prime number */
				if(!(numbers.get(i)%j > 0))
					count++;
			}
			// Specifies that two is an exception to the rule
			if(count == 0 && numbers.get(i) != 2) {
				// Removes prime numbers from the ArrayList
				numbers.remove(i);
				i = 0;
			}
		}
		
		// Prints the remaining numbers in the ArrayList
		System.out.println("Non-prime numbers between 1 and 10:");
		for(int i : numbers) {
			System.out.println(i);
		}
	}
}
