//the next number is the sum of the previous two numbers 

package com.revature.first;

public class Fibonacci {
	
	public static void fib(int number) //parameter == index 
	{
		
		//Initializing the first two numbers
		int current = 1;
		int last = 0;
		System.out.print(last+" ");
		System.out.print(current+" ");
		
		//printing out the rest of the numbers
		int lLast;
		for(int i=2; i<= number; i++) 
		{
			lLast = last;
			last = current;
			current = lLast + last;
			System.out.print(current+" ");
		} 
		
	}

}
