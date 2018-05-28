package com.revature.corejavaassignment;

/**
 * Finds the factorial of a number.
 * @author Nathaniel Simpson
 *
 */
public class Q4NFactorial {
	
	/*
	 * Finds the factorial of a number by multiplying
	 * the number by itself minus 1 and repeating until
	 * it reaches 1.
	 * @param input - the number to be used for calculation.
	 * @return n factorial
	 */
	private static int nFactorial(int input) {
		
		for (int i = input - 1; i > 0; i--)
			input *= i;
		
		return input;
		
	}
	
	/*
	 * Demonstrates finding the n factorial.
	 * @param input - the number to be used for calculation.
	 */
	public static void nFactorialDemo(int input) {
		System.out.print("Q4. N Factorial\n\t");
		System.out.println(input + "!= " + nFactorial(input));
		System.out.println(); //Making room for Q5
	}
	
	/*
	 * For testing
	 */
	public static void main(String[] args) {
		System.out.println(nFactorial(10));
	}

}
