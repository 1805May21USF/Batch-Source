package com.revature.same;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Bubble Sort Question 1
		System.out.println("Question 1");
		BubbleSort sort = new BubbleSort();
		System.out.println("==================================================");
		
		//Fibonacci Question 2
		System.out.println("Question 2");
		Fibonacci fib = new Fibonacci();
		System.out.println("The first 25 fibonacci sequence is " + fib.fibonacci());
		System.out.println("==================================================");
		
		//Reverse Question 3
		System.out.println("Question 3");
		Reverse rev = new Reverse();
		System.out.println("The reverse of Roll Tide is: " + rev.reverse("Roll Tide"));
		System.out.println("==================================================");
		
		//Factorial Question 4
		System.out.println("Question 4");
		Factorial factor = new Factorial();
		System.out.println("Factorial of 5 is: " + factor.factorial(5));
		System.out.println("==================================================");
		
		//Substring Question 5
		System.out.println("Question 5");
		Substring sb = new Substring();
		System.out.println("The substring is: " + sb.substring("rolltide", 3));
		System.out.println("==================================================");
		
		//EvenOrNah Question 6
		System.out.println("Question 6");
		EvenOrNah EON = new EvenOrNah();
		System.out.println("True = Even, False = Odd: " + EON.evenOrNah(4));
		System.out.println("==================================================");
		
		//SortEmployees Question 7
		System.out.println("Question 7");
		SortEmployees SE = new SortEmployees();
		
		System.out.println("Unsorted List : " + SE.listOfEmployees);
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        
        Collections.sort(SE.listOfEmployees, Employees.NameComparator);
        System.out.println("Sorted List By Name : " + SE.listOfEmployees);
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        
        Collections.sort(SE.listOfEmployees, Employees.AgeComparator);
        System.out.println("Sorted List By Age : " + SE.listOfEmployees);
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        
        Collections.sort(SE.listOfEmployees, Employees.DepartmentComparator);
        System.out.println("Sorted List By Department : " + SE.listOfEmployees);
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
		
		//Palindrome Question 8
		System.out.println("Question 8");
		Palindrome palin = new Palindrome();
		ArrayList<String> pal = palin.palindrome(palin.names);
		System.out.println("Printing out palindromes: " + pal);
		System.out.println("==================================================");
		
		//Prime Question 9
		System.out.println("Question 9");
		Prime pr = new Prime();
		System.out.println("Prime numbers in 1 to 100: " + pr.prime(pr.numbers));
		System.out.println("==================================================");
		
		//Ternary Question 10
		System.out.println("Question 10");
		Ternary T = new Ternary();
		System.out.println("The smallest number is: " + T.ternary(6/3,5));
		System.out.println("==================================================");
		
		//TwoFloat Question 11
		System.out.println("Question 11");
		TwoFloat TF = new TwoFloat();
		System.out.println("First float number: " + TF.ft);
		System.out.println("Second float number: " + TF.fl);
		System.out.println("==================================================");
		
		//Even Question 12
		System.out.println("Question 12");
		Even eve = new Even();
		System.out.println("==================================================");
		
		//Triangle Question 13
		System.out.println("Question 13");
		Triangle triangle = new Triangle();
		System.out.println("==================================================");
		
		//SwitchCase Question 14
		System.out.println("Question 14");
		SwitchCase sc = new SwitchCase();
		System.out.println("==================================================");
		
		//CountCharacters Question 16
		System.out.println("Question 16");
		if(args.length > 0) {
			String word = args[0];
			CountCharacters xters = new CountCharacters(); 
			System.out.println("Length of word in args[0] is " + xters.countcharacters(word));
		}else {
			System.out.println("Error: Enter a word");
		}
		System.out.println("==================================================");
		
		//SimpleInterest Question 17
		System.out.println("Question 17");
		SimpleInterest SI = new SimpleInterest();
		System.out.println("==================================================");
		
		//StringOperations Question 18
		System.out.println("Question 18");
		StringOperations SO = new StringOperations();
		String ten = "10";
		System.out.println("Checking  rolltide for uppercase: " + SO.toupper("rolltide"));
		System.out.println("Checking  Rolltide for uppercase: " + SO.toupper("Rolltide"));
		System.out.println("Checking  RollTide for lowercase: " + SO.tolower("RollTide"));
		System.out.println("Converting String 10 to int and adding 10: " + SO.toInt(ten));
		System.out.println("==================================================");
		
		//EvenOddPrime Question 19
		System.out.println("Question 19");
		EvenOddPrime EOP = new EvenOddPrime();
		System.out.println("==================================================");
		
		//ReadFromFile Question 20
		System.out.println("Question 20");
		ReadFromFile RFF = new ReadFromFile();
		System.out.println("==================================================");
	}

}
