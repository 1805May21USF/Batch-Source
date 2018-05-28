package com.revature.corejavaassignment;

/**
 * Checks if a number is even without using the
 * modulus operator.
 * @author Nathaniel Simpson
 *
 */
public class Q6IsEven {
	
	/*
	 * Checks if a number is even using the bitwise AND
	 * operator. This checks the number's last binary
	 * digit. If it is 0, then it is even. If it is 1,
	 * then it is odd.
	 * @param input - the number to be checked.
	 * @return true if even, false if odd.
	 */
	private static boolean isEven(int input) {
		if((input & 1) == 0)
			return true;
		
		return false;
	}
	
	/*
	 * Demonstrates checking if a number is even.
	 * @param input - the number to be checked.
	 */
	public static void isEvenDemo(int input) {
		String evenOrOdd = "";
		if (isEven(input))
			evenOrOdd = "even";
		else
			evenOrOdd = "odd";
		System.out.println("\t" + input + " is " + evenOrOdd);
	}
	
	/*
	 * For testing
	 */
	public static void main(String[] args) {
		isEvenDemo(5);
		isEvenDemo(6);
	}

}
