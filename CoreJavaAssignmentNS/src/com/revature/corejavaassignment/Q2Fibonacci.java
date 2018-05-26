package com.revature.corejavaassignment;

import java.util.ArrayList;

public class Q2Fibonacci {

	private static ArrayList<Integer> fSequence = new ArrayList<>();
	
	private static int fibonacci(int number) {
		if(number <= 1)
			return number;
		
		return fibonacci(number - 1) + fibonacci(number - 2);
	}

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
