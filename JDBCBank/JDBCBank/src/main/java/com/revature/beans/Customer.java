package com.revature.beans;

public class Customer implements java.io.Serializable{
	// The serialVersionUID for the Person class
	private static final long serialVersionUID = 1L;
	
	// The fields stored in the Person class
	private int id;
	private String username;
	private String password;
	private String firstName;
	private char middleInitial;
	private String lastName;
	private int age;
	private String address;
	private String city;
	private int zip;
	private String state;
	
	// Constructor for the Person class
	public Customer(int i, String un, String pw, String fn, char mi, String ln, int age, String a, String c, int z, String st) {
		id = i;
		username = un;
		password = pw;
		firstName = fn;
		middleInitial = mi;
		lastName = ln;
		this.age = age;
		address = a;
		city = c;
		zip = z;
		state = st;
	}

	//Getter and setter for the id value
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	// Getter and setter for the username field
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	// Getters and setters for the password field
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	// getters and setters for the firstName field
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	// Getters and setters for the middleInitial field
	public char getMiddleInitial() {
		return middleInitial;
	}
	public void setMiddleInitial(char middleInitial) {
		this.middleInitial = middleInitial;
	}
	
	// Getter and setter methods for the lastName field
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	// Getter and setter methods for the age field
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	// Getter and setter methods for the address field
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	// Getter and setter methods for the city field
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	// Getter and setter methods for the zip field
	public int getZip() {
		return zip;
	}
	public void setZip(int zip) {
		this.zip = zip;
	}
	
	//Getter and setter methods for the state field
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
}
