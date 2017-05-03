package com.lc.array;

import java.util.HashSet;

/**
 * Created by i305765 on 19/04/2017.
 */
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        boolean duplicated = false;
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!hs.contains(nums[i])) {
                hs.add(nums[i]);
            } else {
                duplicated = true;
                break;
            }
        }
        return duplicated;
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int n = nums.length;
        if (k >= n)
            k = n - 1;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= k; j++) {
                int l = i + j;
                if (l > n - 1)
                    continue;
                int diff = nums[i] - nums[l];
                if (nums[i] > 0 && nums[l] < 0 && diff <= 0) {
                    continue;
                } else if (nums[i] < 0 && nums[l] > 0 && diff >= 0) {
                    continue;
                }
                if (diff < 0) {
                    diff = -diff;
                }
                if (diff < 0) {
                    continue;
                } else if (diff <= t) {
                    return true;
                }
            }
        }
        return false;
    }
}
