package com.revature.assignments;
import java.util.Scanner;
import java.util.Collections;
import java.util.ArrayList;
import com.revature.packageq11.*;
/*
 * 
 * @Author Kaleb Martin
 * @Assingment 1
 * @Date 5/28/18
 * 
 * During the Execution the Console will jump immediately to question 3
 * Do not be alarmed. This is normal. It does this again at Question 6
 * where it will jump all the way up to question 17. And then once more at question 17.
 * unless explicitly required in the assignment, I have hardCoded everything into the methods to 
 * save time. 
 * 
 * 
 * 
 */


public class Test {

		private static Scanner in = new Scanner(System.in);
	
	public static void main(String [] args) {
		
		
		
		
		
		//Question One.....Bubble sort
		System.out.println("\n\n<---------- Question 1 ----------->\n");
		System.out.println();
		Q1.sort();
		Q1.printSort();
		
		
		
		
		//question 2
		System.out.println("\n\n<---------- Question 2 ----------->\n");
		System.out.println();
		Q2.RunFibbonaci();
		
		
		
		
		
		//question 3
		System.out.println("\n\n<---------- Question 3 ----------->\n");
		System.out.println();
		Q3.StringReverse();
		
		
		
		
		
		//question4
		System.out.println("\n\n<---------- Question 4 ----------->\n");
		Q4 q4 = new Q4();
		q4.doWork();
		
		
		
		//question 5
		System.out.println("\n\n<---------- Question 5 ----------->\n");
		Q5 q5 = new Q5();
		int myInt;
		String myString;
		boolean check = false;
		
		
		try {
		System.out.println("Enter a Word");
		myString = in.nextLine();
		outer: while(check == false) {
		System.out.println("Enter a number to index to so i can make a substring");
		myInt = in.nextInt();
		if(myInt < myString.length()) {
		myString = q5.SubString(myString, myInt);
		System.out.println("New String:  " + myString);
		check = true;
			}else {
			continue outer;
			}
		}
		}catch(Exception e){
			System.out.println("Something isn't right here!");
			System.out.println("Make sure you enter a number");
		}
		
		
		
		
		
		//Question 6
		System.out.println("\n\n<---------- Question 6 ----------->\n");
		System.out.println("Enter a number! Ill tell you if it is odd or even!");
		int number = in.nextInt();
		boolean checking = Q6.even(number);
		
		if(checking == true) {
			System.out.println("Its Even");
		}
		else {
			System.out.println("Its Odd");
		}
		
		
		
		
		
		//Question 7
		//todo finish
		System.out.println("\n\n<---------- Question 7 ----------->\n\n");
		ArrayList<Employee> employee = new ArrayList<Employee>();
		Employee one = new Employee("Bob", 40, "Sales");
		Employee two = new Employee("Steven", 28, "HR");
		
		
		Q7 q = new Q7();
		int myInteger = q.compare(one, two);
		System.out.print(myInteger);
		
		
		
		
		//Question 8
		System.out.println("\n\n<---------- Question 8 ----------->\n\n");
		Q8 q8 = new Q8();
		q8.AddWords();
		q8.printWords();
		q8.checkWords();
		q8.printPalindromes();
		
		
		
		//Question 9
		//Print only the primes of an array.
		
		System.out.println("\n\n<---------- Question 9 ----------->\n\n");
		
	 	Q9 q9 = new Q9();
		q9.addIntegers();
		q9.print();
		
		
		
		//Question 10
		//find the minimum of two values using the ternary operator
		System.out.println("\n\n<---------- Question 10 ----------->\n\n");
		Q10 q10 = new Q10();
		System.out.println(q10.checkVals(19,38));
		
		
		
		
		//Question 11
		//Q11.java is in the com.revature.packageq11.*;
		//return the values of a float in another package
		System.out.println("\n\n<---------- Question 11 ----------->\n\n");
		Q11 q11 = new Q11();
		System.out.println(q11.getFloat1());
		System.out.println(q11.getFloat2());
		
		
		
		
		//Question 12
		//Print all the even numbers from an array from 1 to 100.
		System.out.println("\n\n<---------- Question 12 ----------->\n\n");
		Q12 q12= new Q12();
		q12.initArray();
		q12.printEvens();
		
		
		
		//Question 13
		//print the triangle shape using no simple print statements.
		System.out.println("\n\n<---------- Question 13 ----------->\n\n");
		Q13 q13 = new Q13();
		q13.printTriangle();
		
		
		
		//Question 14
		//Q14 demonstrates a switch case.
		//(1)find the root of a number, currently set at 121
		//(2)print the date.
		//(3)create an array of subStrings from a string and print them.
		//default: prints out enter a valid number.
		//the switchCase function is called three times with each possible case;
		System.out.println("\n\n<---------- Question 14 ----------->\n\n");
		Q14 q14 = new Q14();
		q14.switchCase(1);
		System.out.println("\n\n");
		q14.switchCase(2);
		System.out.println("\n\n");
		q14.switchCase(3);
		System.out.println("\n\n");
		q14.switchCase(4);
		
		
		
		//Question 15
		//Q15 implements Q15Interface
		System.out.println("\n\n<---------- Question 15 ----------->\n\n");
		Q15 q15 = new Q15();
		System.out.println(q15.addition(5,16));
		System.out.println(q15.division(27,3));
		
		
		
		
		//System.out.println("\n\n<---------- Question 16 ----------->\n\n");
		//Question 16 is ran from the Q16.java 
		
		
		
		
		//Question 17
		//Calculate simple interest.
		System.out.println("\n\n<---------- Question 17 ----------->\n\n");
		Q17 q17 = new Q17();
		System.out.println("Enter the rate");
		float rate = in.nextFloat();
		System.out.println("enter the principal");
		float principal = in.nextFloat();
		System.out.println("Enter time in years");
		int time = in.nextInt();
		q17.CalculateInterest(rate, principal, time);
		System.out.println("Simple interest:  ");
		q17.printInterest();
		
		
		
		
		//Question 18
		//Q18 extends the abstract 18 class
		//stringToInt()adds ten to the inputted value and prints the new value
		//toUpper()Changes the lowerCase values in a string to UpperCase
		//checkUpperCase()checks to see if a string has upper case values and returns true or false.
		System.out.println("\n\n<---------- Question 18 ----------->\n\n");
		Q18 q18 = new Q18();
		q18.stringToInt("20");
		System.out.println(q18.toUpper("hello Pizza imma eat you!!"));
		System.out.println(q18.checkUppercase("if I am a Pizza then eat me."));
		System.out.println(q18.checkUppercase("im just a lower case pizza don't eat me!"));
		
		
		
		
		//Question 19
		//Q19 adds values from 1-10 to an Integer<arrayList>
		//Adds all the evens up and displays to the Screen
		//Adds all the odds up and displays to the screen.
		//and removes all primes from the array.
		System.out.println("\n\n<---------- Question 19 ----------->\n\n");
		Q19 q19 = new Q19();
		q19.runQ19();
		
		
		
		
		//Question 20
		//Reads in data from a .txt file and formats it correctly
		System.out.println("\n\n<---------- Question 20 ----------->\n\n");
		Q20 q20 = new Q20();
		q20.importData();
		
		in.close();
	}
	
}
