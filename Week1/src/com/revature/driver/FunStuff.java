package com.revature.driver;

import com.revature.beans.Game;
import com.revature.beans.Man;
import com.revature.beans.Person;

//Packages-Namespace that organizes 
//a set of related classes and interfaces

public class FunStuff {
/*
 * Comments!
 * 
 * Naming Conventions
 * Classes and Projects: Pascal Case capitalize each word
 * methods and variables: Camel Case ex. firstSecondThird
 * Package names: lowercase, seperated by periods
 * constants: ALLCAPSLOLZ
 */
	/*
	 * Naming Convention 
	 * Classes and Projects: Pascal Case capital first letter of each word
	 * methods and variables: Camel Case lower firstword then capital letter of the rest
	 * Package name: lower case separated by periods
	 * Constants: ALLCAPS
	 * 
	 * Static: does not need an instance belongs to the class
	 * void: does not return anything
	 * String[] args: args to be utilized in the mothod from the command line
	 * 
	 * 
	 */
//main method is the entry point
	public static void main(String[] args) {
		/*
		 * static dont need an instance/ belongs to class
		 * void: doesn't return anything
		 * String [] args: args to be utilized in method
		 */
//		Person p = new Person("Jim");
//		System.out.println(p.toString());
//		
//		Game g = new Game();
//		Game g2 = new Game("Metal Gear", "Good Game", 27.21);
		
		Person p = new Person("Time");
		System.out.println(p.getWeight());
		p.eat();
		System.out.println("Weight after eating: " + p.getWeight());
		Man m= new Man();
		System.out.println(m.getWeight());
		System.out.printf("Weight After eating: %d" , m.eat());
		
	}

}
