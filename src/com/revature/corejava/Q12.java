package com.revature.corejava;

public class Q12 
{
	private int[] numbers;
	
	//Build the array - int[100]
	public Q12()
	{
		this.numbers = new int[101];
		for(int i = 1; i <= 100; i++)
		{
			this.numbers[i] = i;
		}
	}
	//Go through the int[] and display only the even numbers by testing with %
	public void displayEvenNumbers()
	{
		for(int intTemp: this.numbers)
		{
			if(intTemp % 2 == 0)
			{
				System.out.print(intTemp + " ");
			}
		}
		System.out.print("\n");
	}
}
