package com.revature.GavinHomework;


//Made this bean to help with the toString for the output.
public class Q20Hero {
	
	private int age;
	private String FirstName;
	private String LastName;
	private String State;
	
	public Q20Hero( String firstName, String lastName, int age, String state) {
		super();
		this.age = age;
		this.FirstName = firstName;
		this.LastName = lastName;
		this.State = state;
	}

	public Q20Hero() {
		this.age = 0;
		this.FirstName = null;
		this.LastName = null;
		this.State = null;
	}


	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}

	@Override
	public String toString() {
		return "Name: " + FirstName + " " + LastName + "\n"
			+   "Age: " + age  + " years\n" 
			+ "State: " + State + " State";
	}


	
	
	
}
