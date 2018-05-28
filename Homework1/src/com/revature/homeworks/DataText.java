package com.revature.homeworks;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class DataText {
	
	String newLine = System.getProperty("line.separator");//This will retrieve line separator dependent on OS.
	
	public void read() throws FileNotFoundException
	{
		//creates a string for the filename
		String fileName = "src/data.txt";
			
		
			//reads all the lines in text file and splits the lines up at ":"
			try {
				List<String> lines = Files.readAllLines(Paths.get(fileName),StandardCharsets.UTF_8);
				
				for(String s: lines)
				{
					String[] arr = s.split(":");
					String firstName = arr[0];
					String lastName = arr[1];
					int age = Integer.parseInt(arr[2]);
					String state = arr[3];
					
					//creates a new person with the data
					Person person = new Person(firstName, lastName, age, state);
					System.out.println(person.toString() + newLine);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

	//run method that is called by the main
	 public void run() throws FileNotFoundException
		{
				System.out.println("Question Twenty: " + newLine + "-----------------------------");
				System.out.println("Printing out formatted data text...");
				read();
				System.out.println("-----------------------------");
				System.out.println();
		}


}
