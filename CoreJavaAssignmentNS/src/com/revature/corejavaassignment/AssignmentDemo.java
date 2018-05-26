package com.revature.corejavaassignment;

/**
 * Demonstrates each class outlined in the
 * Core Java Assignment document.
 * @author Nathaniel Simpson
 *
 */
public class AssignmentDemo {
	
	public static void main(String[] args) {
		
		Q1BubbleSort.bubbleSortDemo();
		Q2Fibonacci.fibonacciDemo(25);
		Q3ReverseString.reverseStringDemo("Hello, World! Roll Tide!");
		Q4NFactorial.nFactorialDemo(10);
		
		//Multiple calls for Q5. Substring
		System.out.println("Q5. Substring");
		Q5Substring.substringDemo("Roll Tide!", 3);
		Q5Substring.substringDemo("Roll Tide!", 5);
		Q5Substring.substringDemo("Roll Tide!", 7);
		Q5Substring.substringDemo("Roll Tide!", 700);
		System.out.println(); //Making room for Q6
		
	}

}
