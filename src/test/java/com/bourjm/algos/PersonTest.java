package com.bourjm.algos;

import static org.junit.Assert.*;

import org.junit.Test;

public class PersonTest {
	
	@Test
	public void compareTwoPersons() { 
		Person p1 = new Person("Young", 10);
		Person p2 = new Person("Old", 64);
		assertTrue(p1.compareTo(p2) == 1);
		assertTrue(p2.compareTo(p1) == -1);
	}

	@Test
	public void compareTwoPersonsThatAreEqual() { 
		assertTrue(new Person("a",1).compareTo(new Person("b", 1)) == 0);
	}
}
