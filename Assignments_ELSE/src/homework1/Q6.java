package homework1;

public class Q6 {
	//Write a program to determine if an integer is even without using the modulus operator (%)
	public static void main(String args[]) {
	     
         
        System.out.println("Checking if a number is even");
        
     
        
		for(int i= -1; i<=100; i++){
            isEven(i); //calling division operator method
           
        }       
       
    }   
       
    /*
     * checking even  number without using modulus or remainder operator, Instead
     * this method uses division operator.
     */
    public static void isEven(int number){
        int quotient = number/2;
       
        if(quotient*2== number){
            System.out.println("Using division operator: "  + number + " is Even number");
           
       
        }
    }
   
    

}
