package com.revature.first;

import java.util.ArrayList;

import java.util.List;
import java.lang.Math;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;


import com.revature.second.question11second;

public class Driver {

	public static void main(String[] args) {
		
		//------------q1 ---------------
		System.out.println("Question 1");
		
		int[] q1 = {1,0,5,6,3,2,3,7,9,8,4};
		
		BubbleSort bs = new BubbleSort();
		bs.BubbleSort(q1);
		bs.printBubbleSort(q1);
		
		System.out.println("\n\nQuestion 2");
		
		//--------q2---------------
		Fibonacci hmm = new Fibonacci();
		int index = 25;
		hmm.fib(index);
		
		//System.out.println("The fibonacci number for "+index+" is: "+hmm.fib(index));
		//System.out.print(hmm.fib(index)+" ");
		
		
		//--------- q3 --------------
		System.out.println("\n\nQuestion 3");
		ReverseString rs = new ReverseString();
		rs.rev("Rafael");
		
		
		//---------- q4 ---------------
		System.out.println("\n\nQuestion 4");
		Factorial f = new Factorial();
		f.fac(4);
		
		
		//---------- q5 -----------------
		System.out.println("\n\nQuestion 5");
		String phrase1 = "Revature";
		Question5 q5 = new Question5();
		q5.sub(2, 5, phrase1);
		
		
		
		
		//---------- q6 -----------------
		System.out.println("\n\nQuestion 6");
		Question6 q6 = new Question6();
		q6.isEven(12);
		
		
		//---------- q7 -----------------
		System.out.println("\n\nQuestion 7");
		
		
		
		//---------- q8 -----------------
		System.out.println("\n\nQuestion 8");
		
		//created an arraylist so save all the strings
		ArrayList<String> fiftharr = new ArrayList<String>();
		fiftharr.add("karan");
		fiftharr.add("madam");
		fiftharr.add("tom");
		fiftharr.add("civic");
		fiftharr.add("radar");
		fiftharr.add("jimmy");
		fiftharr.add("kayak");
		fiftharr.add("john");
		fiftharr.add("refer");
		fiftharr.add("billy");
		fiftharr.add("did");
		
		//printing out the fiftharr
		System.out.println("The Original ArrayList: "+fiftharr);

		
		//saving the palindromes in another arrayList
		//go through the list and see if each index is a palindromes
		ArrayList<String> sixthArr = new ArrayList<String>();
		
		for(int i=0; i<fiftharr.size();i++) 
		{
			String original1 = fiftharr.get(i);
			String reverse1 ="";
			for(int j = original1.length()-1; j>=0; j--) 
			{
				reverse1 = reverse1 + original1.charAt(j);
			}		
			
			if(original1.equals(reverse1)) //this will see if the original phrase will match the reverse phrase
			{
				sixthArr.add(reverse1);
			}
			
		}
		
		
		System.out.println("The Palindrome ArrayList: "+sixthArr);
		
		
		//------------q9 ---------------
		System.out.println("\n\nQuestion 9");
		ArrayList arryL = new ArrayList();
		
		for(int i=1; i<=100; i++) 
		{
			if(!(i % 2 == 0)) 
			{
				arryL.add(i);
			}
			//arryL.add(i);
		}
		
		System.out.print(arryL+" ");
		
		
		
		//------------q10 ---------------
		System.out.println("\n\nQuestion 10");
		Question10 q10 = new Question10();
		q10.ternaryOp(2, 10);
		
		
		
		
		
		//------------q11 ---------------
		System.out.println("\n\nQuestion 11");
		question11second q11 = new question11second();
		System.out.println("The first float: "+q11.getOne());
		System.out.println("The second float: "+q11.getTwo());

		
		//------------q12 ---------------
		System.out.println("\n\nQuestion 12");
		List<Integer> evenNumbers = new ArrayList<Integer>();
		for(int i=1; i<=100; i++) 
		{
			if(i%2 == 0) 
			{
				evenNumbers.add(i);
			}
		}
		
		for(int x : evenNumbers) 
		{
			System.out.print(x+" ");
		}

		
		//------------q13 ---------------
		System.out.println("\n\nQuestion 13");
		Question13 q13 = new Question13();
		q13.pyramind(5);
		
		
		//------------q14 ---------------
		System.out.println("\n\nQuestion 14");
		Question14 q14 = new Question14();
		q14.switchCase(3);
		
		

		
		//------------q15 ---------------
		System.out.println("\n\nQuestion 15");
		Question15 q15 = new Question15();
		int one = 4;
		int two = 2;
		
		q15.addition(one, two);
		q15.subtraction(one,two);
		q15.multiplication(one,two);
		q15.division(one,two);


		
		//------------q16 ---------------
		
		System.out.println("\n\nQuestion 16");
		Question16 q16 = new Question16();
		q16.CountCharacters("Hello");
	
		
		//------------q17 ---------------
		
		System.out.println("\n\nQuestion 17");
		Question17 q17 = new Question17();
		q17.setPrincipal();
		q17.setRateOfInterest();
		q17.time();
		q17.interest();
		
		
		//------------q18 ---------------
		System.out.println("\n\nQuestion 18");

		
		//------------q19 ---------------
		System.out.println("\n\nQuestion 19");
		
		List<Integer> secondArr = new ArrayList();
		int sumOfEven =0;
		
		for(int i=1; i<=10; i++) 
		{
			if(i%2==0) 
			{
				secondArr.add(i);
			}
			
		}
		
		List<Integer> thirdArr = new ArrayList();
		int sumOfOdds =0;
		
		for(int i=0; i<10; i++) 
		{
			if(!(i%2==0)) 
			{
				thirdArr.add(i);
			}
		}
		
		List<Integer> fourthArr = new ArrayList();
		int sumOfPrime= 0;
		
		for(int i=0; i<=10; i++) 
		{
			for(int j=1; j<=10; j++) 
			{
				if(i*(j) == i) 
				{
					fourthArr.add(i);
				}
			}
		}
		
		System.out.println(fourthArr);
		
		
		Question19 q19 = new Question19();
		System.out.println("The sum of all even numbers from 1-10 is: "+q19.sum(secondArr));
		System.out.println("The sum of all odd numbers from 1-10 is: "+q19.sum(thirdArr));
		System.out.println("The sum of all prime numbers from 1-10 is: "+q19.sum(thirdArr));



		
		//------------q20 ---------------
		System.out.println("\n\nQuestion 20");
		Question20 q20 = new Question20();
		q20.Del("Data.txt");
			
		
	}

}
