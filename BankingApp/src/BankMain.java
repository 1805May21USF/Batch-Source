import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class BankMain extends Account implements Serializable {
	
	@SuppressWarnings("resource")
	public static void main(String[] args)  throws IOException{
		Customer c = new Customer();
		Scanner input = new Scanner(System.in);
		String name = null;
		String password = null;
		for( int i = 1;i<=3;i++)
		System.out.println(i +".Menu item #"+i);
		System.out.println("0.Quit");
		boolean quit = false;
		int menuItem;
		
		do 
		{
			
		System.out.println("Choose menu item:  ");
		menuItem = input.nextInt();
		switch(menuItem) {
		case 1 :
			System.out.println("Are you a new customer? ");
			c.ArrCustomer();
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
		
		}while(!quit);
	
		System.out.println("Bye");
	}
}
