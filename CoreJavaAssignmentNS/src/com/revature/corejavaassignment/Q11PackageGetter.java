package com.revature.corejavaassignment;

import com.revature.q11package.*;

/**
 * Accesses two floats located in another package.
 * @author Nathaniel Simpson
 *
 */
public class Q11PackageGetter {
	
	// Creating an object of the class located in a different package.
	private static Q11PackageAccess q11 = new Q11PackageAccess();

	/*
	 * Demonstrates package access.
	 */
	public static void packageAccessDemo() {
		System.out.println("Q11. PackageAccess");
		System.out.println("\tThe first float is " + q11.getF1());
		System.out.println("\tThe second float is " + q11.getF2());
		System.out.println();
	}
	
	/*
	 * For testing
	 */
	public static void main(String[] args) {
		packageAccessDemo();
	}
	
}
