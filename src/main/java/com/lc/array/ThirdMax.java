package com.lc.array;

/**
 * Created by i305765 on 15/04/2017.
 */
public class ThirdMax {
    public int thirdMax(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
            if (nums[i] < min) {
                min = nums[i];
            }
        }
        if (max == min)
            return max;

        int secondMax = min;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < max && nums[i] > secondMax) {
                secondMax = nums[i];
            }
        }
        if (secondMax == min) {
            return max;
        }

        int thirdMax = min;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < secondMax && nums[i] > thirdMax) {
                thirdMax = nums[i];
            }
        }
        return thirdMax;

    }
}
