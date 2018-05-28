package com.sunnara.homework;

/*
 * Display the triangle on the console as follows using 
 * any type of loop.  Do NOT use a simple group of 
 * print statements to accomplish this.
* 0			// 0, 1 pattern
* 1 0		
* 1 0 1		
* 0 1 0 1   
 */
public class Q13 {
	
	public void start() {
		System.out.println("Question 13:\nCreating triangle.");
		makeTri();
		System.out.println();
	}

	/**
	 * Makes a triangle using a loop that follows a pattern 0101..
	 * each row adds 1 extra space
	 */
	public void makeTri() {
		boolean tf = false;
		for(int i = 0; i < 4; i++) {
			//Uses boolean to make sure it takes turn printing
			for(int j = 0; j <= i; j++) {
				if(tf) {
					System.out.print("1 ");
					tf = false;
				} else {
					System.out.print("0 ");
					tf = true;
				}
			}
			System.out.println();
		}
	}
}
