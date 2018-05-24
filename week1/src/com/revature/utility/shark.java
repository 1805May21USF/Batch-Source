package com.revature.utility;

public class Shark extends Animal implements Hunt {
	
	
	@Override 
	public void breaths() {
		System.out.println("I breathe underwater");

	}
	
	@Override
	public void findPrey() {
		System.out.println("I ate fishes!");
	}
}
