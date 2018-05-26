package com.revature.test;

class GenericsTest<T> {
	private T obj1;
	private T obj2;

	public GenericsTest(T obj1, T obj2) {
		this.obj1 = obj1;
		this.obj2 = obj2;
		// TODO Auto-generated constructor stub
	}
	
	public T getObj1() {
		return obj1;
	}

	public void setObj1(T obj1) {
		this.obj1 = obj1;
	}

	public T getObj2() {
		return obj2;
	}

	public void setObj2(T obj2) {
		this.obj2 = obj2;
	}

	//public <T> T addTogether (T obj1, T obj2) {return obj1 + obj2;}
	
	public void showType() {
		System.out.println("I'm of type " + obj1.getClass().getSimpleName());
		System.out.println("My value is " + obj1+ "and "+obj2);
	}
}
