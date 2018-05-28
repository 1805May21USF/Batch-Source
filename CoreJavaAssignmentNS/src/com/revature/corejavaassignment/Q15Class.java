package com.revature.corejavaassignment;

/**
 * Simple calculator that uses an interface.
 * @author Nathaniel Simpson
 *
 */
public class Q15Class implements Q15Interface{

	@Override
	public int add(int a, int b) {
		return a + b;
	}

	@Override
	public int subtract(int a, int b) {
		return a - b;
	}

	@Override
	public int multiply(int a, int b) {
		return a * b;
	}

	@Override
	public int divide(int a, int b) {
		return a / b;
	}

}
