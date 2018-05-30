package com.revature.beans;

<<<<<<< HEAD
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
=======
public class Man extends Person{
	
	public int eat() {
		this.setWeight(getWeight() + 10);
		return this.getWeight();
	}
}


	/*Can't use wrappers for overriding
	 * public Integer eat() {
		this.setWeight(getWeight() + 10);
		return this.getWeight();
}*/
>>>>>>> 4540b24bf9211879678f4dac3b5952b44fb5cdce
