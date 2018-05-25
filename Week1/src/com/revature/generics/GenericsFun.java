package com.revature.generics;

class Test<T> {
	T obj;
	
	public Test(T obj) {
		this.obj = obj;
	}
	
	public T getObj() {
		return obj;
	}

	public void setObj(T obj) {
		this.obj = obj;
	}
}

public class GenericsFun {
	public static void main(String[] args) {
		Test<Double> tObj = new Test<Double>(5.4);
		System.out.println(tObj.getObj());
		
		Test<String> tObj1 = new Test<String>("Generic String");
		System.out.println(tObj1.getObj());
	}
}
