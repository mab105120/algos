package datastructures;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by Moe on 2/20/17.
 */
public class Deque<T> implements Iterable<T> {


    private Node first;
    private Node last;
    private int n;

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public void addFirst(T t) {
        validateInput(t);
        if (isEmpty()) addFirstNode(t);
        else {
            Node n = new Node(t, first, null);
            first.previous = n;
            first = n;
        }
        this.n++;
    }

    public void addLast(T t) {
        validateInput(t);
        if (isEmpty()) addFirstNode(t);
        else {
            Node n = new Node(t, null, last);
            last.next = n;
            last = n;
        }
        this.n++;

    }

    public T removeFirst() {
        if (isEmpty()) throw new NoSuchElementException();
        this.n--;
        Node n = first;
        first = n.next;
        return n.t;
    }

    public T removeLast() {
        if (isEmpty()) throw new NoSuchElementException();
        this.n--;
        Node n = last;
        last = n.previous;
        return n.t;
    }

    private void addFirstNode(T t) {
        this.first = this.last = new Node(t, null, null);
    }

    private void validateInput(T t) {
        if (t == null) throw new NullPointerException();
    }

    @Override
    public Iterator<T> iterator() {
        return new DequeIterator();
    }

    private class DequeIterator implements Iterator<T> {

        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            Node n = current;
            current = current.next;
            return n.t;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private class Node {

        T t;
        Node next;
        Node previous;

        Node(T t, Node next, Node previous) {
            this.t = t;
            this.next = next;
            this.previous = previous;
        }
    }
}