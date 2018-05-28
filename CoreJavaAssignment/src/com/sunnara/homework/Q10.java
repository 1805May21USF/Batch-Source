package com.sunnara.homework;


/*
 * Find the minimum of two numbers using ternary operators.
 */
public class Q10 {

	
	public void start() {
		int x = 1000;
		int y = 1;
		System.out.println("Question 10:\nUsing tenary operators");
		System.out.println("From " + x + " and " + y + ", "
		+ findMin(1000,1) + " is the minimum.");
		System.out.println();
	}
	public int findMin(int i, int j) {
		//if i is less then j, return i else j;
		return ((i < j) ? i : j);
	}
}
