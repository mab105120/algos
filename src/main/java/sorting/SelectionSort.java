package sorting;

import org.junit.Test;

public class SelectionSort {

	public static <T extends Comparable<T>> void sort(T[] a) {
		for (int i = 0; i < a.length; i++) {
			int min = i;
			for (int j = i; j < a.length; j++)
				if (Sort.less(a[j], a[min]))
					min = j;
			Sort.exchange(a, i, min);
		}
	}
	
	@Test
	public void test() { 
		Apple a = new Apple(2.00);
		Apple p = new Apple(3.00);
		Sort.less(a, p);
	}
	
	private class Apple implements Comparable<Apple> {
		
		private double weight;
		
		public Apple(double weight) {
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Apple that) {
			// TODO Auto-generated method stub
			if (this.weight < that.weight) return -1;
			else if (this.weight > that.weight) return +1;
			return 0;
		}
	}
	
	private class Person implements Comparable<Person> {
		
		private int age;
		
		public Person(int age) { 
			this.age = age;
		}
		
		@Override
		public int compareTo(Person that) {
			// TODO Auto-generated method stub
			if (this.age > that.age) return 1;
			else if (this.age < that.age) return -1;
			else return 0;
		} 
		
	}
	
}