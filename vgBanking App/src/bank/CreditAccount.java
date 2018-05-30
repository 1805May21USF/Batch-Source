package bank;


public class CreditAccount extends Account{ 
    private static String bal;
	private double interest = 2.9;

    public CreditAccount() {      
        super();
    }

    public CreditAccount(double balance, String id) {   
        super(bal,id);
    }

    public void setInterest(Customer customer) {
      //code
    }

    public void setBalance(double balance) {
       //code
    }

    @Override
    public void deposit(double amount) {
       //code
    }

    @Override
    public void withdraw(double amount) {
       //code
    }

    @Override
    public double getBalance(){
		return balance1;
       //code
    }

    @Override
    public String getAccountId(){
		return accountId;
       //code
    }

    @Override
    public void transfer(double amount, Account account) {
       //code
    }

    public void setInterest(double interest){
       //code
    }

    public double getInterest(){
		return interest;
      //code
    }
}