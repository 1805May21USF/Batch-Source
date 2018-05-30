package bank;

import java.util.Scanner;

public class Bank extends Account {
    String bankName;
    private Customer[] customers = new Customer[100];
	private static Scanner input;
	private static Scanner scanner;
	Bank(String bankName) {
        this.bankName = bankName;
     
         
        
 }

    public Customer[] getCustomer() {
        return customers;
   }  

   public String getBankname() {
	   return bankName;
   }
     
  


   
   public static void main(String[] args) {
	    input = new Scanner(System.in);
	    int choice;
	    int numberOfCustomers = 0;
	    boolean endProgram = false;
	    String user, pass;;   
	    System.out.println("Please enter User ID");
		user= input.nextLine();
		System.out.println("Please enter Password");
		pass = input.nextLine();
		
		if(user.equals("admin") &&(pass.equals("123456789"))){
			System.out.println("Welcome  admin.");
			
		
			
				
			
			
			//else { if(user.equals("admin") &&(pass.equals("password"))){
			//	System.out.println("Welcome  admin."); 
		
   
			
	   
	    Bank bank = new Bank(user);
	    Bank bank1 = new Bank(user);
	    Customer[] customer = bank1.getCustomer();
	    Customer[] customer1 = bank1.getCustomer();

	    do {        
	        System.out.println("    " +" ID:"+"   " + bank1.getBankname() + "\n");
	        System.out.println("    1. Balance                          ");
	        System.out.println("    2. Withdraw                             ");
	        System.out.println("    3. Deposit                              ");
	        System.out.println("    4. Transfer                             ");
	        System.out.println("    5. Add new customer                     ");
	        System.out.println("    0. Exit                                 ");            

	        choice = input.nextInt();

	        
			switch(choice) {

	            case 1:  
	            	System.out.println("-----------------------------------");
					System.out.println("Balnce = "+balance);
					System.out.println("-----------------------------------");
					System.out.println("\n");
					break;


	            case 2: 
	            	System.out.println("-----------------------------------");
					System.out.println("Enter an amount to withdraw");
					System.out.println("-----------------------------------");
					int amount = scanner.nextInt();
					withdraw(amount);
					System.out.println("\n");
					break;


	            case 3: 
	            	System.out.println("-----------------------------------");
					System.out.println("Enter an amount to deposit:");
					System.out.println("-----------------------------------");
					int amount1 = scanner.nextInt();
					deposit(amount1);
					System.out.println("\n");
					break;


	            case 4: 
	            	System.out.println("-----------------------------------");
					//getPreviousTransaction();
	            	boolean finish = false;
	            	
	            	while (!finish)
	        		{
	        				
	        			
	        		}     	
	            	
	            	
	            	
	            	
	            	


	            


	            case 5: //Add customer                   
	                System.out.println("Choose account: ");
	                System.out.println("1. Savings account");
	                System.out.println("2. Credit account");
	                choice = input.nextInt();
	                switch(choice) {

	                    case 1:     //Create savings account
	                        System.out.print("Enter amount to deposit: ");
	                        double amount11 = input.nextDouble();
	                        System.out.println("Account number is: " + numberOfCustomers);
	                        SavingsAccount savingsAccount = new SavingsAccount(amount11, String.valueOf(numberOfCustomers));                    
	                        System.out.print("First name: ");
	                        String firstName = input.next();
	                        System.out.print("Last name: ");
	                        String lastName = input.next();
	                        System.out.print("Customer number: ");
	                        String pnumber = input.next();

	                        Customer newCustomer = new Customer(firstName, lastName, pnumber, savingsAccount);
	                      customer1[numberOfCustomers] = newCustomer;
	                        numberOfCustomers++;              

	                        break;

	                    case 2:     //Create credit account
	                        System.out.print("Enter amount to deposit: ");
	                        double amount111 = input.nextDouble();
	                        System.out.println("Account number is: " + numberOfCustomers);
	                        CreditAccount creditAccount = new CreditAccount(amount111, String.valueOf(numberOfCustomers));                    
	                        System.out.print("First name: ");
	                        String firstName1 = input.next();
	                        System.out.print("Last name: ");
	                        String lastName1 = input.next();
	                        System.out.print("Customer number: ");
	                        String pnumber1 = input.next();

	                        Customer newCustomer1 = new Customer(firstName1, lastName1, pnumber1, creditAccount);
	                        customer1[numberOfCustomers] = newCustomer1;
	                        numberOfCustomers++;                    

	                        break;                            
	                }
	                break;


	            case 0: 
	            	System.out.println("----------------------------------");
					break;
					
	            default:
					System.out.println("Invalid Option! Please try again");
					break;
	        }
	    } while (choice != 0);
	    System.out.println("Thank You for using our services");
	}
   }
   }
   
   
   
