package com.bourjm.algos;

public class Person implements Comparable<Person>{

	private final String name;
	private final int age;
	
	public Person(String name, int age) { 
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public int compareTo(Person that) {
		// TODO Auto-generated method stub
		if (this.age > that.age) return -1;
		else if (this.age < that.age) return 1;
		else return 0;
	}
}
