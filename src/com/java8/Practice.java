package com.java8;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Practice {

	public static void main(String[] args) {
		Practice p = new Practice();
		LocalDate ld = LocalDate.parse("05/05/2019", DateTimeFormatter.ofPattern("MM/dd/yyyy")), ld2;
		System.out.println(ld);
		ld = ld.plusMonths(12);
		ld2 = ld.minus(1, ChronoUnit.MONTHS);
		System.out.println(ld.format(DateTimeFormatter.ofPattern("dd!yyyy,MM")));
		System.out.println(ld.isAfter(ld2));
		
	}
}
