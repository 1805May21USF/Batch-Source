package com.revature.compartors;

import java.util.Comparator;

import com.revature.problem.Employee;

public class AgeCompare implements Comparator<Employee>
{
    public int compare(Employee p1, Employee p2)
    {
    	if (p1.getAge() < p2.getAge()) return -1;
        if (p1.getAge() > p2.getAge()) return 1;
        else return 0;
    }
}
