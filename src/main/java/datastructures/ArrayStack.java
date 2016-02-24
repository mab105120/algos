package datastructures;

import java.util.Iterator;

public class ArrayStack<T> implements Iterable<T>{

	private T[] a = (T[]) new Object[1];
	private int N = 0;
	
	public boolean isEmpty() { 
		return N == 0;
	}
	
	public void push(T t) { 
		if (N >= a.length/2) resize(a.length * 2);
		a[N++] = t;
	}
	
	public T pop() {
		if (N <= a.length/4) resize(a.length / 2);
		return a[--N];
	}
	
	private void resize(int capacity) { 
		T[] copy = (T[]) new Object[capacity];
		for (int i = 0; i < N; i++)
			copy[i] = a[i];
		a = copy;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new ArrayStackIterator();
	}
	
	private class ArrayStackIterator implements Iterator<T> {

		int current = 0;
		
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return current >= N;
		}

		@Override
		public T next() {
			// TODO Auto-generated method stub
			return a[current++];
		} 
	}
}