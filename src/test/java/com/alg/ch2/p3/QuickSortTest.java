package com.alg.ch2.p3;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by i305765 on 22/04/2017.
 */
public class QuickSortTest {
    @Test
    public void quickSort() throws Exception {

        int [] a = new int[]{
            1,2,4,0,18,2,33,199
        };

        QuickSortV2.quickSort(a);
        for (int i : a){
            System.out.println(i);
        }
    }

}