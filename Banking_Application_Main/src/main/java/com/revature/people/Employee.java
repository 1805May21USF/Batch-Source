package com.revature.people;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Employee extends Person{
	
	private String account_level;

	public Employee(String first_name, String last_name, String address, String phone, String username, String password, String SSN, String account_level) {
		super(first_name, last_name, address, phone, username, password, SSN);
		
		this.account_level = account_level;
	}
	
	public void logged_in() {
		Scanner input = new Scanner(System.in);
		boolean repeat = true;
		
		while (repeat == true) {
			System.out.println("What would you like to do " + this.getFirst_name() + " " + this.getLast_name() + "?\r");
			System.out.println("1) Look up an account\r2) Approve or Deny accounts\r3) View accounts\r");
			String answer = input.nextLine();
			switch (answer) {
			case "1":
				//Look up an account
			case "2":
				approve_and_deny_accounts();
			case "3":
				view_account("", "");
			}	
		}
	}
	
	protected String getAccount_level() {
		return account_level;
	}
	
	protected String create_account_customer(String[] customer_account) {

		List<String> lines = Arrays.asList( customer_account[0], customer_account[1], customer_account[2], customer_account[3], customer_account[4], customer_account[5], customer_account[6], customer_account[8], customer_account[9]);

		File newfile = new File("C:\\Users\\JonWi\\Documents\\Revature\\Repository\\Batch-Source\\Banking_Application_Main\\src\\main\\accounts\\customers\\" + customer_account[4] + ".txt");

		boolean created_file;
		try {
			created_file = newfile.createNewFile();
			if (created_file){
		    	Path file = Paths.get("C:\\Users\\JonWi\\Documents\\Revature\\Repository\\Batch-Source\\Banking_Application_Main\\src\\main\\accounts\\customers\\" + customer_account[4] + ".txt");
				try {
					Files.write(file, lines, Charset.forName("UTF-8"));
					return "You can now login to your account and start managing your funds!";
				} catch (IOException e) {
					return "An error occured, you will have to try creating the file again!";
			    	//Come back and make a try catch block
				}
			} else {
				return "An error occured, you will have to try creating the file again!";
			}	
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			return "An error occured, you will have to try creating the file again!";
		}
	}
	
	protected void approve_and_deny_accounts() {
		Scanner input = new Scanner(System.in);
        boolean repeat = true;
        
        while (repeat == true) {
        	File folder = new File("C:\\Users\\JonWi\\Documents\\Revature\\Repository\\Batch-Source\\Banking_Application_Main\\src\\main\\applications");
            
            String[] files = folder.list();
             
            System.out.println("Here are the usernames applications awaiting approval!");
        	
        	System.out.println("Which account do you want to look at? *Please type in the username*\r");
        	 int i = 1;
        	 
        	 for (String file : files) 
             {
             	 String trimmed_file = file.substring(0, file.lastIndexOf('.'));
                 System.out.println(i + ") " + trimmed_file);
                 i++;
             }
        	 String account_to_approve = input.nextLine();
             
             String[] account_info = view_account("application", account_to_approve);
             
             if (account_info != null) {
                 System.out.println("\rWould you like to approve this account? Yes/No");
                 String approve_deny = input.nextLine();
                 
                 if (approve_deny.toLowerCase().equals("yes")) {
                	 String info = create_account_customer(account_info);
                	 if(info.contains("login")) {
                		 boolean delete_file = delete_text(account_info);
                		 if (delete_file) {
                			 repeat = false;
                		 }
                	 } else {
                		 approve_and_deny_accounts();
                	 }
                 } else {
                	 approve_and_deny_accounts();
                 }
             } else {
            	 System.out.println("Sorry, we are having trouble pulling up the account. Please try again!\r");
             }
        }        
	}
	
	protected boolean delete_text(String[] account) {
		File file = new File("C:\\Users\\JonWi\\Documents\\Revature\\Repository\\Batch-Source\\Banking_Application_Main\\src\\main\\applications\\" + account[4] + ".txt");
	     if(file.delete())
	     {
	         System.out.println("File deleted successfully\r");
             return true;
	     } else {
	         System.out.println("Failed to delete the file");
	         return false;
	    }
	}
	
	protected <T> void search_for_account(T account) {
		
	}
	
	protected void file_display() {
		Scanner input = new Scanner(System.in);
		File folder = new File("C:\\Users\\JonWi\\Documents\\Revature\\Repository\\Batch-Source\\Banking_Application_Main\\src\\main\\accounts\\customers");
        
        String[] files = folder.list();
    	
    	System.out.println("Which account do you want to look at? *Please type in the username*\r");
    	 int i = 1;
    	 
    	 for (String file : files) 
         {
         	 String trimmed_file = file.substring(0, file.lastIndexOf('.'));
             System.out.println(i + ") " + trimmed_file);
             i++;
         }
	}
	
	protected String[] view_account_customer(String account, String temp_username) {
		boolean repeat = true;
		file_display();
		return null;
			
	}
	
	protected String[] view_account_employees(String account, String temp_username) {
		return null;
		
	}
	
	protected String[] view_account_applicant(String account, String temp_username) {
		try {
			
			String first_name = null, last_name = null, address = null, phone = null, username = null, password = null, ssn = null, account_type = null, claim_number = null, status = null;
			String[] account_literal = new String[10];		
			//Accessing the file
			Scanner output;
			
			output = new Scanner (new File("C:\\Users\\JonWi\\Documents\\Revature\\Repository\\Batch-Source\\Banking_Application_Main\\src\\main\\applications\\" + temp_username + ".txt"));
			
			//While there is a next line
			while (output.hasNext())
			{
				first_name = output.nextLine();
				last_name = output.nextLine();
				address = output.nextLine();
				phone = output.nextLine();
				username = output.nextLine();
				password = output.nextLine();
				account_type = output.nextLine();
				ssn = output.nextLine();
				status = output.nextLine();
				claim_number = output.nextLine();
				
				System.out.println("Name: " + first_name + " " + last_name + "\r" +
				"Address: " + address + "\r" +
				"Phone: " + phone + "\r" +
				"Username: " + username + "\r" +
				"Password: " + password + "\r" +
				"Account Type: " + account_type + "\r" +
				"SSN: " + ssn + "\r" +
				"Status: " + status + "\r" +
				"Claim Number: " + claim_number + "\r");
			}
				account_literal[0] = first_name;
				account_literal[1] = last_name;
				account_literal[2] = address;
				account_literal[3] = phone;
				account_literal[4] = username;
				account_literal[5] = password;
				account_literal[6] = account_type;
				account_literal[7] = ssn;
				
				output.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			return null;
		}
		return null;	
	}
	
	protected String[] view_account(String account, String temp_username) {
		Scanner input = new Scanner(System.in);
		if (account.contains("application")) {
			
			String[] account_literal = view_account_applicant(account, temp_username);
			return account_literal;
			
		} else {
			boolean repeat = true;
			
			while (repeat == true) {

				System.out.println("Which type of account do you want to look at?\r" +
				"1) Customers\r" +
				"2) Employees\r");
				
				String output = input.nextLine();
				
				switch (output) {
					case "1":
						String[] customers = view_account_customer(account, temp_username);
						break;
					case "2":
						String[] employees = view_account_employees(account, temp_username);
						break;
					default:
						System.out.println();
				}
				
			}
		}
		return null;
	}

}
