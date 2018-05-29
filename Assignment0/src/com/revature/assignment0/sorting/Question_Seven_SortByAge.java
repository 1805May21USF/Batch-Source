package com.revature.assignment0.sorting;

import java.util.Comparator;

import com.revature.assignment0.objects.QuestionSevenEmployees;

public class Question_Seven_SortByAge implements Comparator<QuestionSevenEmployees>{

	public int compare(QuestionSevenEmployees a, QuestionSevenEmployees b)
    {
		/*
		 * If a.age is larger then b.age then they swap making the smaller one before
		 */
		if (a.getAge() > b.getAge()) {
			return 1;
		} else if(a.getAge() == b.getAge()) {
			/*
			 * If it is even then you do not swap
			 */
			return 0;
		} else {
			/*
			 * If a.age is less then b.age then they swap making the smaller one before
			 */
			return -1;
		}
    }
}
