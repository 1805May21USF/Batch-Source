package com.sunnara.homework;

/*
 * Reverse a string without using a temporary variable.  
 * Do NOT use reverse() in the StringBuffer 
 * or the StringBuilder APIs.
 */
public class Q03 {
	public void start() {
		System.out.println("Question 3:");
		String s = "Roll Tide";
		System.out.println("Reversing the string "+ s);
		System.out.println(reverseString(s));
		System.out.println();
	}
	
	/**
	 * Reverses the string given
	 * @param s - string to be reversed
	 * @return - Returns string from parameter in reverse
	 */
	public String reverseString(String s) {
		
		for(int i = 1; i < s.length() ; i++) {
			//2nd the last character to end from right to left
			s = s.concat("" + s.charAt((s.length()-1)-i)); //adds 2nd last char to end of string. 
			s = s.substring(0,(s.length()-2-i)) 
					+ s.substring(s.length()-1-i,s.length()); //removes string used to concat
		}
		return s;	 
	}
}
