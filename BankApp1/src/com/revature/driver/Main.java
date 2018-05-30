package com.revature.driver;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		System.out.println("Welcome to the banking app login. Please choose an option below: ");
		System.out.println("1) Existing Customer Login");
		System.out.println("2) New Customer Login (Create An Account)");
		System.out.println("3) Employee Login");
		System.out.println("4) Administrator Login");
		System.out.print(">");
		
		Scanner sc = new Scanner(System.in);
		int startOption = sc.nextInt();
		
		Customer c1 = new Customer();
		Employee e1 = new Employee();
		Admin a1 = new Admin();
		
		switch (startOption) {
		
		case 1: c1.login();
			break;
		case 2: c1.newUserLogin();
			break;
		case 3: e1.login();
			break;
		case 4: a1.login();
			break;
		default: System.out.println("Invalid option! Please choose a valid option from the menu.");
			break;
			
		}
	}


}
