package com.revature.homeworks;

import java.net.StandardSocketOptions;

public class Triangle {
	String newLine = System.getProperty("line.separator");//This will retrieve line separator dependent on OS.

	public void triangleLoop()
	{
		
		//outer for loop to determine number of rows
		for (int i = 1; i <= 4; i++)
		{
			int x = 0;
			int y = 1;
			
			//set x or y depending on the current row
			switch(i)
			{
				case 1:
				{x = 1; y = 0;}
				break;
				case 2:
				{x = 0; y = 1;}
				break;
				case 3:
				{x = 0; y = 1;}
				break;
				case 4:
				{x = 1; y = 0;}
				break;
			}
			
			//for loop it iterate how many items get printed out in current row
			for( int j = 1; j <= i; j++)
			{
				
				//determines if number to be printed out is 1 or 0
				if (j % 2 == 0)
				{
					
					System.out.print(x);
					
				}
				else 
				{
					System.out.print(y);
					
				}
			}
			System.out.println();
		}
	}

	//run method that is called by the main
		 public void run()
			{
				System.out.println("Question Thirteen: " + newLine + "-----------------------------");
				System.out.println("Printing out triangle. (Using Loops)");
				triangleLoop();
				System.out.println("-----------------------------");
				System.out.println();
			}

}
