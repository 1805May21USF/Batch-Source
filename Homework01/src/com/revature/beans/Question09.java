package com.revature.beans;

import java.util.ArrayList;

public class Question09 {

	ArrayList<Integer> intList = new ArrayList<Integer>();
	
	public void addInts() {
		for(int i=1; i<=100; i++) {
			intList.add(i);
			if(i>1 && isPrime(i)) {
				System.out.println(i + " is a prime number!");
			}
		}
	}
	
	public boolean isPrime(int n) {
		int temp;
		for(int i=2; i<=n/2; i++) {
			temp = n%i;
			if(temp == 0) {
				return false;
			}
		}
		return true;
	}
}
