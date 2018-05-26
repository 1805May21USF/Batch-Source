/****************************************************
 * 		Name: Calculator     						*
 * 		Purpose: Implements the Calculate interface *
 * 				 and allows basic arithmetic to be  *
 * 				 performed							*
 * 		Author: Thomas Loyd							*
 ****************************************************/
package com.revature.storage;

public class Calculator implements Calculate{

	// Implements the Calculate interfaces addition, subtraction, multiplication, and division methods to perform arithmatic on two values
	@Override
	public int addition(int value1, int value2) {
		return value1 + value2;
	}

	@Override
	public int subtraction(int value1, int value2) {
		return value1 - value2;
	}

	@Override
	public int multiplication(int value1, int value2) {
		return value1 * value2;
	}

	@Override
	public double division(double value1, double value2) {
		return value1 / value2;
	}

}
