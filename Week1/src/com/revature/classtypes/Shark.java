package com.revature.classtypes;

public class Shark extends Animal implements Hunt {

	@Override
	public void breath() {
		// TODO Auto-generated method stub
		System.out.println("I breath under water");
	}

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("I eat Anything");
	}
	
	public void findPrey() {
		System.out.println("I ate fishes!");
	}

}
