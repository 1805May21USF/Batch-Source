package com.revature.beans;

public class Question03 {

	public void reverse(String s) {
		String s2 = "";
		int length = s.length();
		
		for(int i=length-1; i>=0; i--) {
			s2 += s.charAt(i);
		}
		System.out.println("Current String: " + s);
		System.out.println("Reversed String: " + s2);
	}
}
