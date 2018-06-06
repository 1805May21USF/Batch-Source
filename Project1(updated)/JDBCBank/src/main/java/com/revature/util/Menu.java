package com.revature.util;
import java.util.Scanner;
public class Menu {
	public static Scanner sc = new Scanner(System.in);
	public static void menu() {
		System.out.println("Welcome to the menu");
		if(sc.nextInt()==1) {
			System.out.println("you entered 1");
		}else {
			System.out.println("you did not enter 1");
		}
		
	}
	
}
