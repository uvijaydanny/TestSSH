package com.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.java8.model.Employee;

// Added feature branch comments
//some additional changes
public class Generic {

	private static List<Employee> empList = Arrays.asList(new Employee(1,"One",25), 
										new Employee(2,"Two",30),
										new Employee(3,"Three",28),
										new Employee(4,"Four",33),
										new Employee(5,"Five",29));
	
	public static void main(String[] args) {
		// filter options
		empList.stream().filter(emp -> emp.getEmpAge() >= 29).skip(2).forEach(System.out::println);
		
		
		// map n flatmap
		List<String> collect = empList.stream().map(emp -> emp.getEmpName()).map(str -> str.split(""))
				.flatMap(arr -> Arrays.stream(arr))
				.map(e ->e.toUpperCase()).filter(e -> !e.equals(" "))
		.collect(Collectors.toList());
		collect.forEach(System.out::print);
		
 		
		// allMatch, any, none
		boolean anyMatch = empList.stream().anyMatch(e->e.getEmpAge() > 35);
		System.out.println("\nAnyMatch " + anyMatch);
		
		// Peek function
/*		System.out.println("Peek Funciton");
		empList.stream().peek(e -> System.out.println(e)).filter(e-> e.getEmpName().length()>=4).forEach(System.out::print);*/
		
		// Iterate n Generate
		Stream.iterate(0, (Integer n) -> n+1).limit(5).collect(Collectors.toList()).forEach(System.out::print);
		Stream.generate(Math::random).limit(5).forEach(System.out::print);
		
		// reduce operation to find the eldest employee 
		Optional<Employee> reduce = empList.stream().reduce((emp1,emp2) -> emp1.getEmpAge() >  emp2.getEmpAge() ? emp1 : emp2);
		System.out.println(reduce.isPresent()?reduce.get().toString():"Not Found");
		
		// replace
		empList.replaceAll(emp -> {
			emp.setEmpName(emp.getEmpName() + " updated");
			return emp;
		});
		empList.forEach(System.out::println);
		
		
		//Sorting Employee List using sort and comparator
		empList.sort((emp1, emp2) -> emp1.getEmpAge().compareTo(emp2.getEmpAge()));
		System.out.println("Sorting and Comparator ");
		empList.forEach(System.out::println);
		
		
	}
}
