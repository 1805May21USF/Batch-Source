package com.revature.GavinHomework;

import static org.junit.Assert.assertEquals;

import java.util.*;
import java.util.concurrent.TimeUnit;

import javax.swing.plaf.synth.SynthSeparatorUI;

import org.junit.Test;

/**
 * @author Gavin
 *
 */

//import Q2Fibonacci.fib;
 
public class DoRunMe {
	
	//Here is my scanner 
	static Scanner input = new Scanner(System.in);
	
	static Q01BubbleSort Q1 = new Q01BubbleSort();
	static Q02Fibonacci Q2 = new Q02Fibonacci();
	static Q03Reverse Q3 = new Q03Reverse();
	static Q04Factorial Q4 = new Q04Factorial();
	static Q05BeginningOfString Q5 = new Q05BeginningOfString();
	static Q06IsEven Q6 = new Q06IsEven();
	//Question 7 is ommited because there need to be multiple of them.
	static Q08ListPalindromes Q8 = new Q08ListPalindromes();
	static Q09Primess Q9 = new Q09Primess();
	static Q10Minimum Q10 = new Q10Minimum();
	static Q11TheFloats Q11= new Q11TheFloats();
	static Q12PrintEven Q12 = new Q12PrintEven();
	static Q13Triangle Q13 = new Q13Triangle();
	static Q14SwitchingItUp Q14 = new Q14SwitchingItUp();
	static Q15Calculating Q15 = new Q15Calculating();
	static Q16NumChar Q16 = new Q16NumChar();
	static Q17Interest Q17 = new Q17Interest();
	static Q18TheFounder Q18 = new Q18TheFounder();
	static Q19ListfulConcerns Q19 = new Q19ListfulConcerns();
	static Q20Notes Q20 = new Q20Notes();
	
	
	
	
	public static void main(String[] args) {
		
		Q07Employee  e1 = new Q07Employee(23,"William", "Accounting");
		Q07Employee e2 = new Q07Employee(29,"Robert", "Finance");
		
		System.out.println("Hello, and welcome to Gavin DePaul's first assinment.");
		System.out.println("Deeper understanding of the code can be found in the comments");
		System.out.println("This is just an easy way to see all of the different questions quickly.\n\n");
		
		System.out.println("Just a headsup, question 16 will be skipped due to command line parameters. Go to the Q16 class to handle it.");
		
		int [] b = {1,0,5,6,3,2,3,7,9,8,4};
		System.out.println("Q1. Perform a bubble sort on the following integer array:  1,0,5,6,3,2,3,7,9,8,4\n");
		System.out.println("The input is: 1 0 5 6 3 2 3 7 9 8 4 ");
		System.out.println("And the output is:");
		printArray(Q1.sortMe(b));
		System.out.println();
		nextQuestion();
		
		System.out.println("Q2. Write a program to display the first 25 Fibonacci numbers beginning at 0.\n");
		for(int i = 0; i < 26; i++) {
			System.out.println("Fibonanci number  " + i +" is: "+Q2.fib(i));
		}
		nextQuestion();	
		
		System.out.println("Q3. Reverse a string without using a temporary variable.  Do NOT use reverse() in the StringBuffer or the StringBuilder APIs.");
		String rt = "Roll Tide";
		
		System.out.println("The string we are going to be reversing is: " + rt);
		System.out.println("The string reversed looks like: " + Q3.reverse(rt));
		nextQuestion();
		
		System.out.println("Q4. Write a program to compute N factorial");
		System.out.print("Enter a n to find the factorial of: ");
		int N = input.nextInt();
		System.out.println("\n"+N + "! = " + Q4.fac(N));
		nextQuestion();
		
		String Qfive = "The Marine Corps";
		System.out.println("Q5. Write a substring method that accepts a string str and an integer idx and returns the substring contained between 0 and idx-1 inclusive.  Do NOT use any of the existing substring methods in the String, StringBuilder, or StringBuffer APIs.");
		System.out.println("The string we are using today is: " + Qfive);
		System.out.print("Input a number between 4 and 12: ");
		N = input.nextInt();
		System.out.println("\nThe 1st to the " + N + "th place in the string is: " + Q5.beg(Qfive, N) );
		
		nextQuestion();
		
		System.out.println("Q6. Write a program to determine if an integer is even without using the modulus operator (%)");
		System.out.print("Enter a number that you want to see is even or odd: " );
		if(Q6.isIt(input.nextInt())) System.out.println("It's even!");
		else System.out.println("It's odd!");
		
		nextQuestion();
		
		System.out.println("Q7. Sort two employees based on their name, department, and age using the Comparator interface.");
		System.out.println("The employees are as follows: ");
		System.out.println(e1.toString());
		System.out.println(e2.toString());
		
		System.out.println("They can be sorted using their comparator function.");
		nextQuestion();
		
		System.out.println("Write a program that stores the following strings in an ArrayList and saves all the palindromes in another ArrayList.\r\n" + 
				"“karan”, “madam”, ”tom”, “civic”, “radar”, “jimmy”, “kayak”, “john”,  “refer”, “billy”, “did”\r\n" + 
				"");
		ArrayList<String>  a = new ArrayList<String>();
		a.add("narak");
		a.add("madam");
		a.add("tom");
		a.add("civic");
		a.add("radar");
		a.add("ymmij");
		a.add("kayak");
		a.add("nhoj");
		a.add("refer");
		a.add("yllib");
		a.add("did");
		
		System.out.println("The output look like this: " + Q8.niceWord(a).toString());
		
		nextQuestion();
		
		System.out.println("Create an ArrayList which stores numbers from 1 to 100 and prints out all the prime numbers to the console.");
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for(int i = 0; i<100; i++) {
			arr.add(i+1);
			if(Q9.isPrime(i+1))	System.out.println(i+1+" is prime");
		}
		
		nextQuestion();
		
		System.out.println("Q10. Find the minimum of two numbers using ternary operators.");
		System.out.println("With the operator 7 and 5 if sent through the method: ");
		System.out.println(Q10.min(5,7) +" ends up popping out.");
		
		nextQuestion();
		
		System.out.println("Q11. Write a program that would access two float-variables from a class that exists in another package. Note, you will need to create two packages to demonstrate the solution.");
		Q11.floatingAway();
		nextQuestion();
		
		System.out.println("Q12. Write a program to store numbers from 1 to 100 in an array. Print out all the even numbers from the array. Use the enhanced FOR loop for printing out the numbers.");
		System.out.println("The output looks like: ");
		Q12.iterableEvens();
		nextQuestion();

		System.out.println(" Display the triangle on the console as follows using any type of loop.  Do NOT use a simple group of print statements to accomplish this.\r\n" + 
				"	0\r\n" + 
				"	1 0\r\n" + 
				"	1 0 1\r\n" + 
				"	0 1 0 1\r\n" + 
				"");
		
		System.out.println("The output looks like: ");
		Q13.tri();
		nextQuestion();
		
		System.out.println("Q14. \r\n" + 
				"Write a program that demonstrates the switch case. Implement the following functionalities in the cases:java\r\n" + 
				"Case 1: Find the square root of a number using the Math class method.\r\n" + 
				"Case 2: Display today’s date.\r\n" + 
				"Case 3: Split the following string and store it in a string array.\r\n" + 
				"       	 “I am learning Core Java”");
		
		System.out.println("The output looks like this: ");
		for(int i = 0; i <3; i++) {
			Q14.Demonstrate(i);
		}
		
		nextQuestion();
		
		System.out.println("Q15. Write a program that defines an interface having the following methods: addition, subtraction, multiplication, and division.  Create a class that implements this interface and provides appropriate functionality to carry out the required operations. Hard code two operands in a test class having a main method that calls the implementing class.");
		System.out.println("This problem is done via testing. Go to Q15 Calculator and run the test.");
		
		
			System.out.println("Skipping 16, run on the Q16 class.");
			nextQuestion();
		
			
		System.out.println("Write a program that calculates the simple interest on the principal, rate of interest and number of years provided by the user. Enter principal, rate and time through the console using the Scanner class.\r\n" + 
				"Interest = Principal* Rate* Time\r\n" + 
				"");
		
		System.out.println("Input the principle, rate, and time: ");
		Q17.findInterest();
		System.out.println("This is the output.");
		nextQuestion();
		
		
		System.out.println("Q18. Write a program having a concrete ;subclass that inherits three abstract methods from a superclass.  Provide the following three implementations in the subclass corresponding to the abstract methods in the superclass:\r\n" + 
				" \r\n" + 
				"1.          	Check for uppercase characters in a string, and return ‘true’ or ‘false’ depending if any are found.\r\n" + 
				"2.          	Convert all of the lower case characters to uppercase in the input string, and return the result.\r\n" + 
				"3.          	Convert the input string to integer and add 10, output the result to the console.\r\n" + 
				"Create an appropriate class having a main method to test the above setup.\r\n" + 
				"");
		
		System.out.println("For question, go to the class and run the test. It'll be better than some other option here.");
		nextQuestion();
		
		System.out.println(" Q19. Create an ArrayList and insert integers 1 through 10. Display the ArrayList. Add all the even numbers up and display the result. Add all the odd numbers up and display the result. Remove the prime numbers from the ArrayList and print out the remaining ArrayList.");
		System.out.println("This is what that looks like : ");
		Q19.Listy();
		nextQuestion();
		
		System.out.println("Create a notepad file called Data.txt and enter the following:\r\n" + 
				"Mickey:Mouse:35:Arizona\r\n" + 
				"Hulk:Hogan:50:Virginia\r\n" + 
				"Roger:Rabbit:22:California\r\n" + 
				"Wonder:Woman:18:Montana\r\n" + 
				" \r\n" + 
				"Write a program that would read from the file and print it out to the screen in the following format:\r\n" + 
				" \r\n" + 
				"Name: Mickey Mouse\r\n" + 
				"Age: 35 years\r\n" + 
				"State: Arizona State\r\n" + 
				"");
		Q20.notes();
		
		System.out.println("Thanks!");		
	}
		
	public static void nextQuestion() {
		System.out.print("Wait for the next question.");
		try {
			TimeUnit.SECONDS.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("\n\n\n\n\n\n=======================Next Question=======================\n\n\n");
	}
	

	public static void printArray(int [] arr) {
		for(int i = 0; i<arr.length;i++) {
			System.out.print(arr[i] + " ");
		}
	}
	
	
	
}
