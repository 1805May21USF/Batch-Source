package com.revature.classtypes;

public class Animal {

	public static void main(String[] args) {
		cat(1.0);

	}

	static void cat(int i) {
		System.out.println("Integer");
	}

	static void cat(double i) {
		System.out.println("Double");
	}

public abstract class Animal {
	
	public abstract void breathe();
	
}
