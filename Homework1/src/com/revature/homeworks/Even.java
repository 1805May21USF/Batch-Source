package com.revature.homeworks;

public class Even {
	
	String newLine = System.getProperty("line.separator");//This will retrieve line separator dependent on OS.
	
	
	//Divides number by two and gets the result.
	//multiplies it by two and if that is equal to number, it is even.
	public int isItEven(int number)
	{
		if ((number/2) * 2 == number )
		{
			 System.out.println("Number is Even");
		}
		else
		{
			System.out.println("Number is not Even");
		}
		
		return number;

	}
	
	
	//run method that is called by the main
	 public void run()
		{
				System.out.println("Question Six: " + newLine + "-----------------------------");
				System.out.println("Is the number even?");
				System.out.println(isItEven(10));
				System.out.println("Is the number even?");
				System.out.println(isItEven(15));
				System.out.println("-----------------------------");
				System.out.println();
		}
}
