package com.lc.union_find;

import org.junit.Test;

/**
 * Created by i305765 on 15/04/2017.
 */
public class LongestConsecutiveTest {

    @Test
    public void TestLongestConsecutive() {
        int[] list = new int[]{1,2,0,1};

        LongestConsecutive lc = new LongestConsecutive();
        int len = lc.longestConsecutive(list);
        System.out.println("len:" + len);

    }
}
