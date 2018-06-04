package com.accessmodifier2;
import com.accessmodifier.AccessVariableFromAnotherClass;


public class Q11 
{
	public static void main(String[] args)
	{
		AccessVariableFromAnotherClass class1 = new 
	AccessVariableFromAnotherClass();
		
		
		System.out.println("Value of public variable in class :" + class1.SkinColor);
		System.out.println("Value of public variable in class :" + class1.SSN);
	    System.out.println("Value of public variable in class :" + class1.ID);
	    System.out.println("Value of public variable in class :" + class1.Zipcode);
	
}
}	

