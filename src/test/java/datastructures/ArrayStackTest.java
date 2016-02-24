package datastructures;

import static org.junit.Assert.*;

import org.junit.Test;

import com.bourjm.algos.Person;

public class ArrayStackTest {

	@Test
	public void arrayStackTest() { 
		ArrayStack<Person> stack = new ArrayStack<Person>();
		stack.push(new Person("Young", 20));
		stack.push(new Person("Adult", 30));
		stack.push(new Person("Elder", 60));
		assertFalse(stack.isEmpty());
		assertTrue(stack.pop().getName().equals("Elder"));
		assertTrue(stack.pop().getName().equals("Adult"));
		assertTrue(stack.pop().getAge() == 20);
		assertTrue(stack.isEmpty());
	}
	
	@Test
	public void iterateThroughArrayStack() { 
		ArrayStack<String> stack = new ArrayStack<>();
		stack.push("1");
		stack.push("2");
		stack.push("3");
		int i = 3;
		for (String s: stack) { 
			assertTrue(Integer.parseInt(s) == i);
			i--;
		}
	}	
}