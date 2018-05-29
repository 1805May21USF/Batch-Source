package com.bank.intro;

public class Intro {
	String welcome;

	public Intro() {
		welcome = "Welcome to Tiffany's Banking App.\n"
				+ "\t1 - Register and apply to open a new account\n\t2 - Login to an existing account\n"
				+ "\t3 - Exit program. \nPlease enter a number on what you would like to do next: ";
	}

	public String getWelcome() {
		return welcome;
	}

	public void setWelcome(String welcome) {
		this.welcome = welcome;
	}
}
