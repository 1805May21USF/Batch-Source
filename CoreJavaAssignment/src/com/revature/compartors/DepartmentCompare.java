package com.revature.compartors;

import java.util.Comparator;

import com.revature.problem.Employee;

public class DepartmentCompare implements Comparator<Employee>
{
    public int compare(Employee p1, Employee p2)
    {
        return p1.getDepartment().compareTo(p2.getDepartment());
    }
}

