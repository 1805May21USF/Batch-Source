package com.revature.questions;

public class QuestionSix {
	
	public QuestionSix() {
		
	}
	
	/*
	 *Exploits integer division in java.
	 *An odd int divided by two will be X.5
	 *which gets truncated to X. Multiply X by
	 *2 and it will be less than the original number.
	 */
	public String run(int n) {
		int newn = n/2;
		newn = newn*2;
		if(newn<n) {
			return "odd";
		}
		return "even";
	}

}
