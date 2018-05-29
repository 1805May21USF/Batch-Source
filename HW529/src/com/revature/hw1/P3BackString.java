package com.revature.hw1;

public class P3BackString {
	public static void backwardzify(String og) {
		//char[] ogChar = og.toCharArray();
		//creates char array from string and cycles through it recursively, then recombines the string
		char[] ogChar = new char[og.toCharArray().length];
		for (int i = og.toCharArray().length-1; i >=0 ; i--) 
			ogChar[og.toCharArray().length - 1 -  i]=og.toCharArray()[i];
		og = String.valueOf(ogChar);
		System.out.println(og);
	}
}
