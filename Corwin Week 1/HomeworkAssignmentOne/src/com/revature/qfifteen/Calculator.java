package com.revature.qfifteen;

public class Calculator implements Operands {

		public Calculator() {
			
		}

		@Override
		public int addition(int a, int b) {
			// TODO Auto-generated method stub
			return a+b;
		}

		@Override
		public int subtraction(int a, int b) {
			// TODO Auto-generated method stub
			return a-b;
		}

		@Override
		public int multiplication(int a, int b) {
			// TODO Auto-generated method stub
			return a*b;
		}

		@Override
		public double dividision(int a, int b) {
			// TODO Auto-generated method stub
			return ((double)a)/b;
		}
		
}
