package sorting;

import java.util.Comparator;

public class SelectionSort {

	public static <T> void sort(Comparator<T> c,T[]a) {
		for (int i = 0; i < a.length; i++) {
			int min = i;
			for (int j = i; j < a.length; j++)
				if (Sort.less(c, a[j], a[min]))
					min = j;
			Sort.exchange(a, i, min);
		}
	}
	
}