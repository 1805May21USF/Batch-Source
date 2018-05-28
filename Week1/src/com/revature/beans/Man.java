package com.revature.beans;

public class Man extends Person {



public Man() {
		super();
		// TODO Auto-generated constructor stub
	}

public int eat()
 {
	this.setWeight(getWeight()+10);
	return this.getWeight();
	 
 }
}
