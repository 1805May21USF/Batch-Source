package com.revature.hw1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class P20Display {
	static ArrayList<P20PersonObject> people;
	public static void setUp() {
 
		people = new ArrayList<P20PersonObject>();
		File file = new File("personinfo.txt");
		Scanner sc;
		try {
			sc = new Scanner(file);
			while(sc.hasNextLine()) {
				String[] line = sc.nextLine().split(":");
				people.add(new P20PersonObject(line[0]+ "  "+line[1], Integer.valueOf(line[2]), line[3]));			
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public static void printOut() {
		setUp();
		for (P20PersonObject p : people) {
			System.out.println("Name: " + p.getName());
			System.out.println("Age: " + p.getAge());
			System.out.println("State: " + p.getState() + " State");
			System.out.println("");
		}
	}
}
