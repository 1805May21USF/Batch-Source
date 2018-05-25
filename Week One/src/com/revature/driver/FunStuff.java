package com.revature.driver;

import com.revature.beans.Game;
import com.revature.beans.Man;
import com.revature.beans.Person;


/*
 * Packages-Namespace that organizes
 * a set of related classes and interfaces
 */

public class FunStuff {

	/*
	 * Naming Conversions
	 * Classes and Projects: Pascel Case (Capitalize Each Work)
	 * Methods and Variables: Camel Case (lower case first word and capitalize every word after)
	 * Package Names: lower case, separated by periods
	 * Constants: All Capitals
	 */
	
	//Main method is the entry point
	
	public static void main(String[] args) {
		/*
		 * static does not need an instance to belong to a class
		 * void: Does not return anything
		 * String[] args: Args to be utilized in a method
		 */
		System.out.println("Hello World");
		
		Person p = new Person("Tim");
		System.out.println(p);
		
		Game g = new Game();
		Game g2 = new Game("MGS","Awesome", 20.71);
		System.out.println(p.eat());
		Man m = new Man();
		System.out.println(m.getWeight());
		System.out.println(m.eat());
	}
}
