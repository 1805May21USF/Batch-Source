package com.revature.corejavaassignment;

import java.util.Scanner;

/**
 * Demonstrates each class outlined in the
 * Core Java Assignment document.
 * @author Nathaniel Simpson
 *
 */
public class AssignmentDemo {

	public static Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		Q1BubbleSort.bubbleSortDemo();
		Q2Fibonacci.fibonacciDemo(25);
		Q3ReverseString.reverseStringDemo("Hello, World! Roll Tide!");
		Q4NFactorial.nFactorialDemo(10);
		
		//Multiple calls for Q5. Substring
		System.out.println("Q5. Substring");
		Q5Substring.substringDemo("Roll Tide!", 3);
		Q5Substring.substringDemo("Roll Tide!", 5);
		Q5Substring.substringDemo("Roll Tide!", 7);
		Q5Substring.substringDemo("Roll Tide!", 700);
		System.out.println(); //Making room for Q6
		
		//Multiple calls for Q6. IsEven
		System.out.println("Q6: IsEven");
		Q6IsEven.isEvenDemo(5);
		Q6IsEven.isEvenDemo(6);
		Q6IsEven.isEvenDemo(99);
		Q6IsEven.isEvenDemo(100);
		System.out.println();
		
		Q7Comparator.comparatorDemo();
		Q8Palindromes.palindromeDemo();
		Q9PrimeNumbers.primeNumberDemo();
		
		//Multiple calls for Q10. TernaryOperator
		System.out.println("Q10. Ternary Operator");
		Q10TernaryOperator.ternaryOperatorDemo(1, 2);
		Q10TernaryOperator.ternaryOperatorDemo(5, 5);
		Q10TernaryOperator.ternaryOperatorDemo(15, 9);
		System.out.println(); //Making room for Q11
		
		Q11PackageGetter.packageAccessDemo();
		Q12EnhancedForLoop.enhancedForLoopDemo();
		Q13Triangle.triangleDemo(4); //Argument dictates the number of lines
		Q14Switch.switchDemo();
		Q15TestClass.main(args); //Q15 says to call from a main method
		Q16NumChars.numCharsDemo(args); //args must be set in run configurations
		Q17InterestCalculator.interestCalculatorDemo();
		Q18ConcreteClass.main(args);
		Q19IntegerArrayList.integerArrayListDemo(1, 10);
		Q20FileReader.fileReaderDemo();
		
	}

}
