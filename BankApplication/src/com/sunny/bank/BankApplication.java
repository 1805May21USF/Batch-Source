package com.sunny.bank;

import java.util.Scanner;

public class BankApplication {
	public static void main(String[] args) {
		BankApplication ba = new BankApplication();
		ba.run();
	}

	public void run() {
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to Sunny's Bank. Please type the corresponding "
				+ "number to continue.");
		System.out.println("1) Login");
		System.out.println("2) Sign up");
		System.out.println("3) Exit");
		String s = input.nextLine();
		int pick = 3;
		boolean onetwo = false;
		while(!onetwo) {
			try {
				pick = Integer.parseInt(s);
				if(pick >= 1 && pick <= 3) {
					onetwo = true;
				} else {
					System.out.println("Please type a valid number.");
					s = input.nextLine();
					pick = Integer.parseInt(s);
				}
			} catch(Exception e) {
				System.out.println("Please type a valid number.");
				s = input.nextLine();
			}
		}
		input.close();
		firstChoice(pick);
	}
	
	public void firstChoice(int i) {
		Scanner in = new Scanner(System.in);
		if(i == 1) {
			System.out.println("Insert Username");
			String user = in.nextLine();
			
			System.out.println("Insert password");
			String pw = in.nextLine();
		} else if (i == 2) {
			
		} else {
			System.out.println("Thank you, goodbye.");
		}
	}
	
	public boolean userExist(String user) {
		return false;
	}
	
	public boolean pwCheck(String user, String pass) {
		return false;
	}

}
