package com.sunnara.homework;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/*
 * Write a program that defines an interface having the 
 * following methods: addition, subtraction, multiplication, 
 * and division.  Create a class that implements this interface
 * and provides appropriate functionality to carry out the 
 * required operations. Hard code two operands in a test class 
 * having a main method that calls the implementing class.
 */
public class Q15 implements Q15Interface{

	public static void main(String[] args) {
		double a = 22;
		double b = 4;
		
		//if executed wit 2 arguments
		if (args.length == 2) {
			a = Double.parseDouble(args[0]);
			b = Double.parseDouble(args[1]);
		}
		
		Q15 example = new Q15();
		example.printSolution(a, b);


	}

	public void start() {
		System.out.println("Question 15:");
		System.out.println("Trying different numbers for operations");
		int x = 10;
		int y = 12;
		System.out.println("x is "+ x + ", y is " + y);
		printSolution(x,y);
		x = 20;
		y = 5;
		System.out.println("x is "+ x + ", y is " + y);
		printSolution(x,y);
		System.out.println();
		
	}
	
	public void printSolution(double x, double y) {
		//Only show decimals when necessary
		NumberFormat nf = new DecimalFormat("##.###");
		System.out.printf("%s + %s = %s\n",
				nf.format(x),nf.format(y),nf.format(add(x, y)));

		System.out.printf("%s - %s = %s\n",
				nf.format(x),nf.format(y),nf.format(sub(x, y)));

		System.out.printf("%s * %s = %s\n",
				nf.format(x),nf.format(y),nf.format(mult(x, y)));

		System.out.printf("%s / %s = %s\n",
				nf.format(x),nf.format(y),nf.format(div(x, y)));		
	}

	/**
	 * adds x and y
	 */
	@Override
	public double add(double x, double y) {
		// TODO Auto-generated method stub
		return x + y;
	}

	/**
	 * subtracts x and y
	 */
	@Override
	public double sub(double x, double y) {
		// TODO Auto-generated method stub
		return x - y;
	}

	/**
	 * multiplies x and y
	 */
	@Override
	public double mult(double x, double y) {
		// TODO Auto-generated method stub
		return x * y;
	}

	/**
	 * divides x and y
	 */
	@Override
	public double div(double x, double y) {
		// TODO Auto-generated method stub
		return x / y;
	}

}

