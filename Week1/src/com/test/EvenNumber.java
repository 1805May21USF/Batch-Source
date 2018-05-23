package com.test;

import com.revature.exceptions.NewException;

public class EvenNumber {
	private int a;
	
	public EvenNumber(int a ) {
		isEven(a);
		setA(a);
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}
	
	static public boolean isEven(int a) {
		try {
			if(a % 2 == 0) {
				return true;
			}else {
				throw new NewException("This is Odd");
				
			}
		} catch (NewException e) {
			System.out.println(e);
		}
		return false;
	}
}
