package com.revature.corejavaassignment;

/**
 * Demonstration class for the simple calculator.
 * @author Nathaniel Simpson
 *
 */
public class Q15TestClass {
	
	public static void main(String[] args) {
		int firstNum = 42;
		int secondNum = 21;
		
		Q15Class operations = new Q15Class();
		
		System.out.println("Q15. Interface");
		System.out.println("\tNumbers used are " + firstNum + " and " + secondNum);
		System.out.println("\tAddition: " + firstNum + " + " + 
				secondNum + " = " + operations.add(firstNum, secondNum));
		System.out.println("\tSubtraction: " + firstNum + " - " + 
				secondNum + " = " + operations.subtract(firstNum, secondNum));
		System.out.println("\tMultiplication: " + firstNum + " * " + 
				secondNum + " = " + operations.multiply(firstNum, secondNum));
		System.out.println("\tDivision: " + firstNum + " / " + 
				secondNum + " = " + operations.divide(firstNum, secondNum));
		System.out.println();
	}

}
