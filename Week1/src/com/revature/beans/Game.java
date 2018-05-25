package com.revature.beans;

public class Game {
	static {
		//Execute once the first time the class is called
		System.out.println("I'm a static code block");
	}
	{
		//Code block, this would run before the instance is created
		//Useful for debugging or making sure a database is connected before instantiation etc.
		System.out.println("Inside code block");
	}
	
	private String name;
	private String genre;
	private double price;
	
	//Overloading constructors
	public Game() {
		this.setName("Tetris");
		this.setGenre("Crap");
		this.setPrice(1.58);
		System.out.println("I created a crap game");
	}
	
	public Game(String name, String genre, double price) {
		super();
		this.name = name;
		this.genre = genre;
		this.price = price;
		Person s = new Person("Jim");
		System.out.println("I created a game and a person named " +
			s.getName());
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
	@Override
	public String toString() {
		return "Game [name=" + name + ", genre=" + genre + ", price=" + price + "]";
	}
	
}
