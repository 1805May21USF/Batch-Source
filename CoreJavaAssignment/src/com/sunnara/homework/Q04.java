package com.sunnara.homework;

/*
 * Write a program to compute N factorial.
 */
public class Q04 {

	
	/**
	 * Factors  by multipling parameter n's value with value-1 recursively
	 * until n equals 1.
	 * @param n - number to be factored
	 * @return factored value
	 */
	public int factor(int n) {
		if(n == 0) {
			return 1;
		}
		return n * factor(n-1);
	}
	
	public void start() {
		int factorThis = 10;
		System.out.println("Question 4:");
		System.out.println(factorThis +" factored is " + factor(factorThis));
		System.out.println();
	}
	
}
