package com.revature.banking;

import java.util.Comparator;

class CompareN implements Comparator<Customer>
{
    public int compare(Customer a, Customer b)
    {
        return a.getId().compareTo(b.getId());
    }
}
