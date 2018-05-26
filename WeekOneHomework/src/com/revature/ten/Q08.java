/****************************************************
 * 		Name: Q08									*
 * 		Purpose: Take a list of words and copy the  *
 * 				 palindromes to another ArrayList	*
 * 		Author: Thomas Loyd							*
 ****************************************************/
package com.revature.ten;

import java.util.ArrayList;

public class Q08 {

	public static void palindromeArrayList() {
		// Creates an ArrayList for words and palindromes
		ArrayList<String> strings = new ArrayList<>();
		ArrayList<String> palindromes = new ArrayList<>();
		
		// Adds Strings to the ArrayList
		strings.add("karan");
		strings.add("madam");
		strings.add("tom");
		strings.add("civic");
		strings.add("radar");
		strings.add("jimmy");
		strings.add("kayak");
		strings.add("john");
		strings.add("refer");
		strings.add("billy");
		strings.add("did");
		
		// Prints the ArrayList of words
		System.out.println("List of words:");
		print(strings);
		
		// Sends all of the Strings in strings to the isPalindrome method
		for(String s : strings) {
			if(isPalindrome(s))
				palindromes.add(s);
		}
		
		// Prints out the ArrayList of palindromes
		System.out.println("List of palindromes:");
		print(palindromes);
	}
	
	private static boolean isPalindrome(String s) {
		// Creates a StringBuilder to reverse the provided String
		StringBuilder sb = new StringBuilder(s);
		sb = sb.reverse();
		// Tests if the provided String is a palindrome
		if(sb.toString().equals(s))
			return true;
		else
			return false;
	}
	
	// Prints the Strings provided in the ArrayList
	private static void print(ArrayList<String> strings) {
		for(String s : strings) {
			System.out.println(s);
		}
	}
}
