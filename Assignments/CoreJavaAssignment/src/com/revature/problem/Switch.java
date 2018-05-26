package com.revature.problem;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Switch {
	public static void switchProblem(int i) {
		switch(i) {
			//Square root
			case 0:
				System.out.println("Square root of 25 is : " + Math.sqrt(25));
				break;
			//Current Date
			case 1:			
			    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");  
			    LocalDateTime now = LocalDateTime.now(); 
			    System.out.println("Today's date is " + dtf.format(now)); 
				break;
			//Split string
			case 2:
				String str = "I am learning Core Java";
				String[] strSplit = str.split(" ");
				System.out.println("'" + str + "' split into array: " + strSplit);
				break;
		}
	}
	
}
