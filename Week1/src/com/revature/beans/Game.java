package com.revature.beans;

public class Game {
	//static code block
	static {
		//static code block are similar.
		//these execute once, when the class is loaded.
		System.out.println("i'm a static code block");
	}
	//code block
	{
		//instance code block that executes before constructor
		//when object is instantiated. not that we can't referenct
		//the object using "this," since the object isn't instantiated yet
		System.out.println("Inside code block");
	}
	private String name;
	private String genre;
	private double price;
	
	public Game() {
		this.setName("tetris");
		this.setGenre("crap");
		this.setPrice(1.58);
		System.out.println("i created a crap game");
	}
	
	public Game(String name, String genre, double price) {
		super();
		this.name = name;
		this.genre = genre;
		this.price = price;
		Person s = new Person("Jim");
		System.out.println("I created a person named");
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

}
