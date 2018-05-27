package com.revature.corejava;

public class Q6 
{
	//Checks for even or odd based on the bitwise and op. Number & 1 returns the last bit and an even number is always 0.
	public String EvenOrOdd(int inputNumber)
	{
		if((inputNumber & 1) == 0)
		{
			return "Even Number";
		}else
		{
			return "Odd Number";
		}
	}

}
