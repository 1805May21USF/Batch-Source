package com.revature.corejavaassignment;

public class Q4NFactorial {
	
	private static int nFactorial(int input) {
		
		for (int i = input - 1; i > 0; i--)
			input *= i;
		
		return input;
		
	}
	
	public static void main(String[] args) {
		System.out.println(nFactorial(10));
	}

}
