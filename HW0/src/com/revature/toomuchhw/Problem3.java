package com.revature.toomuchhw;


//Reverse a string without using a temporary variable.  Do NOT use reverse() in the StringBuffer or the StringBuilder APIs
public class Problem3{
	
	public String reverseMe(String s) {
		// TODO Auto-generated method stub
		int len = s.length();
		String reversies = "";

		for(int i = len-1; i >= 0; i--) {
			reversies = reversies+s.charAt(i);
		}
		return reversies;
	}
	
	

}
