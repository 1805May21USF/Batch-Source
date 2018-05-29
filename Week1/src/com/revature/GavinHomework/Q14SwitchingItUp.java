package com.revature.GavinHomework;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
//import java.util.Scanner;

import org.junit.Test;


//We good
public class Q14SwitchingItUp {

	
	//Y'all think you're slick. Acting like I don't instantly see
	//This is 4 PROBLEMS IN ONE. I'm not oblivious. I see what you're doing here.
//	Scanner input = new Scanner(System.in);
	
	//The first problem is "can I use a switch statement." Well I can so here it is.
	public void Demonstrate(int n) {
		
		switch (n) {
		
		case 1:
			thing1();
			break;
		case 2:
			thing2();
			break;
		case 3:
			thing3();
			break;
		
		}
		
	}
	
	//Second, yes I know I to google how to use simple Math class functions.
	private void thing1() {
		System.out.println("Here is the square root of 25: " + Math.sqrt(25));
		
	}
	
	//I do understand the way to make a date. Here it is.
	private void thing2() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDate localDate = LocalDate.now();
		System.out.println("Here is the date: " + dtf.format(localDate));
		
	}
	
	//I did not know how to split strings. Looking back this would have made 
	//question 20 considerable easier.
	private void thing3() {
		String str = "I am learning core Java";
		String arr[]= str.split(" ");
		System.out.println("Here is the string array: " + arr.toString());
}
	/*
	//Used multiple tests cause I could. Fight me.
	@Test
	public void tester1() {
		double a = 5;
//		double b = thing1();
		assertEquals(a,b,0);
	}
	
	@Test
	public void tester3() {
		String a[] = {"I", "am","learning","core","Java"};
		assertArrayEquals(a,thing3());
	}
	*/
}
