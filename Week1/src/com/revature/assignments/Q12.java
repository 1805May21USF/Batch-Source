package com.revature.assignments;

public class Q12 {

	
	public static int [] arr = new int [100];
	
	//initialize array
	public void initArray() {
		for(int i = 0; i<100; i++) {
			arr[i] = i+1;
		}
	}
	//print the even  numbers if they are modulo 2
	public void printEvens() {
		for(int item : arr) {
			if(item % 2 == 0) {
				System.out.println(item);
			}
		}
	}
	
}
