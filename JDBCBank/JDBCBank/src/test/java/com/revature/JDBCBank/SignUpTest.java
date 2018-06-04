package com.revature.JDBCBank;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Scanner;

import org.junit.Test;
import org.junit.gen5.api.DisplayName;

import com.revature.beans.Customer;
import com.revature.beans.Employee;
import com.revature.exceptions.InvalidInputException;
import com.revature.exceptions.UserExistsException;

/**
 * Unit test for simple App.
 */
public class SignUpTest 
{
	SignUp su = new SignUp(new Scanner(System.in));
	
	@Test
	@DisplayName("Create New Customer")
    public void createCustomerTest()
    {
        assertNotNull(su.createCustomer(new Customer(0, "this", "was", "triumph", 'a', "Im", 22, "making a note", "huge success", 12345, "AS")));
    }
	
	@Test
	@DisplayName("Customer Exists Test")
	public void customerExistsTest() {
		try {
			assertTrue(su.customerExists("this"));
		} catch (UserExistsException e) {
			System.out.println("User doesn't exist!");
		}
	}

    @Test
    @DisplayName("Create New Employee")
    public void createEmployeeTest()
    {
    	assertNotNull(su.createEmployee(new Employee(0, "this", "was", "triumph", 'a', "Im", 22, "making a note", "huge success", 12345, "AS", "science", 23.43)));
    }
    
    @Test
	@DisplayName("Employee Exists Test")
	public void employeeExistsTest() {
		try {
			assertTrue(su.employeeExists("this"));
		} catch (UserExistsException e) {
			System.out.println("User doesn't exist!");
		}
	}
    
    @Test
    @DisplayName("Validate Alphanumeric Input Test")
    public void alphanumericInputTest() {
    	try {
			assertTrue(su.validAlphaNumericInput("hello"));
			assertTrue(su.validAlphaNumericInput("83770"));
			assertTrue(su.validAlphaNumericInput("he77o"));
			assertTrue(su.validAlphaNumericInput("HELLO"));
			assertTrue(su.validAlphaNumericInput("HE77O"));
			assertFalse(su.validAlphaNumericInput("hello>"));
			assertFalse(su.validAlphaNumericInput("83770!"));
			assertFalse(su.validAlphaNumericInput("he770."));
			assertFalse(su.validAlphaNumericInput("HELLO^"));
			assertFalse(su.validAlphaNumericInput("HE770&"));
		} catch (InvalidInputException e) {
			System.out.println("Not valid input!");
		}
    }
    
    @Test
    @DisplayName("Validate Alphabetic Input Test")
    public void alphabeticInputTest() {
    	try {
			assertTrue(su.validAlphabeticInput("hello"));
			assertTrue(su.validAlphabeticInput("heLLo"));
			assertTrue(su.validAlphabeticInput("HeLlO"));
			assertTrue(su.validAlphabeticInput("HELLO"));
			assertTrue(su.validAlphabeticInput("HellO"));
			assertFalse(su.validAlphabeticInput("hell0)"));
			assertFalse(su.validAlphabeticInput("83770"));
			assertFalse(su.validAlphabeticInput("he770."));
			assertFalse(su.validAlphabeticInput("HELLO^"));
			assertFalse(su.validAlphabeticInput("HE770&"));
		} catch (InvalidInputException e) {
			System.out.println("Not valid input!");
		}
    }
    
    @Test
    @DisplayName("Validate Numeric Input Test")
    public void numericInputTest() {
    	try {
			assertTrue(su.validNumericInput("12345"));
			assertTrue(su.validNumericInput("54321"));
			assertTrue(su.validNumericInput("24680"));
			assertTrue(su.validNumericInput("13579"));
			assertTrue(su.validNumericInput("83770"));
			assertFalse(su.validNumericInput("hello)"));
			assertFalse(su.validNumericInput("83770!"));
			assertFalse(su.validNumericInput("he770."));
			assertFalse(su.validNumericInput("HELLO^"));
			assertFalse(su.validNumericInput("HE770&"));
		} catch (InvalidInputException e) {
			System.out.println("Not valid input!");
		}
    }
}
