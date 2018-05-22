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
	 * Classes and Projects: Pascal Case capitalizes each word
	 * Methods and Variables: Camel Case FirstSecondThird
	 * Package names: lowercase, separated by periods
	 * constants: ALLCAPSLOLZ
	 */
	
	//main method is the entry point
	
	public static void main(String[] args) {
		/*
		 * static: don't need an instance/belongs to class
		 * void: doesn't return anything
		 * String[] args: args to be utilized in method
		 */
		/*System.out.println("I did a thing!");
		
		Person p = new Person("Tim");
		System.out.println(p.toString());
		
		Game g = new Game();
		Game g2 = new Game("MGS", "Awesome", 20.71);*/
		Person p = new Person("Tim");
		System.out.println(p.getWeight());
		System.out.println(p.eat());
		Man m = new Man();
		System.out.println(m.getWeight());
		System.out.println(m.eat());
	}
}
