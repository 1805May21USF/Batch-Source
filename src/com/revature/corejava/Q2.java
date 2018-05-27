package com.revature.corejava;

public class Q2 
{
	
	private int[] myFibArray;
	
	public Q2()
	{
		this.myFibArray = new int[25];
	}
	
	//returns the fibonacci array
	public int[] getArray()
	{
		return this.myFibArray;
	}
	
	//Runs the calculations to get the first 25 fibonacci numbers
	public void calcFirst25FibNumbers()
	{
		this.myFibArray[0] = 0;
		this.myFibArray[1] = 1;
		
		for(int i = 2; i < 25; i++)
		{
			this.myFibArray[i] = this.myFibArray[i-2] + this.myFibArray[i-1];
		}
				
	}

}
