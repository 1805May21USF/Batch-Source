package com.revature.utilities;

public class Question4 {
 public static int Q4() {
int i,	factorial=1;
 int number=5; // The number you calculate
 
 for(i=1;i<=number;i++) {
	 
	 factorial=factorial*i;
	 
 }
 return factorial;
 //System.out.println("The factorial of" +number+ "is:"+factorial);
 }
}
