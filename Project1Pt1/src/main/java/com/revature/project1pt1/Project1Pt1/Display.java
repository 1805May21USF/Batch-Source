package com.revature.project1pt1.Project1Pt1;
import java.util.Random;
import java.util.Scanner;

public class Display 
{
	Service service = new Service();
	Customer cus = new Customer();
	Employee emp = new Employee();
	Account acc = new Account();
	Random rand = new Random();
	String newLine = System.getProperty("line.separator");//This will retrieve line separator dependent on OS.
	Scanner input = new Scanner(System.in);


	public void welcome()
	{
		int choice;
		boolean choiceIsGood;
		
		//Welcome Page/ Create new Account Page
        System.out.println("										Welcome to Wakanda National Bank");
        System.out.println("                 							     _______________________________________" + newLine);
        
        do
        {
       	 System.out.println("What would you like to do? Enter in the number of your selection.");
		     System.out.println("1. Apply for a new account" + newLine + "2. Login as a customer " + newLine + "3. Create a new Employee account" + newLine + "4. Login as existing employee"+ newLine + "5. Exit bank");
		     
		     while(!input.hasNextInt())
		     {
		    	 String input2 = input.next();
		    	 System.out.printf("\"%s\" is not a valid selection.\n" + newLine + "Enter 1, 2, 3, 4 or 5 to apply, login or exit respectively.", input2);
		     }
		     choice = input.nextInt();
		     choiceIsGood = true;
		     switch(choice)
	        	{
	        		case 1:
	        			//continue to apply
	        			apply();
	        			System.out.println("You now have an account with Wakanda National Bank!");
	        			welcome();
	        			break;
	        		case 2:
	        			//continue to login() as customer
	        			login();
	        			break;
	        		case 3:
	        			//continue to login() as new employee
	        			eApply();
	        			System.out.println("You now have an employee account with Wakanda National Bank!");
	        			welcome();
	        			break;
	        		case 4:
	        			//continue to login() as existing employee
	        			eLogin();
	        			break;
	        		case 5:
	        			System.out.println("Thank you for using Wakanda National Bank! Goodbye.");
	        			System.exit(0);
	        			break;
	        		default:
	        			//error message
	        			System.out.println("Type 1, 2, 3, 4 or 5 to respectively continue or quit" + newLine);
	        			break;
	        	}
		     
		     
       }while(choice < 0 || choice > 5);
        
    }
	
	
	public void apply()
	{
		int accountNum = rand.nextInt(100000);
		System.out.println("Welcome to the the application process!");
		String user;
		
		do
		{
			System.out.println("Please enter your first name: ");
			 cus.setFirstName(input.next());
			 service.validFirstName(cus.getFirstName());
			
		}while(service.isFnameIsGood() != true);
		
		do
		{
			System.out.println("Please enter your last name: ");
			cus.setLastName(input.next());
			service.validLastName(cus.getLastName());
		}while(service.isLnameIsGood() != true);
		
		System.out.println("Now Let's create a username and Password");
		
		//Create username
		do
		{
			System.out.println("Please enter in a valid username and one that does not exist: ");
			user = input.next();
			
			
			//if username does not exist, set userinput to current username
			if(service.usernameExists(user) != true)
			{
				cus.setUsername(user);
			};
			
		}while(service.validUsername(user) != true);
		

		do
		{
			System.out.println("Please enter in a valid password: ");
			 cus.setPassword(input.next());
			 service.validPassword(cus.getPassword());
			
		}while(service.isPassIsGood() != true);
		
		//customer to auto set intial value and incrementor
		cus.setAccount(0.0, accountNum);
		
		//save and serialize new customer details to text file
		service.customerSerialize(cus);

	}
	
	
	//login to existing customer account
	public void login()
	{
		String user;
		String pass;
		boolean usernameExists = false;
		boolean passwordValid = false;
		do
		{	//try and login
			System.out.println("Please enter your username: ");
			user = input.next();
			
			if (service.usernameExists(user) == false)
			{
				System.out.println("Username does not exist");

			}
			else 
			{
				usernameExists = true;
			}
			
		}while(usernameExists == false);
		
		do
		{
			//deserialize current user data for processing
			cus = service.customerDeserialize(user);
			if (cus != null)
			{
				System.out.println("Please enter your password: ");
				pass = input.next();
				
				if (cus.getPassword().equals(pass))
				{
					passwordValid = true;
				}
				else
				{
					System.out.println("Password is invalid");
				}
			}
			
		}while(passwordValid == false);
		
		if(usernameExists && passwordValid)
		{
			transactions();
		}
		

	}
	
	
	//apply for a new employee account
	public void eApply()
	{
		System.out.println("Welcome to the the employee registration process!");
		String user;
		do
		{
			System.out.println("Please enter your first name: ");
			 emp.setFirstName(input.next());
			 service.validFirstName(emp.getFirstName());
			
		}while(service.isFnameIsGood() != true);
		
		do
		{
			System.out.println("Please enter your last name: ");
			emp.setLastName(input.next());
			service.validLastName(emp.getLastName());
		}while(service.isLnameIsGood() != true);
		
		System.out.println("Now Let's create a username and Password");
		
		//Create username
		do
		{
			System.out.println("Please enter in a valid username and one that does not exist: ");
			user = input.next();
			
			
			//if username does not exist, set userinput to current username
			if(service.eUsernameExists(user) != true)
			{
				emp.setUsername(user);
			};
			
		}while(service.validUsername(user) != true);
		

		do
		{
			System.out.println("Please enter in a valid password: ");
			 emp.setPassword(input.next());
			 service.validPassword(emp.getPassword());
			
		}while(service.isPassIsGood() != true);

		//save and serialize new employee details to text file
		service.employeeSerialize(emp);

	}
	
	//Login into existing employee acccount
	public void eLogin()
	{
		String user;
		String pass;
		boolean usernameExists = false;
		boolean passwordValid = false;
		
		do
		{	//try and login
			System.out.println("Please enter your username: ");
			user = input.next();
			
			if (service.eUsernameExists(user) == false)
			{
				System.out.println("Username does not exist");

			}
			else 
			{
				usernameExists = true;
			}
			
		}while(usernameExists == false);
		
		do
		{
			emp = service.employeeDeserialize(user);
			if (emp != null)
			{
				System.out.println("Please enter your password: ");
				pass = input.next();
				
				if (emp.getPassword().equals(pass))
				{
					passwordValid = true;
				}
				else
				{
					System.out.println("Password is invalid");
				}
			}
			
		}while(passwordValid == false);
		
		if(usernameExists && passwordValid)
		{
			view();
		}
		

	}
	
	
	public void transactions()
	{
		int choice;
		boolean choiceIsGood;
		
		do
		{
			System.out.println(newLine + "Welcome to the transaction menu. What would you like to do?");
			System.out.println("1. Check Balance"+ newLine + "2. Withdraw Vibranium" + newLine + "3. Deposit Vibrainium" + newLine + "4. Initiate a transfer" + newLine + "5. Exit");
			
			 while(!input.hasNextInt())
		     {
		    	 String input1 = input.nextLine();
		    	 System.out.printf("\"%s\" is not a valid selection.\n" + newLine + "Enter 1, 2, 3, 4  or 5 check, withdraw, deposit, transfer or quit respectively.", input1);
		     }
			 
			 choice = input.nextInt();
		     choiceIsGood = true;
		     
		     switch(choice)
		     {
		     	case 1:
	     			//continue to checkBalance
	     			checkBalance();
	     			break;
			    case 2:
	     			//continue to withdraw
	     			withdraw();
	     			break;
	     		case 3:
	     			//continue to deposit
	     			deposit();
	     			break;
	     		case 4:
	     			//continue to transfer
	     			transfer();
	     			break;
	     		case 5:
	     			System.out.println("Thank you for using Wakanda National Bank! Goodbye.");
	     			service.customerSerialize(cus);
	     			System.exit(0);
	     			break;
	     		default:
	     			//error message
	     			System.out.println("Type 1, 2, 3 or 4 to respectively continue or quit" + newLine);
	     			break;
		     }
		}while(choice < 0 || choice > 5);
		
	}
	
	public void checkBalance()
	{
		System.out.println("You now have a balance of "+ cus.getAccountbal() + " vibrainium tokens.");
		service.customerSerialize(cus);
		transactions();
	}
	
	public void withdraw()
	{
		double d;
		boolean wAmountIsValid = false;
		System.out.println("You can withdraw as much vibrainum as you have.");
		System.out.println("Your current balance is " + cus.getAccountbal());
		
		do
		{
			System.out.println("How much do you want to withdraw?");
			while(!input.hasNextDouble())
		     {
		    	 String input1 = input.next();
		    	 System.out.printf("\"%s\" is not a valid selection.\n" + newLine + "Enter a valid number.", input1);
		     }
			d = input.nextDouble();
			if (d < 0)
			{
				System.out.println("input is invalid");
			}
			else
			{
				wAmountIsValid = true;
				service.withdraw(d, cus);
				System.out.println("Your Withdrawal was successful. You now have a balance of "+ cus.getAccountbal() + " vibrainium tokens.");
				service.customerSerialize(cus);
				transactions();
			}
		}while(wAmountIsValid == false);


	}
	
	public void deposit()
	{
		double d;
		boolean wAmountIsValid = false;
		System.out.println("Your current balance is " + cus.getAccountbal());
		System.out.println("You can deposit as much vibrainum as you have.");

		do
		{
			System.out.println("How much do you want to deposit?");
			while(!input.hasNextDouble())
		     {
		    	 String input1 = input.next();
		    	 System.out.printf("\"%s\" is not a valid selection.\n" + newLine + "Enter a valid number.", input1);
		     }
			d = input.nextDouble();
			if (d < 0)
			{
				System.out.println("input is invalid");
			}
			else
			{
				wAmountIsValid = true;
				service.deposit(d, cus);
				System.out.println("Your deposit was successful. You now have a balance of "+ cus.getAccountbal() + " vibrainium tokens.");
				service.customerSerialize(cus);
				transactions();
			}
		}while(wAmountIsValid == false);
		
		
	}
	
	public void transfer()
	{
		Customer c2;
		
		String user;
		boolean usernameExists = false;
		double d;
		boolean wAmountIsValid = false;
		System.out.println("Your current balance is " + cus.getAccountbal());
		System.out.println("You can transfer up to as much vibrainum as you have.");
		
		do
		{
			System.out.println("To whom do you want to transfer money to? Enter in their username.");
			user = input.next();
			if (service.usernameExists(user) == false)
			{
				System.out.println("Username does not exist");

			}
			else 
			{
				usernameExists = true;
				
			}
			
		}while(usernameExists == false);
		
		c2 = service.customerDeserialize(user);
		
		do
		{
			System.out.println("How much do you want to transfer?");
			while(!input.hasNextDouble())
		     {
		    	 String input1 = input.next();
		    	 System.out.printf("\"%s\" is not a valid selection.\n" + newLine + "Enter a valid number.", input1);
		     }
			d = input.nextDouble();
			if (d < 0)
			{
				System.out.println("input is invalid");
			}
			else
			{
				wAmountIsValid = true;
				service.transfer(d, cus,  c2);
				System.out.println("Your transfer was successful. You now have a balance of "+ cus.getAccountbal() + " vibrainium tokens.");
				service.customerSerialize(c2);
				service.customerSerialize(cus);
				transactions();
				
			}
		}while(wAmountIsValid == false);
		
		
		
	}
	
	
	public void view ()
	{
		Customer c;
		String user;
		boolean usernameExists = false;
		
		do
		{
			System.out.println("Which Customer account do you want to view? Enter in their username.");
			user = input.next();
			if (service.usernameExists(user) == false)
			{
				System.out.println("Username does not exist");

			}
			else 
			{
				usernameExists = true;
				
			}
			
		}while(usernameExists == false);
		
		c = service.customerDeserialize(user);
		
		System.out.println("Customer name: " + c.getFirstName() + " " + c.getLastName());
		System.out.println("Customer username: "+ c.getUsername());
		System.out.println("Customer password: "+ c.getPassword());
		System.out.println("Customer account number: "+ c.getAccountnum());
		System.out.println("Customer account balance: "+ c.getAccountbal());
		
	}
	
	
	
}


