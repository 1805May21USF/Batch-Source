package com.revature.toomuchhw;

//Q5. Write a substring method that accepts a string str and an integer idx and returns the substring contained between 0 and idx-1 inclusive.  Do NOT use any of the existing substring methods in the String, StringBuilder, or StringBuffer APIs.
public class Problem5 {

	public String grabStuff(String str, int idx) {
		char[] newString = new char[idx];
		
		for(int i = 0; i < idx; i++) {
			newString[i] = str.charAt(i);
		}
		return new String(newString);
	}
}
