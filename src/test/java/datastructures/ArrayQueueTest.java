package datastructures;

import static org.junit.Assert.*;

import org.junit.Test;

import com.bourjm.algos.Person;

public class ArrayQueueTest {

	@Test
	public void emptyQueue() {
		ArrayQueue<Person> q = new ArrayQueue<>();
		assertTrue(q.isEmpty());
	}

	@Test
	public void queue() {
		ArrayQueue<Person> q = new ArrayQueue<>();
		q.enqueue(new Person("Young", 10));
		q.enqueue(new Person("Adult", 30));
		q.enqueue(new Person("Elder", 60));
		assertTrue(q.front().getName().equals("Young"));
		assertFalse(q.isEmpty());
		assertTrue(q.dequeue().getName().equals("Young"));
		assertTrue(q.front().getName().equals("Adult"));
		assertFalse(q.isEmpty());
		assertTrue(q.dequeue().getName().equals("Adult"));
		assertFalse(q.isEmpty());
		assertTrue(q.dequeue().getName().equals("Elder"));
		assertTrue(q.isEmpty());
		assertNull(q.front());
	}

	@Test
	public void iterateThroughArrayQueue() {
		ArrayQueue<String> q = new ArrayQueue<>();
		q.enqueue("1");
		q.enqueue("2");
		q.enqueue("3");
		int j = 1;
		for (String s : q) {
			assertTrue(Integer.parseInt(s) == j);
			j++;
		}
	}

}
