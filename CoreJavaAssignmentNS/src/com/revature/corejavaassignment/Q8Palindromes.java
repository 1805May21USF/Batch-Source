package com.revature.corejavaassignment;

import java.util.ArrayList;
import java.util.Arrays;

public class Q8Palindromes {
	
	private static String[] inputWords = new String[]{
			"karan", "madam", "tom", "civic", "radar", "jimmy",
			"kayak", "john", "refer", "billy", "did"};
	
	private static ArrayList<String> initialWordList = new ArrayList<>(Arrays.asList(inputWords));
	private static ArrayList<String> palindromeList = new ArrayList<>();
	
	private static boolean isPalindrome(String str) {
		
		if (str.equals(Q3ReverseString.reverseString(str)))
			return true;
		
		return false;
	}
	
	private static ArrayList<String> findPalindromes(ArrayList<String> beforeList) {
		
		ArrayList<String> afterList = new ArrayList<>();
		
		for (String word : beforeList) {
			if (isPalindrome(word))
				afterList.add(word);
		}
		
		return afterList;
		
	}
	
	public static void palindromeDemo() {
		System.out.println("Q8. Palindromes");
		System.out.println("\tInitial ArrayList: " + initialWordList);
		palindromeList = findPalindromes(initialWordList);
		System.out.println("\tPalindrome ArrayList: " + palindromeList);
		System.out.println(); //Making room for Q9
	}
	
	public static void main(String[] args) {
		palindromeDemo();
	}

}
