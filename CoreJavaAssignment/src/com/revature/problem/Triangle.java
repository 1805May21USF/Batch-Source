package com.revature.problem;

import java.util.LinkedList;

public class Triangle {
	
	
	public static String triangle(int size) {
		StringBuilder builder = new StringBuilder();
		boolean otherNum = false;
		
		for (int i = 0; i <= size; i++) {
			for (int j = 0; j < i; j++) {
				if (otherNum) {
					builder.append("1");
					otherNum = false;
				} else {
					builder.append("0");
					otherNum = true;
				}
			}
			builder.append("\n");
		}
		
		return builder.toString();
	}
	
	public static void print(String str) {
		System.out.print("Triangle: " + str);
	}
}
