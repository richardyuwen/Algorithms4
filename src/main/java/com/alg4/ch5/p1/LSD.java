package com.alg4.ch5.p1;

/**
 * Created by i305765 on 20/04/2017.
 */
public class LSD {
    public static void sort(String[] a, int w) {
        int n = a.length;
        String[] aux = new String[n];
        int R = 256;
        for (int i = w - 1; i >= 0; i--) {
            int[] count = new int[R + 1];

            for (int j = 0; j < n; j++) {
                count[a[j].charAt(i) + 1]++;
            }
            for (int j = 0; j < R; j++) {
                count[j + 1] += count[j];
            }
            for (int j = 0; j < n; j++) {
                aux[count[a[j].charAt(i)]++] = a[j];
            }
            for (int j = 0; j < n; j++) {
                a[j] = aux[j];
            }
        }
    }

    public static void asort(String[] a, int w) {
        int n = a.length;
        String[] aux = new String[n];
        int R = 256;
        for (int i = w - 1; i >= 0; i--) {
            int[] count = new int[R];

            for (int j = 0; j < n; j++) {
                count[a[j].charAt(i)]++;
            }
            for (int j = 1; j < R; j++) {
                count[j] += count[j - 1];
            }
            for (int j = n - 1; j >= 0; j--) {
                aux[--count[a[j].charAt(i)]] = a[j];
            }
            for (int j = 0; j < n; j++) {
                a[j] = aux[j];
            }
        }
    }

    public static int charAt(String a, int i) {
        if (i >= a.length()) {
            return -1;
        }
        return a.charAt(i);
    }

    public static void nonfixedSort(String[] a) {
        int n = a.length;
        int maxW = 0;
        for (int i = 0; i < n; i++) {
            if (a[i].length() > maxW) {
                maxW = a[i].length();
            }
        }
        int R = 257;
        String[] aux = new String[n];
        for (int i = maxW - 1; i >= 0; i--) {
            int[] count = new int[R];

            for (int j = 0; j < n; j++) {
                int index = charAt(a[j], i);
                count[index + 1]++;
            }
            for (int j = 1; j < R; j++) {
                count[j] += count[j - 1];
            }
            for (int j = n - 1; j >= 0; j--) {
                aux[--count[charAt(a[j], i) + 1]] = a[j];
            }
            for (int j = 0; j < n; j++) {
                a[j] = aux[j];
            }
        }
    }

}
