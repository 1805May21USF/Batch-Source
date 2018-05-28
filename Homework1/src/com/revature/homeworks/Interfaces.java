package com.revature.homeworks;

interface Operation
{
	void add(int x, int y);
	void subtract(int x, int y);
	void multiply(int x, int y);
	void divide(int x, int y);
	
}

public class Interfaces implements Operation 
{
	
	String newLine = System.getProperty("line.separator");//This will retrieve line separator dependent on OS.

	
	//Implements the functionalities of the interface
	@Override
	public void add(int x, int y) {
		
		System.out.println("The sum of these numbers is: " + (x + y));
		
	}

	@Override
	public void subtract(int x, int y) {
		
		System.out.println("Subtracting these two numbers gives: " + (x - y));
	}

	@Override
	public void multiply(int x, int y) {
		
		System.out.println("Multiplying these two numbers gives: " + (x * y));
	}

	@Override
	public void divide(int x, int y) {
		
		System.out.printf("Dividing these two numbers gives: " + "%.2f",((double)x/y));
	}

	//run method that is called by the main
	public void run()
	{
		System.out.println("Question Fifteen: " + newLine + "-----------------------------");
		System.out.println("Carrying out Addition, Subtraction, Multiplication and division of 24 and 17.");
		System.out.println("-----------------------------" + newLine);
	}
}

