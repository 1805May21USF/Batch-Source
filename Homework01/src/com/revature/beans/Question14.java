package com.revature.beans;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Question14 {
	
	public void runSwitch(int caseNumber) {
		switch (caseNumber) {
			case 1: findSquareRoot();
				break;
			case 2: printDate();
				break;
			case 3: splitString();
				break;
			default: System.out.println("Invalid case number!");
				break;
		}
	}
	
	public void findSquareRoot() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number to find square root of: ");
		int number = sc.nextInt();
		System.out.println("The square root of " + number + " is " + Math.sqrt(number));
	}
	
	public void printDate() {
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");  
	    Date date = new Date();  
	    System.out.println("Today's date: " + formatter.format(date));
	}
	
	public void splitString() {
		String s = "I am learning Core Java";
		String [] arr = s.split(" ");
		for(String s2 : arr) {
			System.out.println(s2);
		}
		
	}

}
