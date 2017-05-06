package com.alg4.ch5.p1;

/**
 * Created by i305765 on 20/04/2017.
 */
public class MSD {
    public static void sort(String[] a) {
        sortRange(a, 0, a.length - 1, 0);
    }

    public static int charAt(String a, int i) {
        if (i >= a.length()) {
            return -1;
        }
        return a.charAt(i);
    }

    public static void sortRange(String[] a, int lo, int hi, int w) {
        if (lo >= hi)
            return;

        int R = 257;
        int n = hi - lo + 1;
        String[] aux = new String[n];

        int[] count = new int[R + 1];

        for (int i = lo; i <= hi; i++) {
            int index = charAt(a[i], w);
            count[index + 2]++;
        }
        for (int i = 0; i < R; i++) {
            count[i + 1] += count[i];
        }
        for (int i = lo; i <= hi; i++) {
            aux[count[charAt(a[i], w) + 1]++] = a[i];
        }
        for (int i = lo; i <= hi; i++) {
            a[i] = aux[i - lo];
        }
        for (int i = 0; i < R - 1; i++) {
            sortRange(a, count[i] + lo, count[i + 1] + lo - 1, w + 1);
        }
    }
}
