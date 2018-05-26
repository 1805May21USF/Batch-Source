package com.revature.driver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import com.revature.floats.FloatClass;
import com.revature.problem.Arguments;
import com.revature.problem.ArrayListStuff;
import com.revature.problem.BubbleSort;
import com.revature.problem.Calculation;
import com.revature.problem.ComparatorStuff;
import com.revature.problem.Employee;
import com.revature.problem.Even;
import com.revature.problem.Evens;
import com.revature.problem.Factorial;
import com.revature.problem.FibNumbers;
import com.revature.problem.FileIO;
import com.revature.problem.Interest;
import com.revature.problem.Minimum;
import com.revature.problem.NotAbstractClass;
import com.revature.problem.Palindromes;
import com.revature.problem.Primes;
import com.revature.problem.Reverse;
import com.revature.problem.Substring;
import com.revature.problem.Switch;
import com.revature.problem.Triangle;

public class CoreJavaDriver {
	//Problem 1: Bubble Sort
	private static void problem1() {
		int[] nums = new int[]{1,0,5,6,3,2,3,7,9,8,4};
		nums = BubbleSort.bubbleSort(nums);
		BubbleSort.print(nums);
	}	
	//Problem 2: 25 Fib Numbers
	private static void problem2() {
		String fibs = FibNumbers.fibNumbers(25);
		FibNumbers.print(fibs);
	}
	//Problem 3: Reverse
	private static void problem3() {
		String strRev = "String to Reverse!";
		System.out.println("String: " + strRev);
		System.out.println("Reversed: " + Reverse.reverse(strRev));
	}
	//Problem 4: N Factorial
	private static void problem4() {
		int n = 4;
		int nFact = Factorial.factorial(n);
		Factorial.print(nFact, n);
	}
	//Problem 5: Substring
	private static void problem5() {
		String strSub = "Rolltide yall";
		int idx = 7;
		System.out.println("String: " + strSub);
		System.out.println("Substring(" + idx + "): " + Substring.substring(strSub, idx));
	}
	//Problem 6: Even
	private static void problem6() {
		int numEven = 8;
		System.out.println(numEven + " is " + Even.even(numEven));
	}
	//Problem 7: Comparator
	private static void problem7() {
		ArrayList<Employee> emps = new ArrayList<Employee>();
		emps.add(new Employee("Jim", "HR", 65));
		emps.add(new Employee("Alice", "Sales", 31));
		ComparatorStuff.sort(emps);
	}
	//Problem 8: Palindromes
	private static void problem8() {
		ArrayList<String> strs = new ArrayList<String>();
		Collections.addAll(strs, "karan", "madam", "tom", "civic", "radar", "jimmy", "kayak", "john", "refer", "billy", "did");
		Palindromes.print(Palindromes.palindromes(strs));
	}
	//Problem 9: Primes
	private static void problem9() {
		ArrayList<Integer> ints = new ArrayList<Integer>();
		for (int i = 1; i < 101; i++) {
			ints.add(i);
		}
		Primes.print(Primes.primes(ints));
	}
	//Problem 10: Minimum
	private static void problem10() {
		int num1 = 5;
		int num2 = 7;
		System.out.println("Numbers: " + num1 + " and " + num2);
		Minimum.print(Minimum.minimum(num1, num2));
	}
	//Problem 11: Floats in another Package
	private static void problem11() {
		FloatClass ft = new FloatClass();
		System.out.println("Floats: " + ft.getFloat1() + " " + ft.getFloat2());
	}
	//Problem 12: EvensInArray
	private static void problem12() {
		int[] nums = new int[100];
		for (int i = 0; i < 100; i++) {
			nums[i] = i+1;
		}
		Evens.print(Evens.evens(nums));
	}
	//Problem 13: Triangle
	private static void problem13() {
		int size = 4;
		Triangle.print(Triangle.triangle(size), size);
	}
	//Problem 14: Switch
	private static void problem14() {
		System.out.println("Switch: ");
		for (int i = 0; i < 3; i++)
			Switch.switchProblem(i);
	}
	//Problem 15: Calculate Interface
	private static void problem15() {
		System.out.println("Calculate: ");
		Calculation cal = new Calculation();
		System.out.println("Add: 3 + 5 = " + cal.add(3, 5));
		System.out.println("Sub: 8 - 3 = " + cal.subtract(8, 3));
		System.out.println("Mult: 4 * 5 = " + cal.multiply(4, 5));
		System.out.println("Div: 20 / 2 = " + cal.divide(20, 2));
	}
	//Problem 16: String length from command line
	private static void problem16(String[] args) {
		System.out.println("Argument length: " + Arguments.arguments(args));
	}
	//Problem 17: Interest
	private static void problem17() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Principle: ");
		double principle = Double.parseDouble(sc.nextLine());
		System.out.print("Rate in decimal: ");
		double rate = Double.parseDouble(sc.nextLine());
		System.out.print("Number of years: ");
		double time = Double.parseDouble(sc.nextLine());
		
		System.out.println("Interest: " + Interest.interest(principle, rate, time));
	}
	//Problem 18: Abstract
	private static void problem18() {
		NotAbstractClass nc = new NotAbstractClass();
		String str = "dude where's my upperCASE";
		
		if (nc.checkForUppercase(str)) {
			System.out.println("'" + str + "' has uppercase");
		} else {
			System.out.println("'" + str + "' doesn't have uppercase");
		}
		
		System.out.println("'" + str + "' becomes " + nc.convertToUppercase(str));
		
		System.out.println("67 becomes " + nc.convertStringToInt("67"));
	}
	//Problem 19: Stuff With ArrayList
	private static void problem19() {
		ArrayList<Integer> ints = new ArrayList<Integer>();
		
		for (int i = 0; i < 10; i++) {
			ints.add(i+1);
		}
		
		ArrayListStuff.arrayListStuff(ints);
	}
	//Problem 20: FileIO
	private static void problem20() {
		FileIO.fileIO();	
	}
	

	public static void main(String[] args) {	
		for (int i = 1; i < 21; i++) {
			print(i);
			
			switch(i) {
				case 1:
					problem1();
					break;
				case 2:
					problem2();
					break;
				case 3:
					problem3();
					break;
				case 4:
					problem4();
					break;
				case 5:
					problem5();
					break;
				case 6:
					problem6();
					break;
				case 7:
					problem7();
					break;
				case 8:
					problem8();
					break;
				case 9:
					problem9();
					break;
				case 10:
					problem10();
					break;
				case 11:
					problem11();
					break;
				case 12:
					problem12();
					break;
				case 13:
					problem13();
					break;
				case 14:
					problem14();
					break;
				case 15:
					problem15();
					break;
				case 16:
					problem16(args);
					break;
				case 17: 
					problem17();
					break;
				case 18: 
					problem18();
					break;
				case 19: 
					problem19();
					break;
				case 20: 
					problem20();
					break;
			}
			
			System.out.println();
		}
	}
	
	private static void print(int i) {
		System.out.println("Problem " + i + ": ");
	}
}
