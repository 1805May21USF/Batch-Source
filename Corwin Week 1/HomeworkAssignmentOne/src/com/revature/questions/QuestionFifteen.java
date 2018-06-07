package com.revature.questions;

import com.revature.qfifteen.Calculator;

public class QuestionFifteen {
	
	public QuestionFifteen() {
		
	}
	
	/*
	 * Instantiates the Calculator class found in
	 * com.revature.qfifteen. The Calculator class implements
	 * the Operands interface.
	 */
	public void run() {
		Calculator c = new Calculator();
		System.out.println(c.addition(2, 5));
		System.out.println(c.subtraction(10, 2));
	}

}
