package com.revature.driver;

import java.util.Scanner;

public class Main {
	
	static Scanner input = new Scanner(System.in);
	
	static int happy;
	static int howhappy;
	static int counter;
	
	public static void main(String[] args) {
		
		happy = 0;
		counter = 0;
		
		System.out.println("Are you happy? ");
		
		happy = input.nextInt();
		
		if(happy != 0) {
			
			System.out.println("How happy are you? ");
			howhappy = input.nextInt();
			
			switch(howhappy) {
			case(0):
				System.out.print("I'm kinda");
				for(int i = 0;i<=howhappy;i++) {
					System.out.print(" happy");
				}
				counter = 0;
				
				do {
					System.out.print("!");
					counter++;
				}while(counter<howhappy);
					
				counter = 0;
				while(counter<howhappy) {
					System.out.print("\nRoll Tide");
					counter++;
				}
				break;
			case(1):
				System.out.print("I'm ");
				for(int i = 0;i<=howhappy;i++) {
					System.out.print(" happy");
				}
				counter = 0;
				
				do {
					System.out.print("!");
					counter++;
				}while(counter<howhappy);
					
				counter = 0;
				while(counter<howhappy) {
					System.out.print("\nRoll Tide");
					counter++;
				}
				break;
			case(2):
				System.out.print("I'm really fjkdlasjfkl3jjkt-ing ");
				for(int i = 0;i<=howhappy;i++) {
					System.out.print(" happy");
				}
				counter = 0;
				
				do {
					System.out.print("!");
					counter++;
				}while(counter<howhappy);
					
				counter = 0;
				while(counter<howhappy) {
					System.out.print("\nRoll Tide");
					counter++;
				}
				break;
			}
			
		}
		else {
			System.out.println("Get happy then");
		}
		
	}

}
