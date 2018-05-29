package com.revature.hw1;

public class P4NFactorial {
	public static void factorial(int n) {
		int k = 1;
		for (int i = n; i > 0; i--) k*=i;
		System.out.println(k);
	}
}
