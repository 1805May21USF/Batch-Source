package com.revature.beans;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/*Q20. Create a notepad file called Data.txt and enter the following:
	Mickey:Mouse:35:Arizona
	Hulk:Hogan:50:Virginia
	Roger:Rabbit:22:California
	Wonder:Woman:18:Montana
	 
	Write a program that would read from the file and print it out to the screen in the following format:
	 
	Name: Mickey Mouse
	Age: 35 years
	State: Arizona State
	*/
class Problem20Person{
	private String firstName;
	private String lastName;
	private int age;
	private String state;
	
	Problem20Person(String firstName, String lastName, int age, String state){
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.state = state;
	}
	String getFirstName(){
		return this.firstName;
	}
	String getLastName(){
		return this.lastName;
	}
	int getAge(){
		return this.age;
	}
	String getState(){
		return this.state;
	}
}

public class Problem20 {
	private static ArrayList<Problem20Person> personList = new ArrayList<>();
	
	public Problem20(){
		readFileandCreatePeople();
		printPeople();
		
	}
	
	public static void addPerson(String firstName, String lastName, int age, String state){
		personList.add(new Problem20Person(firstName, lastName, age, state));
		
	}
	
	private static void readFileandCreatePeople(){
		try(BufferedReader br = new BufferedReader(new FileReader("resources/Data.txt"))) {
			String s;
			while((s = br.readLine()) != null){
				String[] sArray = s.split(":");
				addPerson(sArray[0], sArray[1], Integer.parseInt(sArray[2]), sArray[3]);			
			}       
	    } catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void printPeople(){
		for(Problem20Person p: personList){
			System.out.printf("Name: %s\nAge: %d\nState: %s\n\n", p.getFirstName() + " " + p.getLastName(), p.getAge(), p.getState());
		}
	}
	

}
