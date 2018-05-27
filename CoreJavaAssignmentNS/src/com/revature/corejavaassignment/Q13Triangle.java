package com.revature.corejavaassignment;

public class Q13Triangle {
	
	private static int number = 0;
	private static int length = 1;
	
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
				
				length++;
			}
			
			System.out.println();
		}
	}
	
	public static void triangleDemo(int input) {
		triangle(input);
		System.out.println();
	}
	
	public static void main(String[] args) {
		triangle(6);
	}

}
