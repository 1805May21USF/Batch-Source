package com.revature.questions;

public class QuestionSix {
	
	public QuestionSix() {
		
	}
	public String run(int n) {
		int newn = n/2;
		newn = newn*2;
		if(newn<n) {
			return "odd";
		}
		return "even";
	}

}
