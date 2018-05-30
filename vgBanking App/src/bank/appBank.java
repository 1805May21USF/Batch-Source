package bank;
import java.util.Scanner;

public class appBank  {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BankAccount customer1 =new BankAccount("John","00004");
		customer1.mainMenu();
		//customer1.showMenu();

	}
}

class BankAccount
{
	int balance;
	int previousTransaction;
	String customerName;
	String customerId;
	
	BankAccount(String cname, String cid){
		customerName = cname;
		customerId = cid;
	}
	
	void deposit(int amount)
	{
		if(amount !=0)
		{
			balance = balance + amount;
			previousTransaction = amount;
		}
	}
	
	void withdraw(int amount) {
		if(amount !=0) {
			balance = balance - amount;
			previousTransaction = -amount;
			}
					
		}
		
		void getPreviousTransaction() {
			if(previousTransaction > 0)
			{
				System.out.println("Deposited:"+ previousTransaction );
			}
			else if(previousTransaction < 0)
			{
				System.out.println("withdrawn:" + Math.abs(previousTransaction));
			}
			else {
				System.out.println("No transaction occurred");
			}
		}
		
		void mainMenu() {
			char pick = '\0';
			char option = '\0';
			Scanner scanner = new Scanner(System.in);
			System.out.println("Welcome to Chase Bank");
			System.out.println("\n");
			System.out.println("(1) Log into account");
			System.out.println("(2) Enroll Now");
			
			pick = scanner.next().charAt(0);
			System.out.print("\n");
			
			switch(pick) {
			
			
			
			
			case '1':
				
				System.out.println("-----------------------------------");
				
				Scanner input = new Scanner(System.in);
				String user, pass;
				System.out.println("Please enter User ID");
				user= input.nextLine();
				System.out.println("Please enter Password");
				pass = input.nextLine();
				
				if(user.equals("nicholssullivan") &&(pass.equals("123456789"))){
					System.out.println("welcome  Nick.");
				switch(pick) {
					
				case 'A':
					
					System.out.println("-----------------------------------");
					System.out.println("Balnce = "+balance);
					System.out.println("-----------------------------------");
					System.out.println("\n");
					break;
					
				case 'B':
					
					System.out.println("-----------------------------------");
					System.out.println("Enter an amount to deposit:");
					System.out.println("-----------------------------------");
					int amount = scanner.nextInt();
					deposit(amount);
					System.out.println("\n");
					break;
					
				case 'C':
				
					System.out.println("-----------------------------------");
					System.out.println("Enter an amunt to withdraw");
					System.out.println("-----------------------------------");
					int amount2 = scanner.nextInt();
					withdraw(amount2);
					System.out.println("\n");
					break;
					
				case 'D':
					
					System.out.println("-----------------------------------");
					getPreviousTransaction();
					System.out.println("-----------------------------------");
					System.out.println("\n");
					break;
					
				case 'E':
					System.out.println("----------------------------------");
					break;
					
				default:
					System.out.println("Invalid Option! Please try again");
					break;
					
				}
							
					
				}while(option !='E');
					
					System.out.println("Thank You for using our services");
		
			
				
		}	
				
				
				
				
				
				
				
				
				
			
				
			}
		
		
		void showMenu() {
			
			char option ='\0';
			Scanner scanner = new Scanner(System.in);
			
			System.out.println("Welcome" +" "+ customerName );
			System.out.println("Please enter ID" + " "+ customerId);
			System.out.println("\n");
			System.out.println("A. Check Balance");
			System.out.println("B. Deposit");
			System.out.println("C. Withdaw");
			System.out.println("D. Previous Transaction");
			System.out.println("E. Exit" );
		
		do {
			System.out.println("===================================================== ");
			System.out.println("Enter an option" + "        " + ("\n") + "A. Check Balance" +"   " + "B. Deposit" + "   " +
			"C. Withdraw" + "   " +"D. Previous Transaction"+"   " + "E. Exit");
			System.out.println("===================================================== ");
			option = scanner.next().charAt(0);
			System.out.println("\n");
			
			switch(option) {
			
			case 'A':
				
				System.out.println("-----------------------------------");
				System.out.println("Balnce = "+balance);
				System.out.println("-----------------------------------");
				System.out.println("\n");
				break;
				
			case 'B':
				
				System.out.println("-----------------------------------");
				System.out.println("Enter an amount to deposit:");
				System.out.println("-----------------------------------");
				int amount = scanner.nextInt();
				deposit(amount);
				System.out.println("\n");
				break;
				
			case 'C':
			
				System.out.println("-----------------------------------");
				System.out.println("Enter an amunt to withdraw");
				System.out.println("-----------------------------------");
				int amount2 = scanner.nextInt();
				withdraw(amount2);
				System.out.println("\n");
				break;
				
			case 'D':
				
				System.out.println("-----------------------------------");
				getPreviousTransaction();
				System.out.println("-----------------------------------");
				System.out.println("\n");
				break;
				
			case 'E':
				System.out.println("----------------------------------");
				break;
				
			default:
				System.out.println("Invalid Option! Please try again");
				break;
				
			}
						
				
			}while(option !='E');
				
				System.out.println("Thank You for using our services");
	
		
			
	}	
	
}