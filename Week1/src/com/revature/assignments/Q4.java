package com.revature.assignments;
import java.util.Scanner;

public class Q4 {
	static Scanner in = new Scanner(System.in);
	private int factorial = 1;
	private static int factorialTotal = 1;
	public static boolean factorialGiven = false;
	
	
	public void doWork() {
		
		while(factorialGiven == false) {
		try {
			System.out.println("Enter a number to factorize!");
			factorial = in.nextInt();
		}catch(Exception e) {
			System.out.println("Whatever you did was stupid try again!");
		}
		
		//while i is less than the inputted number
		//increment i and multiply it by the running total.
		for(int i = 2; i <= factorial; i++){
			factorialTotal = i * factorialTotal;
			
			}
			System.out.println(factorialTotal);
			factorialGiven = true;
		}
	}
}