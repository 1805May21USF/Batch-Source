/****************************************************
 * 		Name: Q09									*
 * 		Purpose: Print all the prime numbers from 1 *
 * 				 to 100								*
 * 		Author: Thomas Loyd							*
 ****************************************************/
package com.revature.ten;

import java.util.ArrayList;

public class Q09 {
	public static void prime() {
		// Creates an ArrayList to hold numbers
		ArrayList<Integer> al = new ArrayList<>();
		
		// Adds the numbers 1 to 100 to an ArrayList
		for(int i = 1; i <= 100; i++) {
			al.add(i);
		}
		
		// Tests if any of the numbers in the ArrayList are prime numbers, skips 1 because 1 is not a prime number
		for(int i = 1; i < al.size(); i++) {
			// Counts the number of pairs that can multiply into the provided number
			int count = 0;
			for(int j = 2; j <= al.get(i)/2; j++) {
				/* Takes the number and divides it by an increasing number.
				   If there's a remainder through all of the loops, the number is prime.
				   If there is no remainder, the count value is incremented, stating the number is not a prime number */
				if(!(al.get(i)%j > 0))
					count++;
			}
			// Prints number if it's a prime number
			if(count == 0)
				System.out.println(al.get(i));
		}
	}
}
