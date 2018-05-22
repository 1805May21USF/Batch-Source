package com.revature.beans;

public class Game {
	//Static code block
	static {
		//static code blocks are similar.
		//These execute once, when the class is loaded.
		System.out.println("I'm Static Shock!");
	}
	//Code block
	{
		//instance code block that executes before constructor
		//when object is instantiated. Note that we can't reference
		//the object using "this" since the object isn't instantiated
		//yet
		System.out.println("Inside code block");
	}
	private String name;
	private String genre;
	private double price;
	
	public Game() {
		this.setName("Tetris");
		this.setGenre("Crap");
		this.setPrice(1.58);
		System.out.println("I created a crap game");
		// TODO Auto-generated constructor stub
	}
	
	public Game(String name, String genre, double price) {
		super();
		this.name = name;
		this.genre = genre;
		this.price = price;
		Person s = new Person("Jim");
		System.out.println("I created a game and a person named "+s.getName());
	}

	//Overloading constructors
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
