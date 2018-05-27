package com.revature.P0Banking;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws FileNotFoundException, ClassNotFoundException, IOException
    {
    	Scanner options = new Scanner(System.in);
    	
    	//Create a user object
    	User user = new User();
    	System.out.println( "Hello Bank Partner!" );
        while(true){
        	System.out.print("What would you like to do? \n 1)Login\n 2)Register\n 3)Exit\n");
            int choice = options.nextInt();
            options.nextLine();
	        switch(choice) {
	        case 1://Login
	        	user.loginAcct("Customer");
	        	break;
	        case 2://Register
	        	user.registerAcct("Customer");
	        	break;
	        case 3://Exit
	        	options.close();
	        	System.exit(1);
	        	break;
	        default:
	        	System.out.println("Error: Please choose one of the options!");
	        	break;
	        }
        }
    }
}
