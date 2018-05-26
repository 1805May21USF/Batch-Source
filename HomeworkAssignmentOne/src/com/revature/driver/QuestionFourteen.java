package com.revature.driver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class QuestionFourteen {
	
	public QuestionFourteen() {
		
	}
	public void run() {
		
		for(int i = 1;i<4;i++) {
			switch(i) {
			case 1:
				System.out.println(Math.sqrt(100));
				break;
			case 2:
				Date d = new Date();
				System.out.println(d);
				break;
			case 3:
				 String s = "I am learning Core Java";
				 String[] str = s.split(" ");
				 ArrayList<String> printer = new ArrayList<String>();
				 printer.addAll(Arrays.asList(str));
				 System.out.println(printer.toString());
				break;
			}
		}
		
	}

}
