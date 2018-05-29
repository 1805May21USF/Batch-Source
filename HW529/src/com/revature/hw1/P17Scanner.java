package com.revature.hw1;

import java.util.Scanner;

public class P17Scanner {
	public static void calcInterest() {
		Scanner sc=new Scanner(System.in); 
		System.out.println("Enter your principal");  
		double princ=sc.nextDouble(); 
		System.out.println("Enter your rate of interest");  
		double roi=sc.nextDouble(); 
		System.out.println("Enter your time(yrs)");  
		double yrs=sc.nextDouble(); 
		System.out.println(princ*roi*yrs);
	}
}
