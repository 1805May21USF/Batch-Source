package com.revature.beans;


public class Game {
	private String name;
	private String genre;
	private double price;
	
	//static code block
	static{
		System.out.println("I'm a static code block");
	}
	
	//instance code block
	{
		System.out.println("Inside a code block");
	}
	
	//overloading constructors
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
		System.out.print("I have created a game and a person named");
		System.out.println(" "+s.getName());
	}

	@Override
	public String toString() {
		return "Game [name=" + name + ", genre=" + genre + ", price=" + price + "]";
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
