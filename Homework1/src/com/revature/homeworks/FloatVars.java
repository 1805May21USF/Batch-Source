package com.revature.homeworks;
import com.revature.floating.*;

public class FloatVars {
	String newLine = System.getProperty("line.separator");//This will retrieve line separator dependent on OS.
	
	//method to add two different floats together
	public float add(float x, float y )
	{
		float sum = x + y;
		
		return sum;
	}
	
	
	
	//run method that is called by the main
		 public void run()
			{
			 
			 	//Instantiatea float object to be able to use variables in the package (com.revature.floating)
			 	Floats f1 = new Floats();
				System.out.println("Question Eleven: " + newLine + "-----------------------------");
				System.out.println("Printing out the sum of two float variables from another package");
				System.out.println(add(f1.l, f1.f));
				System.out.println("-----------------------------");
				System.out.println();
			}

}
