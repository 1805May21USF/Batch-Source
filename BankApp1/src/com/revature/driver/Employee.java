package com.revature.driver;

import java.util.Scanner;

public class Employee extends User {
	
	public Employee() {
		
	}
	
	public void showEmployeeMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Employee Menu");
		System.out.println("1) View Customers");
		System.out.println("2) View Accounts");
		System.out.println("3) View Applications");
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
