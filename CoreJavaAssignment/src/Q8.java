import java.util.ArrayList;

public class Q8 {
	/*
	 * Q8. Write a program that stores the following strings in an ArrayList and
	 * saves all the palindromes in another ArrayList. “karan”, “madam”, ”tom”,
	 * “civic”, “radar”, “jimmy”, “kayak”, “john”, “refer”, “billy”, “did”
	 */
	public static void main(String[] args) {
		System.out.println("Q8. Write a program that stores the following strings"
				+ " in an ArrayList and saves all the palindromes in another ArrayList. “karan”, "
				+ "“madam”, ”tom”, “civic”, “radar”, “jimmy”, “kayak”, “john”,  “refer”, “billy”, “did”");
		ArrayList<String> t = new ArrayList<>();
		t.add("karan");
		t.add("madam");
		t.add("tom");
		t.add("civic");
		t.add("radar");
		t.add("jimmy");
		t.add("kayak");
		t.add("john");
		t.add("refer");
		t.add("billy");
		t.add("did");
		System.out.println("ArrayList 1 is : " + t);
		System.out.println("The palindromes from ArrayList 1 is: " + palindrome(t));
	}

	/*
	 * This method returns an ArrayList of all palindromes. A palindrome is a word
	 * that appears to be the same word when reversed. This method checks the word
	 * by reversing it in a temporary String using StringBuffer and compares the two
	 * Strings. If the result of the comparison is true, then the word is a
	 * palindrome and is added to the ArrayList result.
	 */
	static ArrayList<String> palindrome(ArrayList<String> t) {
		ArrayList<String> result = new ArrayList<>();
		for (String str : t) {
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append(str);
			stringBuilder.reverse();
			if (str.equals(stringBuilder.toString())) {
				result.add(str);
			}
		}

		return result;
	}

}
