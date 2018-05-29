package com.revature.solutions;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
public class Switch {

	public static void switching(int x) {
		switch (x) {
			case 1:
				System.out.println(Math.sqrt(127));
				break;
			case 2:
				SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
				String date = sdf.format(new Date()); 
				System.out.println(date);
				break;
			case 3:
				String temp = "I am Learning Core Java";
				String[] fin = temp.split(" ");
				break;
			default:
				System.out.println("not a valid case number");
				break;
		}
	}
}
