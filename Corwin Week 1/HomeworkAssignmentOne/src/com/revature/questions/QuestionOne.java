package com.revature.questions;

public class QuestionOne {
	
	public QuestionOne () {
		
	}
	public void run(int[] toSort) {
		
		//A simple bubblesort
		//swaps values that are out of order
		//Ends when a pass has no swaps
		
		boolean isDone = false;
		while(!isDone) {
			boolean didSwap = false;
			for(int i = 0;i<toSort.length-1;i++) {
				if(toSort[i]>toSort[i+1]) {
					int c = toSort[i];
					toSort[i] = toSort[i+1];
					toSort[i+1] = c;
					didSwap = true;
				}
			}
			if(!didSwap) {
				isDone=true;
			}
		}
	}

}
