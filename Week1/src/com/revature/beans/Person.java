package com.revature.beans;

public class Person {
	//encapsulation
	private static String homePlanet = "earth";
	private String name;
	private int age;
	private int weight;
	
	//Constructors
	
	
	
	public Person(String name) {
		//this.setAge(20);
		this(name, 20);
	}
	
	public Person(String name, int age) {
		this(name,age,200);
	}
	
	public Person(String name, int age, int weight) {
		super();
		this.name = name;
		this.age = age;
		this.weight = weight;
	}
	
	
	
	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", weight=" + weight + "]";
	}

	
}
