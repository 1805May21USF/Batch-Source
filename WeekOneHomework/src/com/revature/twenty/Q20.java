/****************************************************
 * 		Name: Q20									*
 * 		Purpose: Read lines of text from a file and *
 * 				 print the input in a particular	*
 * 				 format
 * 		Author: Thomas Loyd							*
 ****************************************************/
package com.revature.twenty;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

public class Q20 {
	public static void readFile() {
		// Retrieves the Data.txt file in the current directory
		URL filePath = Q20.class.getResource("Data.txt");
		File file = new File(filePath.getFile());
		
		try {
			// Creates a BufferedReader to read the file and a String to hold each line of text
			BufferedReader br = new BufferedReader(new FileReader(file));		
			String line;
			
			while((line = br.readLine()) != null) {
				// Splits the lines in the text file by a separator character
				String[] input = line.split(":");
				// Prints the input in the preferred format
				System.out.printf("Name: %s %s\nAge: %s years\nState %s State\n\n", input[0], input[1], input[2], input[3]);
			}
		// Executes if the file can't be found
		} catch (IOException e) {
			System.out.println("File not found!");
		}
	}
}
