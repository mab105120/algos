package datastructures;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.bourjm.algos.Person;

public class LinkedStackTest {

	private List<Person> persons = Arrays.asList(new Person[]{
			new Person("Young",10),
			new Person("Adult", 30),
			new Person("Elder", 60)
	});
	
	@Test
	public void pushElementsIntoStack() { 
		LinkedStack<Person> stack = new LinkedStack<Person>();
		stack.push(persons.get(0));
		stack.push(persons.get(1));
		stack.push(persons.get(2));
		assertTrue(stack.pop().getName().equals("Elder"));
		assertFalse(stack.isEmpty());
		assertTrue(stack.pop().getName().equals("Adult"));
		assertFalse(stack.isEmpty());
		assertTrue(stack.pop().getName().equals("Young"));
		assertTrue(stack.isEmpty());
	}
	
	@Test(expected = NullPointerException.class)
	public void popFromAnEmptyStack() { 
		LinkedStack<Person> stack = new LinkedStack<>();
		stack.pop();
	}
	
	@Test
	public void iterateThroughStack() { 
		LinkedStack<String> stack = new LinkedStack<>();
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
