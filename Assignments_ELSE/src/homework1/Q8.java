package homework1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;


public class Q8 {

//Write a program that stores the following strings in an ArrayList and saves all the palindromes in another ArrayList.
//	“karan”, “madam”, ”tom”, “civic”, “radar”, “jimmy”, “kayak”, “john”, “refer”, “billy”, “did”	
private static ArrayList<String> pal = new ArrayList<String>();
	
	
	private static ArrayList<String> palindromes( ArrayList<String> list )
	{
		int comparsions,
		    counter;
		
		
		for(String s: list)
		{
			if( s.length() % 2 == 0 )
			{
				comparsions = s.length() / 2;
				counter = 0;
				
				for(int i = 0; i < comparsions; i++)
				{		
					if( s.charAt(i) == s.charAt( s.length() - i - 1) )
						counter++;
					
					if( counter == comparsions )
						pal.add(s);
				}
			}//end-if
			
			else
			{
				comparsions = (s.length()- 1) / 2;
				counter = 0;
				
				for(int j = 0; j < comparsions; j++)
				{	
					if( s.charAt(j) ==  s.charAt( s.length() - j - 1)  )
						counter++;
					
					if( counter == comparsions )
						pal.add(s);	
				}
			}//end-else
			
			
		}
		return pal;
	}//end-method
	
	
	
	
	public static void main(String[] args) 
	{
		ArrayList<String> arr = new ArrayList<String>
		( 
			Arrays.asList("karan",
						  "madam",
						  "tom",
						  "civic",
						  "radar",
						  "sexes",
						  "jimmy",
						  "kayak",
						  "john",
						  "refer",
						  "billy",
						  "did"
			)
		);
		
		
		try( BufferedWriter out = new BufferedWriter(new FileWriter("src/palindromes.txt")) )
		{
			Iterator<String> iter = arr.iterator();
			
			while( iter.hasNext() )
				out.write( "\""+ iter.next() + "\", " );
				
			
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		//print results
		System.out.println("ArrayList: " + arr);
		System.out.println("ArrayList palindromes: " + palindromes(arr) );
	}
}
