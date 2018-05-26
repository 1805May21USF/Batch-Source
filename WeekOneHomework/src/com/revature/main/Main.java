/****************************************************
 * 		Name: Main									*
 * 		Purpose: Provides a UI to access the 20     *
 * 				 Q classes based on user input   	*
 * 		Author: Thomas Loyd							*
 ****************************************************/
package com.revature.main;

import com.revature.ten.*;
import com.revature.twenty.*;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// Creates a scanner to receive user input
		Scanner scan = new Scanner(System.in);
		
		// Creates a flag to constantly accept user input
		boolean flag = true;
		
		while(flag) {
			// Requests a number from 1 to 20
			System.out.println("Please enter an integer from 1 to 20 or exit: ");
			
			String input = scan.nextLine();
			
			// Tests if exit was entered and exits the program if it was
			if(input.equalsIgnoreCase("exit"))
				System.exit(1);
			
			try {
				int i = Integer.parseInt(input);
				
				// Switch case to determine which number was entered and properly executes the corresponding Q class
				switch(i) {
					case (1): System.out.println("Running bubble sort program...");
					          Q01.bubbleSort();
					          break;
					case (2): System.out.println("Running fibonacci program...");
			          		  Q02.fibonacci();
			          		  break;
					case (3): System.out.println("Running String reversal program...");
	          		  		  Q03.reverse();
	          		  		  break;
					case (4): System.out.println("Running factorial program...");
    		  		  		  Q04.factorial(scan);
    		  		  		  break;
					case (5): System.out.println("Running substring program...");
	  		  		  		  Q05.substring(scan);
	  		  		  		  break;
					case (6): System.out.println("Running odd or even program...");
	  		  		  		  Q06.oddOrEven(scan);
	  		  		  		  break;
					case (7): System.out.println("Running sort employees program...");
	  		  		  		  Q07.sortEmployees();
	  		  		  		  break;
					case (8): System.out.println("Running seperate palindromes program...");
	  		  		  		  Q08.palindromeArrayList();
	  		  		  		  break;
					case (9): System.out.println("Running print prime numbers program...");
	  		  		 		  Q09.prime();
	  		  		 		  break;
					case (10): System.out.println("Running ternary minimum program...");
	  		  		  		  Q10.minimum(scan);
	  		  		  		  break;
					case (11): System.out.println("Running access seperate package program...");
							   Q11.print();
							   break;
					case (12): System.out.println("Running print even numbers program...");
	          		  		   Q12.printEven();
	          		  		   break;
					case (13): System.out.println("Running triangle display program...");
							   Q13.triangle();
							   break;
					case (14): System.out.println("Running switch program...");
							   Q14.stringSwitch(scan);
							   break;
					case (15): System.out.println("Running calculator program...");
							   Q15.calculate();
							   break;
					case (16): System.out.println("Please enter a string of letters: ");
							   String line = scan.nextLine();
							   String[] lines = line.split(" ");
							   Q16.main(lines);
							   break;
					case (17): System.out.println("Running interest calculator program...");
							   Q17.interest(scan);
							   break;
					case (18): System.out.println("Please enter a string of letters: ");
					   		   String stringLine = scan.nextLine();
					   		   String[] stringLines = stringLine.split(" ");
					   		   Q18.main(stringLines);
							   break;
					case (19): System.out.println("Running array list modification program...");
	  		 		  		   Q19.printSpecial();
	  		 		  		   break;
					case (20): System.out.println("Running file format program...");
							   Q20.readFile();
							   break;
					// Executes if any other number was entered
					default:   System.out.println("The integer entered must be between 1 and 20!");
				}
			// Executes if the entered value wasn't an integer or exit
			}catch(NumberFormatException e) {
				System.out.println("That wasn't the word exit or an integer!");
			}
		}
		
		scan.close();
	}
}
