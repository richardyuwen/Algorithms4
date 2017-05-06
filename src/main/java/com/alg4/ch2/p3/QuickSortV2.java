package com.alg4.ch2.p3;


/**
 * Created by i305765 on 22/04/2017.
 */
public class QuickSortV2 {
    public static void quickSort(int[] a) {
        iSort(a, 0, a.length - 1);
    }

    public static void iSort(int[] a, int low, int high) {
        if (low >= high)
            return;
        int j = partition(a, low, high);

        iSort(a, low, j - 1);
        iSort(a, j + 1, high);
    }

    public static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static int partition(int[] a, int low, int high) {
        int pivot = a[low];
        int i = low + 1;
        int j = high;
        while (true) {
            while (i <= j) {
                if (a[i] >= pivot)
                    break;
                i++;
            }
            while (i <= j) {
                if (a[j] <= pivot)
                    break;
                j--;
            }
            if (i < j)
                swap(a, i, j);
            else
                break;
        }
        swap(a, low, j);
        return j;
    }
}
