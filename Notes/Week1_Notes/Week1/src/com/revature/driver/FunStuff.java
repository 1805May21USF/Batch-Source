package com.revature.driver;

//Retrieves Person blueprint from com.revature.beans package
//Java bean - most basic implementation of object in Java
//ctrl+shift+o to set import statement for classes

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
 * Package names: lowercase, separated by periods
 * constants: ALLCAPSLOLZ
 */

//main method is the entry point
	public static void main(String[] args) {
		/*
		 * static dont need an instance/ belongs to class
		 * void: doesn't return anything
		 * String [] args: args to be utilized in method
		 */
		//System.out.println("I did a thing!");
		
		/*Game g = new Game();
		Game g2 = new Game("MGS", "Awesome", 20.71);
		
		Person p = new Person("Tim");
		
		//System.out.println(p);
		System.out.println(p.getWeight());
		System.out.println(p.eat());
		
		Man m = new Man();
		
		System.out.println(m.getWeight());
		System.out.println(m.eat());*/
		/*int x = 0;
		
		for(int i = 0; i < 5; i++) 
		{
			x++;
		}
		
		switch(x)
		{
			case 5:
				x++;
			default:
				x--;
		}
		
		do
		{
			x++;
			if(x == 10)
			{
				x = 0;
			}
		}while(x > 5);
		
		while(x != 5)
		{
			
			x++;
		}
		
		System.out.println(x);*/
	}
}
