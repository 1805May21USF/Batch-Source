package com.revature.corejavaassignment;

import com.revature.q11package.*;

public class Q11PackageGetter {
	
	private static Q11PackageAccess q11 = new Q11PackageAccess();

	public static void packageAccessDemo() {
		System.out.println("Q11. PackageAccess");
		System.out.println("\tThe first float is " + q11.getF1());
		System.out.println("\tThe second float is " + q11.getF2());
		System.out.println();
	}
	
	public static void main(String[] args) {
		packageAccessDemo();
	}
	
}
