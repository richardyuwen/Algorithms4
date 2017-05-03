package com.lc.array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by i305765 on 15/04/2017.
 */
public class FindDisappearedNumbers {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new LinkedList<>();
        Arrays.sort(nums);

        int expected = 1;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == expected) {
                expected++;
            } else if (nums[i] > expected) {
                do {
                    list.add(expected);
                    expected++;
                } while (nums[i] > expected);
                ++expected;
            }
        }
        while (expected <= n) {
            list.add(expected++);
        }
        return list;
    }
}
