package com.revature.solutions;

public class NFactorial {
	public static int factorial(int x) {
		int answer = x;
		while(x>1) {
			answer = answer*(x-1);
			x--;
		}
		return answer;
	}
}
