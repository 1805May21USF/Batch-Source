package com.revature.driver;
import com.revature.beans.*;

//Packages-Namespace that organizes 
//a set of related classes and interfaces.

public class FunStuff {
	/*
	 * 
	 * Comments!
	 * 
	 * 
	 * Naming Conventions
	 * Classes and Projects: Pascal Case capitalize each word
	 * methods and variables: Camel Case ex: firstSecondThird
	 * Package names: lowercase, seperated by periods
	 * constants: ALLCAPS
	 */
	
	//Main Method is the entry point
	public static void main(String[] args) {
		
		/*
		 * static don't need an instance / belongs to the class
		 * void- no return value
		 * String [] args : arguments to be utilized in method
		 * 
		 */

		System.out.println("Pizza!");
		
		//create a new person Tim
		Person p = new Person("Tim");
		
		System.out.print(p.getName() + ": ");
		System.out.println(p.getWeight());
		System.out.println(p.getName() + ": " + p.eat());
		
		
		Man m = new Man("Bob");
		System.out.print(m.getName() + ": ");
		System.out.println(m.getWeight()) ;
		m.eat();
		System.out.print(m.getName() + ": ");
		System.out.println(m.getWeight());
	}
}