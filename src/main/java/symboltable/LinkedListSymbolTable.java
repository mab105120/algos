package symboltable;

import java.util.Iterator;

public class LinkedListSymbolTable<K extends Comparable<K>, V> implements
		Iterable<K> {

	/*
	 * This class is an elementary implementation of a symbol table It utilizes
	 * the linked list data structure to perform search and insert operations
	 * this implementation is simple though not efficient. This algorithm has to
	 * go through every element in the list to both insert a new element and
	 * search for an existing element. The complexity for both operations is
	 * quadratic (not good!)
	 */

	private Node first;

	private class Node {
		// These instance variables don't have to encapsulated since they are
		// not accessible to the client (because the Node class is private)
		K key;
		V value;
		Node next;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public void put(K key, V value) {
		Node current = first;
		while (current != null) {
			if (current.key.compareTo(key) == 0) {
				current.value = value;
				return;
			}
			current = current.next;
		}
		Node oldFirst = first;
		first = new Node();
		first.key = key;
		first.value = value;
		first.next = oldFirst;
	}

	public boolean contains(K key) {
		return get(key) != null;
	}

	public V get(K key) {
		Node current = first;
		while (current != null) {
			if (current.key.compareTo(key) == 0)
				return current.value;
			current = current.next;
		}
		return null;
	}

	@Override
	public Iterator<K> iterator() {
		return new LinkedListSymbolTableIterator();
	}

	private class LinkedListSymbolTableIterator implements Iterator<K> {

		Node current = first;

		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public K next() {
			Node oldCurrent = current;
			current = current.next;
			return oldCurrent.key;
		}
	}
}