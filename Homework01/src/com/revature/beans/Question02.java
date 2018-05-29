package com.revature.beans;

public class Question02 {

	static int n1=0, n2=1, n3=0;    
	
	public void fib(int count){    
	    if(count > 0){    
	         n3 = n1 + n2;    
	         n1 = n2;    
	         n2 = n3;    
	         System.out.print(" " + n3);   
	         fib(count - 1);    
	     }    
	 }    
}
