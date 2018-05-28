package com.sunnara.homework;

/*
 * Write a program to display the number of characters 
 * for a string input. The string should be entered as a 
 * command line argument using (String [ ] args).
 */
public class Q16 {
	
	
	public static void main(String[] args) {
		
		System.out.println("Question 16:");
		int count = 0;
		for(String s : args) {
			count += s.length();
		}
		System.out.println("The String : \"" + args[0] +"\" has " + count + " characters");
		System.out.println();
	}
	
}
