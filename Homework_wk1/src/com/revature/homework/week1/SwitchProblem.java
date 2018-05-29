package com.revature.homework.week1;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SwitchProblem {
	//program prints different switch case statements

	public SwitchProblem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void switchCases() {
		//this method prints three different cases of switch statements
		
		for(int i = 0; i < 3; i++) {
			switch(i) {
			case 0:
				System.out.println("Output of square root of 33: " + Math.sqrt(33));
				break;
			case 1:
				DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
				Date today = new Date();
				System.out.println("Today's date: " + dateFormat.format(today));
				break;
			case 2:
				String str = "I am learning Core Java";
				String[] splitStr = str.split(" ");
				List<String> strArray = new ArrayList<String>();
				for(String item: splitStr) {
					strArray.add(item);
				}
				System.out.print("String array of 'I am learning Core Java': ");
				System.out.println(strArray + ", ");
				break;
			default:
				System.out.println("ROLL TIDE");
				break;
			}
		}
	}
}
