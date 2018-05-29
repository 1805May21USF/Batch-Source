package com.revature.same;

/*
 * A class to check if a numner is even or not
 */
public class EvenOrNah {

	/*
	 * A Constructor for the EvenOrNah class
	 */
	public EvenOrNah() {
	}
	
	/*
	 * A method thats checks if a number is even
	 * @Param number to check if it is even
	 * @return returns true if the number is true and false otherwise
	 */
	public static Boolean evenOrNah(int number) {
		Boolean isEven = false;
		int operation = (number/2)*2;
		if(operation == number)
			isEven = true;
		return isEven;
	}
}
