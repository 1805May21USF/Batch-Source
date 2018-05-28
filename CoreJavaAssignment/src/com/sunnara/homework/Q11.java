package com.sunnara.homework;

import com.sunnara.access.FloatsInHere;

/*
 * Write a program that would access two float-variables 
 * from a class that exists in another package. Note, you 
 * will need to create two packages to demonstrate the solution.
 */
public class Q11 {
	
	Float f1;
	Float f2;
	
	/**
	 * Grabs float from package in FloatsInHere
	 */
	public void start() {
		FloatsInHere fin = new FloatsInHere();
		f1 = fin.getF1();
		f2 = fin.getF2();
		System.out.println("Question 11:");
		System.out.println("The float retrieved from another package are "+ 
		f1 +" and "+ f2 );
		System.out.println();
	}
	
}
