package com.revature.GavinHomework;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/*
Create an ArrayList and insert integers 1 through 10. Display the ArrayList.
Add all the even numbers up and display the result.
Add all the odd numbers up and display the result.
Remove the prime numbers from the ArrayList and print out the remaining ArrayList.
*/
public class Q19ListfulConcerns {

	Q09Primess Q09 = new Q09Primess();
	
	ByteArrayInputStream in = new ByteArrayInputStream("100".getBytes());
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream(); 
	
	
	@Before
	public void setUpStreams() {
		System.setOut(new PrintStream(outContent));
	}
	
	@After
	public void restoreStreams() {
		System.setOut(System.out);
	}
	
	//I simply do not know or understand how to do output testing.
	@Test
	public void tester() { 
		Listy();
		assertEquals("The even numbers added up = 30\n" 
					+"The odd numbers added up = 25\n" ,outContent.toString());
	}
	
	
	//If the array was different it would still work.
	public void Listy() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i<10; i++) {
			list.add(i+1);
		}
		int even = 0;
		int odd = 0;
		for(int i = 0; i < 10; i++) {
			if(list.get(i)%2 == 0) even += list.get(i);
			if(list.get(i)%2 == 1) odd += list.get(i);
		}
		
		System.out.println("The even numbers added up = " + even);
		System.out.println("The odd numbers added up = " + odd);
		int i = 0;
		
		//Gotta use the is prime part of the list.
		//The algorithm advances i if the number is not prime
		//if the number is prime it removes it form the list and
		//does not advance i.
		while( i<list.size()){
			if(Q09.isPrime(list.get(i))) {
				list.remove(i); 
				continue;
			}
			i++;
		}
		for(int x: list) {
			System.out.println(x);
		}
		
	}
	
	
	
}
