package datastructures;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by Moe on 2/20/17.
 */
public class Deque<Item> implements Iterable<Item> {

    private Node first; // pointer to the first item in the deque
    private Node last; // pointer to the last item in teh deque
    private int size; // number of items in the deque

    /**
     * Checks if deque is empty
     *
     * @return true if deque is empty, false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Number of items in the deque
     *
     * @return number of items in the deque
     */
    public int size() {
        return size;
    }

    /**
     * Adds item to the front of the deque
     *
     * @param item item
     */
    public void addFirst(Item item) {
        validateInput(item);
        if (isEmpty()) addFirstNode(item);
        else {
            Node n = new Node(item, first, null);
            first.previous = n;
            first = n;
        }
        this.size++;
    }

    /**
     * Adds item to the end of the deque
     *
     * @param item item
     */
    public void addLast(Item item) {
        validateInput(item);
        if (isEmpty()) addFirstNode(item);
        else {
            Node n = new Node(item, null, last);
            last.next = n;
            last = n;
        }
        this.size++;

    }

    /**
     * Remove item from the front of the deque
     *
     * @return item
     */
    public Item removeFirst() {
        if (isEmpty()) throw new NoSuchElementException();
        this.size--;
        Node n = first;
        first = n.next;
        return n.item;
    }

    /**
     * Remove item from the end of the deque
     *
     * @return item
     */
    public Item removeLast() {
        if (isEmpty()) throw new NoSuchElementException();
        this.size--;
        Node n = last;
        last = n.previous;
        return n.item;
    }

    /*
        Adds the first node to the deque
     */
    private void addFirstNode(Item item) {
        Node n = new Node(item, null, null);
        this.first = n;
        this.last = n;
    }

    /*
        Validates whether the input is null, throws NullPointerException if so
     */
    private void validateInput(Item item) {
        if (item == null) throw new NullPointerException();
    }

    /**
     * Deque iterator
     *
     * @return iterator over the items of the deque
     */
    @Override
    public Iterator<Item> iterator() {
        return new DequeIterator();
    }

    private class DequeIterator implements Iterator<Item> {

        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            if (current == null) throw new NoSuchElementException();
            Node n = current;
            current = current.next;
            return n.item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private class Node {

        private Item item;
        private Node next;
        private Node previous;

        Node(Item item, Node next, Node previous) {
            this.item = item;
            this.next = next;
            this.previous = previous;
        }
    }
}