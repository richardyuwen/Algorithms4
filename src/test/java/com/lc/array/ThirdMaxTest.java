package com.lc.array;

import org.junit.Test;

/**
 * Created by i305765 on 15/04/2017.
 */
public class ThirdMaxTest {
    @Test
    public void TestThirdMax() {
        ThirdMax tm = new ThirdMax();
        int[] nums = new int[]{1, 2, -2147483648};
        int max = tm.thirdMax(nums);
        System.out.println(max);
    }
}
