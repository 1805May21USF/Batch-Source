import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



class MenusTest {
	
	private static Scanner in = new Scanner(System.in);
	private boolean validEntry = false;
	private int entry;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void mainMenu() {
		
		do {
		try {
		System.out.println("------Welcome, select an option below to begin-----");
		System.out.println("---------(1)Login----------");
		System.out.println("---------(2)Signup---------");
		System.out.println("---------(3)Exit-----------");
		entry = Integer.parseInt(in.next());
		
		//Test String and assert that the returned value is not a string
		String testString = "";
		Integer obj = new Integer(entry);
		assertNotSame(testString, obj);
		
		
		
		//begin Switch statement
		switch(entry) {
		case 1:{
			//open login Screen
			assertEquals(entry,1);
			validEntry = true;
			break;
		}
		case 2:{
			//open the Sign up screen
			assertEquals(entry,2);
			validEntry = true;
			
			break;
		}
		case 3:{
			//exit the app
			assertEquals(entry,3);
			System.out.println("Thank you for your loyal service");
			System.out.println("Goodbye!!!");
			System.exit(0);
			}
		default:{
			System.out.println("invalid option\n");
		}
		}//end switch
		
		}catch(Exception e) {
			System.out.println("invalid  option");
		}
		}while(validEntry != true);
		
	}
	
	
	
	//Login Screen
	public void loginScreen() {
		
		System.out.println("---------Please login below---------");
		System.out.println("Enter your UserName");
		String userName = in.next();
		System.out.println("Enter your Password");
		String password = in.next();
		
		//check username and password are in the database
		
		
	}

}
