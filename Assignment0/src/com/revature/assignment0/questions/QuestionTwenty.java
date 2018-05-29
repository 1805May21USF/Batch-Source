package com.revature.assignment0.questions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class QuestionTwenty {
	
	public static void Question_Twenty() {
		
		System.out.println("\r------Question Twenty-------");
		System.out.println("20.) Write a program that would read from the file and print it out to the screen.\r");
		
		try {
			/*
			 * I put this in a try catch block to attempt to catch a file not found exception.
			 * Created four string variables to attach the file values to
			 */
			String first_name, last_name, age, state;
			
			//Accessing the file
			Scanner  output = new Scanner (new File("C:\\Users\\JonWi\\Desktop\\Data.txt"));
			
			//The delimiter is used to separate the values in the text file
			output.useDelimiter(":");
			
			//While there is a next line
			while (output.hasNext())
			{
				first_name = output.next();
				last_name = output.next();
				age = output.next();
				state = output.next();
				
				//Prints out the information in the correct order that I wanted
				System.out.println("Name: " + first_name + " " + last_name + "\r"+
						"Age: " + age + "\r" +
						"State: " + state + "\r");
			}
			
			//Close the scanner
			output.close();
		} catch (FileNotFoundException e) {
			//Used to catch a filenotfound
			e.printStackTrace();
		}
	}
}
