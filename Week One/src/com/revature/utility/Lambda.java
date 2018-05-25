package com.revature.utility;

import java.text.SimpleDateFormat;
import java.util.*;
public class Lambda {

   public static void main(String[] args) {
	   SimpleDateFormat ft =  new SimpleDateFormat ("Y");
      Date dNow = new Date();
      System.out.println(ft.format(dNow));
   }
}