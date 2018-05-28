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
	@Test 
	public void QT11() {
	
		Q11.doit((float) 1999.1,-1);
		assert (com.revature.compare.Employee.f1 ==1999.1f);
		assert (com.revature.compare.Employee.f2==-1);

}
	@Test 
	public void QT12() {
		
		assert (Q12.doit().toString().equals("0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 40, 42, 44, 46, 48, 50, 52, 54, 56, 58, 60, 62, 64, 66, 68, 70, 72, 74, 76, 78, 80, 82, 84, 86, 88, 90, 92, 94, 96, 98, "));
}
	@Test 
	public void QT13() {
		System.err.println(Q13.doit());
		assert (Q13.doit().equals("0 \n1 0 \n1 0 1 \n0 1 0 1 \n"));
}	
	@Test 
	public void QT14() {
		System.out.println(Q14.doit(0)[0]);
		System.out.println(Q14.doit(1)[0]);
		System.out.println(Q14.doit(2)[0]);

	}
	
	@Test 
	public void QT15() {
		for (int i=0; i<20; i++) {
			double r1 = Math.random();
			double r2 = Math.random();
			assert (Q15.add(r1, r2) == r1+r2);
			assert (Q15.sub(r1, r2) == r1-r2);
			assert (Q15.mult(r1, r2) == r1*r2);
			assert (Q15.div(r1, r2) == r1/r2);
			

		}
}
	
	@Test 
	public void QT16() {
		String[] args= new String[1];
		args[0]="LOLOLOLOLOLOLOL";
		Q16.main(args);
}
	
	@Test 
	public void QT17() {
		//SEE Q17 class
}
	
	@Test 
	public void QT18() {
		//SEE Q18 class
}
	@Test 
	public void QT19() {
		Q19.doit();
}
	@Test 
	public void QT20() {
		Q20.doit();
}
	
	
}
