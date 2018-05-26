package com.revature.problem;

public class Even {
	public static String even(int num) {
		String temp = Double.toString((double) num / 2.0);

		if (Integer.parseInt(temp.substring(temp.indexOf('.') + 1)) > 0) {
			return "Not Even";
		}
		
		return "Even";
	}
}
