package javaCore;

import java.lang.*;
import java.util.*;

public class q16StringInput {
	public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        String input = keyboard.nextLine();
        args.add(input);
        int sum = args.length;
        keyboard.close();
        System.out.println("you entered" + sum + "characters");
        }
        
    }
