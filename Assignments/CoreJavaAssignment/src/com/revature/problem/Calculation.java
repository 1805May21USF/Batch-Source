package com.revature.problem;

interface Calculate {
	int add(int a, int b);
	int subtract(int a, int b);
	int multiply(int a, int b);
	double divide(int a, int b);
}

public class Calculation implements Calculate {	
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
	public double divide(int a, int b) {
		return a / b;
	}
}
