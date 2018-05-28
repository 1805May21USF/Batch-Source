package com.revature.homeworks;

import java.io.FileNotFoundException;

public class Homework1Main {

	public static void main(String[] args) throws FileNotFoundException {
		
		String newLine = System.getProperty("line.separator");//This will retrieve line separator dependent on OS.
		
		System.out.println("	                          HOMEWORK ONE (read instructions.txt in the src folder before proceeding) " + newLine + "    =====================================================================================================================");
		
		//-1-------Bubble Sort-----------
		BubbleSort b = new BubbleSort();
		b.run();
		
		//-2-------Fibonacci-----------
		Fibonacci f = new Fibonacci();
		f.run();
		
		//-3-------Reverse-----------
		Reverse R = new Reverse();
		R.run();
		
		//-4-------Factorial-----------
		Factorial fa = new Factorial();
		fa.run();
		
		//-5-------Substring-----------
		Substring s = new Substring();
		s.run();
		
		//-6-------Even?-----------
		Even e = new Even();
		e.run();
		
		//-7-------Comparator-----------
		Employee em = new Employee();
		em.run();
		
		//-8-------Palindrome-----------
		Palindrome p = new Palindrome();
		p.run();
		
		//-9-------Prime-----------
		Prime pr = new Prime();
		pr.run();
		
		//-10-------Minimum-----------
		Minimum mini = new Minimum();
		mini.run();
		
		//-11-------FloatVars-----------
		FloatVars fl = new FloatVars();
		fl.run();
		
		//-12-------EnhancedForEven-----------
		EnhancedForEven efe = new EnhancedForEven();
		efe.run();
		
		//-13-------Triangle-----------
		Triangle tri = new Triangle();
		tri.run();
		
		//-14-------Switch-----------
		Switch switching = new Switch();
		switching.run();
		
		//-15-------Interface-----------
		Interfaces inte = new Interfaces();
		inte.run();
		inte.add(24,17);
		inte.subtract(24,17);
		inte.multiply(24,17);
		inte.divide(24,17);
		
		//-16-------StringInput-----------
		StringInput string= new StringInput();
		string.run(args[0]);
		
		//-17-------Simple Interest-----------
		SimpleInterest sI= new SimpleInterest();
		sI.run();
		
		//-18-------Concrete-----------
		Stringy string1= new Stringy();
		string1.run();
		
		//-19-------EvenOddPrime-----------
		EvenOddPrime eop = new EvenOddPrime();
		eop.run();
		
		//-20-------NotePadFile-----------
		DataText dt = new DataText();
		dt.run();

		
	}

}
