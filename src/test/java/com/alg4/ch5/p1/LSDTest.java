package com.alg4.ch5.p1;

import org.junit.Test;

/**
 * Created by i305765 on 20/04/2017.
 */
public class LSDTest {
    @Test
    public void sort() throws Exception {
        String[] a = new String[]{
                "4PGC938",
                "2IYE230",
                "3CI0720",
                "1ICK750",
                "1OHV8",
                "4JZY524",
                "1ICK750",
                "3CI0720",
                "1OHV",
                "1OHV845",
                "2RLA629",
                "2RLA629",
                "3ATW723",
        };

        LSD.nonfixedSort(a);

        for (String s : a) {
            System.out.println(s);
        }
    }

}