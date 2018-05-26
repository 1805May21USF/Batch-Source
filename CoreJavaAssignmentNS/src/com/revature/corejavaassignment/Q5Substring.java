package com.revature.corejavaassignment;

public class Q5Substring {
	
	private static String substring(String str, int idx) {
		if (idx >= str.length())
			return str;
		
		String substring = "";
		for (int i = 0; i < idx; i++) {
			substring += str.charAt(i);
		}
		
		return substring;
	}
	
	public static void substringDemo(String str, int idx) {
		System.out.println("\tIndex = " + idx + ": " + substring(str, idx));
	}
	
	public static void main(String[] args) {
		substringDemo("Roll Tide!", 5);
		substringDemo("Roll Tide!", 7);
		substringDemo("Roll Tide!", 700);
	}

}
