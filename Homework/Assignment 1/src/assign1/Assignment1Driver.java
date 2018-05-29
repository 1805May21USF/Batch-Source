package assign1;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

// For Quest11
import secondpackage.Quest11;

public class Assignment1Driver {

	// Add log4j
	static{
        
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
    System.setProperty("current.date.time", dateFormat.format(new Date()));
    }
	
	static Logger log = Logger.getLogger(Assignment1Driver.class.getName());
	
	
	
	public static void main(String[] args) {
		// Configure log4j
		BasicConfigurator.configure();
		
		Assignment1Driver.log.info("Inside main(): ");
		System.out.println("Begin Assignment1Driver: \n");

		//1
		
		//2
		// Display first 25 fibonacci numbers
		Quest2.DisplayFibonacci();
		
		//3
		Quest3.ReverseString("weekday");
		
		//4
		// Calculate N factorial
		Quest4.ComputeNFactorial(1);
		Quest4.ComputeNFactorial(2);
		Quest4.ComputeNFactorial(3);
		Quest4.ComputeNFactorial(4);
		Quest4.ComputeNFactorial(5);
		
		
		//5
		System.out.println("Substring of \"weekend\": " + Quest5.FindSubstring("weekend", 3) + "\n");;
		
		//6
		Quest6.CheckIfEven(15);
		
		//7
		
		//8
		
		//9
		// Print prime numbers
		Quest9.ArrayListPrimeNums();
		
		//10
		Quest10.FindMin(2, 3);
		Quest10.FindMin(5, 10);
		
		//11
		//Imported secondpackage.Quest11 above.
		Quest11 q11 = new Quest11();
		System.out.println("First Float Number: " + q11.getFirstNumber());
		System.out.println("Second Float Number: " + q11.getSecondNumber());
		
		//12
		Quest12.ArrayEnhancedForLoop();
		
		//13
		Quest13.DisplayTriangle();
		
		//14
		Quest14.SwitchCases(1);
		Quest14.SwitchCases(2);
		Quest14.SwitchCases(3);
		
		//15
		Quest15 q15 = new Quest15();
		q15.addition(2, 4);
		q15.subraction(2, 4);
		q15.multiplication(2, 4);
		q15.division(2, 4);
		System.out.println();
		
		//16
		// Using command line to get total chars of String[] args passed in.
		System.out.println("Quest16: ");
		System.out.println("Comment out package declaration at top of Quest 16.java before compiling.");
		System.out.println("For Quest 16, use command line to compile Quest16.java.");
		System.out.println("javac Quest16.java");
		System.out.println("Then run using: java Quest16 hello there");
		System.out.println("args.length :2\nNumber of characters for String[] args is: 10");
		
		//17
		// Calculate interest
		Quest17.calculateInterest();
		
		
	}

}
