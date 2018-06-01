package BankingApp;

import java.util.*;

public class customer {
	
	private static void registerUsernameAndPassword() {
		//personalInformation(){
			Scanner enterUsername = new Scanner(System.in);
			String username = enterUsername.nextLine();
			Scanner enterPassword = new Scanner(System.in);
			String password = enterPassword.nextLine();
		
	}
	
	private static void applyToOpenAnAccount() {
		Scanner enterUsername = new Scanner(System.in);
		String username = enterUsername.nextLine();
		Scanner enterPassword = new Scanner(System.in);
		String password = enterPassword.nextLine();
		
		//accountBalances
	}
	
	private static void applyForJointAccount() {
		//accountInformation
		//accountBalances
	}
	
	private static void withdraw() {
		Scanner enterAmmountOut = new Scanner(System.in);
		Float ammountOut = enterAmmountOut.nextFloat();
		bankAccount myAccount = new bankAccount();
		myAccount.balance = myAccount.balance - ammountOut;
	}
	
	private static void deposit() {
		Scanner enterAmmountIn = new Scanner(System.in);
		Float ammountIn = enterAmmountIn.nextFloat();
		bankAccount myAccount = new bankAccount();
		myAccount.balance = myAccount.balance + ammountIn;
	}

	private static void transferFunds() {
		Scanner enterAmmountTransfered = new Scanner(System.in);
		Float ammountTransfered = enterAmmountTransfered.nextFloat();
		Scanner enterTargetAccount= new Scanner(System.in);
		String targetAccount = enterTargetAccount.nextLine();
		bankAccount myAccount = new bankAccount();
		myAccount.balance = myAccount.balance - ammountTransfered;
}
}
