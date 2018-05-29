package com.revature.assignments;

public class Q6 {
	
	//determine whether the inputted number is even
	public static boolean even(int myInt) {
		//the loop will break end when the number is either 0 or -1
		//by subtracting 2 every iteration.
		while(true) {
		//set return type
			myInt = myInt-2;
			if(myInt == 0 || myInt == -1) {
				break;
			}
		}
		//return true if its even
		if(myInt == 0) {
		return true;}
		//return false if its -1
		else
		return false;
	}

}
