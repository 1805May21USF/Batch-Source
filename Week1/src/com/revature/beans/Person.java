package com.revature.beans;

public class Person {
	//Static code block
	static {
		//Static code blocks are similar. These execute once, when the class is loaded.
		System.out.println("I'm a static code block");
	}
	//code block
	{
		//instance code block that executes before constructor when object is instantiated.
		//Note that we can't reference the object using "this," since the object isn't 
		//instantiated yet.
		System.out.println("Inside code block");
	}
	
	//encapsulation
	private static String homePlanet = "Earth";
	private String name;
	private int age;
	private int weight;
	
	//Constructors
	//default constructor
	public Person() {
		
	}
	
	//overloading default constructor
	public Person(String name, int age, int weight) {
		super();
		this.name = name;
		this.age = age;
		this.weight = weight;
	}
	
	public Person(String name) {
		this(name, 20);
	}
	
	public Person(String name, int age) {
		this(name, age, 200);
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
