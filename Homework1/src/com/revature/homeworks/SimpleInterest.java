package com.revature.homeworks;

import java.util.Scanner;

public class SimpleInterest {
	
	double prin, rate;
	int time;
	public double sI;
	String newLine = System.getProperty("line.separator");//This will retrieve line separator dependent on OS.
	
	public Double sICalculator(double p, double r, int t)
	{
		sI = (p * r * t)/ 100;
		
		return sI;
	}

	//run method that is called by the main
		public void run()
		{	
			System.out.println();
			Scanner input = new Scanner(System.in);
			System.out.println(newLine + "Question Seventeen: " + newLine + "-----------------------------");
			System.out.println("Enter in the Principal: ");
			prin = input.nextDouble();
			System.out.println("Enter in the Rate: ");
			rate = input.nextDouble();
			System.out.println("Enter in the Time as an integer value: ");
			time = input.nextInt();
			System.out.println("The Simple Interest is: " + sICalculator(prin, rate, time));
			System.out.println("-----------------------------" + newLine);
		}

}
