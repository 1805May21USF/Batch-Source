package javaCore;

public class q2Fibonacci {
	int num1 = 0;
	int num2 = 1;
	int num3;
	{
	for(int i=0; i < 23; i++){
		if (i == 0) {
			System.out.print("0 1");
		}
		num3=num1+num2;    
		  System.out.print(" "+num3);    
		  num1=num2;    
		  num2=num3;    
	}
	  System.out.println(" ");

	}
		}