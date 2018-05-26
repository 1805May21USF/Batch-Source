package com.revature.beans;

public class Person {
	//Creates a shared single copy of the variable that is accessible to every instance of the class.
	private static String homePlanet="Earth";
	private String name;
	private int age;
	private int weight;
	
	//Constructor chaining
	public Person() {
	}
	public Person(String name) {
		this(name, 20);
	}
	public Person(String name, int age) {
		this(name, age, 200);
	}		
	public Person(String name, int age, int weight) {
		this.name = name;
		this.age = age;
		this.weight = weight;
	}

	//Source, Generate getters and setters
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
	
	public static String getHomePlanet() {
		return homePlanet;
	}
	
	public int eat() {
		int newWeight = weight+5;
		this.setWeight(newWeight);
		return this.getWeight();
	}
	
	
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", weight=" + weight + "]";
	}
	
}
