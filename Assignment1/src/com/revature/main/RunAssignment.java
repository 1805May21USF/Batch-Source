package com.revature.main;

import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

import com.revature.beans.Problem1;
import com.revature.beans.Problem10;
import com.revature.beans.Problem12;
import com.revature.beans.Problem13;
import com.revature.beans.Problem14;
import com.revature.beans.Problem15;
import com.revature.beans.Problem16;
import com.revature.beans.Problem17;
import com.revature.beans.Problem18;
import com.revature.beans.Problem19;
import com.revature.beans.Problem2;
import com.revature.beans.Problem20;
import com.revature.beans.Problem3;
import com.revature.beans.Problem4;
import com.revature.beans.Problem5;
import com.revature.beans.Problem6;
import com.revature.beans.Problem7;
import com.revature.beans.Problem8;
import com.revature.beans.Problem9;
import com.revature.comparators.*;

public class RunAssignment {

	public static void main(String[] args) {
		
	/* Q1. Perform a bubble sort on the following integer array:  1,0,5,6,3,2,3,7,9,8,4 */
		 System.out.println("Question 1 Sorted Array: " + Problem1.arrayToString(new int[]{1,0,5,6,3,2,3,7,9,8,4}));
		
	/* Q2. Write a program to display the first 25 Fibonacci numbers beginning at 0. */
		 System.out.println("Question 2 First 25 of Fibonacci: " + Problem2.returnFirst25());
		 
	/* Q3. Reverse a string without using a temporary variable.  Do NOT use reverse() in the StringBuffer or the StringBuilder APIs.*/
		 System.out.print("Question 3 Reversed Word: ");
		 Problem3.reverseWord("boo");
		 
	/* Q4. Write a program to compute N factorial. */
		 Problem4 p4 = new Problem4(5);
		 System.out.printf("Question 4 The Factorial of N = 5 is : %d\n", p4.getFactorial());
		 
	/* Q5. Write a substring method that accepts a string str and an integer idx 
	* and returns the substring contained between 0 and idx-1 inclusive.  
	* Do NOT use any of the existing substring methods in the String, StringBuilder, or StringBuffer APIs.*/
		 System.out.printf("Question 5 String from 0 - idx-1: %s\n", Problem5.giveMeANewString("HelloMan", 5));
	
	/*Q6. Write a program to determine if an integer is even without using the modulus operator (%)*/
		 System.out.println("Question 6 is number even n = 13799? " + Problem6.isEven(13799));
	
	/*Q7. Sort two employees based on their name, department, and age using the Comparator interface.*/
		 ArrayList<Problem7> sortMe = new ArrayList<Problem7>();
		 sortMe.add(new Problem7("Jim", "Boat", 42));
		 sortMe.add(new Problem7("Adam", "HR", 26));
		 Collections.sort(sortMe, new AgeCompare());
		 
		 for(Problem7 p: sortMe){
			 System.out.printf("Question 7\nSort by Age:\nName: %s Department: %s Age: %d\n", p.getName(), p.getDepartment(), p.getAge());
		 }
		 Collections.sort(sortMe, new DepartmentCompare());
		 for(Problem7 p: sortMe){
			 System.out.printf("Sort by Department:\nName: %s Department: %s Age: %d\n", p.getName(), p.getDepartment(), p.getAge());
		 }
		 Collections.sort(sortMe, new NameCompare());
		 for(Problem7 p: sortMe){
			 System.out.printf("Sort by Name:\nName: %s Department: %s Age: %d\n", p.getName(), p.getDepartment(), p.getAge());
		 }
	/*Q8. Write a program that stores the following strings in an ArrayList and saves all the palindromes in another ArrayList.
	“karan”, “madam”, ”tom”, “civic”, “radar”, “jimmy”, “kayak”, “john”,  “refer”, “billy”, “did”*/
		 Problem8 p8 = new Problem8();
		 ArrayList<String> array = p8.giveMePalidromes("karan", "madam", "tom", "civic", "radar", "jimmy", 
				 "kayak", "john", "refer", "billy", "did");
		 System.out.println("Question 8 ArrayOfPalindroms: " + array);
		 
	/*Q9. Create an ArrayList which stores numbers from 1 to 100 and prints out all the prime numbers to the console.*/
		 Problem9 primeArray = new Problem9();
		 System.out.println("Question9 : ");
		 for(Integer i: primeArray.getPrimeNumbers()){
			 System.out.print(i + " ");
		 }
		 System.out.println();
	/*Q10. Find the minimum of two numbers using ternary operators.*/
		 System.out.printf("Question 10: Minimum of two numbers is: %d\n", Problem10.minimumOfTwoNumbers(11, 6));
		 
	/*Q11. Write a program that would access two float-variables from a class that exists in another package. Note, you will need 
	 * to create two packages to demonstrate the solution.*/
		 com.revature.float_package.Problem11Float p11 = new com.revature.float_package.Problem11Float(1.201f,2.001f);
		 System.out.printf("Question 11 Adding two floats: %.4f\n", p11.getA() + p11.getB() );
		 
	/*Q12. Write a program to store numbers from 1 to 100 in an array. Print out all the even numbers from the array. Use the 
	 * enhanced FOR loop for printing out the numbers.*/
		 System.out.print("Question 12 Print all even numbers from array: [");
		 Problem12 p12 = new Problem12();
		 for(int i : p12.getNumbers()){
			if(i % 2 == 0){
				System.out.print(i + " ");
			}		 
		 }
		 System.out.println("]");
		 
	/*Q13. Display the triangle on the console as follows using any type of loop.  Do NOT use a simple group of print statements 
	 * to accomplish this.
	0
	1 0
	1 0 1
	0 1 0 1
	 */
	System.out.println("Question 13: ");
	Problem13.printTriangle(4);
		 
	/*Q14. Write a program that demonstrates the switch case. Implement the following functionalities in the cases:java
	Case 1: Find the square root of a number using the Math class method.
	Case 2: Display today’s date.
	Case 3: Split the following string and store it in a string array.
       	 “I am learning Core Java”
	 */
	Problem14 p14 = new Problem14(8);
	System.out.println("Question 14: I am showing 1 result of the switch. Modify in the class. The result is: ");
	p14.switchDemo();
	System.out.println();
		 
	/*Q15. Write a program that defines an interface having the following methods: addition, subtraction, multiplication, 
	 * and division.  Create a class that implements this interface and provides appropriate functionality to carry out 
	 * the required operations. Hard code two operands in a test class having a main method that calls the implementing class.*/
	double a = 10.0; double b = 2.0; Problem15 p15 = new Problem15();
	System.out.printf("Question 15: a = %.2f b = %.2f \nAddition: %.2f Subtract: %.2f Multiply: %.2f Division: %.2f\n", a, b, p15.addition(a, b),
			p15.substraction(a, b), p15.multiply(a, b), p15.division(a, b));
		 
	/*Q16. Write a program to display the number of characters for a string input. The string should be entered as a command 
	 * line argument using (String [ ] args).*/
	System.out.println("The number of characters in args is: " + Problem16.getNumberOfCharsInString(args));
	
	/*Q17. Write a program that calculates the simple interest on the principal, rate of interest and number of years provided by the user. 
	 * Enter principal, rate and time through the console using the Scanner class. Interest = Principal* Rate* Time
	 */
	//inputFor17();
		
	/*Q18. Write a program having a concrete ;subclass that inherits three abstract methods from a superclass.  Provide the following three implementations in the subclass corresponding to the abstract methods in the superclass:
 
	1.          	Check for uppercase characters in a string, and return ‘true’ or ‘false’ depending if any are found.
	2.          	Convert all of the lower case characters to uppercase in the input string, and return the result.
	3.          	Convert the input string to integer and add 10, output the result to the console.
	Create an appropriate class having a main method to test the above setup.
	 */
	Problem18 p18 = new Problem18();
	System.out.println("Does the string contain uppercase letters? " + p18.checkForUpperCaseLetters("yesS"));
	System.out.println("Return all Capital Letter " + p18.stringToUpperCase("yess"));
	String p18Num = "10";
	System.out.printf("Add 10 to number input as a String. The number is %s and + 10 is : %d\n", p18Num, p18.add10ToNumberReturnString(p18Num));
	
	/*Q19. Create an ArrayList and insert integers 1 through 10. Display the ArrayList. Add all the even numbers up and display the result. Add all the odd numbers up and display the result. Remove the prime numbers from the 
	 * ArrayList and print out the remaining ArrayList.*/
	System.out.println("Question 19: ");
	Problem19 p19 = new Problem19();
	p19.printSumOfEvenNumbersInArray();
	p19.printSumOfOddNumbersInArray();
	p19.removePrimeNumberFromArrayAndPrint();
	
	/*Q20. Create a notepad file called Data.txt and enter the following:
		Mickey:Mouse:35:Arizona
		Hulk:Hogan:50:Virginia
		Roger:Rabbit:22:California
		Wonder:Woman:18:Montana
		
		Write a program that would read from the file and print it out to the screen in the following format:
 			Name: Mickey Mouse
			Age: 35 years
			State: Arizona State
	 */
	Problem20 p20 = new Problem20();
		 
	}
	public static void inputFor17(){
		Scanner s = new Scanner(System.in);
		try {
			System.out.println("Enter Principal: ");
			double principal = Double.parseDouble(s.nextLine());
			System.out.println("Enter Rate");
			double rate = Double.parseDouble(s.nextLine());
			System.out.println("Enter Time in Years");
			double timeInYears = Double.parseDouble(s.nextLine());
			Problem17 p17 = new Problem17(rate, principal, timeInYears);
			System.out.println("Question 18: Simple Intrest is " + p17.getIntrest());
		} catch (Exception e) {
			System.out.println("Invalid Input");
			inputFor17();
		}
		
		
	}
}
