package com.revature.beans;

public class Person {
	
	private static String homePlanet = "earth";
	private String name;
	private int age;
	private int weight;
	
	public Person() {
		super();
	}
	public Person(String name) {
		this(name,20);		
	}
	public Person(String name, int age) {
		this(name, age, 200);
	}

	
	public Person(String name, int age, int weight) {
		this.name = name;
		this.age = age;
		this.weight = weight;
		// TODO Auto-generated constructor stub
	}
	
	
	public String getName() {
		return name;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", weight=" + weight + "]";
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
	
	public int eat() {
		this.setWeight(weight + 5);
		return this.getWeight();
	}
}
