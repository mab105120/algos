package sorting;

import java.util.Comparator;

/**
 * Created by Moe on 3/3/17.
 */
public class ShellSort {

    public static <T> void sort(Comparator<T> c, T[]t) {
        int h = 1;
        while (h < t.length) h = h * 3 + 1;
        while (h >= 1) {
            for (int i = h; i < t.length; i++) {
                int j = i;
                while (j >= h && Sort.less(c, t[j], t[j - h])) {
                    Sort.exchange(t, j, j - h);
                    j -= h;
                }
            }
            h = h / 3;
        }
    }
}
