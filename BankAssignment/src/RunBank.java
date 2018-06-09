import java.util.Scanner;

public class RunBank {

	public static void main(String[]args) {
		Bank bank = new Bank();
		while(true) {
			
		System.out.println("1. Open Account");	
		System.out.println("2. Deposit ");	
		System.out.println("3. Withdraw ");	
		System.out.println("4. Check Balance");	
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter Option");
			int option = scanner.nextInt();
			
			switch(option) {
			
			case 1:
				System.out.println("Enter amount");
				long accountNumber = bank.createAccount(scanner.nextDouble());
				if(accountNumber!=0)
					System.out.println("Congratiolation your account number "+ accountNumber);
				else
					System.out.println(" Fail to create an account ");
				
				break;
			case 2:
				System.out.println("Enter account number ");
				int depositStatus = bank.deposit(scanner.nextLong(), scanner.nextDouble());
				if (depositStatus!=0)
					System.out.println("Deposited ");
				else
					System.out.println("fails to deposit");
				break;
			case 3: 
				System.out.println("Enter account number ");
				int withdrawStatus = bank.deposit(scanner.nextLong(), scanner.nextDouble());
				if (withdrawStatus!=0)
					System.out.println("Success ");
				else
					System.out.println("fails to withdraw");
				
				break;
			case 4: 
				System.out.println("Enter account number ");
				double balance = bank.getBalance(scanner.nextLong());
				if (balance==-1)
					System.out.println("ACCOUNT NUMBER NOT FOUND");
				else
					System.out.println("Balance "+balance);
				
				break;
			case 5: System.exit(0);break;
			default: System.out.println("Invalid Option! ");
			}
		}
	}
}
