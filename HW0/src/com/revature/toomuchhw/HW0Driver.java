package com.revature.toomuchhw;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import java.io.*;

import com.revature.toomuchhw.Problem7.Employee;

public class HW0Driver {

	public static void main(String[] args) throws IOException{

		//Problem 1 - Bubble Sort
		System.out.println("Problem 1: ");
		int[] p1 = new Problem1().performBubbleSort(new int[] {1,0,5,6,3,2,3,7,9,8,4});
		for(int i:p1) {System.out.print(i+" ");};
		
		//Problem 2 - FibMe
		System.out.println("\n\nProblem 2: ");
		int[] p2 = new Problem2().fibMe();
		for(int i:p2) {System.out.print(i+" ");};
		
		//Problem 3 - Reversies
		System.out.println("\n\nProblem 3: ");
		System.out.println("elppA to "+new Problem3().reverseMe("elppA"));
		
		//Problem 4 - Factorials
		System.out.println("\nProblem 4: ");
		System.out.println(new Problem4().factMe(5));
		
		//Problem 5 - Substring
		System.out.println("\nProblem 5: ");
		System.out.println(new Problem5().grabStuff("Tide Roll", 6));
		
		//Problem 6 - Is Even
		System.out.println("\nProblem 6: ");
		System.out.println("Is 3 even? "+new Problem6().isEven(3));
		
		//Problem 7 - Compare Employees
		System.out.println("\nProblem 7: ");
		ArrayList<Employee> names = new Problem7().compareNames();
		ArrayList<Employee> departments = new Problem7().compareDepartment();
		ArrayList<Employee> ages = new Problem7().compareAge();
		for(int i = 0; i < names.size(); i++) {System.out.print(names.get(i).getName()+" ");}
		System.out.println();
		for(int i = 0; i < names.size(); i++) {System.out.print(departments.get(i).getDepartment()+" ");}
		System.out.println();
		for(int i = 0; i < names.size(); i++) {System.out.print(ages.get(i).getAge()+" ");}
		
		//Problem 8 - Palindromes
		System.out.println("\n\nProblem 8: ");
		ArrayList<String> words = new ArrayList<String>(
				Arrays.asList("karan", "madam", "tom", "civic", "radar", "jimmy", "kayak", "john",  "refer", "billy", "did"));
		System.out.println(new Problem8().findAllPalindromes(words));
		
		//Problem 9 - Primes
		System.out.println("\nProblem 9: ");
		new Problem9().printPrime();
		
		//Problem 10 - Min
		System.out.println("\n\nProblem 10: ");
		int theMin = new Problem10(3,8).findMin();
		System.out.println("Out of [3,8] the min is "+theMin);
		
		//Problem 11 - Accessing Floats
		System.out.println("\nProblem 11: ");
		new Problem11().getFloats();
		
		//Problem 12 - Print Evens
		System.out.println("\nProblem 12: ");
		new Problem12().printEven();
		System.out.println();
		
		//Problem 13 - Print Triangle
		System.out.println("\nProblem 13: ");
		Problem13 tri = new Problem13(4);
		tri.printTriangle();
		
		//Problem 14 - Switch Cases
		System.out.println("\nProblem 14: ");
		new Problem14().switchCases(1);
		new Problem14().switchCases(2);
		new Problem14().switchCases(3);
		
		//Problem 15 - Calculator
		System.out.println("\nProblem 15: ");
		int x = 10;
		int y = 3;
		System.out.print(new Problem15(x,y).addition()+" ");
		System.out.print(new Problem15(x,y).subtraction()+" ");
		System.out.print(new Problem15(x,y).multiplication()+" ");
		System.out.print(new Problem15(x,y).division()+" ");
		
		//Problem 16 - Var Args in Command Line
		System.out.println("\n\nProblem 16: ");
		System.out.println(args[0]+" is length "+new Problem16(args[0]).findLength());
		
		//Problem 17 - Simple Interest
		System.out.println("\nProblem 17: ");
		Scanner input = new Scanner(System.in);
		System.out.print("Input Principal: ");
		int principal = input.nextInt();
		System.out.print("Input Rate in Decimals: ");
		double percent_rate = input.nextDouble();
		System.out.print("Input Year: ");
		int year = input.nextInt();
		Problem17 interest = new Problem17(principal,percent_rate,year);
		System.out.println("Simple interest is: "+interest.calcInterest());
		
		//Problem 18 - Wrappers and Abstract Classes/Methods
		System.out.println("\nProblem 18: ");
		String s = "10";
		Problem18 a = new Problem18();
		System.out.print(a.uppercases(s)+" ");
		System.out.print(a.convertLowercase(s)+" ");
		System.out.print(a.convertToInteger(s)+" ");
		
		//Problem 19 - Print stuff out
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for(int i = 1; i<11; i++) {
			arr.add(i);
		}
		System.out.println("\n\nProblem 19: ");
		new Problem19(arr).displayStuff();
		
		//Problem 20 - FILEIO
		System.out.println("\nProblem 20: ");
		String file = "C:\\Users\\Nicholas\\Documents\\Revature\\may21batch\\Batch-Source\\HW0\\src\\com\\revature\\toomuchhw\\Data.txt";
		new Problem20(file).readFile();
		
	}
}
