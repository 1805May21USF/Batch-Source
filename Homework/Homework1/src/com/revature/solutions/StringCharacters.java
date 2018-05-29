package com.revature.solutions;

public class StringCharacters {
	public static void charCount(String[] args) {
		int count = 0;
		for(int i = 0;i<args.length;i++) {
			for(int j = 0;j<args[i].length();j++) {
				count++;
			}
		}
		System.out.println("Number of character = " + count);
	}
}
