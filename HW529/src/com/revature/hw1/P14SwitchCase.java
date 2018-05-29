package com.revature.hw1;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class P14SwitchCase {
	public static void switchin(int n) {
		Random rand = new Random(); 
		int value = rand.nextInt(100); 
		switch(n) {
		case 1:
			System.out.println(Math.sqrt(value));
			break;
		case 2:
			DateFormat format = new SimpleDateFormat("yyyy/MM/dd");
			Date date = new Date();
			System.out.println(format.format(date)); 
			break;
		case 3:
			String newS = "I am learning to code Java!";
			//String[] above = newS.split(" ");
			System.out.println(java.util.Arrays.toString(newS.split(" ")));
		}
	}
}
