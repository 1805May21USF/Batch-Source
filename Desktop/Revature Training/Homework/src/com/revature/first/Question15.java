package com.revature.first;

public class Question15 implements Question15Interface{
	
	public void addition(int x, int y) 
	{
		int sum = x +y;
		System.out.println(x+" + "+y+" = "+sum);
	}
	
	public void subtraction(int x1, int y1) 
	{
		int sub = x1-y1;
		System.out.println(x1+" - "+y1+" = "+sub);
	}
	
	public void multiplication(int x2, int y2) 
	{
		int mul = x2 * y2;
		System.out.println(x2+" * "+y2+" = "+mul);
	}
	
	public void division(int x3, int y3) 
	{
		int div = x3/y3;
		System.out.println(x3+" / "+y3+" = "+div);
	}

}
