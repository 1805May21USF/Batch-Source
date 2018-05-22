package com.revature.driver;

import com.revature.beans.Game;
import com.revature.beans.Person;
<<<<<<< HEAD
=======

//Packages-Namespace that organizes 
//a set of related classes and interfaces
>>>>>>> d85e5520c17cd9adf752007f2227babea7b85d0f

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
		System.out.println("I did a thing!");
<<<<<<< HEAD
		Person p = new Person("Tim");
		System.out.println(p);
		
		Game g = new Game();
		Game g2 = new Game("MGS","Awesome",20.71);
		
		
	}
=======
		
		Person p= new Person("Tim");
		System.out.println(p);
		
		Game g= new Game();
		Game g2= new Game("MGS","Awesome",20.71);
		}
>>>>>>> d85e5520c17cd9adf752007f2227babea7b85d0f
}
