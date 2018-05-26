package com.revature.toomuchhw;

import java.util.Date;

/*Q14. Write a program that demonstrates the switch case. Implement the following functionalities in the cases:java
Case 1: Find the square root of a number using the Math class method.
Case 2: Display today’s date.
Case 3: Split the following string and store it in a string array.
       	 “I am learning Core Java”*/
public class Problem14 {

	public void switchCases(int x) {
		switch(x) {
			case 1:
				double squareRoot = Math.sqrt(16.0);
				System.out.println(squareRoot+' ');
				break;
			case 2:
				Date date = new Date();
				System.out.println(date);
				break;
			case 3:
				String s = "I am learning Core Java";
				String[] strArr = s.split("");
				for(String t:strArr) {
					System.out.print(t+'/');
				}
				System.out.println();
				break;
		}
	}

}
