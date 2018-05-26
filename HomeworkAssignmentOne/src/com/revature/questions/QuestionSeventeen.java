package com.revature.questions;

import java.util.Scanner;

public class QuestionSeventeen {
	
	public QuestionSeventeen() {
		
	}
	/*
	 * Just uses scanner to get some values and multiply them.
	 */
	public double run() {
		
		Scanner input = new Scanner(System.in);
		System.out.println("What is the principal?");
		double principal = input.nextDouble();
		System.out.println("What is the rate?");
		double rate = input.nextDouble();
		System.out.println("What is number of years for the loan?");
		int years = input.nextInt();
		
		return principal * rate * years;
		
		
	}

}
