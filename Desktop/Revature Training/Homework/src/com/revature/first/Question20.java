package com.revature.first;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Question20 {
	
	public void Del(String fil) 
	{
		//something to read the file in
		File file = new File(fil);
		
		try 
		{
			Scanner scan = new Scanner(file).useDelimiter("\\s*");
			
			String firstOne = scan.nextLine();
			//System.out.println(firstOne);
			String firstDel = firstOne.substring(0, 6);
			String firstDel1 = firstOne.substring(7, 12);
			System.out.println("Name: "+firstDel+" "+firstDel1);
			String age = firstOne.substring(13, 15);
			System.out.println("Age: "+age+" years");
			String state = firstOne.substring(16, 22);
			System.out.println("State: "+state+" State");
			
			System.out.println("\n");
			
			String secondOne = scan.nextLine();
			String secondDel = secondOne.substring(0, 4);
			String secondDel1 = secondOne.substring(5, 10);
			System.out.println("Name: "+secondDel+" "+secondDel1);
			String age1 = secondOne.substring(11, 13);
			System.out.println("Age: "+age1+" years");
			String state1 = secondOne.substring(14, 22);
			System.out.println("State: "+state1+" State");
			
			
			System.out.println("\n");
			
			String thirdOne = scan.nextLine();
			String thirdDel = thirdOne.substring(0, 5);
			String thirdDel1 = thirdOne.substring(6, 12);
			System.out.println("Name: "+thirdDel+" "+thirdDel1);
			String age2 = thirdOne.substring(13, 15);
			System.out.println("Age: "+age2+" years");
			String state2 = thirdOne.substring(16, 26);
			System.out.println("State: "+state2+" State");
			
			
			System.out.println("\n");
			
			String fourthOne = scan.nextLine();
			String fourthDel = fourthOne.substring(0, 6);
			String fourthDel1 = fourthOne.substring(7, 12);
			System.out.println("Name: "+fourthDel+" "+fourthDel1);
			String age3 = fourthOne.substring(13, 15);
			System.out.println("Age: "+age3+" years");
			String state3 = fourthOne.substring(16, 23);
			System.out.println("State: "+state3+" State");
			
			
		}
		catch(IOException ioe) 
		{
			ioe.printStackTrace();
		}
	}

}
