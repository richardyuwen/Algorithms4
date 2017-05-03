package com.lc.array;

import org.junit.Test;

import java.util.List;

/**
 * Created by i305765 on 15/04/2017.
 */
public class FindDisappearedNumbersTest {

    @Test
    public void TestFindDisappearedNumbers() {
        FindDisappearedNumbers fd = new FindDisappearedNumbers();
        int[] nums = new int[]{
                4, 3, 2, 7, 8, 2, 3, 1
        };

        List<Integer> disappearedList = fd.findDisappearedNumbers(nums);
        System.out.println(disappearedList);
    }
}


