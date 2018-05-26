package com.revature.questions;

public class QuestionFive {
	
	public QuestionFive() {
		
	}
	
	public String run(String s,int idx) {
		char[] y = s.toCharArray();
		char[] toret = new char[idx+1];
		
		for(int i = 0;i<idx+1;i++) {
			toret[i] = y[i];
		}
		
		return new String(toret);
	}

}
