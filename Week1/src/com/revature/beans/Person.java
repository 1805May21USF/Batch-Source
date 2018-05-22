package com.revature.beans;

public class Person {
	
	//Encapsulation
	private String name;
	private int age;
	private int weight;
	private static String homeplanet = "Earth";
	
	//Constructors
	public Person() {
		super();
		
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
	
	public static String getHomeplanet() {
		return homeplanet;
	}
	public static void setHomeplanet(String homeplanet) {
		Person.homeplanet = homeplanet;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", weight=" + weight + "]";
	}

}
