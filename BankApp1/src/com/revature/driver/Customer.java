package com.revature.driver;

import java.util.Scanner;

public class Customer extends User {
	
	public void showCustomerMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Customer Menu");
		System.out.println("1) View Personal Information");
		System.out.println("2) View Account(s)");
		System.out.println("3) Apply For Account");
		System.out.print(">");
		int option = sc.nextInt();
		
		switch (option) {
		
		case 1:
			break;
		case 2: 
			break;
		case 3:
			break;
		default: System.out.println("Invalid option! Please choose a valid option.");
			break;
		}
	}
	
	

}
