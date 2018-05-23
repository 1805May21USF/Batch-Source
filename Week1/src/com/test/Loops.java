package com.test;

import java.util.Scanner;

public class Loops {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Input: ");
		String key = s.nextLine();
		int x1 = 10;
		
		switch (key) {
		case "for":
			for(int i = 0; i < 10; i+=2) {
				System.out.println(i);
			}
			break;
			
		case "do":
					int x = 1;
					do {
						System.out.println("Hey it is a do while loop!" );
						--x;
						
					} while (x > 0);
			break;
			
		case "if":
			if(x1 >= 10) {
				System.out.println("I like class, i will be on time");
			}else {
				System.out.println("I need more sleep before I go to class");
			}
			break;

		default:
			while(x1 < 11) {
				System.out.println("While loop nice huh");
				x1++;
			}
			
			break;
		}

	}

}
