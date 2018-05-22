package com.revature.driver;

import com.revature.beans.Person;
import com.revature.beans.Game;


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
		
		
		Person p  = new Person("Tim");
		System.out.println(p.toString());
		
		Game g = new Game();
		Game g2 = new Game("MGS","crappy",20.71);
		System.out.println(g2);
	}
}
