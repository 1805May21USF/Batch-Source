package com.revature.questions;

import java.util.Arrays;

public class QuestionTwo {

	public QuestionTwo() {
		
	}
	public void run(int n) {
		
		/*-------------------------------
		 * Iterative solution to fib. Recursive
		 * would have been cooler but this came first.
		 * Just adds the preceeding two numbers in the
		 * sequence and prints.
		 */
		
		int[] preceeding = {0,1};
		System.out.print(preceeding[0] + ", " + preceeding[1]+", ");
		for(int i = 0;i<n-2;i++) {
			int sum = preceeding[0]+preceeding[1];
			preceeding[0] = preceeding[1];
			preceeding[1] = sum;
			System.out.print(sum + ", ");
		}
		System.out.print("\n");
	}
}
