package com.revature.same;

public class Factorial {

	public Factorial() {
		// TODO Auto-generated constructor stub
	}
	
	public static int factorial(int number) {
		if(number == 0){
			return 1;
		}
		return number * factorial(number-1);
	}

}
