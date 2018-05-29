package com.revature.same;

/*
 * A class to calculate the factorial of a given number
 */
public class Factorial {

	/*
	 * A constructor for the Factorial class
	 */
	public Factorial() {
		// TODO Auto-generated constructor stub
	}
	
	/*
	 * A method to calculate the factorial of a given number
	 * @Param number to calculate its factorial
	 * @return returns an in which is the factorial of a number
	 */
	public static int factorial(int number) {
		if(number == 0){
			return 1;
		}
		return number * factorial(number-1);
	}

}
