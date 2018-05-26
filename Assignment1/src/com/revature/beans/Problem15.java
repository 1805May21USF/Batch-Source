package com.revature.beans;

import com.revature.interfaces.Problem15Interface;
/*Q15. Write a program that defines an interface having the following methods: addition, subtraction, multiplication, 
 * and division.  Create a class that implements this interface and provides appropriate functionality to carry out 
 * the required operations. Hard code two operands in a test class having a main method that calls the implementing class.*/
public class Problem15 implements Problem15Interface{

	@Override
	public double addition(double a, double b) {	
		return a + b;
	}

	@Override
	public double multiply(double a, double b) {
		return a * b;
	}

	@Override
	public double substraction(double a, double b) {
		return a - b;
	}

	@Override
	public double division(double a, double b) {
		try {
			return a/b;
		} catch (Exception e) {
			System.out.println("You cannot divide by 0");
		}
		return 0;
	}

}
