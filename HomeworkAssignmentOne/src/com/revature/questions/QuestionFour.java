package com.revature.questions;

public class QuestionFour {
	
	public QuestionFour() {
		
	}
	
	/*
	 *Simple for loop for multiplying
	 */
	public void run(int n) {
		int val = 1;
		for(int i = 1 ; i <= n; i++) {
			val *= i ;
		}
		System.out.print(val + "\n");
	}

}
