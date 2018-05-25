package com.revature.beans;

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
