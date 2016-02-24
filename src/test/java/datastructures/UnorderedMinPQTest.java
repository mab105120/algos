package datastructures;

import static org.junit.Assert.*;

import org.junit.Test;

public class UnorderedMinPQTest {

	@Test
	public void minPqWithArray() {
		Integer[] a = new Integer[] { 0, 1, 2, 5, 8, 4, 2, 6, 8 };
		UnorderedMinPQ<Integer> pq = new UnorderedMinPQ<>(a);
		assertTrue(pq.removeMin() == 0);
		pq.insert(-2);
		pq.insert(-4);
		pq.insert(0);
		assertTrue(pq.removeMin() == -4);
		assertTrue(pq.removeMin() == -2);
		assertTrue(pq.removeMin() == 0);
	}

	@Test
	public void minPqWithInsertingItems() {
		UnorderedMinPQ<Integer> pq = new UnorderedMinPQ<Integer>();
		pq.insert(1);
		pq.insert(2);
		pq.insert(4);
		pq.insert(13);
		assertTrue(pq.removeMin() == 1);
		pq.insert(0);
		pq.insert(-2);
		assertTrue(pq.removeMin() == -2);
		assertTrue(pq.removeMin() == 0);
	}
}
