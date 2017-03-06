package sorting;

import datastructures.OrderedMaxPQ;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class OrderedMaxPQTest {

	@Test
	public void minPq() {
		OrderedMaxPQ<Integer> pq = new OrderedMaxPQ<>(Integer::compare);
		pq.insert(1);
		pq.insert(5);
		pq.insert(0);
		pq.insert(-2);
		pq.insert(10);
		assertTrue(pq.removeMax() == 10);
		assertTrue(pq.removeMax() == 5);
		assertTrue(pq.removeMax() == 1);
		assertTrue(pq.removeMax() == 0);
		assertTrue(pq.removeMax() == -2);
		try {
			pq.removeMax();
		} catch (Throwable e) {
			assertTrue(e.getMessage().equals("The array is empty!"));
		}
	}
}
