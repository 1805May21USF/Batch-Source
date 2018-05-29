package com.revature.assignments;
import java.io.File;
import java.util.Scanner;

public class Q20 {
	
	private Scanner in;
	private String fName;
	private String lName;
	private String age;
	private String state;
	
	public void importData() {
		
		try {
			in = new Scanner(new File("Data.txt")).useDelimiter(":|\n");
		}catch(Exception FileNotFoundException) {
			System.out.println("uh oh, your file is missing!");
		}
		finally {
		
		while(in.hasNext()) {
			fName = in.next();
			lName = in.next();
			age = in.next();
			state = in.next();
			System.out.println("Name: " + fName + " " + lName);
			System.out.println("Age: " + age +  " years");
			System.out.println("State: " + state + " State");
			System.out.println();
			
		}
		}
		
	}
	
	
}
