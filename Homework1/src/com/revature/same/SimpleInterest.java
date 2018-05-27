package com.revature.same;

import java.util.Scanner;

public class SimpleInterest {

	public SimpleInterest() {
		// TODO Auto-generated constructor stub
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter Principal: ");
		int x = sc.nextInt();
		System.out.print("Enter Rate: ");
		int y = sc.nextInt();
		System.out.print("Enter Time: ");
		int z = sc.nextInt();
		System.out.println("The Simple Interest is: " + simpleinterest(x,y,z));
	}
	
	public static double simpleinterest(int principal, int rate, int time) {
		double rt = (double)(rate * 1.0) / 100;
		return principal*rate*time;
	}

}
