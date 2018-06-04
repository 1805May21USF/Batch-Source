package homework1;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Q14
{
	 //Write a program that demonstrates the switch case. Implement the following functionalities in the cases:java
	 //Case 1: Find the square root of a number using the Math class method.
	 //Case 2: Display today’s date.
	 //Case 3: Split the following string and store it in a string array.
	 //“I am learning Core Java”
	
	public static void doCase(int i)
	{
		// using at switch statement
		try( Scanner scan = new Scanner(System.in) )
		{
			switch(i)
			{
				case 1:                 
					System.out.println("Enter a number: ");
					double num = scan.nextDouble();
					System.out.println("The square root of " + num + " is: " + Math.sqrt(num));
					break;
				case 2:
					Date today = Calendar.getInstance().getTime();
					System.out.println("Today's date is: " + today);
					break;
				case 3:
					String str = "I am Learning core java";
					String[] arr = str.split("\\s");
					for(String s: arr)
						System.out.println(s);
					break;
			}
		} //end-try
		
		catch(Exception e)
		{
			e.printStackTrace();
		} 
		
	}
	
	
	public static void main(String[] args)
	{	//print out results
		doCase(1);
		System.out.println();
		doCase(2);
		System.out.println();
		doCase(3);	
	}
}