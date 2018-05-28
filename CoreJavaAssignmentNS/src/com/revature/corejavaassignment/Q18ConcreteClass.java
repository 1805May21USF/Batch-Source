package com.revature.corejavaassignment;

/**
 * Uses the methods from an abstract class to perform
 * simple calculations.
 * @author Nathaniel Simpson
 *
 */
public class Q18ConcreteClass extends Q18AbstractClass{
	
	private static String testString1 = "Roll Tide";
	private static String testString2 = "roll tide";
	private static String testString3 = "59";
	
	/*
	 * Demonstrates methods from the abstract class.
	 */
	public static void abstractClassDemo() {
		System.out.println("Q18. Abstract and Concrete classes");
		System.out.println("\tUppercase test for \"" + testString1
				+ "\" returns " + hasUpperCase(testString1));
		System.out.println("\tUppercase test for \"" + testString2
				+ "\" returns " + hasUpperCase(testString2));
		
		System.out.println("\tAll caps (yelly-case, according to Joe) for \""
				+ testString1 + "\" is \"" + toUpperCase(testString1) + "\"");
		
		System.out.println("\tConverting \"" + testString3 + "\" to"
				+ " an integer and adding 10: " + stringToIntPlus10(testString3));
		System.out.println();
	}
	
	/*
	 * For testing
	 */
	public static void main(String[] args) {
		abstractClassDemo();
	}

}
