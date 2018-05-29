package com.revature.GavinHomework;
import com.revature.GavinHomeworkExtraOne.MyFloat;
import com.revature.GavinHomeworkExtraTwo.MyOtherFloat;


public class Q11TheFloats {

	public void floatingAway() {
		//Two different floats from two different classes. Honestly 
		//this question intimidated me so much I skipped it till my
		//last question. These classes have one field, a float, and
		//I use them to make a float and print them out.
		MyFloat floatOne = new MyFloat((float) 3.5);
		MyOtherFloat floatTwo = new MyOtherFloat((float) 7.5);
	
		System.out.println("The numbers: " + floatOne.getMaFloat() + " and " + floatTwo.getMaOtherFloat());
		System.out.println("are both from different objects in different packages.");
	
	  }
	
}
