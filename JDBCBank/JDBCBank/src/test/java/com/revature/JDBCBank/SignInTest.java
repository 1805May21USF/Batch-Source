package com.revature.JDBCBank;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Scanner;

import org.junit.Test;
import org.junit.gen5.api.DisplayName;

import com.revature.exceptions.IncorrectPasswordException;

/**
 * Unit test for simple App.
 */
public class SignInTest 
{
	SignIn si = new SignIn(new Scanner(System.in));
	
	@Test
	@DisplayName("Customer Login Test")
    public void customerLoginTest()
    {
        try {
			assertTrue(si.customerLogin("this", "was"));
		} catch (IncorrectPasswordException e) {
			System.out.println("Wrong password!");
		}
    }

    @Test
    @DisplayName("Employee Login Test")
    public void employeeLoginTest()
    {
    	try {
			assertTrue(si.employeeLogin("this", "was"));
		} catch (IncorrectPasswordException e) {
			System.out.println("Wrong password!");
		}
    }
    
    @Test
    @DisplayName("Customer Retrieval Test")
    public void customerRetrievalTest() {
    	assertNotNull(si.getCustomer("this"));
    }
    
    @Test
    @DisplayName("Employee Retrieval Test")
    public void employeeRetrievalTest() {
    	assertNotNull(si.getEmployee("this"));
    }
}
