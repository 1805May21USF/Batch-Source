package corejava;

import java.util.Scanner;

public class Driver {
	public static void main(String[] args) {
		
		//numbers 1-20 determine which question's solution is shown in console
		int whichAnswer = 18;
		
		switch (whichAnswer) {
		case 1:
			System.out.println(Q1.Solution());
			break;
		case 2:
			System.out.println(Q2.Solution());
			break;
		case 3:
			System.out.println(Q3.Solution("reversed"));
			break;
		case 4:
			System.out.println(Q4.Solution());
			break;
		case 5:
			System.out.println(Q5.Solution("thisisatestforquestion5", 7));
			break;
		case 6:
			System.out.println(Q6.Solution());
			break;
		case 7:
			Q7.Solution();
			break;
		case 8:
			System.out.println(Q8.Solution());
			break;
		case 9:
			Q9.Solution();
			break;
		case 10:
			System.out.println(Q10.Solution(30, 10));
			break;
		case 11:
			Q11.Solution();
			break;
		case 12:
			Q12.Solution();
			break;
		case 13:
			Q13.Solution(4);
			break;
		case 14:
			Q14.Solution();
			break;
		case 15:
			Q15class math = new Q15class();
			System.out.println(math.Subtraction(14,36));
			break;
		case 16:
			System.out.println(Q16.getLength(args));
			break;
		case 17:
			Scanner scanner = new Scanner(System.in);
            int principal, rate, time;
            
            System.out.println("Enter principal:");
            principal=scanner.nextInt();
            System.out.println("Enter rate:");
            rate=scanner.nextInt();
            System.out.println("Enter time:");
            time=(scanner.nextInt());  
            
			System.out.println(Q17.Solution(principal, rate, time));
			break;
		case 18:
			Q18subclass sub = new Q18subclass();
			System.out.println(sub.CheckUpper("uppercase"));
			sub.ToInt("100");
			System.out.println(sub.ToUpper("should be uppercase"));
			break;
		case 19:
			Q19.Solution();
			break;
		case 20:
			Q20.Solution();
			break;
		}
	}
}
