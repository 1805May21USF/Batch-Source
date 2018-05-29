package com.revature.first;

import java.util.Scanner;

public class Question17 {
	
	private double principal;
	private double rateOfInterest;
	private double times;
	
	Scanner input = new Scanner(System.in);
	
	public void setPrincipal() 
	{
		System.out.print("Principal: ");
		double prin = input.nextDouble();
		principal = prin;
	}
	
	public void setRateOfInterest() 
	{
		System.out.print("Rate Of Interest: ");
		double rOInterest = input.nextDouble();
		rateOfInterest = rOInterest;
	}
	
	public void time() 
	{
		System.out.print("Number of Years: ");
		double number = input.nextDouble();
		times = number;
		
	}
	
	public void interest() 
	{
		System.out.println("The Interest is: "+principal*rateOfInterest*times);
	}

}
