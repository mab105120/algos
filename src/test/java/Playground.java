import edu.princeton.cs.introcs.In;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import sorting.Sort;
import sorting.SortTest;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Moe on 2/22/17.
 */
public class Playground {

    @Test
    public void test() throws IOException {
        String[] s = new String[]{"a", "d", "f", "c", "b", "e"};
        sort(s);
        assertTrue(SortTest.isSorted(s));

        String[] letters = FileUtils.readFileToString(new File("/Users/Moe/Desktop/letters.txt"))
                .split(" ");
        assertEquals(1000, letters.length);
        sort(letters);
        assertTrue(SortTest.isSorted(letters));

    }

    @Test
    public void t() throws IOException {
        final String FILE_PATH = "src/test/resource/letters.txt";
        In in = new In(new File(FILE_PATH));
        String[] s = in.readAllStrings();
    }

    private <T extends Comparable<T>> void sort(T[] t) {
        int h = 1;
        while (h < t.length) h = h * 3 + 1;
        while (h >= 1) {
            for (int i = h; i < t.length; i++) {
                int j = i;
                while (j >= h && Sort.less(t[j], t[j - h])) {
                    Sort.exchange(t, j, j - h);
                    j -= h;
                }
            }
            h = h / 3;
        }
    }

}
