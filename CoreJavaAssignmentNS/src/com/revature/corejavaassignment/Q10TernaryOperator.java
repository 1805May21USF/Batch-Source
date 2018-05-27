package com.revature.corejavaassignment;

public class Q10TernaryOperator {
	
	private static int min(int x, int y) {
		return (x <= y) ? x : y;
	}
	
	public static void ternaryOperatorDemo(int x, int y) {
		System.out.println("\tMininum of " + x + " and " + y + " is: " + min(x,y));
	}
	
	public static void main(String[] args) {
		ternaryOperatorDemo(5,6);
	}

}
