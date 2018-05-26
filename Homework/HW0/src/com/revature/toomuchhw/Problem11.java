package com.revature.toomuchhw;

import com.revature.pixarfloats.GetProblem11;
//Q11. Write a program that would access two float-variables from a class that exists in another package.
//Note, you will need to create two packages to demonstrate the solution.
public class Problem11 {

	public Problem11() {
		// TODO Auto-generated constructor stub
	}
	
	public void getFloats() {
		float a = new GetProblem11().getA();
		float b = new GetProblem11().getB();
		
		System.out.println(a+","+b);
	}
	

}
