package sorting;

import edu.princeton.cs.introcs.In;
import org.junit.Test;

import java.io.File;
import java.util.function.Consumer;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SortTest {

    @Test
    public void lessTest() {
        assertTrue(Sort.less(1, 2));
    }

    @Test
    public void equalItems() {
        assertFalse(Sort.less(1, 1));
    }

    @Test
    public void exchange() {
        Integer[] i = new Integer[]{1, 2, 3, 4, 5, 6};
        Sort.exchange(i, 4, 5);
        assertTrue(i[4] == 6);
        assertTrue(i[5] == 5);
    }

    public static <T extends Comparable<T>> boolean isSorted(T[] a) {
        for (int i = 1; i < a.length; i++)
            if (Sort.less(a[i], a[i - 1])) return false;
        return true;
    }

    private static String[] readLetters() {
        In in = new In(new File("src/test/resource/letters.txt"));
        return in.readAllStrings();
    }

    @Test
    public void sort() {
        String[] s = readLetters();
        sort(s, InsertionSort::sort);
        sort(s, SelectionSort::sort);
        sort(s, QuickSort::sort);
        sort(s, MergeSort::sort);
        sort(s, ShellSort::sort);
    }

    private static <T extends Comparable<T>> void sort(T[] t, Consumer<T[]> c) {
        c.accept(t);
        assertTrue(isSorted(t));
    }

}