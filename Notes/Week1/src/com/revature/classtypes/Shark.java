package com.revature.classtypes;

public class Shark extends Animal implements Hunt {

	@Override
	public void breath() {
		// TODO Auto-generated method stub
		System.out.println("I breathe underwater!");
	}

	@Override
	public void findPrey() {
		// TODO Auto-generated method stub
		System.out.println("I ate fishies!");
	}
	
}
