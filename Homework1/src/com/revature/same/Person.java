package com.revature.same;

public class Person {
	String name;
	String age;
	String state;
	

	public Person() {
		// TODO Auto-generated constructor stub	
	}
	@Override
	public String toString() {
		//return "Person [name=" + name + ", age=" + age + ", state=" + state + "]";
		return "Name: " + name +
				"\nAge: " + age +
				"\nState: " + state;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
}
