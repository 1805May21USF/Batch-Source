package com.revature.beans;

public class Game {
	private String name;
	private String genre;
	private double price;
	
	//Constructors
	public Game() {
		this.setName("Tetris");
		this.setGenre("Crap");
		this.setPrice(1.50);
		System.out.println("I created a crap game");
	}
	
	public Game(String name, String genre, double price) {
		this.name = name;
		this.genre = genre;
		this.price = price;
		Person s = new Person("Jim");
		System.out.println("I created a " + this.getName() + " and a person named " + s.getName());
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
