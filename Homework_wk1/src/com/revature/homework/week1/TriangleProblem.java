package com.revature.homework.week1;

public class TriangleProblem {
	//program prints a triangle sequence of 0's and 1's

	public TriangleProblem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void printTriangle() {
		//this method prints the triangle of 0's and 1's
		boolean swap = true;
		
		for(int i = 1; i < 5; i++) {
			for(int j = 0; j < i; j++) {
				if(swap) {
					System.out.print(0 + " ");
				}else {
					System.out.print(1 + " ");
				}
				swap = !swap;
			}
			System.out.println();
		}
		
	}
}
