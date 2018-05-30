package com.revature.people;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import com.revature.accounts.Account;

public class Application extends Person{

	private String claim_number;
	private String status;
	private String account_type;
	
	public Application(String first_name, String last_name, String address, String phone, String username, String password, String account_type, String SSN) {
		super(first_name, last_name, address, phone, username, password, SSN);
		this.account_type = account_type;

	}

	public String create_application () throws IOException {
		try {
			Integer temp_claim = ThreadLocalRandom.current().nextInt(0, 10000000 + 1);
			this.setClaim_number(temp_claim.toString());
			this.setStatus("Pending");
			
			switch(this.getAccount_type()){
				case "1":
					this.setAccount_type("Checking");
					break;
				case "2":
					this.setAccount_type("Savings");
					break;
				case "3":
					this.setAccount_type("Joint");
					break;
			}
			
			List<String> lines = Arrays.asList( this.getFirst_name(), this.getLast_name(), this.getAddress(), this.getPhone(), this.getUsername(), this.getPassword(), this.getSSN(), this.getAccount_type(), this.getStatus(), this.getClaim_number());

			File newfile = new File("C:\\Users\\JonWi\\Documents\\Revature\\Repository\\Batch-Source\\Banking_Application_Main\\src\\main\\applications\\" + this.getUsername() + ".txt");

			boolean created_file = newfile.createNewFile();
			
		     if (created_file){
		    	Path file = Paths.get("C:\\Users\\JonWi\\Documents\\Revature\\Repository\\Batch-Source\\Banking_Application_Main\\src\\main\\applications\\" + this.getUsername() + ".txt");
				Files.write(file, lines, Charset.forName("UTF-8"));
				return "File created!. Here is your claim number that can be used to track the application. Claim #: " + this.getClaim_number();
		     }
		     else{
		    	 
		    	 try {
		    	 	String claim_number = "";
					
					//Accessing the file
					Scanner  output = new Scanner (new File("C:\\Users\\JonWi\\Documents\\Revature\\Repository\\Batch-Source\\Banking_Application_Main\\src\\main\\applications\\" + this.getUsername() + ".txt"));
					
					//While there is a next line
					while (output.hasNext())
					{
						claim_number = output.nextLine();
						
					}
						output.close();
						return "You already have an application pending. Contact them with the claim # " + claim_number;  
				} catch (FileNotFoundException e) {
					return "Oops, looks like we could not access your file! Please contact our bank during normal business hours to talk to someone";
				}
		     }
		} catch (IOException e) {
			System.out.println(e.getMessage());
			return  "Oops, looks like we could not create your file! Please contact our bank during normal business hours to talk to someone";
		}
	}
	
	protected String getAccount_type() {
		return account_type;
	}

	protected void setAccount_type(String account_type) {
		this.account_type = account_type;
	}

	protected String getStatus() {
		return status;
	}

	protected void setStatus(String status) {
		this.status = status;
	}
	
	protected String getClaim_number() {
		return claim_number;
	}

	protected void setClaim_number(String claim_number) {
		this.claim_number = claim_number;
	}

}