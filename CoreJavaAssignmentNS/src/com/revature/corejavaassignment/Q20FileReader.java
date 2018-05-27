package com.revature.corejavaassignment;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Q20FileReader {
	
	private final static String fileName = "Data.txt";
	private static String line = "";
	
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
	
	public static void fileReaderDemo() {
		fileReader(fileName);
	}
	
	public static void main(String[] args) {
		fileReader(fileName);
	}

}
