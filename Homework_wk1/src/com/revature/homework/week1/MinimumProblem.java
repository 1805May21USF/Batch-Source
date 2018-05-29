package com.revature.homework.week1;

public class MinimumProblem {
	//program that prints out the minimum of two numbers
	
	private int x, y;

	public MinimumProblem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MinimumProblem(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public void minNumber(int x, int y) {
		//this method accepts two integers
		//and prints out the minimum of two integers
		int min = x < y ? x:y;
		
		System.out.println("The minimum number between " + this.getX() + " and " + this.getY() + " is: " + min);
	}
}
