package com.revature.homework.week1.float_problem;

public class FloatProblem {
	//program that initializes two float-variables
	
	private float f1 = 5.25f; 
	private float f2 = 5.29f;

	public FloatProblem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FloatProblem(float f1, float f2) {
		super();
		this.f1 = f1;
		this.f2 = f2;
	}

	public float getF1() {
		return f1;
	}

	public void setF1(float f1) {
		this.f1 = f1;
	}

	public float getF2() {
		return f2;
	}

	public void setF2(float f2) {
		this.f2 = f2;
	}

	@Override
	public String toString() {
		return "FloatProblem [f1=" + f1 + ", f2=" + f2 + "]";
	}
	

}
