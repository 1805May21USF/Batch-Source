package com.revature.solutions;

public class reverseString {
	public static String reverse(String str) {
		int stringLength = str.length();
		for (int i = 1;i<stringLength;i++) {
			str = str + str.substring(stringLength - (i+1), stringLength-i);
		}
		str = str.substring(stringLength-1, (2*stringLength-1));
		System.out.println(str);
		
		return str;
	}
}
