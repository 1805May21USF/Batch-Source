package com.revature.drive;
import java.util.*;
public class FunStuff {
	
	public static void main(String[] arg) {
		System.out.println("hello world");
		 Scanner in = new Scanner(System.in);
		 int a = 0;
		 int j = 2;
		 boolean check = false;
		 
	      System.out.println("Enter an integer");
	      a = in.nextInt();
	      
	     if(a%2==0) {
	    	 System.out.println("your number is even");
	     }else {
	    	 System.out.println("your number is odd");
	     }
	
	     for(int i = 0;i<1000;i++) {
	    	 if(i%a==0) {
	    		 System.out.println(i+" is a multiple of your number");
	    	 }
	     }
	     
	     do {
	    	 if((j%a)==0) {
	    		 check=true;
	    		 System.out.println("your number is not prime");
	    	 }
	    	 j++;
	    	 if(j>1000000) {System.out.println("your number is a number");break;}
	     }while(check ==false);
	     j=0;
	     while(a<1000000) {
	    	 a = a*2;
	    	 j++;		 
	     }
	     System.out.println("your number must be doubled "+j+" times to be greater than a million");
	     switch(a) {
	     	case(0):
	     			System.out.println("0 is not cool");
	     			break;
	     	case(1776):
	     			System.out.println("INDEPENDENCE");
	     			break;
	     	default:
	     			System.out.println("your number is terrible");
	     			break;
	     	
	     }
	     
	}
}
