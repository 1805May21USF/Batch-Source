package com.revature.driver;

<<<<<<< HEAD
import com.revature.beans.Game;
import com.revature.beans.Man;
import com.revature.beans.Person;

//Packages Name space that organizes a set of related classes and interfaces
public class FunStuff {
	/*
	 * naming conventions
	 * Classes and projects : pascal case capitalize each word
	 * methods and variables: camel case firstSecondThird
	 * package names : lowercase, seperated by periods 
	 * constants : ALL CAPS
	 */
	
	// main method is the entry point 
	public static void main (String[] args) {
		/*
		 * static don't need need  an instance / belongs to class
		 * void: doesn't return anything
		 * String[] args : arguments to be utilized in methods
		 */
		/*System.out.println("I did it ");
		
		Person p = new Person("Tim");
		System.out.println(p.toString());
		
		Game g = new Game();
		Game g2 = new Game("MGS", "AWESOME", 20.71);*/
		
		Person p = new Person("Tim");
		System.out.println(p.getWeight());
		p.eat();
		Man m  = new Man();
		System.out.println(m.getWeight());
		System.out.println(m.eat());
		
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
>>>>>>> 4540b24bf9211879678f4dac3b5952b44fb5cdce
}
