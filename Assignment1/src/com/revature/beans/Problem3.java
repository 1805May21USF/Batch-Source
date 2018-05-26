package com.revature.beans;
/*Q3. Reverse a string without using a temporary variable.  Do NOT use reverse() in the StringBuffer 
 * or the StringBuilder APIs.*/


public class Problem3 {
	
	public static void reverseWord(String s){
		for(int i=0;i<s.length();){
			System.out.print(s.charAt(s.length()-1));
			 s = s.substring(0,s.length()-1);
		}
		System.out.println();
		
	}
}