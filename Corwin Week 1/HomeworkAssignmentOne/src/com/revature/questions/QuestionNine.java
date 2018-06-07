package com.revature.questions;

import java.util.ArrayList;

public class QuestionNine {
	public QuestionNine() {
		
	}
	
	/*
	 * A simple prime detection. Go through each number, then
	 * go through all the numbers leading up to it testing using modulo.
	 * if it is zero then the number is not prime.
	 */
	
	public void run() {
		ArrayList<Integer> nums = new ArrayList<Integer>();
		
		for(int i = 1;i<=100;i++) {
			boolean isPrime = true;
			for(int j = 2;j<i;j++) {
				if(i%j == 0) {
					isPrime = false;
				}
			}
			if(isPrime) {
				System.out.print(i + " ");
			}
			nums.add(i);
		}
		System.out.println("");
	}
}
