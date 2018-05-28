package com.sunnara.homework;

import java.util.Scanner;

/*
 * Write a program that calculates the simple interest 
 * on the principal, rate of interest and number of years 
 * provided by the user. Enter principal, rate and time 
 * through the console using the Scanner class.
 * 
 * Interest = Principal* Rate* Time
 */
public class Q17 {
	private double principal;
	private double rate;
	private double time;
	private double interest;
	
	
	public static void main(String[] args) {
		Q17 e = new Q17();
		e.start();
	}
	
	/**
	 * Uses scanner inputs to calculate interest
	 */
	public void start() {
		System.out.println("Question 17:\nCalculate Interst.");
		Scanner in = new Scanner(System.in);
		String s = "";
		boolean check = false;
		System.out.println("Please enter the principal ($) : ");
		s = in.nextLine();
		
		//Loops until a number is inputed;
		while(!check) {
			try {
				principal = Double.parseDouble(s);
				check = true;
			} catch (Exception e) { //Catches if a letter has been typed
				System.out.println("Please input a valid value.");
				s = in.nextLine();
			}
		}
		
		check = false;
		System.out.println("Please enter the rate (%):");
		s = in.nextLine();
		while(!check) {
			try {
				rate = Double.parseDouble(s)/100;//decimal value of %
				check = true;
			} catch (Exception e) {
				System.out.println("Please input a valid value.");
				s = in.nextLine();
			}
		}
		
		check = false;
		System.out.println("Please enter the time (years) : ");
		s = in.nextLine();
		while(!check) {
			try {
				time = Double.parseDouble(s);
				check = true;
			} catch (Exception e) {
				System.out.println("Please input a valid value.");
				s = in.nextLine();
			}
		}
		in.close();
		interest = principal * rate * time; 
		System.out.printf("The interest is $%.2f\n", interest);
		System.out.println();
	}

}
