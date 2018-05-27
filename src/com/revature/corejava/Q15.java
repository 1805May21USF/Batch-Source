package com.revature.corejava;


//Created interface myMathOps for this. Used addition and multiplication for the instantiated object in driver class
public class Q15 implements myMathOps
{

	@Override
	public int addition(int firstNumber, int secondNumber) {
		return firstNumber + secondNumber;
		
	}

	@Override
	public int subtraction(int firstNumber, int secondNumber) {
		return firstNumber - secondNumber;
		
	}

	@Override
	public int multiplication(int firstNumber, int secondNumber) {
		return firstNumber * secondNumber;
		
	}

	@Override
	public double division(double numerator, double denominator) {
		return numerator / denominator;
		
	}
	
}
