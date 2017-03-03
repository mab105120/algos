package datastructures;

import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Moe on 2/27/17.
 */
public class RandomizedQueueTest {

    @Test
    public void testRandomizedQueue() {
        RandomizedQueue<String> q = new RandomizedQueue<>();
        assertTrue(q.isEmpty());
        assertEquals(0, q.size());
        q.enqueue("a");
        q.enqueue("b");
        q.enqueue("c");
        assertFalse(q.isEmpty());
        assertEquals(3, q.size());
        q.enqueue("d");
        q.enqueue("e");
        for (int i = 0; i < 3; i++)
            q.dequeue();
        assertEquals(2, q.size());
        assertFalse(q.isEmpty());
        q.dequeue();
        q.dequeue();
        assertTrue(q.isEmpty());
        assertEquals(0, q.size());
    }

    @Test(expected = NullPointerException.class)
    public void insertNullItem() {
        RandomizedQueue<Integer> q = new RandomizedQueue<>();
        q.enqueue(null);
    }

    @Test(expected = NoSuchElementException.class)
    public void testRemoveFromEmptyQueue() {
        RandomizedQueue<String> q = new RandomizedQueue<>();
        assertTrue(q.isEmpty());
        assertEquals(0, q.size());
        q.dequeue();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void callRemoveOnIterator() {
        RandomizedQueue<String> q = new RandomizedQueue<>();
        q.enqueue("a");
        q.enqueue("b");
        Iterator<String> iterator = q.iterator();
        iterator.remove();
    }

    @Test(expected = NoSuchElementException.class)
    public void callNextWhenIteratorIsDone() {
        RandomizedQueue<String> q = new RandomizedQueue<>();
        q.enqueue("a");
        q.enqueue("b");
        Iterator<String> iterator = q.iterator();
        for (int i = 0; i < 3; i++)
            iterator.next();
    }

    @Test
    public void testSamplingFromRandomQueue() {
        RandomizedQueue<String> q = new RandomizedQueue<>();
        assertTrue(q.isEmpty());
        assertEquals(0, q.size());
        q.enqueue("a");
        q.enqueue("b");
        q.enqueue("c");
        for (int i = 0; i < 11; i++)
            q.sample();
        assertFalse(q.isEmpty());
        assertEquals(3, q.size());
    }

}
