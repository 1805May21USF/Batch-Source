package bankm;
import java.util.*;



class Account{
    String name,acc_type;
    int Acc_num,Acc_Balance;
    Account(){
      
    }
        Account(String n,int acc_num,int b,String a_t){
            name=n;
            Acc_num=acc_num;
            Acc_Balance=b;
            acc_type=a_t;
        }
} // end class

class create_account extends Account{
    create_account(String n,int acc_num,int b,String a_t){ // pass name and account type 
            name=n;
            Acc_num=acc_num;
            Acc_Balance=b;
            acc_type=a_t;
    }
    create_account(){
        super();
    }
        
    void insert(String n,int acc_num,String a_t){ // input user name, account number and type 
        name=n;
        acc_type=a_t;
        Acc_num=acc_num; // generate random number 
        Acc_Balance=0;
    }
    
    void display_details(){
        System.out.println("Depositor Name :" +name);
        System.out.println("Account Number : "+Acc_num);
        System.out.println("Account Balance : "+Acc_Balance);
        System.out.println("Account Type : "+acc_type);
    }
 
        void deposite(int acc_num,int money){                 
                Acc_Balance=money;    
        }
        
        int withdraw(int withd){
                Acc_Balance=Acc_Balance-withd;
                return Acc_Balance;
        }
  
} // end class 

      
public class Main {
    public static void main(String args[]){
        String user_name=null,type;
        type = null;
        int balance=0,tmp=0;
        int withd=0,cb=0;
// to generate Random Account Number 
int aNumber = 0; 
aNumber = (int)((Math.random() * 9000)+1000); 

        create_account user = new create_account("user",0,0,"savings"); // initilaize -- name,acc_number,Balance,Type
    
            Scanner in = new Scanner(System.in);
            Scanner strng=new Scanner(System.in);
            int userChoice;
            boolean quit = false;

            do {
                  System.out.println("1. Create Account");
                  System.out.println("2. Deposit money");
                  System.out.println("3. Withdraw money");
                  System.out.println("4. Check balance");
                  System.out.println("5. Display Account Details");
                  System.out.println("0. to quit: \n");
                  System.out.print("Enter Your Choice : ");
                  userChoice = in.nextInt();
                  switch (userChoice) {
                      
                  case 1:
                        System.out.print("Enter your Name : ");
                        user_name=strng.nextLine(); 
                        System.out.print("Enter Accout Type : ");
                        type=in.next();
                        user.insert(user_name, aNumber, type);  // inserted 
                        System.out.println("\n\tYour Account Details\n\tDont Forget Account Number\n");
                        System.out.println("**************************");                       
                        user.display_details();
                        break;
                      
                case 2: // deposite
                    System.out.print("Enter your account Number : ");
                    tmp=in.nextInt();
                 if(tmp==user.Acc_num){
                 System.out.print("Enter Amount Of Money : ");
                 balance=in.nextInt();
                 user.Acc_Balance=balance;
                 System.out.println("\t Successfully Deposited.");
              }                
                     else
                    System.out.println("Wrong Accoount Number.");          
                   break;
                    
                  case 3: // withdraw money                      
                     System.out.print("Enter your account Number : ");
                      tmp=in.nextInt();
                      
                          if(tmp==user.Acc_num){                         
                             if(user.Acc_Balance==0)
                             System.out.print("Your Account is Empty.");
                             
                             else{
                             System.out.print("Enter Amout Of Money : ");   
                             withd=in.nextInt();  
                             
                             if(withd>user.Acc_Balance){
                             System.out.print("Enter Valid Amout of Money : ");
                             withd=in.nextInt();
                             }
                             else
                             cb= user.withdraw(withd);
                             System.out.println("Your Current Balance : "+cb);   
                             }
                          }
                             else
                             System.out.println("Wrong Accoount Number.");  
                        break;
     
                  case 4: // check balance 

                      System.out.print("Enter your Account Number : ");
                      tmp=in.nextInt();
                      
                             if(tmp==user.Acc_num){
                             System.out.println("Your Current Balance : "+user.Acc_Balance);
                             }
                             else
                             System.out.println("Wrong Accoount Number.");                         
                      break;
                      
                  case 5: // display all info 
                          
                      System.out.print("Enter your Account Number :");
                      tmp=in.nextInt();                     
                             if(tmp==user.Acc_num){                               
                             user.display_details();                             
                        }else
                             System.out.println("Wrong Accoount Number.");
                             
                      break;
                  case 0:
                        quit = true;
                        break;
                  default:
                        System.out.println("Wrong Choice.");
                        break;
                  }
                  System.out.println("\n");
            } while (!quit);
            System.out.println("Thanks !");
             
     } //  end main function 
    
} //  end mian class