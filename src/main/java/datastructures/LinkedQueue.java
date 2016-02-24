package datastructures;

import java.util.Iterator;

public class LinkedQueue<T> implements Iterable<T> {

	// Queue is a collection of items that implement the LIFO method. 
	// This class is an implementation of a Queue data structure using linked list.
	
	private Node first, last;
	
	private class Node { 
		T t;
		Node next;
	}
	
	public boolean isEmpty() { 
		return first == null;
	}
	
	public void enqueue(T t) { 
		Node oldLast = last;
		last = new Node();
		last.t = t;
		if (isEmpty()) first = last;
		else oldLast.next = last;
	}
	
	public T dequeue() { 
		Node oldFirst = first;
		first = first.next;
		if (isEmpty()) last = null;
		return oldFirst.t;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new LinkedQueueIterator();
	}	
	
	private class LinkedQueueIterator implements Iterator<T> {

		Node current = first;
		
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return last.next != null;
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