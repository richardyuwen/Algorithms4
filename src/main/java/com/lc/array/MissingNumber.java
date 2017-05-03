package com.lc.array;

/**
 * Created by i305765 on 18/04/2017.
 */
public class MissingNumber {

    public int missingNumber(int[] nums) {
        int len = nums.length;
        int total = len * (len + 1) / 2;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
        }
        int miss = total - sum;
        return miss;
    }
}
