package com.revature.first;

public class Factorial {
	
	public void fac(int x) 
	{
		int result = 1;
		
		for(int i=1; i<=x; i++) 
		{
			result = result*i;
		}
		
		System.out.println("The Factorial of "+x+" is : "+result);
		
	}

}
