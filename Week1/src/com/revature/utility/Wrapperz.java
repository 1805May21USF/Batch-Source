package com.revature.utility;

public class Wrapperz {
	static int myInt = 3;
	static int myInteger = 5;
	
	static public int addEmUp(int a, int b) {
		return a + b;
	}
	
	public static void main(String[] args) {
		System.out.printf("Adding my two numbers: %d", addEmUp(myInt, myInteger));
	}
}