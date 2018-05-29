package com.revature.solutions;

public class Triangles {
	public static void printTriangle(int lines) {
		int count = 0;
		for(int i = 0;i<lines;i++) {
			for(int j = 0;j<=i;j++) {
				if(((count)%2)==0) {
					System.out.print("0");
					count++;
				}else {
					System.out.print("1");
					count++;
				}
			}
			System.out.println("");
		}
	}

}
