package com.revature.same;

import java.util.*;

/*
 * A class to calculate the first 25 fibonacci sequence 
 */
public class Fibonacci {

	/*
	 * A Constructor for the Fibonacci class
	 */
	public Fibonacci() {
		// TODO Auto-generated constructor stub
		fibonacci();
	}
	
	/*
	 * A method to calculate the first 25 fibonacci sequence
	 * @Param none
	 * @return returns an arraylist of the first 25 fibonacci sequence
	 */
	public static ArrayList<Integer> fibonacci() {
		ArrayList<Integer> fib = new ArrayList<>();
		fib.add(0); fib.add(1);
		for(int i = 0; i < 23; i++) {
			int first = fib.get(i);
			int second = fib.get(i+1);
			fib.add(first + second);
		}
		return fib;
	}

}
