package com.revature.questions;

public class QuestionThree {
	
	public QuestionThree(){
		
	}
	public String run(String s) {
		char[] y = s.toCharArray();
		int midpoint =  y.length/2;
		for(int i = 0;i<midpoint;i++) {
			templessSwap(i,y.length-1-i,y);
		}		
		return new String(y);
	}
	public void templessSwap(int i, int j,char[] s) {
		s[i] = (char) (s[i] + s[j]);
		s[j] = (char) (s[i] - s[j]);
		s[i] = (char) (s[i] - s[j]);
		
	}

}
