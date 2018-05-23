package com.revature.driver;

import com.revature.beans.Game;
import com.revature.beans.Man;
import com.revature.beans.Person;

/*
* Comments!
* 
* Naming Conventions
* Classes and Projects: Pascal Case capitalize each word
* methods and variables: Camel Case firstSecondThird
* Package names: lowercase, separated by periods.
* constants: ALLCAPS
*/

//main method is the entry point
public class funstuff {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * static dont need an instance to run it
		 * void: no return
		 * String [] args: args to be used in method
		 */
		System.out.println('G');
		
		Person p= new Person("Nick");
		 System.out.println(p.toString());
		/* 
		 Game g= new Game();
		 Game g2= new Game("Breath of the wild", "Awesome", 60);
	}
*/
		  Person pe = new Person("Tim");
		  System.out.print(pe.getWeight());
		  pe.eat();
		  Man m = new Man();
		  System.out.println(m.getWeight());
		  System.out.println(m.eat());
}
}
