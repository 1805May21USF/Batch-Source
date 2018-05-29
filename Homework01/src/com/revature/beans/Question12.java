package com.revature.beans;

public class Question12 {
	
	public int [] nums = new int [100];
	
	public void storeNums() {
		for(int i=0; i<=99; i++) {
			nums[i] = i+1;
		}
	}
	
	public void printEvenNums(int [] numArr) {
		for(int element : numArr) {
			if(element % 2 == 0) {
				System.out.println(element + " is an even number!");
			}
		}
	}

}
