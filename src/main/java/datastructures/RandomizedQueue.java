package datastructures;

import edu.princeton.cs.introcs.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by Moe on 2/26/17.
 */
public class RandomizedQueue<Item> implements Iterable<Item> {

    private Item[] items; // array to hold the objects in the queue
    private int n; // number of objects in the queue

    public RandomizedQueue() {
        items = (Item[]) new Object[1]; // the ugly cast
        n = 0;
    }

    /**
     * Checks if the queue is empty
     *
     * @return true if queue is empty, false otherwise
     */
    public boolean isEmpty() {
        return n == 0;
    }

    /**
     * The size of the queue
     *
     * @return size of the queue
     */
    public int size() {
        return n;
    }

    /**
     * Adds items to the queue
     *
     * @param item item
     */
    public void enqueue(Item item) {
        if (item == null) throw new NullPointerException();
        if (n >= items.length / 2) resize(items.length * 2);
        items[n++] = item;
    }

    /**
     * Removes item from the queue at random
     *
     * @return item
     */
    public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException();
        if (n <= items.length / 4) resize(items.length / 2);
        int r = StdRandom.uniform(0, n);
        swap(r, --n);
        Item t = items[n];
        items[n] = null; // to avoid loitering
        return t;
    }

    /**
     * Returns, but does not remove, an item from the queue
     *
     * @return item
     */
    public Item sample() {
        return items[StdRandom.uniform(0, n)];
    }

    /*
        Resize the array to avoid too large, or too small, array with empty nodes.
     */
    private void resize(int size) {
        Item[] tmp = (Item[]) new Object[size]; // the ugly cast
        for (int i = 0; i < n; i++)
            if (items[i] != null) tmp[i] = items[i];
        items = tmp;
    }

    /*
        swaps two elements in the array
     */
    private void swap(int i, int j) {
        Item t = items[i];
        items[i] = items[j];
        items[j] = t;
    }

    /**
     * Iterator over the elements of the queue
     *
     * @return iterator
     */
    public Iterator<Item> iterator() {
        return new RandomQueueIterator();
    }

    private class RandomQueueIterator implements Iterator<Item> {

        private Item[] temp;
        private int current;

        RandomQueueIterator() {
            current = 0;
            temp = (Item[]) new Object[n]; // the ugly cast
            for (int i = 0; i < n; i++)
                temp[i] = items[i];
            StdRandom.shuffle(temp);
        }

        @Override
        public boolean hasNext() {
            return current < n;
        }

        @Override
        public Item next() {
            if (current >= n) throw new NoSuchElementException();
            return temp[current++];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}