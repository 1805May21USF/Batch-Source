package com.revature.lambda;

interface MyString {
	String myCryptorFunction(String str);
}

public class TestLambda {
	public static void main (String args[]) {
        // Block lambda to encrypt a string
        MyString cryptor = (str) -> {
            String result = "";
            
            for(int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if (ch == 'z')
                	ch = 'a';
                else if (ch == 'Z')
                	ch = 'A';
                else
                	ch++;
                result += ch;
            }
            
            return result;
        };
        System.out.println(cryptor.myCryptorFunction("HelloZ"));
    }
}
