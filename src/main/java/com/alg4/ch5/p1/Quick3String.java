package com.alg4.ch5.p1;

/**
 * Created by i305765 on 22/04/2017.
 */
public class Quick3String {
    private static int charAt(String a, int i) {
        if (i >= a.length())
            return 0;
        return a.charAt(i) + 1;
    }

    public static void sort(String[] a) {
        sort(a, 0, a.length - 1, 0);
    }

    public static void exchange(String[] a, int i, int j) {
        String tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void sort(String[] a, int lo, int hi, int d) {
        if (lo >= hi)
            return;
        int v = charAt(a[lo], d);
        int lt = lo;
        int gt = hi;
        int i = lt + 1;
        while (i <= gt) {
            if (charAt(a[i], d) < v) {
                exchange(a, lt++, i++);
            } else if (charAt(a[i], d) > v) {
                exchange(a, i, gt--);
            } else {
                i++;
            }
        }
        sort(a, lo, lt - 1, d);
        if (v != 0) {
            sort(a, lt, gt, d + 1);
        }
        sort(a, gt + 1, hi, d);
    }
}
