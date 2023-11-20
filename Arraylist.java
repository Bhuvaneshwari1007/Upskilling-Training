package com.collections;

import java.util.ArrayList;

public class Arraylist {
	public static void main(String[] args) {
		ArrayList<String>winners = new ArrayList<String>();
		winners.add("Ajay");
		winners.add("Akash");
		winners.add("Dileep");
		winners.add("Anitha");
		winners.add("Aswin");
		
		System.out.println("The winners are: "+ winners); 
		
		String str = winners.get(1);
		System.out.println("Winner at index 1: "+ str);
		
		winners.set(0, "Sweta");
		System.out.println("Modified Array list is: "+winners);
		
		String str1 = winners.remove(2);
		System.out.println("Updated Array List is: "+ winners);
		System.out.println("Removed element: "+str1);
	}
}
