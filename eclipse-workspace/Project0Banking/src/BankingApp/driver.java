package BankingApp;

import java.util.Scanner;

public class driver {

	public static void main(String[] args) {
		System.out.println("Welcome to Big Money Bank!");
		
		//Customer or employee
		System.out.println("Are you a customer: 1, or Employee: 2");
		Scanner enterRole = new Scanner(System.in);
		int role = enterRole.nextInt();
		
		//Customer Start
		if(role == 1) {
			System.out.println("Welcome valued customer!");
			System.out.println("Do you want to apply for an accout: 1, apply for a joint account: 2, or Login to your account: 3");
			Scanner enterAccountOption = new Scanner(System.in);
			int accountOption = enterAccountOption.nextInt();
			
			//Account options
			if(accountOption == 1) {
				System.out.println("you chose to apply for an account!");
				records newAccount = new records();
				newAccount.makeANewAccount();
		}
			else if(accountOption == 2) {
				System.out.println("you chose to apply for a joint account!");

		}
			else {
				System.out.println("you chose to login to your account!");
				System.out.println("Enter your username!");
				Scanner enterUsername = new Scanner(System.in);
				String theirUsername = enterUsername.nextLine();
				System.out.println("Enter your password!");
				Scanner enterPassword = new Scanner(System.in);
				String theirPassword = enterPassword.nextLine();
					//if(theirUsername && theirPassword == )
				
				
					System.out.println("would you like to withdraw: 1, deposit: 2, or transfer: 3");
					Scanner enterWhatToDoWithFunds = new Scanner(System.in);
					int fundsOption = enterWhatToDoWithFunds.nextInt();
					if(fundsOption == 1) {
						//withdraw
						System.out.println("withdraw how much?");
						Scanner enterWithdrawAmmount = new Scanner(System.in);
						Float theirWithdraw = enterWithdrawAmmount.nextFloat();
					}
					else if(fundsOption == 2) {
						//deposit
						System.out.println("deposit how much?");
						Scanner enterDepositAmmount = new Scanner(System.in);
						Float theirDeposit = enterDepositAmmount.nextFloat();
					}
					else {
						//transfer
						System.out.println("Transfer how much?");
						Scanner enterTransferAmmount = new Scanner(System.in);
						Float theirWithdraw = enterTransferAmmount.nextFloat();
					}
			}
		}
		
		//Employee Start
		else {
			System.out.println("Hello employee. are you an admin: 1, or just another little pion: 2");
			Scanner enterJobOption = new Scanner(System.in);
			int jobOption = enterJobOption.nextInt();
				if(jobOption == 1) {
					
					//Admin Start
					System.out.println("Welcome noble Admin. Would you like to access a customer account: 1, Approve/deny applications: 2, cancel an account: 3 ");
					Scanner enterAdminChoice = new Scanner(System.in);
					int adminChoice = enterAdminChoice.nextInt();
					if(adminChoice == 1) {
						
					//Enter an account
					System.out.println("you chose to login to an account!");
					System.out.println("Enter their username!");
					Scanner enterUsername = new Scanner(System.in);
					String theirUsername = enterUsername.nextLine();
					System.out.println("Enter their password!");
					Scanner enterPassword = new Scanner(System.in);
					String theirPassword = enterPassword.nextLine();
					
					//Withdraw Deposit Transfer
					System.out.println("would you like to withdraw: 1, deposit: 2, or transfer: 3");
					Scanner enterWhatToDoWithFunds = new Scanner(System.in);
					int fundsOption = enterWhatToDoWithFunds.nextInt();
						if(fundsOption == 1) {
							//withdraw
							System.out.println("withdraw how much?");
							Scanner enterWithdrawAmmount = new Scanner(System.in);
							Float theirWithdraw = enterWithdrawAmmount.nextFloat();
						}
						else if(fundsOption == 2) {
							//deposit
							System.out.println("deposit how much?");
							Scanner enterDepositAmmount = new Scanner(System.in);
							Float theirDeposit = enterDepositAmmount.nextFloat();
						}
						else {
							//transfer
							System.out.println("Transfer how much?");
							Scanner enterTransferAmmount = new Scanner(System.in);
							Float theirTransfer = enterTransferAmmount.nextFloat();
						}
					
					}
					
					//Approval and Denial
					else if(adminChoice == 2) {
						System.out.println("you chose to approve or deny applications");
						System.out.println("Joann Bugsly: 85: Welfare" + "Y or N");
						Scanner enterJudgement = new Scanner(System.in);
						String theirJudgement = enterJudgement.nextLine();
						if(theirJudgement == "Y") {
							System.out.println("You have shown mercy");
						}
						else {
							System.out.println("tell her only the strong may enter here");
						}
					}
				}
				else {
					
					//Employee Start
					System.out.println("Welcome lowly employee. Would you like to view a customer account:1, Approve/deny applications: 2");
					Scanner enterEmployeeChoice = new Scanner(System.in);
					int employeeChoice = enterEmployeeChoice.nextInt();
					if(employeeChoice == 1) {
					System.out.println("you chose to login to their account!");
					System.out.println("Enter their username!");
					Scanner enterUsername = new Scanner(System.in);
					String theirUsername = enterUsername.nextLine();
					System.out.println("Enter their password!");
					Scanner enterPassword = new Scanner(System.in);
					String theirPassword = enterPassword.nextLine();
					}
					else if(employeeChoice == 2) {
						System.out.println("you chose to approve or deny applications");
						System.out.println("Joann Bugsly: 85: Welfare" + "Y or N");
						Scanner enterJudgement = new Scanner(System.in);
						String theirJudgement = enterJudgement.nextLine();
						if(theirJudgement == "Y") {
							System.out.println("You have shown mercy");
						}
						else {
							System.out.println("tell her only the strong may enter here");
						}
				}
		}

	}

}}
