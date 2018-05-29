package com.revature.homework.week1.problem_15;

public class Calculation implements Operation{
	//this class implements Operation interface and
	//overrides the abstract methods

	public Calculation() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
		public int addition(int a, int b) {
		//this method adds the integers
			return a+b;
	}
	
	@Override
	public int subtraction(int a, int b) {
		//this method performs the subtraction operations
		return Math.abs(a-b);
	}
	
	@Override
	public int multiplication(int a, int b) {
		//return the product of two integers
		return a*b;
	}
	
	@Override
	public int division(int a, int b) {
		//divides one integer by another
		//and return the result
		if(a > b) {
			return a/b;
		}else {
			return b/a;
		}
		
	}
}
