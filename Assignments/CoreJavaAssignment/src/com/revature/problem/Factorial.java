package com.revature.problem;

public class Factorial {
	public static int factorial(int num) {
		int result = 1;
		
		if (num < 0) {
			return -1;
		} if (num != 0) {
			for (int i = 1; i <= num; i++) {
				result *= i;
			}
		}
		
		return result;
	}
	
	public static void print(int num, int n) {
		System.out.print(n + " Factorial: ");
		
		if (num == -1) {
			System.out.print("Sorry no negative numbers!");
		} else {
			System.out.print(num);
		}
		
		System.out.println();
	}
}
