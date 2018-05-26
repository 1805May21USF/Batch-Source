package com.revature.corejavaassignment;

public class Q4NFactorial {
	
	private static int nFactorial(int input) {
		
		for (int i = input - 1; i > 0; i--)
			input *= i;
		
		return input;
		
	}
	
	public static void nFactorialDemo(int input) {
		System.out.print("Q4. N Factorial\n\t");
		System.out.println(input + "!= " + nFactorial(input));
		System.out.println(); //Making room for Q5
	}
	
	public static void main(String[] args) {
		System.out.println(nFactorial(10));
	}

}
