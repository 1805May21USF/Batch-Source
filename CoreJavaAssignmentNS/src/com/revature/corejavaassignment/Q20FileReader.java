package com.revature.corejavaassignment;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Reads information from a .txt file, formats it
 * into a user-friendly format, and outputs it
 * to the console.
 * @author Nathaniel Simpson
 *
 */
public class Q20FileReader {
	
	private final static String fileName = "Data.txt";
	private static String line = "";
	
	/*
	 * Reads information from a .txt file, formats it
	 * into a user-friendly format, and outputs it
	 * to the console.
	 * @param fileName - the name of the .txt file
	 */
	private static void fileReader(String fileName) {
		
		System.out.println("Q20. FileReader");
		
		try {
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
			
			while ((line = br.readLine()) != null) {
				String[] input = line.split(":");
				
				System.out.println("\tName: " + input[0] + " " + input[1]);
				System.out.println("\tAge: " + input[2] + " years");
				System.out.println("\tState: " + input[3] + " State");
				System.out.println();
			}
			
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found");
		} catch (IOException e) {
			System.out.println("Unable to read the file");
		} 
		
	}
	
	/*
	 * Demonstrates the file reader.
	 */
	public static void fileReaderDemo() {
		fileReader(fileName);
	}
	
	/*
	 * For testing
	 */
	public static void main(String[] args) {
		fileReader(fileName);
	}

}
