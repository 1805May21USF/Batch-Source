package com.revature.compartors;

import java.util.Comparator;

import com.revature.problem.Employee;

public class NameCompare implements Comparator<Employee>
{
    public int compare(Employee p1, Employee p2)
    {
        return p1.getName().compareTo(p2.getName());
    }
}

