package homework1;

import java.util.ArrayList;

public class Q12
{
	
	//Write a program to store numbers from 1 to 100 in an array. 
	//Print out all the even numbers from the array. Use the enhanced FOR loop for printing out the numbers.
	private static boolean isPrime(int i)
	{
		//started a  counter
		int counter = 0;
		
		for(int j = 1; j <= i; j++)
			if( i % j == 0)
				counter++;
			
		if( i <= 3 )
			return true;
		else if( counter > 2)
			return false;
		else
			return true;
	}
	
	
	public static void main(String[] args)
	{
		ArrayList<Integer> list = new ArrayList<Integer>();
		// storing the number from 1 to 100 in a for loop statement 
		for(int i = 1; i <= 100; i++)
		{
			list.add(i);
			if( isPrime(i) )
				//print out results, out is all even numbers from the array
				System.out.print(i + ", ");
		}
		
	}
}