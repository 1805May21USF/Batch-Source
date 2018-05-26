package revature_homwork1;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;

import org.junit.Test;




public class AllTests {
	@Test
	public void QT1() {
		int[] temp = Q1.defaultArray.clone();
				Arrays.sort(temp);
		int[] ours=Q1.sort(Q1.defaultArray);
		assertArrayEquals(temp,ours);
		//System.out.println("sorted: " + Arrays.toString(temp)+ " ours: " + Arrays.toString(ours));
	}
	@Test 
	public void QT2() {
		int[] realFibs = {0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368};
		assertArrayEquals(Q2.fib(25),realFibs );
	}
	@Test 
	public void QT3() {
		//System.out.println("\"POTATO!\" reversed is: "+Q3.rev("POTATO!"));

		assert (Q3.rev("potato!").equals("!otatop"));
		assert (Q3.rev("AAAAAAAAAAAAA").equals("AAAAAAAAAAAAA"));
	}
	@Test 
	public void QT4() {
		assert(Q4.fac(2)==2);
		assert(Q4.fac(3)==6);
		assert(Q4.fac(11)==39916800);

	}
	@Test 
	public void QT5() {
		//System.out.println(Q5.substr("potato", 2, 4)+", "+"potato".substring(2, 4));
		assert (Q5.substr("potato", 2, 4).equals("potato".substring(2, 4)));
	}
	@Test 
	public void QT6() {
		assert(Q6.even(22));
		assert(Q6.even(2));
		assert(!Q6.even(41));
		assert(!Q6.even(1));

	}
	@Test 
	public void QT7() {
		com.revature.compare.Employee e1 = new com.revature.compare.Employee("bob","Acct",9912);
		com.revature.compare.Employee e2= new com.revature.compare.Employee("Sam","money",2);
		assert (0<e1.compareTo(e2));
	}
	@Test 
	public void QT8() {
		Q8.doit();
		String[] array = {"karan", "madam", "tom", "civic", "radar", "jimmy", "kayak", "john",  "refer", "billy", "did"};
		String[] arrayP = {"madam", "civic", "radar","kayak", "refer","did"};

		assertArrayEquals(Q8.words2.toArray(), array);
		assertArrayEquals(Q8.palendromes.toArray(), arrayP);
	}
	@Test 
	public void QT9() {
		Q9.get();
		Integer[] primes = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};
		assertArrayEquals(primes, Q9.primes.toArray());
	}
	@Test 
	public void QT10() {
		assert (Q10.max(10, 34) == 34);
		assert (Q10.max(10, 4) == 10);

}
}
