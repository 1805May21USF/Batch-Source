package com.revature.hw1;

public class P15Calculator implements P15Interface{

	@Override
	public void add(int a, int b) {
		// TODO Auto-generated method stub
		System.out.println((a+b));
	}

	@Override
	public void subtract(int a, int b) {
		// TODO Auto-generated method stub
		System.out.println(a - b);
	}

	@Override
	public void multiply(int a, int b) {
		// TODO Auto-generated method stub
		System.out.println(a*b);
	}

	@Override
	public void divide(double a, double b) {
		// TODO Auto-generated method stub
		System.out.println(a/b);
	}
	
	
	
}
