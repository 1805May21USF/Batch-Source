package com.revature.driver;

import java.util.Random;

import com.revature.beans.Man;
import com.revature.beans.Person;

//Packages - Namespace that organizes a set of related classes and interfaces
public class FunStuff {
	/*
	 * Naming Conventions
	 * Classes and Projects: Pascal Case capitalize each word
	 * Methods and variables: Camel Case 
	 * Package Name: Lowercase, separated by periods
	 * Constants: All Caps
	 */
	
	//main method is the entry point
	public static void main(String[] args) {
		/*
		 * Static - dont need an instance / belongs to the class
		 * void - doesn't return anything
		 * String[] args - args to be utilized in method 
		 */
//		System.out.println("Woo");
//		
//		Person p = new Person("Time");
//		System.out.println(p.toString());
//		
//		Game g = new Game();
//		Game g2 = new Game("MGS", "Awesome", 20.71);
		
		Person p = new Person("Tim");
		System.out.println(p.getWeight());
		System.out.println(p.eat());
		Man m = new Man();
		System.out.println(m.getWeight());
		System.out.println(m.eat());
		
//		Random ran = new Random(System.currentTimeMillis());
//		int chance = ran.nextInt();
//		
//		while (true) {
//			for (int i = 0; i < 5; i++) {
//				if (chance > 0) {
//					chance++;
//				} else {
//					chance--;
//				}
//			}
//			do {
//				chance += 10;
//			} while (chance > 0 && chance < 100);
//			if (chance < 0) {
//				chance = 0;
//			} else {
//				chance = 1;
//			}
//			break;
//		}
//		switch(chance) {
//			case 1:
//				System.out.println("You Win!");
//				break;
//			default:
//				System.out.println("You Lose!");
//				break;
//		}
	
		
		
	}
}
