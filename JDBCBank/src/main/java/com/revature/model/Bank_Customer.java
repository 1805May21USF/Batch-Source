package com.revature.model;

public class Bank_Customer {
	
	
	private String userName;
	private String password;
	private String first_Name;
	private String last_name;
	private String social_Security;
	private String age;
	private String address;
	private String city;
	private String state;
	private String zipcode;
	
	
	//public  Bank_Customer(int i, String string, String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9, String string10) {
		//super();
		// TODO Auto-generated constructor stub
	//}


	public Bank_Customer( String userName, String password) {
		super();
		
		this.userName = userName;
		this.password = password;
		
	}


		public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getFirst_Name() {
		return first_Name;
	}


	public void setFirst_Name(String first_Name) {
		this.first_Name = first_Name;
	}


	public String getLast_name() {
		return last_name;
	}


	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}


	public String getSocial_Security() {
		return social_Security;
	}


	public void setSocial_Security(String social_Security) {
		this.social_Security = social_Security;
	}


	public String getAge() {
		return age;
	}


	public void setAge(String age) {
		this.age = age;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getZipcode() {
		return zipcode;
	}


	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	
}
