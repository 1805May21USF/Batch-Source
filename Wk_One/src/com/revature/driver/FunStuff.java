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
 * methods and variables: Camel Case
 * Package names: lowercase, separated by periods
 * constants: ALLCAPS
 */
	
	//main method is the entry point
	public static void main(String[] args) {
		/*
		 * static: don't need an instance/ belongs to class
		 * void: doesn't return anything
		 * String [] args: args to be utilized in method
		 */
		/*System.out.println("Revature Rocks!!!");
		
		Person p1 = new Person("Tim");
		System.out.println(p1);
		
		Game g1 = new Game();
		Game g2 = new Game("MGS", "Awesome", 19.99);
//		System.out.println(g1);
//		System.out.println(g2);
*/	
		Person p1 = new Person("Tim");
		System.out.println(p1.getWeight());
		System.out.println(p1.eat());
		Man m1 = new Man();
		System.out.println(m1.getWeight());
		System.out.println(m1.eat());
		}
	

}
