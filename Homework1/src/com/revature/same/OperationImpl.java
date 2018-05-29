package com.revature.same;

/*
 * A class to add, subtract, multiply, and divide number. Implements Operations
 */
public class OperationImpl implements Operations {

	/*
	 * A Constructor for the OperationImply class
	 */
	public OperationImpl() {
		// TODO Auto-generated constructor stub
	}
	
	/*
	 * A method to add two numbers
	 * @Param x number to be added
	 * @Param y number to be added
	 * @return returns the sum of x and y
	 */
	public int addition(int x, int y) {
		return x + y;
	}
	
	/*
	 * A method to subtract two numbers
	 * @Param x number to be subtracted
	 * @Param y number to be subtractbed
	 * @return returns the difference of x and y
	 */
	public int subtraction(int x, int y) {
		return x - y;
	}
	
	/*
	 * A method to add multiply numbers
	 * @Param x number to be multiplied
	 * @Param y number to be multiplied
	 * @return returns the multiplication of x and y
	 */
	public int multiplication(int x, int y) {
		return x * y;
	}

	/*
	 * A method to divide two numbers
	 * @Param x number to be divided
	 * @Param y number to be divided
	 * @return returns the division of x and y
	 */
	public double division(int x, int y) {
		return x * 1.0 / y * 1.0;
	}
}
