package com.revature.corejavaassignment;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Checks if words in a String ArrayList are palindromes
 * and adds the palindromes to a new String ArrayList.
 * @author Nathaniel Simpson
 *
 */
public class Q8Palindromes {
	
	// String array from the assignment
	private static String[] inputWords = new String[]{
			"karan", "madam", "tom", "civic", "radar", "jimmy",
			"kayak", "john", "refer", "billy", "did"};
	
	// ArrayList with the set of words to be checked
	private static ArrayList<String> initialWordList = new ArrayList<>(Arrays.asList(inputWords));
	// ArrayList where palindromes are added
	private static ArrayList<String> palindromeList = new ArrayList<>();
	
	/*
	 * Utilizes the reverseString method from Q3 to check if a string is equal
	 * to itself when reversed. If so, it is a palindrome and returns true.
	 * @param str - String to be checked.
	 * @return true if a palindrome, false if not a palindrome.
	 */
	private static boolean isPalindrome(String str) {
		
		if (str.equals(Q3ReverseString.reverseString(str)))
			return true;
		
		return false;
	}
	
	/*
	 * Iterates through an ArrayList to find palindromes.
	 * @param beforeList - The ArrayList to be scanned for palindromes.
	 * @return ArrayList containing palindromes found in beforeList.
	 */
	private static ArrayList<String> findPalindromes(ArrayList<String> beforeList) {
		
		ArrayList<String> afterList = new ArrayList<>();
		
		for (String word : beforeList) {
			if (isPalindrome(word))
				afterList.add(word);
		}
		
		return afterList;
		
	}
	
	/*
	 * Demonstrates finding palindromes.
	 */
	public static void palindromeDemo() {
		System.out.println("Q8. Palindromes");
		System.out.println("\tInitial ArrayList: " + initialWordList);
		palindromeList = findPalindromes(initialWordList);
		System.out.println("\tPalindrome ArrayList: " + palindromeList);
		System.out.println(); //Making room for Q9
	}
	
	/*
	 * For testing
	 */
	public static void main(String[] args) {
		palindromeDemo();
	}

}
