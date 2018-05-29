package com.revature.homework.week1;

public class InterestProblem {
	//this class initializes principal, rate of interest, and the term
	//using getters and setters
	
	private int principal;
	private int rate;
	private int year;
	public InterestProblem() {
		super();
		// TODO Auto-generated constructor stub
	}
	public InterestProblem(int principal, int rate, int year) {
		super();
		this.principal = principal;
		this.rate = rate;
		this.year = year;
	}
	public int getPrincipal() {
		return principal;
	}
	public void setPrincipal(int principal) {
		this.principal = principal;
	}
	public int getRate() {
		return rate;
	}
	public void setRate(int rate) {
		this.rate = rate;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}

}
