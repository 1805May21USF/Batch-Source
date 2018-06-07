package com.revature.qtwenty;

import java.io.Serializable;

public class Celebrity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String fname;
	private String lname;
	private int age;
	private String town;
	
	public Celebrity(String f,String l,int a, String t) {
		this.fname = f;
		this.lname = l;
		this.age = a;
		this.town = t;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String name) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

}
