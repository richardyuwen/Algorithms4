package com.lc.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by i305765 on 18/04/2017.
 */
public class RotateArray {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        if (n == 0)
            return;
        List<Integer> list = new ArrayList<>();
        int step = k % nums.length;
        if (step == 0)
            return;
        for (int i = 0; i < step; i++) {
            list.add(nums[n - 1 - i]);
        }
        for (int i = n - step - 1; i >= 0; i--) {
            nums[i + step] = nums[i];
        }
        for (int i = 0; i < step; i++) {
            nums[step - 1 - i] = list.get(i);
        }
    }
}
