package com.revature.homework.week1;

public class FibonacciProblem {
	//print first 25 fibonacci numbers beginning at 0
	
	public FibonacciProblem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int fibSequence(int n) {
		//this method takes in an integer
		//and prints out the sequence starting at 0
		if(n == 0) {
			return 0;
		}else if(n == 1){
			return 1;
		}else {
			return fibSequence(n - 1) + fibSequence(n - 2);
		}
	}
	
}
