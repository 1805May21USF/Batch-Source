package com.revature.toomuchhw;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*Q20. Create a notepad file called Data.txt and enter the following:
Mickey:Mouse:35:Arizona
Hulk:Hogan:50:Virginia
Roger:Rabbit:22:California
Wonder:Woman:18:Montana
 
Write a program that would read from the file and print it out to the screen in the following format:
 
Name: Mickey Mouse
Age: 35 years
State: Arizona State
*/
public class Problem20 {
	String fileName;
	
	public Problem20(String fileName) {
		super();
		this.fileName = fileName;
	}
	
	public void readFile() throws IOException{
		try {
			File file = new File("Data.txt");
			BufferedReader in = new BufferedReader(new FileReader(file));
			String line;
			
			while((line = in.readLine()) != null) {
				String[] n = line.split(":");
				System.out.println("Name: "+ n[0]+" "+n[1]);
				System.out.println("Age: "+ n[2]);
				System.out.println("State: "+n[3]+" State\n");
			}
			in.close();
		}catch(IOException e) {
			System.out.println("Help, I'm Dying!");
		}
	}

}
