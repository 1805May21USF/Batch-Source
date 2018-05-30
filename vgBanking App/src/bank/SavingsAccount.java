package bank;

public class SavingsAccount extends Account{ 
    private static double bal;
	

    public SavingsAccount() {     
        super();
    }

    public SavingsAccount(double balance, String id) {   
        super(bal,id);
    }

    

    public void setBalance(double balance) {
    	Account.balance = balance;
    }

    @Override
    public void deposit(double amount) {
    	if(amount !=0)
		{
			balance = balance + amount;
			previousTransaction = (int) amount;
		}
    }

    @Override
    public void withdraw(double amount) {
    	if(amount !=0) {
			balance = balance - amount;
			previousTransaction = -amount;
			}
    }

    @Override
    public double getBalance(){
		return balance;
       
    }

    @Override
    public String getAccountId(){
		return accountId;
       
    }

    @Override
    public void transfer(double amount, Account account) {
       //code
    }

    
    }


