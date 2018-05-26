/****************************************************
 * 		Name: Q15									*
 * 		Purpose: Uses a Calculator object to        *
 * 				 perform basic arithmetic           *
 * 		Author: Thomas Loyd							*
 ****************************************************/
package com.revature.twenty;

import com.revature.storage.Calculator;

public class Q15 {
	public static void calculate() {
		// Creates an instance of the Calculator class
		Calculator calc = new Calculator();
		
		// Instantiates two values to perform calculations on
		int value1 = 15;
		int value2 = 7;
		
		// Prints the two values and the results of the calculations performed on the values
		System.out.println(value1 + " + " + value2 + " = " + calc.addition(value1, value2));
		System.out.println(value1 + " - " + value2 + " = " + calc.subtraction(value1, value2));
		System.out.println(value1 + " * " + value2 + " = " + calc.multiplication(value1, value2));
		System.out.println(value1 + " / " + value2 + " = " + calc.division(value1, value2));
	}
}
