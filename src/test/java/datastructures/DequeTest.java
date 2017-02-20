package datastructures;

import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Moe on 2/20/17.
 */
public class DequeTest {

    @Test
    public void dequeTest() {
        Deque<String> d = new Deque<>();
        assertTrue(d.isEmpty());
        d.addFirst("a");
        d.addLast("b");
        assertEquals(2, d.size());
        d.addLast("c");
        d.addFirst("d");
        assertEquals(4, d.size());
        assertFalse(d.isEmpty());
        assertEquals("c", d.removeLast());
        assertEquals("d", d.removeFirst());
        assertEquals(2, d.size());
        d.addFirst("n");
        assertEquals("n", d.removeFirst());
        assertEquals("b", d.removeLast());
        assertEquals("a", d.removeFirst());
        assertTrue(d.isEmpty());
    }

    @Test
    public void dequeIterationTest() {
        Deque<Integer> d = new Deque<>();
        d.addFirst(1);
        d.addLast(4);
        d.addLast(3);
        d.addFirst(5);
        d.addLast(2);
        d.addFirst(0);
        int[] expected = new int[]{0, 5, 1, 4, 3, 2};
        int i = 0;
        for(Integer j: d) assertEquals((int) j, expected[i++]);
    }

    @Test (expected = UnsupportedOperationException.class)
    public void dequeRemoveElementInIteration() {
        Deque<String> d = new Deque<>();
        Iterator iterator = d.iterator();
        iterator.remove();
    }

    @Test (expected = NoSuchElementException.class)
    public void testRemoveNodeFromEmptyDeque() {
        Deque<String> d = new Deque<>();
        assertTrue(d.isEmpty());
        d.addFirst("a");
        assertFalse(d.isEmpty());
        assertEquals(1, d.size());
        assertEquals("a", d.removeLast());
        assertTrue(d.isEmpty());
        d.removeFirst();
    }

    @Test (expected = NullPointerException.class)
    public void testAddInvalidInput() {
        Deque<String> d = new Deque<>();
        d.addFirst(null);
    }
}