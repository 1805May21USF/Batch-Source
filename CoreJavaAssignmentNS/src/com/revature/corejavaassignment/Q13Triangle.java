package com.revature.corejavaassignment;

/**
 * Creates a triangle out of alternating
 * 0s and 1s.
 * @author Nathaniel Simpson
 *
 */
public class Q13Triangle {
	
	/*
	 * Creates a triangle out of
	 * alternating 0s and 1s
	 */
	private static void triangle(int numLines) {
		int zeroOne = 0;
		
		System.out.println("Q13. Triangle");
		
		for (int i = 0; i < numLines; i++) {
			
			System.out.print("\t");
			
			for (int j = 0; j <= i; j++) {
				System.out.print(zeroOne + " ");
				
				if (zeroOne == 0)
					zeroOne = 1;
				else
					zeroOne = 0;

			}
			
			System.out.println();
		}
	}
	
	/*
	 * Demonstrates the triangle method
	 */
	public static void triangleDemo(int input) {
		triangle(input);
		System.out.println();
	}
	
	/*
	 * For testing
	 */
	public static void main(String[] args) {
		triangle(4);
	}

}
