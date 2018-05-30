package com.revature.beans;

<<<<<<< HEAD

public class Game {
	// Static code block
	static {
		// static code blocks are similar
		//these execute once, when the class is loaded}
	}
	
	//CODE BLOCK
	{
		//instance code block that executes before constructor
		//when object is instantiated. NOTE that we can't reference
		//the object using "this" since the object isn't instantiated
		// yet.
		System.out.println("INSIDE CODE BLOCK");
=======
public class Game {
	//Static code block
	static {
		//Static code blocks are similar.
		//These execute once, when the class is loaded.
		System.out.println("I'm a static code block");
	}
	//code block
	{
		//instance code block that executes before constructor
		//when object is instantiated. Note that we can't reference 
		//the object using "this," since the object isn't instantiated 
		//yet.
		System.out.println("Inside code block");
>>>>>>> 4540b24bf9211879678f4dac3b5952b44fb5cdce
	}
	private String name;
	private String genre;
	private double price;
	
	//overloading constructors
<<<<<<< HEAD
	
=======
>>>>>>> 4540b24bf9211879678f4dac3b5952b44fb5cdce
	public Game() {
		this.setName("Tetris");
		this.setGenre("Crap");
		this.setPrice(1.58);
		System.out.println("I created a crap game");
	}
	
<<<<<<< HEAD
=======
	
	
	
	
>>>>>>> 4540b24bf9211879678f4dac3b5952b44fb5cdce
	public Game(String name, String genre, double price) {
		super();
		this.name = name;
		this.genre = genre;
		this.price = price;
<<<<<<< HEAD
		Person s = new Person("Jim");
		System.out.println("I created a game and a person named " +s.getName());
	}

=======
		Person s= new Person("Jim");
		System.out.println("I created a game and a person named "+
		s.getName());
	}





>>>>>>> 4540b24bf9211879678f4dac3b5952b44fb5cdce
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
	
<<<<<<< HEAD

=======
>>>>>>> 4540b24bf9211879678f4dac3b5952b44fb5cdce
}
