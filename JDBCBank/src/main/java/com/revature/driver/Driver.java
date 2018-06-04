package com.revature.driver;

import com.revature.ui.Menu;

public class Driver {
	
	public static void main(String[] args) {
		
		printHeader();
		Menu menu = new Menu();
		menu.initializeMenu();
		
	}
	
	public static void reinitialize() {
		Menu menu = new Menu();
		menu.initializeMenu();
	}
	
	private static void printHeader() {
		System.out.println("+---------------------------------+");
		System.out.println("|--Welcome to Bank of Roll Tide!--|");
		System.out.println("+---------------------------------+");
		System.out.println();
	}

}
