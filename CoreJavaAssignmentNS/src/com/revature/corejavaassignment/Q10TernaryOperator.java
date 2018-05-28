package com.revature.corejavaassignment;

/**
 * Finds the min of two numbers using the ternary operator.
 * @author Nathaniel Simpson
 *
 */
public class Q10TernaryOperator {
	
	/*
	 * Finds the min of two numbers using the ternary operator.
	 * @param x - first number
	 * @param y - second number
	 * @return the min of x and y.
	 */
	private static int min(int x, int y) {
		return (x <= y) ? x : y;
	}
	
	/*
	 * Demonstrates the ternary operator.
	 */
	public static void ternaryOperatorDemo(int x, int y) {
		System.out.println("\tMininum of " + x + " and " + y + " is: " + min(x,y));
	}
	
	/*
	 * For testing
	 */
	public static void main(String[] args) {
		ternaryOperatorDemo(5,6);
	}

}
