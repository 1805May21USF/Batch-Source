package com.revature.corejavaassignment;

import java.util.ArrayList;

/**
 * Outputs the Fibonacci sequence to an argument-determined
 * limit. This is set to 25 per the assignment.
 * @author Nathaniel Simpson
 *
 */
public class Q2Fibonacci {

	// ArrayList which will contain the sequence of numbers.
	private static ArrayList<Integer> fSequence = new ArrayList<>();
	
	/*
	 * Calculates the next number in the sequence recursively.
	 * @param number - the number to be used for calculation.
	 * @return the previous two numbers added together.
	 */
	private static int fibonacci(int number) {
		if(number <= 1)
			return number;
		
		return fibonacci(number - 1) + fibonacci(number - 2);
	}

	/*
	 * Demonstrates populating the fSequence ArrayList
	 * and outputting the Fibonacci numbers.
	 * @param digits - number of Fibonacci numbers to display.
	 */
	public static void fibonacciDemo(int digits) {
		System.out.print("Q2. Fibonacci Sequence\n\t");
		for(int i = 0; i <= digits; i++)
			fSequence.add(fibonacci(i));
		System.out.println(fSequence.toString());
		System.out.println(); //Making room for Q3
	}
	
	/*
	 * For testing purposes. All classes will be
	 * accessible from a demo class.
	 */
	public static void main(String[] args) {
		fibonacciDemo(25);
	}
	
}
