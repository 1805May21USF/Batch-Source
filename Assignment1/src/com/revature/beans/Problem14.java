package com.revature.beans;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/*Q14. Write a program that demonstrates the switch case. Implement the following functionalities in the cases:java
Case 1: Find the square root of a number using the Math class method.
Case 2: Display today’s date.
Case 3: Split the following string and store it in a string array.
       	 “I am learning Core Java”
*/
public class Problem14 {
	private final String case3 = "I am learning Core Java";
	private final DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	private Date todayDate;
	private double num;
	
	public Problem14(double d){
		this.todayDate = new Date();
		this.num = d;	
	}
	
	public void printTodaysDate(){
		System.out.println(sdf.format(todayDate));
	}
	
	public double getSquareRoot(double d){
		return Math.sqrt(d);
	}
	
	public String[] storeStringInArray(){
		return this.case3.split(" ");
	}
	private double getNum(){
		return this.num;
	}
	public void switchDemo(){
		 String key = "c";
		 switch (key) {
		 	case "a":
		 		System.out.printf("The Square of %f is : %.5f\n", getNum(), getSquareRoot(getNum()));
		 		break;
		 	case "b":
		 		System.out.print("Todays date is: " );
		 		printTodaysDate();
		 		break;
		 	case "c":
		 		System.out.print("The contents of the array after spit are: [");
		 		String[] s = storeStringInArray();
		 		for (int i = 0; i < s.length; i++){
		 			if(i < s.length -1){
		 				System.out.print(s[i] + ",");
		 			}else{
		 				System.out.print(s[i]);
		 			}	
		 		}
		 		System.out.print("]");
		 		break;
		 	default:
		 		System.out.println("No matches sorry!");
		 		break;
		}
	}
}
