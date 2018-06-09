package com.revature.beans;

<<<<<<< HEAD
public class Person {
 // encapsulation 
 private static String homePlanet = "earth";

 private String name;

 
private int age;
 
private int weight;




//constructors 
public Person() {
	super();
}

public Person(String name ) {
	this(name,20);

}
public Person (String name, int age) {
	this(name, age, 140);
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
public static String getHomePlanet() {
	return homePlanet;
}
public static void setHomePlanet(String homePlanet) {
	Person.homePlanet = homePlanet;

}
public int eat() {
	int newWeight=weight+5;
	for (int i=1;i<6;i++)
		newWeight++;
this.setWeight(newWeight);
return this.getWeight();

}

=======
import java.io.Serializable;

public class Person implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//encapsulation
	private static String homePlanet="earth"; 
	private String name;
	private int age;
	private int weight;
	
	//Constructors
	//Default
	
	public Person(String name) {
	this(name, 20);	
	}
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Person( String name , int age) {
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
	public static String getHomePlanet() {
		return homePlanet;
	}
	
	public int eat() {
		int newWeight=weight;
		for(int i=1;i<6;i++) {
			newWeight++;
		}
		
		this.setWeight(newWeight);
		return this.getWeight();
	}
	
	
	
>>>>>>> 4540b24bf9211879678f4dac3b5952b44fb5cdce
}
