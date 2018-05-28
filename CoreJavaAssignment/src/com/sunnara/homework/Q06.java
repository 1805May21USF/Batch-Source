package com.sunnara.homework;

/*
 * Write a program to determine if an integer 
 * is even without using the modulus operator (%)
 */
public class Q06 {

	/**
	 * Checks if int is even without using the % operator
	 * Uses bitwise and
	 * @param i - integer to be checked
	 * @return - returns true or false if even or odd.
	 */
	public boolean isItEven(int i) {
		
		if ((i&1) == 1) { //i & 0001
			return false;
		}
		return true;
	}
	
	public void start() {
		System.out.println("Question 6:");
		int num = 1000;
		System.out.println("Checking if " + num + " is even");
		if(isItEven(num)) {
			System.out.println("Yes, it is even");
		} else {
			System.out.println("No, it is not even");
		}
		System.out.println();
		
	}
}
