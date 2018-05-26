package revature_homwork1;

import java.util.ArrayList;
import java.util.Arrays;

public class Q8 {
	public static String[] words= {"karan", "madam", "tom", "civic", "radar", "jimmy", "kayak", "john",  "refer", "billy", "did"};
	public static ArrayList<String> words2;
	public static ArrayList<String> palendromes;
	public static void doit() {
		words2=new ArrayList<String>();
		palendromes=new ArrayList<String>();
		for (String word : words) {
			words2.add(word);
			if (word.substring(word.length()/2).equals( Q3.rev(word.substring(0, (word.length()/2+word.length()%2))))) {
				palendromes.add(word);
			}
			
		}
		//System.out.println(Arrays.deepToString(palendromes.toArray()));
	}
}
