package com.revature.questions;

public class QuestionThirteen {
	
	public QuestionThirteen() {
		
	}
	
	/*
	 * It's just an alternating sequence of ones and zeros
	 * with each row length being the row count + 1. Uses a toggle
	 * to switch between zero and one.
	 */
	public void run() {
		
		boolean toggle = true;
		for(int i = 1;i<5;i++) {
			for(int j = 0;j<i;j++) {
				if(toggle) {
					System.out.print(0 + " ");
				}
				else {
					System.out.print(1 + " ");
				}
				toggle = !toggle;
			}
			System.out.println();
		}
	}

}
