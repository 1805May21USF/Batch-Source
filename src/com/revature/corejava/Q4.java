package com.revature.corejava;

public class Q4 
{
	private long factorialNumber;
	private int factorial;
	
	public long getFactorialNumber()
	{
		return this.factorialNumber;
	}
	
	
	//Loads in a default number for factorial, if inputed is less than 0, 0 is set as the default and user notified
	public Q4()
	{
		this.factorialNumber = 0;
		this.factorial = 5;
	}
	
	public Q4(int factorial)
	{
		if(factorial >= 0 )
		{	
			this.factorial = factorial;
		}
		else
		{
			System.out.println("Factorial number must be >= 0. Set to 0");
			this.factorial = 0;
		}
	}
	//Calculates the factorial of a number inputed by use of a for loop by starting at that number and working backwards to 1
	public void calcFactorialNumber()
	{
		this.factorialNumber = this.factorial;
		for(int i = this.factorial - 1; i>0; i--)
		{
			this.factorialNumber = this.factorialNumber * i;
		}
	}
	
}
