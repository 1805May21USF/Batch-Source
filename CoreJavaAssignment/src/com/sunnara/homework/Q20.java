package com.sunnara.homework;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * Create a notepad file called Data.txt and enter the following:
 * Mickey:Mouse:35:Arizona
 * Hulk:Hogan:50:Virginia
 * Roger:Rabbit:22:California
 * Wonder:Woman:18:Montana
 *
 * Write a program that would read from the file and print it out to the screen in the following format:
 *
 * Name: Mickey Mouse
 * Age: 35 years
 * State: Arizona State
 */
public class Q20 {

	private final String DATA = "Data.txt"; //text file won't change name
	
	public void start() {
		readFile();
	}

	public void readFile() {
		File f = new File(DATA);
		Scanner input = null;
		try {
			input = new Scanner(f);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(input.hasNextLine()) { 	//checks to see if line exists
			String[] line = (input.nextLine().split(":")); //Splits line into array using ":"
			System.out.printf("Name: %s %s\nAge: %s years\nState: %s State\n\n",
					line[0],line[1],line[2],line[3]);			
		}

	}

}