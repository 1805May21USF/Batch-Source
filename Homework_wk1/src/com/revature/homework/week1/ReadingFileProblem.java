package com.revature.homework.week1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadingFileProblem {
	//reads from the 'Data.txt' file
	//and prints it out on the console

	public void readFile() {
		String filename = "Data.txt"; //filename
		String str = " ";
		
		try {
			FileReader file = new FileReader(filename); //reads the "data.txt" file
			
			BufferedReader reader = new BufferedReader(file); // wraps the filereader
			
			while((str = reader.readLine()) != null) {
				//prints the string from the file
				String[] strArray = str.split(":");
				System.out.println("Name: " + strArray[0] + " " + strArray[1]);
				System.out.println("Age: " + strArray[2] + " years");
				System.out.println("State: " + strArray[3] + " State");
			}
			
			reader.close();
		}catch(FileNotFoundException e) {
			System.out.println("File could not be open");
		}catch(IOException e) {
			System.out.println("File reading error");
		}
	}
}
