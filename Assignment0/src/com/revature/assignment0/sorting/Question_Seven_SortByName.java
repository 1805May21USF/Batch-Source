package com.revature.assignment0.sorting;

import java.util.Comparator;

import com.revature.assignment0.objects.QuestionSevenEmployees;

public class Question_Seven_SortByName implements Comparator<QuestionSevenEmployees> {
	
	    public int compare(QuestionSevenEmployees a, QuestionSevenEmployees b)
	    {
			 /* 
			  * Compareas the wprds and orders the smaller one first
			  */
	        return a.getName().compareTo(b.getName());
	    }
}
