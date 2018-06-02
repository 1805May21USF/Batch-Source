package com.revature.JDBCBank;

import java.sql.SQLException;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.beans.SuperUser;

/*import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;*/

import com.revature.beans.User;
import com.revature.exceptions.NullUserException;
import com.revature.util.AppUtil;

public class App 
{
	public static final Scanner sc = new Scanner(System.in);
	public static final Logger log = LogManager.getLogger(App.class);
    public static void main( String[] args )
    {
    	System.out.println( "Hello Bank Partner!" );
        while(true){
        	try {
	        	System.out.print("What would you like to do? \n 1)Login\n 2)Register\n 3)Exit App\n");	        	
	        	String choice = sc.nextLine();
		        switch(Integer.parseInt(choice)) {
			        case 1://Login
			        	String[] cred = AppUtil.getCredentials();
			        	if(AppUtil.checkSuperUser(cred[0], cred[1])) {
			        		SuperUser admin = new SuperUser(cred[0],cred[1]);
			        		admin.receiveSuperUserActions();
			        	}
			        	else {
			        		User usr = AppUtil.login(cred);
							System.out.println("\nWelcome "+usr.getFirstname()+".");
				        	usr.promptUser();
			        	}
						break;
			        case 2://Register
			        	AppUtil.register();
			        	break;
			        case 3://Exit
			        	sc.close();
			        	System.exit(1);
			        	break;
		        	default:
		        		System.out.println("Error: Please choose one of the options!");
		        		break;
		        }
        	}catch(SQLException | NullUserException e) {
        		System.out.println("Please pick a valid input.");
		    }catch(Exception e) {
		    	e.printStackTrace();
		    }
        }
    } 
}
