package com.lc.array;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by i305765 on 15/04/2017.
 */
public class PascalTriangle_2 {

    public List<Integer> getRow(int rowIndex) {

        int[] preArray = new int[rowIndex + 1];
        int[] nextArray = new int[rowIndex + 1];
        preArray[0] = 1;
        int index = 2;
        for (; index <= rowIndex + 1; index++) {
            getNext(preArray, nextArray, index);
            int[] tmpArray = preArray;
            preArray = nextArray;
            nextArray = tmpArray;
        }
        List<Integer> list = new LinkedList<>();
        for (int i : preArray) {
            list.add(i);
        }
        return list;
    }

    void getNext(int[] preArray, int[] nextArray, int index) {
        int p = -1;
        for (int i = 0; i < index; i++) {
            nextArray[i] = 0;
            if (p != -1) {
                nextArray[i] += preArray[p];
            }
            if (p + 1 < index - 1) {
                nextArray[i] += preArray[p + 1];
            }
            p++;
        }
    }

    public static void main(String[] args) {
        PascalTriangle_2 pt2 = new PascalTriangle_2();
        List<Integer> list = pt2.getRow(2);
        for (Integer i : list) {
            System.out.print(i);
            System.out.print(" ");
        }
    }
}
