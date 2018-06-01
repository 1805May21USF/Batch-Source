package com.revature.driver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
	
	public static String[] strs = {"Wow","Hey","Dude","Yo","Ya","Yz","Tide Roll"};
	
	public static void main(String[] args) {
		
		//Adds strs elements to a new array list
		ArrayList<String> strings = new ArrayList<String>();
		strings.addAll(Arrays.asList(strs));
		
		//Prints original string list
		for(String s:strings) {
			System.out.println(s);
		}
		
		System.out.println("\nSorted by second character: \n");
		
		//Sorts the arraylist by the second character using provided lambda expression
		//Sorts by difference in unicode value
		Collections.sort(strings, (arg0,arg1) -> { return arg0.charAt(1) - arg1.charAt(1); });
		
		//Prints sorted string list
		for(String s:strings) {
			System.out.println(s);
		}
		
	}
	
}
