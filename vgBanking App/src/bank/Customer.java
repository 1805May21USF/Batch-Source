package bank;

public class Customer {
    private String firstName;
    private String lastName;
    private String number;

    private SavingsAccount account = new SavingsAccount();
    private CreditAccount cAccount = new CreditAccount();

    Customer(String firstName, String lastName, String number, SavingsAccount account) {   
        this.firstName = firstName;
        this.lastName = lastName;
        this.number = number;
        this.account = account;
     }

    Customer(String firstName, String lastName, String number, CreditAccount cAccount) {   
        this.firstName = firstName;
        this.lastName = lastName;
        this.number = number;
        this.cAccount = cAccount;
    }

    public SavingsAccount getAccount() {
        return account;
    }

    public CreditAccount getCreditAccount() {
        return cAccount;
    }            
}