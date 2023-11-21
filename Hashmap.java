package com.collections;

import java.util.HashMap;

public class Hashmap {
	public static void main(String[] args) {
		
		HashMap<Integer, String> languages = new HashMap<>();
		
		languages.put(1,"Tamil");
		languages.put(2,"Malayalam");
		languages.put(3, "Telugu");
		languages.put(4, "Hindi");
		languages.put(5, "Kannada");
		languages.put(6, "Baduga");
		
		System.out.println("Hashmap: "+ languages);
		
		String value = languages.get(1);
	    System.out.println("Value at index 1: " + value);
	}

}
