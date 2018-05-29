package com.revature.assignment0.questions;

import java.util.Scanner;

public class QuestionSeventeen {
		public static void Question_Seventeen() {

			System.out.println("\r------Question Seventeen-------");
			System.out.println("17.) Write a program that calculates the simple interest on the principal, rate of interest and number of "
					+ "years provided by the user. Enter principal, rate and time through the console using the Scanner class.\r\n" + 
					"Interest = Principal* Rate* Time.\r");
			
			//Call the three methods that the question needs to compute simple interest
			float principle = simple_intrest("principle");
			float rate = simple_intrest("rate");
			float time = simple_intrest("time");
			
			//Prints out the formula and output
			System.out.println("$" + principle + " * " + rate + "% * " +  time + " years = $" + principle * rate * time);
;		}
		
		public static float simple_intrest(String command) {
			
			//Use a scanner to accept a user input
			Scanner input = new Scanner(System.in);
			
			//Used to make sure the code does not exit the while loop while it is false
			boolean pass =  false;
			float input_integer = 0;
			
			while(pass == false) {
				//Takes the string passed and inputs it in to the command
				System.out.println("Enter your " + command);
				//Accepts a new input from the user to store it in the variable that called it
				String i = input.next();
				
				//Used to check to see if the text entered is a number and not to throw any exceptions
				if (tryParseInt(i)) {  
					    input_integer = Integer.parseInt(i);
					    //Once it is passed it will set the pass to true exiting the loop
						pass = true;
						
				} else {
					//Entered the wrong input
					System.out.println("\"" + i +"\" is not a valid input!" );
				}
			}
			return input_integer;
		}
		
		//Used to check to see if there was an error, if there is an error it will send a false report back allowing me to submit a string
		static boolean tryParseInt(String value) {  
		     try {  
		         Integer.parseInt(value);  
		         return true;  
		      } catch (NumberFormatException e) {  
		         return false;  
		      }  
		}
	}
