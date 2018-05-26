package com.revature.toomuchhw;
/*//Q15. Write a program that defines an interface having the following methods:
//	addition, subtraction, multiplication, and division.  
//	Create a class that implements this interface and provides appropriate functionality to 
//	carry out the required operations. Hard code two operands in a test class 
//	having a main method that calls the implementing class.
*/public class Problem15 implements Problem15Interface{
	private int x;
	private int y;
	
	public Problem15(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	@Override
	public int addition() {
		return x+y;
	}

	@Override
	public int subtraction() {
		// TODO Auto-generated method stub
		return x-y;
	}

	@Override
	public int multiplication() {
		// TODO Auto-generated method stub
		return x*y;
	}

	@Override
	public double division() {
		// TODO Auto-generated method stub
		return (double)x/y;
	}
}
