package com.revature.driver;

<<<<<<< HEAD
//Packages-Namespace that organizes a set of related classes and interfaces
public class FunStuff {
	/*
	 * Comments!
	 * 
	 * Naming Conventions
	 * Classes and Projects: PascalCase
	 * Methods and Variables: camelCase
	 * Package names: lowercase, separated by periods
	 * Constants: ALLCAPS
	 */
	
	//main method is the entry point
	public static void main(String[] args) {
		/*
		 * static: don't need an instance to run it/belongs to a class
		 * void: doesn't return anything 
		 * String[] args: arguments to be utilized in method
		 */
		System.out.println("Gaming + anime = life <3");
	}
	
=======
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

//main method is the entry point
	public static void main(String[] args) {
		/*
		 * static dont need an instance/ belongs to class
		 * void: doesn't return anything
		 * String [] args: args to be utilized in method
		 */
	/*	System.out.println("I did a thing!");
		
		Person p= new Person("Tim");
		System.out.println(p);
		
		Game g= new Game();
		Game g2= new Game("MGS","Awesome",20.71);*/
		Person p= new Person("Tim");
		System.out.println(p.getWeight());
		System.out.println(p.eat());
		Man m= new Man();
		System.out.println(m.getWeight());
		System.out.println(m.eat());
		}
>>>>>>> ec5f11550b6b3458c1acdc08a12362358b94e466
}
