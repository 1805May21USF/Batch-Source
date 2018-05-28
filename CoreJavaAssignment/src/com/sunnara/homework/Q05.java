package com.sunnara.homework;

/*
 * Write a substring method that accepts a string str 
 * and an integer idx and returns the substring contained 
 * between 0 and idx-1 inclusive.  Do NOT use any of the 
 * existing substring methods in the String, 
 * StringBuilder, or StringBuffer APIs
 */
public class Q05 {
	
	/**
	 * Substrings a string without using the substring method
	 * provided by the String Class.
	 * @param str - String to be substringed
	 * @param idx - substring from 0 to idx-1
	 * @return
	 */
	public String substring(String str, int idx) {
		String s = ""; //temporarily string to contain new substring
		for(int i = 0; i < idx; i++) {
			s += str.charAt(i); //adds char to new string until reaching idx-1
		}
		return s;
	}
	
	public void start() {
		String s = "I love racecars";
		int idx = 11;
		System.out.println("Question 5: ");
		System.out.println("Original string is \"" + s + "\" with index "+ idx +" is:");
		System.out.println(substring(s,idx));
		System.out.println();
	}

}
