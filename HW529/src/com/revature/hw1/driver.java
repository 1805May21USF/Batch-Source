package com.revature.hw1;
import javax.swing.*;

public class driver {
	public static void main(String[] args) {
		boolean keepGoing = true;
		JFrame frame = new JFrame("InputDialog");
		
		//String proceed = JOptionPane.showInputDialog(frame, "Would you like to be able to change the default values of the inputs?(y/n)");
		//String name = JOptionPane.showInputDialog(frame, "Type in the number of the problem you would like to run");
		while(keepGoing) {
			String name = JOptionPane.showInputDialog(frame, "Type in the number of the "
					+ "problem you would like to run or type \"all\" to run them all haphazardly. "
					+ "\nPSA: if I stop asking you if you want to keep running problems, the console "
					+ "may be awaiting your input.");
			switch(name) {
			case "1":
				System.out.println("--- Problem 1 ---");
				P1BubbleSort.bubbleSort();
				break;
			case "2":
				System.out.println("--- Problem 2 ---");
				P2Fibonacci.fibonacci();
				break;
			case "3":
				System.out.println("--- Problem 3 ---");
				P3BackString.backwardzify("SODIDTHISWORK?");
				break;
			case "4":
				System.out.println("--- Problem 4 ---");
				P4NFactorial.factorial(10);
				break;
			case "5":
				System.out.println("--- Problem 5 ---");
				//String name = JOptionPane.showInputDialog(frame, );
				P5Substring.substring("TESTING", 4);
				break;
			case "6":
				System.out.println("--- Problem 6 ---");
				P6EvenOrNah.isItEven(8);
				break;
			case "7":
				System.out.println("--- Problem 7 ---");
				P7Comparing.myCompare();
				break;
			case "8":
				System.out.println("--- Problem 8 ---");
				P8Palindrome.palindromeChecker();
				break;
			case "9":
				System.out.println("--- Problem 9 ---");
				System.out.println(java.util.Arrays.toString(P9Primes.isItPrime().toArray()));
				break;
			case "10":
				System.out.println("--- Problem 10 ---");
				P10Ternary.ternaryMin(14, 9);
				break;
			case "11":
				System.out.println("--- Problem 11 ---");
				P11AltPackage.grabFloats();
				break;
			case "12":
				System.out.println("--- Problem 12 ---");
				P12EnhancedFor.foreachForReal();
				break;
			case "13":
				System.out.println("--- Problem 13 ---");
				P13PyramidSchemeHaha.pyramidify();
				break;
			case "14":
				System.out.println("--- Problem 14 ---");
				P14SwitchCase.switchin(3);
				break;
			case "15":
				System.out.println("--- Problem 15 ---");
				int a = 10;
				int b = 5;
				P15Calculator p = new P15Calculator();
				p.divide(a, b);
				break;
			case "16":
				System.out.println("--- Problem 16 ---");
				System.out.println(args[0].toCharArray().length);
				break;
			case "17":
				System.out.println("--- Problem 17 ---");
				P17Scanner.calcInterest();
				break;
			case "18":
				System.out.println("--- Problem 18 ---");
				P18Abstract hello = new P18Concrete();
				System.out.println(hello.uppercasePresence("Ahahaha"));
				System.out.println(hello.lowercaseConvert("AahAhA"));
				System.out.println(hello.ordPlusTen("23"));
				break;		
			case "19":
				System.out.println("--- Problem 19 ---");
				P19ArrayListBlah.hooplah();
				break;
			case "20":
				System.out.println("--- Problem 20 ---");
				P20Display.printOut();
				break;
			case "all":
				System.out.println("--- Problem 1 ---");
				P1BubbleSort.bubbleSort();
				
				System.out.println("--- Problem 2 ---");
				P2Fibonacci.fibonacci();
				
				System.out.println("--- Problem 3 ---");
				P3BackString.backwardzify("SODIDTHISWORK?");
				
				System.out.println("--- Problem 4 ---");
				P4NFactorial.factorial(10);
				
				System.out.println("--- Problem 5 ---");
				//String name = JOptionPane.showInputDialog(frame, );
				P5Substring.substring("TESTING", 4);
				
				System.out.println("--- Problem 6 ---");
				P6EvenOrNah.isItEven(8);
				
				System.out.println("--- Problem 7 ---");
				P7Comparing.myCompare();
				
				System.out.println("--- Problem 8 ---");
				P8Palindrome.palindromeChecker();
				
				System.out.println("--- Problem 9 ---");
				System.out.println(java.util.Arrays.toString(P9Primes.isItPrime().toArray()));
				
				System.out.println("--- Problem 10 ---");
				P10Ternary.ternaryMin(14, 9);
				
				System.out.println("--- Problem 11 ---");
				P11AltPackage.grabFloats();
				
				System.out.println("--- Problem 12 ---");
				P12EnhancedFor.foreachForReal();
				
				System.out.println("--- Problem 13 ---");
				P13PyramidSchemeHaha.pyramidify();
				
				System.out.println("--- Problem 14 ---");
				P14SwitchCase.switchin(3);
				
				System.out.println("--- Problem 15 ---");
				int a1 = 10;
				int b1 = 5;
				P15Calculator p1 = new P15Calculator();
				p1.add(a1, b1);
				
				System.out.println("--- Problem 16 ---");
				System.out.println(args[0].toCharArray().length);
				
				System.out.println("--- Problem 17 ---");		
				P17Scanner.calcInterest();
				
				System.out.println("--- Problem 18 ---");
				P18Abstract hey = new P18Concrete();
				System.out.println(hey.uppercasePresence("Ahahaha"));
				System.out.println(hey.lowercaseConvert("AahAhA"));
				System.out.println(hey.ordPlusTen("23"));
				
				System.out.println("--- Problem 19 ---");	
				P19ArrayListBlah.hooplah();
				
				System.out.println("--- Problem 20 ---");
				P20Display.printOut();
				break;
			default:
				JOptionPane.showMessageDialog(null, "It'd be nice if you actually put in the correct input -_-");
				break;
			}
			String done = JOptionPane.showInputDialog(frame, "Run another problem?(y/n)");
			if(done.equals("n")) {
				keepGoing = false;
			}
		}
		/*String s1 = "cabe";
		String s2 = "c";
		System.out.println(s1.compareTo(s2));*/
	}
}
