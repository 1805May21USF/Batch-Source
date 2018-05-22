package com.revature.beans;

public class Game {
<<<<<<< HEAD
	//static code block
	static {
		//Static codes blocks are similar.
=======
	//Static code block
	static {
		//Static code blocks are similar.
>>>>>>> 3ebf56765f16133b3c08ed32cefd5349d6312136
		//These execute once, when the class is loaded.
		System.out.println("I'm a static code block");
	}
	//code block
	{
		//instance code block that executes before constructor
<<<<<<< HEAD
		//when object is instantiated. Note that we can't reference
		//the object using "this," since the object isn't instantiated
		//yet
=======
		//when object is instantiated. Note that we can't reference 
		//the object using "this," since the object isn't instantiated 
		//yet.
>>>>>>> 3ebf56765f16133b3c08ed32cefd5349d6312136
		System.out.println("Inside code block");
	}
	private String name;
	private String genre;
	private double price;
	
	//overloading constructors
	public Game() {
<<<<<<< HEAD
		this.setName("tetris");
		this.setGenre("Puzzle");
=======
		this.setName("Tetris");
		this.setGenre("Crap");
>>>>>>> 3ebf56765f16133b3c08ed32cefd5349d6312136
		this.setPrice(1.58);
		System.out.println("I created a crap game");
	}
	
	
<<<<<<< HEAD
=======
	
	
	
>>>>>>> 3ebf56765f16133b3c08ed32cefd5349d6312136
	public Game(String name, String genre, double price) {
		super();
		this.name = name;
		this.genre = genre;
		this.price = price;
<<<<<<< HEAD
		Person s = new Person("Jimmy");
		System.out.println("I created a game and a person named " + 
				s.getName());
	}


=======
		Person s= new Person("Jim");
		System.out.println("I created a game and a person named "+
		s.getName());
	}





>>>>>>> 3ebf56765f16133b3c08ed32cefd5349d6312136
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
<<<<<<< HEAD
	
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
	
=======
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
>>>>>>> 3ebf56765f16133b3c08ed32cefd5349d6312136
	@Override
	public String toString() {
		return "Game [name=" + name + ", genre=" + genre + ", price=" + price + "]";
	}
	
<<<<<<< HEAD
	
=======
>>>>>>> 3ebf56765f16133b3c08ed32cefd5349d6312136
}
