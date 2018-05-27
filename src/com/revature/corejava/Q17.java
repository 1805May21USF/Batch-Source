package com.revature.corejava;

import java.util.Scanner;

public class Q17 
{
	private double rate;
	private double principal;
	private double time;
	
	public static Scanner input = new Scanner(System.in);
	
	//Prompts user for input and calculates the interest.
	public void calcIntrest()
	{
		//Scanner input = new Scanner(System.in);
		System.out.println("Enter in amount you wany to invest");
		this.principal = input.nextDouble();
		System.out.println("Enter in the rate of return");
		this.rate = input.nextDouble();
		System.out.println("Enter in how many years");
		this.time = input.nextDouble();
		System.out.println(this.time);
		System.out.println("Amount earned would be $"+this.principal * this.rate * this.time);
	}
}
