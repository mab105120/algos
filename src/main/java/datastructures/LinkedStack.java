package datastructures;

import java.util.Iterator;

public class LinkedStack<T> implements Iterable<T> {

	// A stack is a collection of items that implements the FIFO method.
	// This class is an implementation of a stack data structure using linked
	// list.

	private Node first;

	private class Node {
		T t;
		Node next;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public void push(T t) {
		Node temp = first;
		first = new Node();
		first.t = t;
		first.next = temp;
	}

	public T pop() {
		Node temp = first;
		first = first.next;
		return temp.t;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new LinkedStackIterator();
	}

	public T getFirst() {
		return this.first.t;
	}

	private class LinkedStackIterator implements Iterator<T> {

		Node current = first;

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return current != null;
		}

		@Override
		public T next() {
			// TODO Auto-generated method stub
			Node oldCurrent = current;
			current = current.next;
			return oldCurrent.t;
		}

	}

}