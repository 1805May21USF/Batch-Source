package com.revature.scanner;

import java.util.Scanner;

public class FunScan {
	public static Scanner sc = new Scanner(System.in);
	
	public static void printMe() {
		String contents;
		String contents1;
		System.out.println("What would you like to print?");
		contents= sc.nextLine();
		
		System.out.println("What would you like also to print?");
		
		contents1= sc.nextLine();
		
		
		//sc.close();
		System.out.println(contents);
		System.out.println(contents1);
		//sc.reset();
		System.out.println("test");
		System.out.println("again");
		contents= sc.nextLine();
		System.out.println(contents);
	}
	
	public static void main(String[] args) {
		printMe();
	}
}
