package com.revature.homework.week1;

public class EvenIntegerProblem {
	//program to determine if an integer is even
	//without using modulus operator
	
	public EvenIntegerProblem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public boolean isEven(int n) {
		//accepts an integer and return if an integer is even
		boolean check;
		
		if(n == 0) {
			check = true;
		}else if((n/2)*2 == n) {
			check = true;
		}else {
			check = false;
		}
		
		return check;	
	}
}
