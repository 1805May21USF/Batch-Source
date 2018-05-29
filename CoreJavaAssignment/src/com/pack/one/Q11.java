package com.pack.one;

import com.pack.two.Q11a;

public class Q11 {
	/*
	 * Q11. Write a program that would access two float-variables from a class that
	 * exists in another package. Note, you will need to create two packages to
	 * demonstrate the solution.
	 */
	public static void main(String[] args) {
		// To access the two float variables from a class that exists in another
		// package, you must import the class through its package name
		Q11a t = new Q11a();
		System.out.println("Float variable A: " + t.getCarry());
		System.out.println("FLoat variable B: " + t.getCarry2());
	}

}
