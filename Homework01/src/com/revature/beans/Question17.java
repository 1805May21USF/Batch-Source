package com.revature.beans;

import java.util.Scanner;

public class Question17 {

	Scanner sc = new Scanner(System.in);
	
	public void calculateInterest() {
		System.out.println("Enter principle: ");
		double principle = sc.nextDouble();
		
		System.out.println("Enter interest rate: ");
		double interestRate = sc.nextDouble();
		
		System.out.println("Enter time: ");
		double time = sc.nextDouble();
		
		System.out.println("Principle: " + principle);
		System.out.println("Interest Rate:" + interestRate);
		System.out.println("Time: " + time);
		
		double interest = (principle * interestRate * time);
		System.out.println("Your interest is: " + interest);
	}
	
}
