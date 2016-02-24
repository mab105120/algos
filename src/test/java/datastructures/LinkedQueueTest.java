package datastructures;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.bourjm.algos.Person;

public class LinkedQueueTest {
	
	
	@Test
	public void linkedListQueue() { 
		LinkedQueue<Person> q = new LinkedQueue<>();
		q.enqueue(new Person("Young", 10));
		q.enqueue(new Person("Adult", 30));
		q.enqueue(new Person("Elder", 70));
		assertFalse(q.isEmpty());
		assertTrue(q.dequeue().getName().equals("Young"));
		assertTrue(q.dequeue().getName().equals("Adult"));
		assertTrue(q.dequeue().getName().equals("Elder"));
	}

	@Test (expected = NullPointerException.class)
	public void dequeueEmptyQueue() { 
		LinkedQueue<Person> q = new LinkedQueue<>();
		q.dequeue();
	}
	
	@Test
	public void iterateThroughQueue() { 
		LinkedQueue<String> q = new LinkedQueue<>();
		q.enqueue("1");
		q.enqueue("2");
		q.enqueue("3");
		int j = 1;
		for (String s: q) { 
			assertTrue(Integer.parseInt(s) == j);
			j ++;
		}
	}
	
}
