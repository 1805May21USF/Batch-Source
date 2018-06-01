package com.revature.questions;

import com.revature.qeighteen.ThingyImplementer;

public class QuestionEighteen {
	
	public QuestionEighteen() {
		
	}
	
	/*
	 * Just instantiates the ThingyImplementor class from
	 * com.revature.qeighteen. ThingyImplementor implements the
	 * Thingy interface
	 */
	
	public void run() {
		ThingyImplementer t = new ThingyImplementer();
		System.out.println(t.caseChecker("woooooooooooooooow"));
		System.out.println(t.toYellyCase("woooooooooooooooow"));
		System.out.println(t.stringPluser("100"));
	}

}
