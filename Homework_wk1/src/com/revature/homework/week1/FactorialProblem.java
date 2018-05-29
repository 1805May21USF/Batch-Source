package com.revature.homework.week1;

public class FactorialProblem {
	//program to compute N factorial
	
	private int n;
	
	public FactorialProblem(int n) {
		super();
		this.n = n;
	}

	public FactorialProblem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}
	
	public int printFactorial(int n) {
		//takes in an integer and prints
		//the factorial of that integer
		if(n == 0 || n == 1) {
			return 1;
		}else {
			return n*printFactorial(n-1);
		}
	}

}
