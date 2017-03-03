package datastructures;

import org.junit.Test;
import sorting.SortTest;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

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

    @Test (expected = NoSuchElementException.class)
    public void callNextWhenIteratorIsDone() {
        Deque<String> d = new Deque<>();
        d.addFirst("e");
        d.addFirst("d");
        d.addFirst("c");
        d.addFirst("b");
        d.addFirst("a");
        Iterator<String> iterator = d.iterator();
        for(int i = 0; i < 6; i++) iterator.next();
    }

    @Test
    public void testOrder() {
        Deque<String> d = new Deque<>();
        d.addFirst("e");
        d.addFirst("d");
        d.addFirst("c");
        d.addFirst("b");
        d.addFirst("a");
        String[] output = new String[5];
        for(int i = 0; i < 5; i++) output[i] = d.removeFirst();
        assertTrue(SortTest.isSorted(output));
    }

}