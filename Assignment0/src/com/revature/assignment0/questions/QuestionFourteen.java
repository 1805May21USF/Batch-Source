package com.revature.assignment0.questions;

import java.util.*;

public class QuestionFourteen {
	public static void Question_Fourteen() {
		
		System.out.println("\r------Question Fourteen-------");
		System.out.println("14.) Write a program that demonstrates the switch case. Implement the following functionalities in the cases:javar.\r");
		/*
		 * Create a scanner to accept inputs
		 * Set repeat to false to allow the while loop to repeat if they input wrong
		 */
		Scanner input = new Scanner(System.in);
		boolean repeat = false;
		String string_array = "I am learning Core Java";
		
		while(repeat == false) {
			
			System.out.println("What do you want to do?\r" +
					"1) Find the square root of a number using the Math class method.\r" +
					"2) Display today’s date.\r" +
					"3) Split the following string and store it in a string array.");
			
			//Gather input from user
			String i = input.next();
			
			//Use a custom tryparse that will make sure the text entered is a number and not a letter
			if (tryParseInt(i)) {  
				  int input_integer = Integer.parseInt(i);
				   
				  //Use a switch statement based on user input to produce the corresponding content
				   switch(input_integer) {
					case 1:
						boolean move_forward = false;
						while(move_forward == false) {
							//Ask for antother input and if they do not entere a number it will keep repeating
							System.out.println("\rEnter a number to square root!" );
							i = input.next();
							//Use the tryparse again to make sure that the text entered is a number
							if (tryParseInt(i)) {  
									//Square root the number and write it
								   input_integer = Integer.parseInt(i);
									System.out.println(Math.sqrt(input_integer));
									move_forward = true;
							} else {
								//When the number entered is wrong
								System.out.println("\"" + i +"\" is not a valid input!" );
							}
						}
						break;
					case 2:
						//Produces current date
						System.out.println("Today's date is: " + new Date() + "\r");
						break;
					case 3:
						//Split the string to a char array based on space
						System.out.println(Arrays.toString(string_array.split(" ")));
						break;
					default:
						//When the number entered is wrong
						System.out.println("\r\"" + i +"\" is not a valid input!\r" );
				   }
				} else {
					//When the number entered is wrong
					System.out.println("\r\"" + i +"\" is not a valid input!\r" );
				}
			
			System.out.println("Do you want to try again? \"Yes or No\"");
			
			//Used to check to see if the user wants to do it again
			String finished = input.next();
			
			//Changes the repeat variable to see if it will continue
			repeat = (finished.toLowerCase().equals("yes")) ? false : true;
			}
		}
	
	 static boolean tryParseInt(String value) {  
	     try {  
	         Integer.parseInt(value);  
	         return true;  
	      } catch (NumberFormatException e) {  
	         return false;  
	      }  
	}
}
