package com.alg4.ch2.p3;

/**
 * Created by i305765 on 22/04/2017.
 */
public class QuickSort {

    public static void quickSort(int[] a) {
        iSort(a, 0, a.length - 1);
    }

    public static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void iSort(int[] a, int low, int high) {
        if (low >= high) {
            return;
        }
        int j = partitionL(a, low, high);

        iSort(a, low, j - 1);
        iSort(a, j + 1, high);
    }

    public static int partitionH(int[] a, int low, int high) {

        int pivot = a[high];

        int i = low - 1;
        int j = low;
        while (j <= high - 1) {
            if (a[j] <= pivot) {
                swap(a, ++i, j);
            }
            j++;
        }
        swap(a, ++i, high);
        return i;
    }

    public static int partitionL(int[] a, int low, int high) {
        int pivot = a[low];
        int i = low;
        int j = i + 1;
        while (j <= high) {
            if (a[j] <= pivot) {
                swap(a, ++i, j);
            }
            j++;
        }

        swap(a, low, i);
        return i;
    }
}
