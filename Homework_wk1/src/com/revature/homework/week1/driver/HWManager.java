package com.revature.homework.week1.driver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.revature.homework.week1.BubbleSortProblem;
import com.revature.homework.week1.EvenIntegerProblem;
import com.revature.homework.week1.EvenNumberProblem;
import com.revature.homework.week1.FactorialProblem;
import com.revature.homework.week1.FibonacciProblem;
import com.revature.homework.week1.IntegerProblem;
import com.revature.homework.week1.InterestProblem;
import com.revature.homework.week1.MinimumProblem;
import com.revature.homework.week1.PalindromeArrayList;
import com.revature.homework.week1.PrimeProblem;
import com.revature.homework.week1.ReadingFileProblem;
import com.revature.homework.week1.StringReverseProblem;
import com.revature.homework.week1.SubstringProblem;
import com.revature.homework.week1.SwitchProblem;
import com.revature.homework.week1.TriangleProblem;
import com.revature.homework.week1.compare.Employee;
import com.revature.homework.week1.compare.EmployeeComparator;
import com.revature.homework.week1.float_problem.FloatProblem;
import com.revature.homework.week1.problem_15.Calculation;
import com.revature.homework.week1.problem_18.StringConverter;;

public class HWManager {
	/*Driver class to run all the questions from the homework*/
	
	public static void main(String[] args) {
		
		//bubble sort problem
		int[] arr1 = {1,0,5,6,3,2,3,7,9,8,4};
		System.out.println("Q1:");
		BubbleSortProblem bsp = new BubbleSortProblem();
		bsp.setArr(arr1);
		System.out.print("Here's the array before sorting: ");
		bsp.printArray(arr1);
		System.out.println();
		bsp.sortArray(arr1);
		System.out.print("Here's the array after sorting: ");
		bsp.printArray(arr1);
		System.out.println();
		
		//fibonacci problem
		System.out.print("Q2:\n" + "First 25 fibonacci number beginning at 0: ");
		FibonacciProblem fp = new FibonacciProblem();
		for(int i = 0; i < 25; i++)
		System.out.print(fp.fibSequence(i) + " ");
		System.out.println();
		
		//reverse a string
		StringReverseProblem srp = new StringReverseProblem();
		String s1 = "Too much homework";
		srp.setStr(s1);
		System.out.print("Q3:\n" + "Here's the reversed string of '" + srp.getStr() + "': ");
		srp.printReverse(s1);
		System.out.println();
		
		//compute N factorial
		FactorialProblem fcp = new FactorialProblem();
		System.out.println("Q4:\n"+"Here's the result of 5!: " + fcp.printFactorial(5));
		
		//return substring by passing a string and an integer
		System.out.println("Q5:");
		SubstringProblem sp = new SubstringProblem();
		String s = "STUPENDOUS";
		int n = 5;
		sp.setStr(s);
		System.out.print("Here's the substring result of " + sp.getStr() + ": ");
		sp.printSubstring(s, n);
		
		//check if an integer is even without using modulus
		EvenIntegerProblem ep = new EvenIntegerProblem();
		System.out.println("Q6:\n" + "14 an even integer: True or False-  " + ep.isEven(14));
		System.out.println("15 an even integer: True or False- " + ep.isEven(15));
		
		//sorting employees
		System.out.println("Q7:");
		List<Employee> employeeList = new ArrayList<Employee>();

		employeeList.addAll(Arrays.asList(
				new Employee[] { new Employee("John", 26, "Sales"), 
						new Employee("Natasha", 24, "Accounting"), }));
		System.out.println("=================================");
		Collections.sort(employeeList, new EmployeeComparator());
		System.out.println("Sorting based on age: ");
		for(Employee e : employeeList){
			
			System.out.println(e);
		}
		
		System.out.println("=================================");
		Collections.sort(employeeList, (arg0, arg1) 
				-> {return arg0.getName().compareTo(arg1.getName());});
		
		System.out.println("Sorting based on name: ");
		
		for(Employee e : employeeList){
			
			System.out.println(e);
			
		}
		
		System.out.println("=================================");
		Collections.sort(employeeList, (arg0, arg1) 
				-> {return arg0.getDept().compareTo(arg1.getDept());});
		
		System.out.println("Sorting based on department: ");
		
		for(Employee e : employeeList){
			
			System.out.println(e);
			
		}
		
		//arraylist containing palindromes
		System.out.println("Q8: ");
		PalindromeArrayList pal = new PalindromeArrayList();
		ArrayList<String> arrList = new ArrayList<String>(
				Arrays.asList("karan", "madam", "tom", "civic", "radar", "jimmy", "kayak", "john", "refer", "billy", "did"));
		System.out.println("Here's the arraylist with all strings: " + arrList);
		ArrayList<String> palindromeList = new ArrayList<String>();
		System.out.print("Here's the arraylist with all palindromes: ");
		System.out.println(pal.findPalindrome(arrList, palindromeList));
		
		//prints all the prime numbers between 1-100
		System.out.println("Q9: ");
		PrimeProblem pp = new PrimeProblem();
		ArrayList<Integer> numList = new ArrayList<Integer>();
		System.out.print("Here are the prime numbers between 1-100: ");
		pp.printPrime(numList);
		System.out.println();
		
		//prints minimum of two numbers
		System.out.println("Q10: ");
		int x = 14;
		int y = 12;
		MinimumProblem mp = new MinimumProblem();
		mp.setX(x);
		mp.setY(y);
		mp.minNumber(x, y);
		
		//accesses float-variables from another class and prints it out
		System.out.println("Q11: ");
		FloatProblem flp = new FloatProblem();
		System.out.println("Here are the float-varibles: " + flp.getF1() + " and " + flp.getF2());
		
		//prints out even numbers between 1 to 100
		System.out.println("Q12: ");
		EvenNumberProblem  enp = new EvenNumberProblem();
		int[] arr2 = new int[100];
		enp.setArr(arr2);
		enp.printEven(arr2);
		System.out.println();
		
		//displays triangle containing 0's and 1's
		System.out.println("Q13: ");
		TriangleProblem tp = new TriangleProblem();
		tp.printTriangle();
		
		//prints out different switch case statements
		System.out.println("Q14: ");
		SwitchProblem swp = new SwitchProblem();
		swp.switchCases();
		
		//prints out addition, subtraction, multiplication, and division
		//result of two integers
		System.out.println("Q15: ");
		Calculation cal = new Calculation();
		System.out.println("Result of addition: " + cal.addition(121, 11));
		System.out.println("Result of subtraction: " + cal.subtraction(121, 11));
		System.out.println("Result of multiplication: " + cal.multiplication(121, 11));
		System.out.println("Result of division: " + cal.division(121, 11));
		
		//accepts string argument and prints out the number of characters
		/*System.out.println("Q16: ");
		StringCharacterProblem scp = new StringCharacterProblem();
		scp.main(args);*/
		
		//accepts user input for the principal, interest rate, and the #'s of years
		//and calculates the interest by multiplying all of them
		System.out.println("Q17: ");
		InterestProblem ip = new InterestProblem();
		Scanner input = new Scanner(System.in);
		int principal;
		int interestRate;
		int numYear;
		System.out.println("Enter an integer value of principal: ");
		principal = input.nextInt();
		ip.setPrincipal(principal);
		System.out.println("Enter an integer value of interest rate: ");
		interestRate = input.nextInt();
		ip.setRate(interestRate);
		System.out.println("Enter an integer value of number of years: ");
		numYear = input.nextInt();
		ip.setYear(numYear);
		int interest = (ip.getPrincipal())*(ip.getRate())*(ip.getYear());
		System.out.println("The interest is calculated to be " + interest);
		input.close();
		
		//checks for uppercase letter in the string
		//converts lowercase to uppercase
		//adds integer to the string and returns the result
		System.out.println("Q18: ");
		String word = "deadpool";
		StringConverter sc = new StringConverter();
		System.out.println("Checking for uppercase characters: " + sc.uppercaseChecker(word));
		System.out.println("Converting lowercase to uppercase: " + sc.convertToUpperCase(word));
		System.out.println("Adding integer to the string: " + sc.convertString("27"));
		
		//displays arraylist of numbers from 1-10
		//adds all the even numbers
		//adds all the odd numbers
		//removes the prime numbers and prints the list again
		System.out.println("Q19: ");
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 1; i <= 10; i++) {
			list.add(i);
		}
		System.out.println("Here's the arraylist in the beginning: " + list);
		IntegerProblem intp = new IntegerProblem();
		System.out.println("Total of all the even numbers between 1-10 is: " + intp.addEven(list));
		System.out.println("Total of all the odd numbers between 1-10 is: " + intp.addOdd(list));
		System.out.print("Heres the list after removing prime: ");
		intp.printList(list);
		
		//reads from the "Data.txt" file and prints out the context
		System.out.println("Q20: ");
		ReadingFileProblem rp = new ReadingFileProblem();
		rp.readFile();
	}
}
