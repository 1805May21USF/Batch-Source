package com.revature.same;

public class EvenOrNah {

	public EvenOrNah() {
		// TODO Auto-generated constructor stub
		//System.out.println(evenOrNah(-2));
	}
	
	public static Boolean evenOrNah(int number) {
		Boolean isEven = false;
		int operation = (number/2)*2;
		if(operation == number)
			isEven = true;
		return isEven;
	}
}
