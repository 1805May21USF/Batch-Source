package bankapp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Account {
	double balance;
	double depositAmount;
	double withdrawAmount;
	double transferAmount;
	boolean transferIntoAcc = false;
	public Account() {
		balance = 0;
	}
	
	public void WriteAccount(String username) {
		
		// Serialize
		BankAppDriver.log.info("Begin Serialization - WriteAccount(): ");
		
		try{
			// Make accounts directory if doesn't exist.
			File directory = new File("bankcust/account/");
			directory.mkdir();
			
			// Create customer.ser file and serialize
			FileOutputStream fileOut = new FileOutputStream("bankcust/account/acc" + username + ".ser");
			BankAppDriver.log.info("Serialized data will be written in bankcust/account/acc" + username + ".ser");
			
			ObjectOutputStream outStream = new ObjectOutputStream(fileOut);
			
			
			outStream.writeObject(balance);
			
			
			BankAppDriver.log.info("Check Variable of Type Double Written To .ser File - balance");
			BankAppDriver.log.info(String.format("balance: %.2f", balance));
			
			outStream.close();
			fileOut.close();
			
			BankAppDriver.log.info("End Serialization - WriteAccount() \n");
			
			
		} catch(IOException i){
			i.printStackTrace();
		}
	}
	
	public void ViewBalance(Account custAcc, String userNam) {
		
		//Deserialize
		
		BankAppDriver.log.info("Begin Deserialization - View Balance(): ");
		
		BankAppDriver.log.info("Account reference is set to null. a = (custAcc = null) ");
		custAcc = null;
		
		try {
			FileInputStream fileIn = new FileInputStream("bankcust/account/acc" + userNam + ".ser");
			
			ObjectInputStream inStream = new ObjectInputStream(fileIn);
			balance = (Double) inStream.readObject();
			
			BankAppDriver.log.info("Check Variable of Type Double Read From .ser File - balance");
			BankAppDriver.log.info(String.format("balance: %.2f", balance));
			
			// Print balance to console
			System.out.format("\nBalance: $%.2f\n", balance);
			
			inStream.close();
			fileIn.close();
		} catch(IOException i) {
			i.printStackTrace();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		BankAppDriver.log.info("End Deserialization - View Balance() \n");
	}
	
	public void Deposit(double depAmount, String userNam) {
		BankAppDriver.log.info("Begin Deposit(): ");
		
		depositAmount = depAmount;
		
		BankAppDriver.log.info(String.format("Deposit Amount: %.2f", depAmount));
		
		try {
			FileInputStream fileIn = new FileInputStream("bankcust/account/acc" + userNam + ".ser");
			
			ObjectInputStream inStream = new ObjectInputStream(fileIn);
			
			// Read current balance
			balance = (Double) inStream.readObject();
			
			BankAppDriver.log.info(String.format("Before Depositing, Balance = %.2f", balance));
			
			// View balance before deposit
			System.out.println(String.format("%nPrevious Balance: %.2f", balance));
			
			// Print out deposit amount
			System.out.println(String.format("%nDeposit amount: %.2f%n", depAmount));
			
			
			// Deposit into account
			balance += depositAmount;
			
			BankAppDriver.log.info(String.format("After Depositing, Balance = %.2f", balance));
			System.out.println(String.format("After Depositing, Balance = %.2f for user %s", balance, userNam));
			// Write balance into file.
			WriteAccount(userNam);
			
			
			
			
			inStream.close();
			fileIn.close();
			
		}
		catch(IOException i) {
			i.printStackTrace();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		BankAppDriver.log.info("End Deposit() \n");
	}
	
	public void Withdraw(double drawAmount, String userNam) {
		BankAppDriver.log.info("Begin Withdraw(): ");
		
		BankAppDriver.log.info("Username: " + userNam);
		withdrawAmount = drawAmount;
		
		BankAppDriver.log.info(String.format("Withdraw Amount: %.2f", drawAmount));
		
		try {
			FileInputStream fileIn = new FileInputStream("bankcust/account/acc" + userNam + ".ser");
			
			ObjectInputStream inStream = new ObjectInputStream(fileIn);
			
			// Read current balance
			balance = (Double) inStream.readObject();
			
			BankAppDriver.log.info(String.format("Before Withdrawing, Balance = %.2f", balance));
			// View balance before deposit
			System.out.println(String.format("%nPrevious Balance: %.2f", balance));
			
			// Print out deposit amount
			System.out.println(String.format("%nWithdraw amount: %.2f", drawAmount));
			
			// Withdraw from account
			balance -= withdrawAmount;
			
			BankAppDriver.log.info(String.format("After Withdrawing, Balance = %.2f%n", balance));
			System.out.println(String.format("After Withdrawing, Balance = %.2f for user %s", balance, userNam));
			
			// Write balance into file.
			WriteAccount(userNam);
			
			
			
			inStream.close();
			fileIn.close();
			
		}
		catch(IOException i) {
			i.printStackTrace();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BankAppDriver.log.info("End Withdraw() \n");
	}
	
	
	public void Transfer(double transAmount, Customer cT) {
		BankAppDriver.log.info("Begin Transfer(): ");
		
		
		transferAmount = transAmount;
		
		// Ask Customer -> Option: Transfer Into Current Account From Other Account Or Transfer To Other Account From Current Account
		
		
		BankAppDriver.log.info(String.format("Transfer Amount: %.2f", transferAmount));
		
		// Transfer Into Current Account From Other Account
		if(transferIntoAcc == true) {
			BankAppDriver.log.info("Transfer Into Account From Joint Account.");
			Withdraw(transferAmount, cT.secondJointAccUsername);
			Deposit(transferAmount, cT.username);
		}
		else {
			// Transfer To Other Account From Current Account
			BankAppDriver.log.info("Transfer To Joint Account From Current Account.");
			Withdraw(transferAmount, cT.username);
			Deposit(transferAmount, cT.secondJointAccUsername);
			
		}
		
		BankAppDriver.log.info("End Transfer() \n");
	}
}
