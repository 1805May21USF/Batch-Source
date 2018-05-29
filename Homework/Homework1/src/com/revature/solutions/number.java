package com.revature.solutions;

public class number implements MathOperators {
	private double value;

	public number(double value) {
		super();
		this.value = value;
	}

	@Override
	public  double addition(double a, double b) {
		return a+b;
	}

	@Override
	public double subtraction(double a, double b) {
		return a-b;
	}

	@Override
	public double multiplication(double a, double b) {
		return a*b;
	}

	@Override
	public double division(double a, double b) {
		return a/b;
	}
	
}
