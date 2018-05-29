package com.revature.beans;

import java.util.ArrayList;

public class Question19 {
	
	ArrayList<Integer> numList = new ArrayList<Integer>();
	
	public void addAndDisplay() {
		for(int i=0; i<10; i++) {
			numList.add(i+1);
			System.out.println(numList.get(i));
		}
	}
	
	public void addEvenOddIntegers() {
		int evenSum=0, oddSum=0;
		for(int i=0; i<10; i++) {
			int n = numList.get(i);
			if(n%2 == 0) {
				evenSum += n;
			} else {
				oddSum += n;
			}
		}
		System.out.println("Sum of even integers: " + evenSum);
		System.out.println("Sum of odd integers: " + oddSum);
	}

}
