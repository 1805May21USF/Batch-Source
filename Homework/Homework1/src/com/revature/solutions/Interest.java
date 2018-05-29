package com.revature.solutions;
import java.util.Scanner;
public class Interest {
	public static double calculateInterest() {
		
		Scanner in = new Scanner(System.in);
		double principle,rate,time;
		System.out.println("QuestionPlease enter the principle amount of the loan");
		principle = in.nextDouble();
		System.out.println("Please enter the interest rate on the loan");
		rate = in.nextDouble();
		System.out.println("Please enter the time on the loan");
		time = in.nextDouble();
		System.out.println("The interest is " + principle*(rate/100)*time);
		return principle*rate*time;
	}
}
