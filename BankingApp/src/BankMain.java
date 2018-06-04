import java.io.File;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class BankMain  implements Serializable, AccountManager {
	
	@SuppressWarnings("resource")
	public static void main(String[] args)  throws IOException{
		Customer c = new Customer();
		Random rand = new Random();
		Account a = new Account();
		Scanner input = new Scanner(System.in);
		String name= "";
		String password = "";
		double initialAmount;
		
		
		System.out.println("  Cloud Bank   ");
		System.out.println("Press 1 to Register");
		System.out.println( "Press 2 to Login");
		System.out.println("Press 0 to quit ");
		boolean quit = false;
		int menuItem;
		
		do 
		{
			
		
		menuItem = input.nextInt();
		switch(menuItem) {
		case 1 :
			System.out.println("Please enter your desired username ");
			name = input.next();
			c.setUserName(name);
			System.out.println("Please enter your desired password");
			password = input.next();
			c.setPassword(password);
			System.out.println("What is your initial amount ?");
			initialAmount = input.nextDouble();
			a.setBalance(initialAmount);
			int  n = rand.nextInt(50) + 1;
			System.out.println("your account number is " + n);
			c.setAccountID(n);
			ArrayList<Customer> arr = new ArrayList<Customer>();
			boolean isThere = true;
			if (!isThere) {
				arr.add(c);
				}
			break;
		case 2 : 
			System.out.println("Login");
		File outFile = new File("src/UsernamesAndPasswords.txt");
		FileWriter fWriter = new FileWriter (outFile, true);
		PrintWriter pWriter = new PrintWriter(fWriter);
		System.out.println("Please Enter your Username ");
		name = input.next();
		c.setUserName(name);
		System.out.println("Please Enter your Password ");
		password = input.next();
		c.setPassword(password);
		break;
		case 0:
			quit = true;
			break;
		default: System.out.println(" Invalid choice");
		}
		}
		while(!quit);
		{
			
		System.out.println("Bye");
	}
		}

	@Override
	public void deposit(double d) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void withdraw(double w) {
		// TODO Auto-generated method stub
		
	}
	}


