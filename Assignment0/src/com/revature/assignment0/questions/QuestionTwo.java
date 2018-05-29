package com.revature.assignment0.questions;

public class QuestionTwo {
	public static void Question_Two() {
		
		//Create three variables to house the previous number, second previous number and the actual total
		int second_previous = 0;
		int frist_previous = 1;
		int total = 1;
		
		//Adds the two previous numbers together to get the new total, do this 25 times to get the new total
		for(int i = 2; i <= 25; i++ ) {
			total = frist_previous + second_previous;
			second_previous = frist_previous;
			frist_previous = total;
		}
		
		System.out.println("\r------Question Two-------");
		System.out.println("2.) Write a program to display the first 25 Fibonacci numbers beginning at 0.\r");
		System.out.println(total);
	}
}
