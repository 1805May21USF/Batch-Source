package com.revature.homeworks;

import java.util.Date;

public class Switch {
	
	String newLine = System.getProperty("line.separator");//This will retrieve line separator dependent on OS.

	public void switching(int num )
	{
		
		//Switch statement with three cases based on what is passed in
		switch(num)
		{
			//uses math.sqrt to obtain the sqrt
			case 1:
				double x = Math.sqrt(164);
				System.out.println("The square root of 164 is: " + x + newLine);
				break;
				//uses Date to obtain current date
			case 2:
				Date date = new Date();
				System.out.println("Todays Date is: " + date + newLine);
				break;
				
			//Splits the String using String split and uses a forEach loop
			case 3:
				String str = "I am learning Core java";
				String[] arr = str.split(" ");
				for (String s :arr)
				{
					System.out.println(s);
				}
				System.out.println();
				break;
			default:
				System.out.println("There is no such Option");
				break;
		}
		
	}

	
	//run method that is called by the main
	 public void run()
		{
			System.out.println("Question Fourteen: " + newLine + "-----------------------------");
			System.out.println("1. Square root of 164 " + newLine + "2. Printing todays date" + newLine + "3. Printing string array of split string");
			System.out.println("___________________________________________" + newLine);
			switching(1);
			switching(2);
			switching(3);
			System.out.println("-----------------------------" + newLine);
		}

}
