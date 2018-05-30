package bank;

import java.util.Scanner;


public class TransferTest {

	
	public static void main(String[] args) 
	{
		Scanner kb = new Scanner(System.in);
		
		Bank acctUno = new Bank("Biggs");
		Bank acctDos = new Bank("Wedge");
		
		boolean finish = false;
		
		while (!finish)
		{
			System.out.println("Current Open Accounts: \n\n"
					+ acctUno.toString() +"\n"
					+ acctDos.toString()
					);			
			
			System.out.println("Would you like to: " 
					+ "\n(1) Transfer money from account #" 
						+ acctUno.getAcctNumber() + " to account #" 
						+ acctDos.getAcctNumber()
					+ "\n(2) Transfer money from account #" 
						+ acctDos.getAcctNumber() + " to account #" 
						+ acctUno.getAcctNumber()
					+ "\n(3) Save all transfers and exit");
			if(kb.hasNextInt())
			{
				int selected = kb.nextInt();
				kb.nextLine();
				
				if (selected == 1 || selected == 2)
				{
					System.out.print("How much would you like to transfer? ");
					
					double amount = kb.nextDouble();
					kb.nextLine();
					
					if (selected == 1)
					{
				//		Account.transfer(acctUno, acctDos, amount); 
						System.out.println("findnotfounf");
					}
					else if (selected == 2)
					{
				//		acctDos.transfer(acctUno, amount);
						System.out.println("findnotfounf");
					}
					
					System.out.print("Would you like to perform another transfer? [y/n] ");
					String confirm = kb.next().toLowerCase();
					kb.nextLine();
					
					if (confirm.equals("n") || confirm.equals("no"))
					{
						System.out.println("Thank you.");
						finish = true;
					}
				}				
				else if (selected == 3)
				{
					System.out.println("Thank you.");
					finish = true;
				}
				else
				{
					System.out.println("Invalid request.");
				}
			}
		}
	}
}