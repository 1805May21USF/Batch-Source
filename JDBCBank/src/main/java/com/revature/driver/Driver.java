package com.revature.driver;

import com.revature.ui.Menu;

/**
 * Initializes the program.
 * @author Nathaniel Simpson
 *
 */
public class Driver {
	
	public static void main(String[] args) {
		
		printHeader();
		Menu menu = new Menu();
		menu.initializeMenu();
		
	}
	
	/*
	 * Reinitializes the program. A run method should have been used,
	 * but was overlooked until late into development.
	 */
	public static void reinitialize() {
		Menu menu = new Menu();
		menu.initializeMenu();
	}
	
	/*
	 * Prints the header for the program.
	 */
	private static void printHeader() {
		System.out.println("+---------------------------------+");
		System.out.println("|--Welcome to Bank of Roll Tide!--|");
		System.out.println("+---------------------------------+");
		System.out.println();
	}

}
