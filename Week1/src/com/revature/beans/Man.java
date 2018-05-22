package com.revature.beans;

public class Man extends Person{
	
	public int eat() {
		this.setWeight(this.getWeight() + 10);
		return this.getWeight();
	}
}
