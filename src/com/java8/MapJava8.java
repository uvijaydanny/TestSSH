package com.java8;

import java.util.HashMap;
import java.util.Map;

public class MapJava8 {

	private static Map<Integer, String> Omap = new HashMap<>(); 
	
	
	public static void main(String[] args) {
		Omap.put(1, "One");
		Omap.put(2, "Two");
		Omap.put(3, "Three");
		Omap.put(4, "Four");
		Omap.put(5, "Five");
		
		Omap.computeIfAbsent(6, i -> "Six");
		Omap.forEach((i,s)-> System.out.println(i + " - " + s));
		
		Omap.computeIfPresent(4, (i,s)->null);
		Omap.forEach((i,s)-> System.out.println(i + " - " + s));
		
	}
	
}
