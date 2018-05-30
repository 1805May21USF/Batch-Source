package com.revature.banking;

import java.util.Comparator;

class CompareNE implements Comparator<Employee>
{
    // Used for sorting in ascending order of
    // roll name
    public int compare(Employee a, Employee b)
    {
        return a.getName().compareTo(b.getName());
    }
}