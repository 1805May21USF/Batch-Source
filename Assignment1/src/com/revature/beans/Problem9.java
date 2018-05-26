package com.revature.beans;
/*Q9. Create an ArrayList which stores numbers from 1 to 100 and prints out all the prime numbers to the console.*/
import java.util.ArrayList;

public class Problem9 {
	private ArrayList<Integer> iArray = new ArrayList<Integer>();
	private ArrayList<Integer> primes = new ArrayList<Integer>();
	
	public Problem9(){
		for(int i = 1; i <=100; i++){
			iArray.add(i);
		}
		setPrimes(getIArray());
	}
	public ArrayList<Integer> getPrimeNumbers(){
		return this.primes;
	}
	public ArrayList<Integer> getIArray(){
		return this.iArray;
	}
	
	public void setPrimes(ArrayList<Integer> a){
		for(Integer i: a){
			if(isPrime(i)){
				primes.add(i);
			}
		}
		
	}
	
	private static boolean isPrime(int n){
		if( n < 2){
			return false;
		}
		for(int i = 2; i < n; i++){
			if(n % i == 0 ){
				return false;
			}
		}
		return true;
	}
}
