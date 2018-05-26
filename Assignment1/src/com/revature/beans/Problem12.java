package com.revature.beans;

public class Problem12 {
	int[] numbers = new int[100];
	
	public Problem12(){
		for(int i = 0; i < 100; i++ ){
			numbers[i] = i + 1;
		}
	}
	
	public int[] getNumbers(){
		return this.numbers;
	}
}
