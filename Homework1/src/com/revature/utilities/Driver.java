package com.revature.utilities;
import java.util.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Stream;

public class Driver extends Question13{

	public static void main(String[] args) throws IOException {
		Question1 b = new Question1();
		Question3 a = new Question3();
	
		int[] array = {1,0,5,6,3,2,3,7,9,8,4};
	
		System.out.println(Arrays.toString(b.bubble_srt(array)));
		
		System.out.println(Question2.Question2());
		
		System.out.println(Question3.Q3());
		
		System.out.println(Question4.Q4());
		System.out.println(Question5.Q5());
		System.out.println(Question6.Q6());
		  Question8 q8 = new Question8();
		      ArrayList<String> names =  new ArrayList<>();
		        names.add("Edwin"); names.add("Curwin"); names.add("Juan");
		        names.add("Jose"); names.add("Joe");
		        names.add("Ramon");   names.add("Michael");
		        names.add("Success"); names.add("Carlos");
		        names.add("DOO"); names.add("Ben");
		        ArrayList<String> pal = q8.palindrome(names);
		        System.out.println(pal);
		        ArrayList al=new ArrayList();
		        
		        al.add(new Employee("Edwin ",25, " Muma"));
		        al.add(new Employee("Jose  ",24, " Library"));
		        
		        System.out.println("Sorting by Name :");
		        
		        Collections.sort(al,new EmployeeComparator());
		        Iterator itr=al.iterator();
		          while(itr.hasNext()) {
		        	Employee em =(Employee)itr.next();
		        	System.out.println(em.name +" "+em.age + " "+em.department);
		        	}
		        
		          
		          
		          System.out.println("Sorting by age: ");
		        
		        Collections.sort(al, new AgeComparator());
		       Iterator itr2=al.iterator();
		       while(itr2.hasNext()) {
		    	   Employee em =(Employee)itr2.next();
		        	System.out.println(em.name +""+ em.age + "" +em.department);
		        }
		        System.out.println("Sorting by department :");
		        
		        Collections.sort(al,new EmployeeComparator());
		        Iterator itr3=al.iterator();
		          while(itr3.hasNext()) {
		        	Employee em =(Employee)itr3.next();
		        	System.out.println(em.name+""+ em.age+""+ em.department);
		        	}
		        
		        
		        
		 System.out.println(Question9.Q9());
		
		 System.out.println(Question10.Q10());
		System.out.println(Question11.Q11());
		System.out.println(Question12.Q12());
		Question13.Q13();
		Question14.Q14();
		Question15 q15 = new Question15();
		System.out.println(q15.Addition(5,3));
		System.out.println(q15.Substraction(7, 5));
		System.out.println(q15.Multiplication(8, 3));
		System.out.println(q15.Division(7, 2));
		String yoo = args[0];
		Question16 q16 = new Question16();
		int x = q16.Count(yoo);
		System.out.println(x);
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Principal");
		int e = sc.nextInt();
		System.out.println("Enter Rate Of Interest");
		int ee = sc.nextInt();
		System.out.println("Enter Time");
		int eee = sc.nextInt();
		Question17 q17 = new Question17();
		System.out.println(("The result " + q17.Interest(e,ee,eee)));
		Question18v2 q18 = new Question18v2();
		String d = "24";
		int u = 10;
		System.out.println(q18.Uppercase("lol"));
		System.out.println(q18.Lowercase("this is a test"));
		q18.Convert(d);
		Question19 q19 = new Question19();
		q19.Q19();
		Question20 r = new Question20();
		Question20.readfile();
		}
	}
	


