package project1;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TestCustomer {

	public TestCustomer() {
		// TODO Auto-generated constructor stub
	}
	
	@Test
	public void testGetFirstName() {
		Customer c = new Customer("Jay Jay","Okocha","JL56y","J5");
		String firstName = c.getFirstName();
		assertEquals("Jay Jay", firstName);
	}
	
	@Test
	public void testGetLastName() {
		Customer c = new Customer("Jay Jay","Okocha","JL56y","J5");
		String lastName = c.getLastName();
		assertEquals("Okocha", lastName);
	}
	
	@Test
	public void testGetUserName() {
		Customer c = new Customer("Jay Jay","Okocha","JL56y","J5");
		String userName = c.getUserName();
		assertEquals("JL56y", userName);
	}
	
	@Test
	public void testGetPassword() {
		Customer c = new Customer("Jay Jay","Okocha","JL56y","J5");
		String password = c.getPassword();
		assertEquals("J5", password);
	}
	
	@Test
	public void testToString() {
		Customer c = new Customer("Jay Jay","Okocha","JL56y","J5", "765234", 50);
		String str = "\nFirstName: " + c.getFirstName() +
					 "\nLastName: " + c.getLastName() +
					 "\nUsername: " + c.getUserName() +
					 "\nPassword: " + c.getPassword() +
					 "\nAccount Number: " + c.getAccountNumber() +
					 "\nAccount Balance: " + c.getAccountBalance();
		assertEquals(str, c.toString());
	}
	
	
}
