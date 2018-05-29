package com.revature.assignment0.questions;

import java.util.*;

import com.revature.assignment0.objects.QuestionSevenEmployees;
import com.revature.assignment0.sorting.Question_Seven_SortByAge;
import com.revature.assignment0.sorting.Question_Seven_SortByDepartment;
import com.revature.assignment0.sorting.Question_Seven_SortByName;

public class QuestionSeven {

		public static void Question_Seven(List<QuestionSevenEmployees> b) {
			
			System.out.println("\r------Question Seven-------");
			System.out.println("7.)Sort two employees based on their name, department, and age using the Comparator interface.\r");
			
			System.out.println("---------------");
			System.out.println("Unsorted");
			System.out.println("---------------");
			
			//Prints out the unsorted name, department, and age 
			for(int i = 0; i < b.size(); i++) {
				System.out.println(b.get(i));
			}
			
			System.out.println("---------------");
			System.out.println("Sorted By Name");
			System.out.println("---------------");
			
			//Uses the compare method to sort the employees by their name
			Collections.sort(b, new Question_Seven_SortByName());
			
			for(int i = 0; i < b.size(); i++) {
				System.out.println(b.get(i));
			}
			System.out.println("---------------------");
			System.out.println("Sorted By Department");
			System.out.println("---------------------");
			
			//Uses the compare method to sort the employees by their department
			Collections.sort(b, new Question_Seven_SortByDepartment());
			
			for(int i = 0; i < b.size(); i++) {
				System.out.println(b.get(i));
			}
			
			System.out.println("-------------");
			System.out.println("Sorted By Age");
			System.out.println("-------------");
			
			//Uses the compare method to sort the employees by their age
			Collections.sort(b, new Question_Seven_SortByAge());
			
			for(int i = 0; i < b.size(); i++) {
				System.out.println(b.get(i));
			}
		}
}
